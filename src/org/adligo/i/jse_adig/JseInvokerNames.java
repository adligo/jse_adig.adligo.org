package org.adligo.i.jse_adig;

public class JseInvokerNames {
	public static final String PACKAGE_NAME = "org.adligo.i.jse_adig.";
	
	/**
	 * I_GCheckedInvoker
	 * accepts a string returns a boolean
	 */
	public static final String CREATE_DIRECTORY_INVOKER = PACKAGE_NAME + "a";
	/**
	 * I_GCheckedInvoker
	 * accepts a MoveFileToken returns a boolean
	 */
	public static final String MOVE_FILE_INVOKER = PACKAGE_NAME + "b";
	/**
	 * I_GInvoker
	 * accepts a string returns a boolean
	 */
	public static final String DIRECTORY_EXISTS_INVOKER = PACKAGE_NAME + "c";
	/**
	 * I_GInvoker
	 * accepts a string returns a boolean
	 */
	public static final String FILE_EXISTS_INVOKER = PACKAGE_NAME + "d";
	
	/**
	 * I_GCheckedInvoker
	 * accepts a FileAppenderParams object and returns a FileAppender
	 */
	public static final String FILE_APPENDER_FACTORY_INVOKER = PACKAGE_NAME + "e";
	
	/**
	 * I_GCheckedInvoker
	 * accepts a FileAppenderToken object and returns a Boolean
	 */
	public static final String FILE_APPENDER_INVOKER = PACKAGE_NAME + "f";
	

	/**
	 * I_GInvoker
	 * accepts a FileAppenderToken object and returns a Boolean
	 */
	public static final String CLOSE_FILE_APPENDER_INVOKER = PACKAGE_NAME + "g";
}
