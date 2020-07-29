package tarun.com.node;


public class XmlNodeManager {

	private static String indent(XmlNode node) {
		StringBuilder sb = new StringBuilder();
		int indent = node.getLevel() + 1;
		
		while (indent != 0) {
			sb.append("  ");
			--indent;
		}
		return sb.toString();
	}
	
	public static String openTag(XmlNode node) {
		StringBuilder sb = new StringBuilder();
		sb.append(indent(node));
		
		sb.append("<" + node.getTag());
		
		if (node.getId() != null) {
			sb.append(" id=\"" + node.getId() + "\"");
		}
		
		if (node.getValue() != null) {
			sb.append(" value=\"" + node.getValue() + "\"");
		}
		
		sb.append(">\n");
		
		return sb.toString();
	}
	
	public static String closeTag(XmlNode node) {
		StringBuilder sb = new StringBuilder();
		sb.append(indent(node));
		sb.append("</" + node.getTag() + ">\n");
		return sb.toString();
	}
	
	public static String childTag(XmlNode node) {
		StringBuilder sb = new StringBuilder();
		sb.append(indent(node));
		if (null != node.getValue() && !node.getValue().equals("")) {
			sb.append("<" + node.getTag() + ">" + node.getValue() + "</" + node.getTag() + ">\n");
		} else {
			sb.append("</" + node.getTag() + ">\n");
		}
		return sb.toString();
	}
}
