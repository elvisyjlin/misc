package prog.unknown_hero.utility;

public class BaseMessage {

	String type;
	String content;
	
	public BaseMessage(String type, String content) {
		this.type = type;
		this.content = content;
	}
	
	public String type() {
		return type;
	}
	
	public String[] content() {
		return content.split(",");
	}
	
}
