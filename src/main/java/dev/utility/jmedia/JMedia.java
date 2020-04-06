package dev.utility.jmedia;

import java.io.IOException;

import dev.utility.jmedia.jvideo.JVideoTools;

public class JMedia {
	
	public static void main(String[] args) throws IOException, InterruptedException
	{
		if(args[0].equals("trim"))
		{
			JVideoTools.getJVideoCropper(args[1], args[2]);
		}
		
		if(args[0].equals("compress"))
		{
			JVideoTools.getJVideoCompressor();
		}
		
		
	}

}
 