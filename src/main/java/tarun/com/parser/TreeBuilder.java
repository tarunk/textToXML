package tarun.com.parser;

import tarun.com.node.XmlNode;
import tarun.com.node.XmlTree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TreeBuilder {
	private List<XmlNode> xmlNodes;
	
	public TreeBuilder(List<XmlNode> nodes) {
		xmlNodes = nodes;
	}
	
	public XmlTree buildTree() {
		XmlTree xmlTree = new XmlTree();
		Map<Integer, XmlNode> parent = new HashMap<>();
		
		for (XmlNode node : xmlNodes) {
			if (0 == node.getLevel()) {
				xmlTree.addToRoot(node);
				parent.clear();
				parent.put(node.getLevel(), node);
			} else {
				XmlNode parentNode = parent.get(node.getLevel() - 1);
				if (null == parentNode) {
					throw new NullPointerException("Level " + (node.getLevel() - 1) + " - parent is not present, illegal input");
				}
				parentNode.addNode(node);
				parent.put(node.getLevel(), node);	
			}
		}
		

		return xmlTree;
	}
}
 