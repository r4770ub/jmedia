package dev.utility.jmedia.jaudio;

import java.io.IOException;

public class CompressorTest {

	public static void main(String [] args) throws IOException, InterruptedException
	{
		JAudioCompressor compressor = JAudioTools.getJAudioCompressor(JAudioCompressor.ITERATIVE_COMPRESSION);
		compressor.process();
	}
}
