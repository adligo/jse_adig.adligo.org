package org.adligo.i.jse_adig;

import java.util.Collection;


public class FileAppenderToken {
	public static final String FILE_APPENDER_TOKEN_DOES_NOT_ACCEPT_A_NULL_LINES_COLLECTION = 
					"FileAppenderToken does not accept a null lines Collection";
	public static final String FILE_APPENDER_TOKEN_DOES_NOT_ACCEPT_NULL_DATA = 
					"FileAppenderToken does not accept null data.";
	public static final String FILE_APPENDER_TOKEN_DOES_NOT_ACCEPT_A_NULL_FILE_APPENDER = 
					"FileAppenderToken does not accept a null FileAppender.";
	
	private FileAppender appender;
	private boolean line = false;
	private String data;
	private Collection<String> lines;
	
	public FileAppenderToken(FileAppender p_appender,String p_data, boolean p_line) {
		appender = p_appender;
		if (appender == null) {
			throw new NullPointerException(
					FILE_APPENDER_TOKEN_DOES_NOT_ACCEPT_A_NULL_FILE_APPENDER);
		}
		data = p_data;
		if (appender == null) {
			throw new NullPointerException(
					FILE_APPENDER_TOKEN_DOES_NOT_ACCEPT_NULL_DATA);
		}
		line = p_line;
	}
	
	public FileAppenderToken(FileAppender p_appender,Collection<String> p_lines) {
		line = false;
		appender = p_appender;
		if (appender == null) {
			throw new NullPointerException(
					FILE_APPENDER_TOKEN_DOES_NOT_ACCEPT_A_NULL_FILE_APPENDER);
		}
		lines = p_lines;
		if (appender == null) {
			throw new NullPointerException(
					FILE_APPENDER_TOKEN_DOES_NOT_ACCEPT_A_NULL_LINES_COLLECTION);
		}
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

	public boolean hasLines() {
		if (lines != null) {
			return true;
		}
		return false;
	}
	Collection<String> getLines() {
		return lines;
	}
}
