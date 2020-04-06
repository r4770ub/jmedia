package dev.utility.jmedia.jvideo;

import java.io.IOException;

public class JVideoTools {
	
	public static JVideoCropper getJVideoCropper(String startTime, String duration) throws IOException, InterruptedException
	{
		return new JVideoCropper(startTime, duration); 
	}
	
	public static JVideoCompressor getJVideoCompressor() throws IOException, InterruptedException
	{
		return new JVideoCompressor(); 
	}

}
