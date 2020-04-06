package dev.utility.jmedia;

import java.io.IOException;

public class FFMPEG {
	
	
	
	private String[] commandArray; 
	public FFMPEG(String [] commandArray) 
	{
		this.commandArray = commandArray; 
	}
	public void run() throws IOException, InterruptedException 
	{
		
    	printCommand();
    	ProcessBuilder pb = new ProcessBuilder(commandArray).inheritIO();
		Process process = pb.start();
		process.waitFor();
		process.destroy();
	 
	}
	
	private void printCommand() 
	{
		for(String str: commandArray)
		{
			System.out.print(str + " ");
		}
	}
	

}
