package tarun.com.parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XmlWriter {
	private static final String FILE_EXT_SEPARATOR = "\\.(?=[^\\.]+$)";
	private String outputFile;
	
	public XmlWriter(String fileName) {
		outputFile = fileName.split(FILE_EXT_SEPARATOR)[0] + ".xml";
	}
	
	public String getoutputFile() {
		return outputFile;
	}
	
	public void writeXmlFile(String xmlText) {
		File file = new File(this.outputFile);
		BufferedWriter bw = null;
		
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			
			bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
			bw.write(xmlText);
		} catch(IOException e) {
			System.err.println("Failed to write file " + file.getAbsoluteFile());
			e.printStackTrace();
		} finally {
			if (bw != null)
			{
				try
				{
					bw.close();
				}
				catch (IOException e)
				{
					System.err.println("Unable to close file " + file.getAbsoluteFile());
					e.printStackTrace();
				}
			}
		}
		
	}
}
