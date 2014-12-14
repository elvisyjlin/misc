package prog.unknown_hero.core;

import com.mobagel.meeti.api.java.MeetiAPI;
import com.mobagel.meeti.api.java.MeetiCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.magiclen.json.JSONArray;
import org.magiclen.json.JSONObject;

import prog.unknown_hero.utility.BaseMessage;
import prog.unknown_hero.utility.Receiver;

public class GameController {
	
	static GameStage gameStage;
	static int waitCount = 0;
	static long startTime = 0;
	static String[] playerOrder = new String[4];
	static int myOrder;

	private static final String GROUP_ID = "public";
	private static final String APP_NAME = "zeroasclin@gmail.com";
	private static final String API_KEY = "9f046a5457cc84660323d4a2ef0a5091";
	private static final String ACCOUNT = "user2";
	private static final String PASSWORD = "994e363bd0a0a84df00f7b17a83fc286";
	private static final int REQUEST_INITIAL_LOGIN = 0;
	private static final int REQUEST_INITIAL_GET_SERVER_TIME = 1;
	private static final int REQUEST_INITIAL_SET_PROFILE = 2;
	private static final int REQUEST_INITIAL_JOIN_GROUP = 3;
	private static final int REQUEST_SYSTEM_NOTIFICATION = 4;
	private static final int REQUEST_SET_MESSAGE = 5;
	private static final int REQUEST_GET_MESSAGE = 6;
	private static final int REQUEST_GET_PROFILE = 7;
	private static final int REQUEST_SET_GROUP = 8;
	private static final int REQUEST_GET_GROUP = 9;

	private final static MeetiAPI api = new MeetiAPI();
	private static boolean available = false, stopping = false;
	private static JSONObject profile = null;
	private static String name = "";
	private static JSONArray messages = new JSONArray();
	private static long lastReceiveMessageTime = 0;
	
	private static boolean inGroup=false;
	
	private final static HashMap<String, JSONObject> profileMap = new HashMap<>();
	
	private static class cardSet{
		List<Card> CARD = new ArrayList();
		List<Player> PLAYER =new ArrayList();
		boolean start=false;
		void init(boolean in){
			start=in;
			this.CARD.clear();
			this.PLAYER.clear();
			for(int i=0; i<28; i++)
			{
				Card tmp;
				if(i<2)			tmp=new Character(4,0);
				else if(i<4)	tmp=new Character(4,1);
				else if(i<6)	tmp=new Character(4,2);
				else if(i<9)	tmp=new EffectCards(4,3);
				else if(i<12)	tmp=new EffectCards(4,4);
				else if(i<15)	tmp=new EffectCards(4,5);
				else if(i<18)	tmp=new EffectCards(4,6);
				else if(i<21)	tmp=new EffectCards(4,7);
				else if(i<24)	tmp=new EffectCards(4,8);
				else if(i<26)	tmp=new Weapon(4, 9);
				else			tmp=new Weapon(4, 10);
				CARD.add(tmp); 
			}
			if(!start) builtGame();
		}
		private void builtGame() { 
			for(int i=0; i<4; i++)
			{
				int ram;
				boolean untrue=true;
				while(untrue)
				{
					ram=(int) (Math.random()%3);
					if(CARD.get(ram*2) instanceof Character){
						untrue=false;
						CARD.remove(ram*2);
						CARD.add(ram*2, new Player(myOrder, CARD.get(ram*2).num));
						PLAYER.add((Player) CARD.get(ram*2));
					}
					else if(CARD.get(ram*2+1) instanceof Character){
						untrue=false;
						CARD.remove(ram*2+1);
						CARD.add(ram*2+1, new Player(myOrder, CARD.get(ram*2+1).num));
						PLAYER.add((Player) CARD.get(ram*2+1));
					}
				}
			
			}
			for(int i=1; i<4; i++)
			{
				
			}
		
		}
	}
	
	
	private final static MeetiCallback callback = (final int requestCode, final String result) -> {
		switch (requestCode) {
			case REQUEST_INITIAL_LOGIN: //System.out.println("REQUEST_INITIAL_LOGIN");
				//初始化並登入
				try {
					final JSONObject json = new JSONObject(result);
					final String token = json.getString("token");
					api.setToken(token);
					if (!json.has("profile")) { //如果沒有Profile，表示第一次登入，所以要輸入暱稱創建Profile
						while (name.length() == 0) {
							System.out.print("請輸入暱稱：");
							name = "unknown_hero";
						}
						profile = new JSONObject();
						profile.put("person_email", ACCOUNT);
						profile.put("person_name", name);
						api.setProfile(REQUEST_INITIAL_SET_PROFILE, profile.toString());
					} else {
						profile = json.getJSONObject("profile");
						name = profile.getString("person_name");
						api.setGroupJoin(REQUEST_INITIAL_JOIN_GROUP, GROUP_ID);
					}
				} catch (final Exception ex) {
					//登入失敗
				}
				break;
			case REQUEST_INITIAL_SET_PROFILE: //System.out.println("REQUEST_INITIAL_SET_PROFILE");
				//創完Profile後，自動加入到聊天室群組
				api.setGroupJoin(REQUEST_INITIAL_JOIN_GROUP, GROUP_ID);
				break;
			case REQUEST_INITIAL_GET_SERVER_TIME: //System.out.println("REQUEST_INITIAL_GET_SERVER_TIME");
				//取得Server上的時間，以便作為抓取訊息的基準
				try {
					final long time = Long.parseLong(result);
					lastReceiveMessageTime = time - 3600000; // 將最後收到訊息的時間設為前1小時，以便抓取前1小時之後的訊息
					startTime = time;
				} catch (final Exception ex) {

				}
				api.getMessage(REQUEST_GET_MESSAGE, GROUP_ID, String.valueOf(lastReceiveMessageTime));
				break;
			case REQUEST_SYSTEM_NOTIFICATION: //System.out.println("REQUEST_SYSTEM_NOTIFICATION  " + result);
				//查看有無系統通知
				try {
					final JSONObject notifications = new JSONObject(result);
					final JSONArray messagesArray = notifications.getJSONArray("messages");
					final int l = messagesArray.length();
					for (int i = 0; i < l; i++) {
						final JSONObject notification = messagesArray.getJSONObject(i);
						final int type = notification.getInt("msg_type");
						switch (type) {
							case 5000: //收到新訊息
								final String groupid = notification.getString("msg_content");
								if (groupid.equals(GROUP_ID)) {
									api.getMessage(REQUEST_GET_MESSAGE, groupid, String.valueOf(lastReceiveMessageTime));
								}
								break;
							case 1000: //有新使用者加入
								break;
						}
					}
				} catch (final Exception ex) {

				}
				if (!stopping) {
					try {
						//停止1秒
						Thread.sleep(1000);
					} catch (final Exception ex) {

					}
					//再次查看系統通知
					api.getSystemNotification(REQUEST_SYSTEM_NOTIFICATION);
				}
				break;
			case REQUEST_SET_MESSAGE: //System.out.println("REQUEST_SET_MESSAGE");
				break;
			case REQUEST_INITIAL_JOIN_GROUP: //System.out.println("REQUEST_INITIAL_JOIN_GROUP");
				api.getServertime(REQUEST_INITIAL_GET_SERVER_TIME);
				break;
			case REQUEST_GET_MESSAGE: //System.out.println("REQUEST_GET_MESSAGE");
				//取得群組中的訊息
				try {
					if (result != null && result.length() > 0) {
						final JSONObject messagesObj = new JSONObject(result);
						messages = messagesObj.getJSONArray("messages");
						final int l = messages.length();
						//將傳送者的使用者ID暫存到ArrayList中
						final ArrayList<String> idList = new ArrayList<>();
						for (int i = 0; i < l; i++) {
							final JSONObject message = messages.getJSONObject(i);
							final String senderID = message.getString("msg_senderid");
							if (!idList.contains(senderID)) {
								idList.add(senderID);
							}
						}
						//轉成陣列
						final String[] idArray = new String[idList.size()];
						idList.toArray(idArray);
						api.getProfiles(REQUEST_GET_PROFILE, idArray);
					} else {
						available = true;
					}
				} catch (final Exception ex) { ex.printStackTrace();

				}
				break;
			case REQUEST_GET_PROFILE: //System.out.println("REQUEST_GET_PROFILE");
				// 取得Profile
				try {
					final JSONObject profiles = new JSONObject(result);
					final JSONArray profileArray = profiles.getJSONArray("profiles");
					final int l = profileArray.length();
					for (int i = 0; i < l; i++) {
						final JSONObject profile1 = profileArray.getJSONObject(i);
						final String profileID = profile1.getString("person_email");
						profileMap.put(profileID, profile1);
					}
					if (!available) {
						available = true;
					} else {
						final int length = messages.length();
						for (int i = 0; i < length; i++) {
							final JSONObject message = messages.getJSONObject(i);
							parseMessage(message, true);
						}
					}
				} catch (final Exception ex) {

				}
				break;
			case REQUEST_SET_GROUP: //System.out.println("REQUEST_SET_GROUP");
				api.setGroupJoin(REQUEST_INITIAL_JOIN_GROUP, GROUP_ID);
				break;
			case REQUEST_GET_GROUP: //System.out.println("REQUEST_GET_GROUP");
				try {
					System.out.println();
					if (result != null && result.length() > 0) {
						final JSONObject messagesObj = new JSONObject(result);
						messages = messagesObj.getJSONArray("groups");
						final int l = messages.length();
						if(l>0) inGroup=true;
						//將傳送者的使用者ID暫存到ArrayList中
						final ArrayList<String> idList = new ArrayList<>();
						for (int i = 0; i < l; i++) {
							final JSONObject message = messages.getJSONObject(i);
							final String userID = message.getString("group_members");
							if (!idList.contains(userID)) {
								idList.add(userID);
							}
						}
						//轉成陣列
						final String[] idArray = new String[idList.size()];
						idList.toArray(idArray);
						
					} else {
						available = true;
					}
				} catch (final Exception ex) {

				}
				break;
		}
	};

	public static boolean login(boolean init) {
		gameStage = new GameStage();
		
		api.initial(REQUEST_INITIAL_LOGIN, APP_NAME, API_KEY, ACCOUNT, PASSWORD, callback);
		while (!available) {
			//Busy Waiting, 直到Meeti物件初始化成功才跳出
			try {
				Thread.sleep(200);
			} catch (final Exception ex) {
			}
		}
		System.out.println("登入成功！");
		System.out.println("---歷史訊息---");
		final int l = messages.length();
		for (int i = 0; i < l; i++) {
			final JSONObject message = messages.getJSONObject(i);
			System.out.println(message);
			parseMessage(message);
		}
		System.out.println("--- ----- ---");
		
		if(init) {
			JSONObject groupData = new JSONObject();
			groupData.put("group_id", GROUP_ID);
			groupData.put("group_name", "Pro.G");
			groupData.put("group_type", "1");
			groupData.put("group_members", "user1,user2,user3,user4,user5");
			groupData.put("group_admins", "user1");
			System.out.println(groupData);
			api.setGroup(REQUEST_SET_GROUP, GROUP_ID, groupData.toString());
			System.out.println("創立群組！");
		}
		
		gameStage.nextStage();
		waiting();
			
		return true;
	}
	
	public static void waiting() {

		//開始取得系統通知
		api.getSystemNotification(REQUEST_SYSTEM_NOTIFICATION);
		System.out.println("開始接收");
		
		final JSONObject obj = new JSONObject();
		obj.put("msg_groupid", GROUP_ID);
		obj.put("msg_senderid", ACCOUNT);
		obj.put("msg_content", "join");
		obj.put("msg_type", "1");
		api.setMessage(REQUEST_SET_MESSAGE, GROUP_ID, obj.toString());
		
		playerOrder[0] = ACCOUNT;
		
	}
	
	static enum GAME_PHASE {IDLE, WAIT, DRAW, HERO, PLAY, ATCK, EXCH, END};
	
	public static void gameStart() {
		int plyNum;
		GAME_PHASE gamePhase = GAME_PHASE.IDLE;
		stopping = false;
		while (!stopping) {
			final String message = "";
			
			switch(gamePhase) {
			case IDLE:
				if(Receiver.hasMessage()) {
					String[] receive = Receiver.get().content();
					if("end".equals(receive[0])) {
						if(player.showStatus().equals(receive[1])) {
							gamePhase = GAME_PHASE.DRAW;
						}
					}
				}
				break;
			case WAIT:
				break;
			case DRAW:
				player.drawCard();
				gamePhase = GAME_PHASE.HERO;
				break;
			case HERO:
				break;
			case PLAY:
				break;
			case ATCK:
				break;
			case EXCH:
				break;
			case END:
				break;
			}
			
			if (message.length() > 0) {
				if (":q".equals(message)) { //輸入「:q」停止
					stopping = true;
					System.out.println("掰掰");
				} else if (":g".equals(message)) {
					api.getGroups(REQUEST_GET_GROUP);
				} else {
					final JSONObject obj = new JSONObject();
					obj.put("msg_groupid", GROUP_ID);
					obj.put("msg_senderid", ACCOUNT);
					obj.put("msg_content", message);
					obj.put("msg_type", "1");
					api.setMessage(REQUEST_SET_MESSAGE, GROUP_ID, obj.toString());
				}
			}
		}
		gameStage.nextStage();
	}


	/**
	 * 分析訊息。
	 *
	 * @param message 傳入訊息物件
	 * @param ignoreSelf 傳入是否忽略自己的訊息
	 */
	public static void parseMessage(final JSONObject message, final boolean ignoreSelf) {
		final String senderID = message.getString("msg_senderid");
		final String content = message.getString("msg_content");
		final String[] subContent = content.split(",");
		lastReceiveMessageTime = message.getLong("msg_time") + 1; //記錄最後收到訊息的時間
		if (ignoreSelf || startTime > message.getLong("msg_time")) {
			if (ACCOUNT.equals(senderID)) {
				return;
			}
		}
		System.out.println(message);
		if(gameStage.isWaiting()) {
			if("join".equals(subContent[0])) {
				System.out.println(++waitCount);
				playerOrder[waitCount] = senderID;
				if(waitCount == 3) {

					final JSONObject obj = new JSONObject();
					obj.put("msg_groupid", GROUP_ID);
					obj.put("msg_senderid", ACCOUNT);
					obj.put("msg_content", "start,"+playerOrder[0]+","+playerOrder[1]+","+playerOrder[2]+","+playerOrder[3]);
					obj.put("msg_type", "1");
					api.setMessage(REQUEST_SET_MESSAGE, GROUP_ID, obj.toString());
					
					myOrder = 0;
					gameStart();
				}
			} else if("start".equals(subContent[0])) {
				for(int i=0; i<4; i++) {
					playerOrder[i] = subContent[i+1];
					if(playerOrder[i].equals(ACCOUNT)) {
						myOrder = i;
					}
				}
				gameStart();
			}
		} else if(gameStage.isPlaying()) {
			Receiver.send(new BaseMessage(message.getString("msg_senderid"), message.getString("msg_content")));
		}
		/*
		if (profileMap.containsKey(senderID)) {
			System.out.println(String.format("%s：%s", profileMap.get(senderID).getString("person_name"), content));
		} else {
			System.out.println(String.format("%s：%s", senderID, content));
		}
		*/
	}

	/**
	 * 分析訊息。
	 *
	 * @param message 傳入訊息物件
	 */
	public static void parseMessage(final JSONObject message) {
		parseMessage(message, false);
	}
	
	
}
