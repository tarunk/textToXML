package tarun.com.app;

import tarun.com.node.XmlNode;
import tarun.com.node.XmlTree;
import tarun.com.parser.TextReader;
import tarun.com.parser.TreeBuilder;
import tarun.com.parser.XmlWriter;

import java.util.List;

public class GedcomParser {
	
	public static void parseAndWriteXML(String textFilePath) throws Exception {
		try {
			TextReader textRd = new TextReader(textFilePath);
			XmlWriter xmlWr = new XmlWriter(textFilePath);
			List<XmlNode> xmlNodes = textRd.textToXmlNode();
			TreeBuilder tBuilder = new TreeBuilder(xmlNodes);
			XmlTree xmlTree = tBuilder.buildTree();
			String xml = xmlTree.toString();
			xmlWr.writeXmlFile(xml);
		} catch (Exception e) {
			throw e;
		}
		
	}
 
	public static void main(String[] args) {
		try {
			if (args.length < 1) {
				System.out.println("specify file name");
				return;
			}
			GedcomParser.parseAndWriteXML(args[0]);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
