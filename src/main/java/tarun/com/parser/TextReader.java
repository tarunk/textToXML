package tarun.com.parser;

import tarun.com.node.XmlNode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TextReader
{
	private List<XmlNode> xmlNodes;
	private String fileName;
	
	public TextReader(String filePath) {
		fileName = filePath;
		xmlNodes = new ArrayList<>();
		
	}
	
	public List<XmlNode> textToXmlNode() {
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(fileName));
			String line;
			int lineCount = 0;
			while ((line = bufferReader.readLine()) != null && lineCount < Integer.MAX_VALUE) {
				++lineCount;
				if (line != null && line.trim().compareTo("") != 0) {
					String[] tokens = line.split("\\s+", 3);
					XmlNode xmlNode = new XmlNode();
					xmlNode.setLevel(Integer.parseInt(tokens[0]));
					if (tokens[1].startsWith("@") && tokens[1].endsWith("@")) {
						xmlNode.setId(tokens[1]);
						xmlNode.setTag(tokens[2].toLowerCase());
					} else if (3 == tokens.length) {
						xmlNode.setTag(tokens[1].toLowerCase());
						if (null != tokens[2]) {
							xmlNode.setValue(tokens[2]);
						}
					} else {
						xmlNode.setTag(tokens[1].toLowerCase());
					}
					
					xmlNodes.add(xmlNode);
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found" + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return xmlNodes;
	}
}
