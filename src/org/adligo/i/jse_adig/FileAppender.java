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
	private FileWriter writer;
	private String lineFeed;
	
	public FileAppender(FileWriter p, String p_lineFeed) {
		writer = p;
		lineFeed = p_lineFeed;
	}
	
	FileWriter getWriter() {
		return writer;
	}

	String getLineFeed() {
		return lineFeed;
	}
	
}
