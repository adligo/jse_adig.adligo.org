package org.adligo.i.jse_adig;

import org.adligo.i.adig.client.GRegistry;

public class JseRegistry {

	public static void setup() {
		GRegistry.addCheckedInvoker(
				JseInvokerNames.CREATE_DIRECTORY_INVOKER, 
				new CreateDirectoryInvoker());
		GRegistry.addCheckedInvoker(
				JseInvokerNames.MOVE_FILE_INVOKER, 
				new MoveFileInvoker());
		
	}
}
