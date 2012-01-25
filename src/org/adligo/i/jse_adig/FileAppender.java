package org.adligo.i.jse_adig;

import java.io.FileWriter;

/**
 * note most of the getters in this class are package
 * private to prevent access from client code
 * 
 * @author scott
 *
 */
public class FileAppender {
	public static final String FILE_APPENDER_DOES_NOT_ACCEPT_A_NULL_WRITER = 
						"FileAppender does not accept a null writer";
	public static final String FILE_APPENDER_DOES_NOT_ACCEPT_A_NULL_LINE_FEED = 
						"FileAppender does not accept a null line feed";
	
	private FileWriter writer;
	private String lineFeed;
	
	FileAppender(FileWriter p, String p_lineFeed) {
		writer = p;
		if (writer == null) {
			throw new NullPointerException(FILE_APPENDER_DOES_NOT_ACCEPT_A_NULL_WRITER);
		}
		lineFeed = p_lineFeed;
		if (lineFeed == null) {
			throw new NullPointerException(FILE_APPENDER_DOES_NOT_ACCEPT_A_NULL_LINE_FEED);
		}
	}
	
	FileWriter getWriter() {
		return writer;
	}

	String getLineFeed() {
		return lineFeed;
	}
	
}
