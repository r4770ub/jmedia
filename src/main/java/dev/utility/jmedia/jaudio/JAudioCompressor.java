package dev.utility.jmedia.jaudio;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import dev.utility.jmedia.JMediaConfigurations;
import dev.utility.jsystem.JSystemTools;
import dev.utility.jsystem.JTerminal;

public class JAudioCompressor {
	public static final int RECURSIVE_COMPRESSION = 0;
	public static final int ITERATIVE_COMPRESSION = 1;


	private int compressionOption;
	private String currentFile; 

	PrintWriter writer;
	Process process;

	JAudioCompressor(int COMPRESSION_OPTION) throws IOException 
	{
		this.compressionOption = COMPRESSION_OPTION;
		writer = new PrintWriter(JMediaConfigurations.AUDIO_ERROR_LOG);
		JTerminal terminal = JSystemTools.getTerminal(JTerminal.DEBUG_ON);
		terminal.mkdir(JMediaConfigurations.AUDIO_COMPRESSED_DIR);
	 	terminal.mkdir(JMediaConfigurations.AUDIO_UNCOMPRESSED_DIR);
	}
	public void process() throws IOException, InterruptedException 
	{
		if(compressionOption == RECURSIVE_COMPRESSION)
		{
			recursiveCompression(new File(JMediaConfigurations.AUDIO_UNCOMPRESSED_DIR));
		}
		else if( compressionOption == ITERATIVE_COMPRESSION)
		{
			interativeCompression(new File(JMediaConfigurations.AUDIO_UNCOMPRESSED_DIR)); 
		}
		else
		{
			throw new IOException("Invalid compression option entered"); 
		}
	}

	private void recursiveCompression(File root) throws IOException, InterruptedException 
	{
		if(root.isFile())
		{
			convertFile(root); 
		}
		else
		{
			interativeCompression(root); 
		}
	}
	private void interativeCompression(File root) throws IOException, InterruptedException 
	{
		
		File[] files = root.listFiles(); 
		for(File file: files)
		{
			convertFile(file); 
		}
		
	}

	private void convertFile(File audioFile) throws IOException, InterruptedException {

		File newAudiofile = new File(audioFile.getAbsolutePath().replaceAll("uncompressed", "compressed"));
		log("File: " + audioFile.getAbsolutePath());

		if (newAudiofile.exists()) 
		{
			log("File already exsists not overriding");
		}
		else if(!audioFile.getAbsolutePath().contains(".mp3"))
		{
			log("File is not a mp3 file"); 
		}
		else
		{
			
			JMediaConfigurations.AUDIO_COMPRESSION_COMMAND[3] = audioFile.getAbsolutePath();
			String outputAudioString = audioFile.getAbsolutePath().replaceAll("uncompressed", "compressed");
		//	outputAudioString= outputAudioString.replaceAll(" ", "_");
			File outputAudioFile = new File(outputAudioString);
			JMediaConfigurations.AUDIO_COMPRESSION_COMMAND[4] = outputAudioFile.getAbsolutePath();

			ProcessBuilder pb = new ProcessBuilder(JMediaConfigurations.AUDIO_COMPRESSION_COMMAND).inheritIO();
			process = pb.start();
			process.waitFor();
			process.destroy();

		} 
	}
	private void log(String event)
	{
		
		System.out.println(currentFile+  ":" + event); 
		writer.println(currentFile +":"+ event); 
		
	}


}
