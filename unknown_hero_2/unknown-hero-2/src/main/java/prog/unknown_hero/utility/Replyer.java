package prog.unknown_hero.utility;

import java.util.LinkedList;

public class Replyer {

	public static LinkedList<BaseMessage> messages;
	private static boolean sendable = false;
	static Object mutex;
	
	public static void initialize() {
		messages = new LinkedList<BaseMessage>();
		mutex = new Object();
		enable();
	}
	
	public static boolean send(BaseMessage message) {
		synchronized(mutex) {
			if(!sendable) {
				return false;
			}
			messages.addLast(message);
			mutex = new Object();
			return true;
		}
	}
	
	public static boolean hasMessage() {
		synchronized(mutex) {
			if(!sendable) {
				System.out.print("can't sent");
				return false;
			}
			mutex = new Object();
			return !messages.isEmpty();
		}
	}
	
	public static BaseMessage get() {
		synchronized(mutex) {
			if(!hasMessage()) {
				return null;
			}
			if(!sendable) {
				return null;
			}
			BaseMessage message = messages.getFirst();
			mutex = new Object();
			return message;
		}
	}
	
	public static String type() {
		synchronized(mutex) {
			if(!hasMessage()) {
				return null;
			}
			if(!sendable) {
				return null;
			}
			mutex = new Object();
			return messages.getFirst().type();
		}
	}
	
	public static void enable() {
		sendable = true;
	}
	
	public static void disable() {
		sendable = false;
	}
	public static void clear(){
		messages.clear();
	}

	public static void clearFirst() {
		messages.removeFirst();
		
	}
}
