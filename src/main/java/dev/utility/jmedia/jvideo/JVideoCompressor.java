package dev.utility.jmedia.jvideo;

import java.io.IOException;
import java.util.List;

import dev.utility.jbase.JHelper;
import dev.utility.jbase.constants.JConstants;
import dev.utility.jfile.JFileSorter;
import dev.utility.jfile.JFileTools;
import dev.utility.jmedia.JMediaConfigurations;
import dev.utility.jsystem.JSystemTools;
import dev.utility.jsystem.JTerminal;
   
public class JVideoCompressor {

	JTerminal terminal = JSystemTools.getTerminal(JTerminal.DEBUG_ON);

	private int INPUT_FILE_INDEX = 2;
	private int OUTPUT_FILE_INDEX = 5;

	JVideoCompressor() throws IOException, InterruptedException {
		terminal.rm(JConstants.OUTPUT_VIDEO_DIRECTORY);
		terminal.mkdir(JConstants.OUTPUT_VIDEO_DIRECTORY);
		process();

	}

	public void process() throws IOException, InterruptedException {

		JFileSorter sorter = JFileTools.getFileSorter(JConstants.INPUT_VIDEO_DIRECTORY, JFileSorter.NO_SORT);
		String inputFileName = sorter.getFileNames()[0];
		String outputFileName = JHelper.getExtFileName(inputFileName);
		outputFileName = JConstants.OUTPUT_VIDEO_DIRECTORY + outputFileName;
		String[] compressorArray = JMediaConfigurations.VIDEO_COMPRESSION_COMMAND;
		compressorArray[2] = inputFileName;
		compressorArray[5] = outputFileName;

	}

}
