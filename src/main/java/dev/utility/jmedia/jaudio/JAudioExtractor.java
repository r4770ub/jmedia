package dev.utility.jmedia.jaudio;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dev.utility.jmedia.JMediaConfigurations;
import dev.utility.jsystem.JSystemTools;
import dev.utility.jsystem.JTerminal;


public class  JAudioExtractor
{
	
	
	
	
	JTerminal terminal; 

	private List<String> urls; 
	
	JAudioExtractor(String  inputFileName) throws IOException
	{
		
		terminal = JSystemTools.getTerminal(JTerminal.DEBUG_ON);
		this.urls = new ArrayList<String>(); 
		Scanner fileReader = new Scanner(new File(inputFileName)); 

		while(fileReader.hasNext()) 
		{
			urls.add(fileReader.next()) ;
		}
		fileReader.close();
		
		
		
	}
		

	public void process() throws IOException 
	{
		terminal.mkdir(JMediaConfigurations.AUDIO_UNCOMPRESSED_DIR);
		terminal.mkdir(JMediaConfigurations.AUDIO_COMPRESSED_DIR);


		for(String url: urls)
		{
			String command = JMediaConfigurations.AUDIO_EXTRACTOR_COMMAND    + url; 
			terminal.run(command); 
			
		}
		
	}




	public List<String> getRequestData() {
		return urls;
	}



}
