package org.adligo.i.jse_adig;

import org.adligo.i.adig.shared.GRegistry;

public class JseRegistry {

	public static void setup() {
		//invokers
		GRegistry.addInvoker(JseInvokerNames.DIRECTORY_EXISTS_INVOKER, 
				new DirectoryExistsInvoker());
		GRegistry.addInvoker(JseInvokerNames.FILE_EXISTS_INVOKER, 
				new FileExistsInvoker());
		GRegistry.addInvoker(JseInvokerNames.CLOSE_FILE_APPENDER_INVOKER, 
				new CloseFileAppenderInvoker());
		//checked invokers
		GRegistry.addCheckedInvoker(
				JseInvokerNames.CREATE_DIRECTORY_INVOKER, 
				new CreateDirectoryInvoker());
		GRegistry.addCheckedInvoker(
				JseInvokerNames.MOVE_FILE_INVOKER, 
				new MoveFileInvoker());
		
		GRegistry.addCheckedInvoker(
				JseInvokerNames.FILE_APPENDER_FACTORY_INVOKER, 
				new FileAppenderFactoryInvoker());
		GRegistry.addCheckedInvoker(
				JseInvokerNames.FILE_APPENDER_INVOKER, 
				new FileAppenderInvoker());
	}
}
