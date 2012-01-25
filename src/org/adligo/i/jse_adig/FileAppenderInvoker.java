package org.adligo.i.jse_adig;

import org.adligo.i.adi.client.InvocationException;
import org.adligo.i.adig.client.BaseGInvoker;
import org.adligo.i.adig.client.I_GCheckedInvoker;

public class FileAppenderInvoker extends BaseGInvoker implements I_GCheckedInvoker<FileAppenderToken, Boolean>{

	public static final String REQUIRES_A_NON_NULL_FILE_APPENDER_TOKEN = " requires a non Null FileAppenderToken.";

	public FileAppenderInvoker() {
		super(FileAppenderToken.class, Boolean.class);
	}

	@Override
	public Boolean invoke(FileAppenderToken valueObject)
			throws InvocationException {
		if (valueObject == null) {
			throw new InvocationException("" + this.getClass().getName() +
						REQUIRES_A_NON_NULL_FILE_APPENDER_TOKEN);
		}
		return null;
	}
}
