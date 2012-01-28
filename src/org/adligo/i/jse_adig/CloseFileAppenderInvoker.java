package org.adligo.i.jse_adig;

import java.io.IOException;

import org.adligo.i.adig.client.BaseGInvoker;
import org.adligo.i.adig.client.I_GInvoker;
import org.adligo.i.log.client.Log;
import org.adligo.i.log.client.LogFactory;

public class CloseFileAppenderInvoker extends BaseGInvoker implements I_GInvoker<FileAppender, Boolean>  {
	private static final Log log = LogFactory.getLog(CloseFileAppenderInvoker.class);
	
	CloseFileAppenderInvoker () {
		super(FileAppender.class, Boolean.class);
	}

	@Override
	public Boolean invoke(FileAppender valueObject) {
		try {
			valueObject.close();
			return true;
		} catch (IOException x) {
			// note this is one of the checked exceptions I generally disagree with 
			// in the java api, how would a programmer recover from a IOException
			// during close of file writer, close it again?
			log.debug(x.getMessage(), x);
		}
		return false;
	}
}
