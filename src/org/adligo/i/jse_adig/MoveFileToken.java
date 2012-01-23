package org.adligo.i.jse_adig;

/**
 * this class is just the input to a file move operation
 * (on java.io.File wrapped for JUnits)
 * it uses the system dependent file path name
 * 
 * @author scott
 *
 */
public class MoveFileToken {
	private String from_file_path;
	private String to_file_path;
	
	public String getFrom_file_path() {
		return from_file_path;
	}
	public void setFrom_file_path(String from_file_path) {
		this.from_file_path = from_file_path;
	}
	public String getTo_file_path() {
		return to_file_path;
	}
	public void setTo_file_path(String to_file_path) {
		this.to_file_path = to_file_path;
	}
}
