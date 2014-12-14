package prog.unknown_hero.utility;

import java.util.LinkedList;

public class Receiver {

	private static LinkedList<BaseMessage> messages;
	private static boolean sendable = false;
	static Object mutex;
	
	public static void initialize() {
		messages = new LinkedList<BaseMessage>();
		mutex = new Object();
		enable();
	}
	
	public static void send(BaseMessage message) {
		synchronized(mutex) {
			if(!sendable) {
				return;
			}
			messages.addLast(message);
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
			if(!sendable) {
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
			if(!sendable) {
				return null;
			}
			return messages.getFirst().type();
		}
	}
	
	public static void enable() {
		sendable = true;
	}
	
	public static void disable() {
		sendable = false;
	}

}
