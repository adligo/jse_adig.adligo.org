package org.adligo.i.jse_adig;

import java.util.Collection;


public class FileAppenderToken {
	private FileAppender appender;
	private boolean line = false;
	private String data;
	private Collection<String> lines;
	public FileAppenderToken(FileAppender p_appender,String p_data, boolean p_line) {
		appender = p_appender;
		data = p_data;
		line = p_line;
	}
	
	public FileAppenderToken(FileAppender p_appender,Collection<String> p_lines) {
		line = false;
		appender = p_appender;
		lines = p_lines;
	}

	FileAppender getAppender() {
		return appender;
	}

	boolean isLine() {
		return line;
	}

	String getData() {
		return data;
	}

	private boolean hasLines() {
		if (lines != null) {
			return true;
		}
		return false;
	}
	Collection<String> getLines() {
		return lines;
	}
}
