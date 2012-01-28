package org.adligo.i.jse_adig;

import java.io.FileWriter;
import java.io.IOException;

import org.adligo.i.util.client.StringUtils;

/**
 * note most of the getters in this class are package
 * private to prevent access from client code
 * 
 * @author scott
 *
 */
public class FileAppender {
	public static final String FILE_APPENDER_DOES_NOT_ACCEPT_A_EMPTY_FILE_NAME = "File Appender does not accept a empty fileName";
	public static final String FILE_APPENDER_DOES_NOT_ACCEPT_A_NULL_WRITER = 
						"FileAppender does not accept a null writer";
	public static final String FILE_APPENDER_DOES_NOT_ACCEPT_A_NULL_LINE_FEED = 
						"FileAppender does not accept a null line feed";
	
	private FileWriter writer;
	private String lineFeed;
	private String fileName;
	private boolean open = true;
	
	FileAppender(FileWriter p, String p_lineFeed, String p_fileName) {
		writer = p;
		if (writer == null) {
			throw new NullPointerException(FILE_APPENDER_DOES_NOT_ACCEPT_A_NULL_WRITER);
		}
		lineFeed = p_lineFeed;
		if (lineFeed == null) {
			throw new NullPointerException(FILE_APPENDER_DOES_NOT_ACCEPT_A_NULL_LINE_FEED);
		}
		fileName = p_fileName;
		if (StringUtils.isEmpty(fileName)) {
			throw new NullPointerException(FILE_APPENDER_DOES_NOT_ACCEPT_A_EMPTY_FILE_NAME);
		}
	}
	
	void append(String p) throws IOException {
		writer.append(p);
	}
	
	void flush() throws IOException {
		writer.flush();
	}
	
	void close() throws IOException {
		open = false;
		writer.close();
	}

	String getLineFeed() {
		return lineFeed;
	}

	String getFileName() {
		return fileName;
	}

	public boolean isOpen() {
		return open;
	}
	
}
