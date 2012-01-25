package org.adligo.i.jse_adig;

/**
 * for character files 
 * good name for 
 * 
 * @author scott
 *
 */
public class FileAppenderParams {
	public static final String UNIX_LINE_FEED = "\n";
	public static final String MAC_LINE_FEED = "\r";
	public static final String DOS_LINE_FEED = "\r\n";
	
	/**
	 * should be one of the constants above
	 * but anything goes
	 */
	private String lineFeed;
	private String fileName;
	
	String getLineFeed() {
		return lineFeed;
	}
	void setLineFeed(String lineFeed) {
		this.lineFeed = lineFeed;
	}
	String getFileName() {
		return fileName;
	}
	void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
