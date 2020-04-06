package dev.utility.jmedia;

public class JMediaConfigurations 
{
	public static final String AUDIO_DIRECTORY= "/home/r4770/Music/";
	public static final String AUDIO_FILE_DIRECTORY= "/home/r4770/Music/music";
	public static final String AUDIO_UNCOMPRESSED_DIR= "/home/r4770/Music/uncompressed/";
	public static final String AUDIO_COMPRESSED_DIR= "/home/r4770/Music/compressed/";
	
	public static final String VIDEO_DIRECTORY= "/home/r4770/Videos/";
	public static final String VIDEO_FILE_DIRECTORY= "/home/r4770/Videos/videos";
	public static final String VIDEO_INPUT_DIR= "/home/r4770/Videos/inputs/";
	public static final String VIDEO_COMPRESSED_DIR= "/home/r4770/Videos/compressed/";
	public static final String VIDEO_CONVERTED_DIR= "/home/r4770/Videos/converted/";

	 

	public static final String AUDIO_ERROR_LOG = JMediaConfigurations.AUDIO_DIRECTORY + "audio_log.dat"; 
	public static final String VIDEO_ERROR_LOG = JMediaConfigurations.VIDEO_DIRECTORY + "video_log.dat"; 

 
	
	public static final   String[] AUDIO_COMPRESSION_COMMAND = { "lame", "-b", "64", " ", " " };
	public static final String [] AUDIO_EXTRACTOR_COMMAND = {"youtube-dl", "--extract-audio", "--audio-format mp3", " -o ",JMediaConfigurations.AUDIO_UNCOMPRESSED_DIR ,"%(title)s.%(ext)s "};
	
	public static final  String[] VIDEO_COMPRESSION_COMMAND = 	{"ffmpeg", "-i", " ", "-vf", "scale=iw/2:ih/2" , " "};
	public static final  String[] VIDEO_CHANGE_FORMAT_COMMAND = 	{"ffmpeg", "-i", " ", "-vcodec", "copy" , " "};
	public static final String[] VIDEO_CROP_COMMAND = {"ffmpeg","-i", " ", "-ss"," ", "-t"," ", "-c", "copy", " "};


   
} 
