package org.adligo.i.jse_adig;

import org.adligo.i.adig.client.GRegistry;

public class JseRegistry {

	public static void setup() {
		//invokers
		GRegistry.addInvoker(JseInvokerNames.DIRECTORY_EXISTS_INVOKER, 
				new DirectoryExistsInvoker());
		GRegistry.addInvoker(JseInvokerNames.FILE_EXISTS_INVOKER, 
				new FileExistsInvoker());
		
		//checked invokers
		GRegistry.addCheckedInvoker(
				JseInvokerNames.CREATE_DIRECTORY_INVOKER, 
				new CreateDirectoryInvoker());
		GRegistry.addCheckedInvoker(
				JseInvokerNames.MOVE_FILE_INVOKER, 
				new MoveFileInvoker());
		
	}
}
