package dev.utility.jmedia.jvideo;

import java.io.IOException;

import dev.utility.jbase.JHelper;
import dev.utility.jbase.constants.JConstants;
import dev.utility.jfile.JFileSorter;
import dev.utility.jfile.JFileTools;
import dev.utility.jmedia.FFMPEG;
import dev.utility.jmedia.JMediaConfigurations;

public class JVideoCropper {
	
	
	private final int INDEX_INPUT_FILE = 2; 
	private final int INDEX_START_TIME = 4; 
	private final int INDEX_DURATION = 6; 
	private final int OUTPUT_FILE = 9; 
	private String inputFile; 
	private String startTime; 
	private String duration; 

  
   
	
	JVideoCropper(String startTimme, String duration ) throws IOException, InterruptedException
	{
		JFileSorter fileSorter = JFileTools.getFileSorter(JConstants.INPUT_VIDEO_DIRECTORY, JFileSorter.NO_SORT);
		this.inputFile = fileSorter.getFileNames()[0]; 
		this.startTime = startTime; 
		this.duration = duration; 
		System.out.println("Video cropper selected....");
		System.out.println("Start time: " +  startTime); 
		System.out.println("Duration time: "+ duration);
		crop();
	}
    
    
    public void crop() throws IOException, InterruptedException
    {
    	
    	String fileName = JHelper.getExtFileName(inputFile);
    	String[] cropCommandArray = JMediaConfigurations.VIDEO_CROP_COMMAND;
    	
    	for(String str: cropCommandArray)
    	{
    		System.out.println(str);
    	}
    	cropCommandArray[INDEX_INPUT_FILE] = inputFile; 
    	cropCommandArray[INDEX_START_TIME] = startTime; 
    	cropCommandArray[INDEX_DURATION] = duration; 
    	cropCommandArray[OUTPUT_FILE] = JConstants.OUTPUT_DESKTOP_DIRECTORY + fileName; 
    	
    	FFMPEG ffmpeg = new FFMPEG(cropCommandArray); 
    	ffmpeg.run(); 
    	
   
    }

}
