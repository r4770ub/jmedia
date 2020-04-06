package dev.utility.jmedia.jvideo;

import java.io.IOException;
import java.util.List;

import dev.utility.jfile.JFileSorter;
import dev.utility.jfile.JFileTools;
import dev.utility.jmedia.JMediaConfigurations;

public class JVideoConverter {

	public static final String MP4_FORMAAT = "mp4";
	public static final String WEBM_FORMAAT = "webm";
	public static final String FLV_FORMAAT = "flv";
	public static final String AVI_FORMAAT = "avi";

	private String videoExtenstion; 

	JVideoConverter(String user_format) throws IOException
	{
		this.videoExtenstion = user_format;
	}

	public void process() throws InterruptedException, IOException
	{
		JFileSorter fileSorter = JFileTools.getFileSorter(JMediaConfigurations.VIDEO_INPUT_DIR, JFileSorter.SORT_FILES_ALPHANUMERIC);
		String[] fileNames= fileSorter.getFileNames(); 
		for (String fileName : fileNames) {
	
						String inputFilePath = fileName;
						
						String outputFilePath = inputFilePath.substring(0, inputFilePath.length()-3)+ videoExtenstion;
						outputFilePath = outputFilePath.replaceAll("inputs", "outputs"); 

						JMediaConfigurations.VIDEO_CHANGE_FORMAT_COMMAND[2] = inputFilePath;
						JMediaConfigurations.VIDEO_CHANGE_FORMAT_COMMAND[5] = outputFilePath;
						System.out.println("\n\n In File: " + inputFilePath);
						System.out.println("Out File: " + outputFilePath); 
						System.out.println("changing types beginning \n\n"); 
					
						
						ProcessBuilder pb = new ProcessBuilder(JMediaConfigurations.VIDEO_CHANGE_FORMAT_COMMAND).inheritIO();
						Process process = pb.start();
						process.waitFor();
						process.destroy();

				} 
	}

}
