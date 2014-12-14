package prog.unknown_hero.utility;

import java.util.LinkedList;

public class Receiver {

	private static LinkedList<BaseMessage> messages;
	private static boolean sendable = false;
	static Object mutex;
	
	public static void initialize() {
		messages = new LinkedList<BaseMessage>();
		mutex = new Object();
	}
	
	public static void send(BaseMessage message) {
		synchronized(mutex) {
			messages.addLast(message);;
		}
	}
	
	public static boolean hasMessage() {
		synchronized(mutex) {
			if(!sendable) {
				return false;
			}
			return !messages.isEmpty();
		}
	}
	
	public static BaseMessage get() {
		synchronized(mutex) {
			if(!hasMessage()) {
				return null;
			}
			BaseMessage message = messages.getFirst();
			return message;
		}
	}
	
	public static String type() {
		synchronized(mutex) {
			if(!hasMessage()) {
				return null;
			}
			return messages.getFirst().type();
		}
	}

}
