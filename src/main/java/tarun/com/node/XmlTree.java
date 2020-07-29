package tarun.com.node;

public class XmlTree {
	private final static int rootLevel = -1;
	private final static String rootTag = "gedcom";
	private XmlNode root;
	
	public XmlTree() {
		root = new XmlNode();
		root.setLevel(rootLevel);
		root.setTag(rootTag);
	}
	
	public XmlNode getRoot() {
		return root;
	}
	
	public void addToRoot(XmlNode node) {
		if (null == node) {
			throw new NullPointerException("XmlNode is null");
		}
		root.addNode(node);
	}
	
	public String toString() {
		return root.toString();
	}
}
