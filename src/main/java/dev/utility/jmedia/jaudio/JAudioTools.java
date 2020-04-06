package dev.utility.jmedia.jaudio;

import java.io.FileNotFoundException;
import java.io.IOException;

public class JAudioTools 
{

	JAudioTools() 
	{
		
	}
	public  static JAudioCompressor getJAudioCompressor(int COMPRESSION_OPTION) throws IOException
	{
		return new JAudioCompressor(COMPRESSION_OPTION);
	}
	
	public static JAudioExtractor getJAudioExtractor(String inputFileName) throws IOException
	{
		return new JAudioExtractor(inputFileName); 
	}

}
