package tarun.com.node;

import java.util.ArrayList;
import java.util.List;

public class XmlNode {
	private int level;
	private String id;
	private String tag;
	private String value;
	private List<XmlNode> childNodes;
	
	
	public XmlNode() {
		childNodes = new ArrayList<>();
	}

	public void addNode(XmlNode ele) {
		if (null == ele) {
			throw new NullPointerException("Error: Inserting null");
		}
		childNodes.add(ele);
	}
	
	public String toString() {
		StringBuilder xml = new StringBuilder();
		List<XmlNode> childNodes = this.getChildNodes();
		if (childNodes.isEmpty()) {
			xml.append(XmlNodeManager.childTag(this));
		} else {
			xml.append(XmlNodeManager.openTag(this));
			for (XmlNode node : childNodes) {
				xml.append(node.toString());
			}
			xml.append(XmlNodeManager.closeTag(this));
		}
		return xml.toString();
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<XmlNode> getChildNodes() {
		return childNodes;
	}

	public void setChildNodes(List<XmlNode> childNodes) {
		this.childNodes = childNodes;
	}
	
	
}
