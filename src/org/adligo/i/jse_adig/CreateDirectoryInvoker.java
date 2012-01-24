package org.adligo.i.jse_adig;

import java.io.File;

import org.adligo.i.adi.client.InvocationException;
import org.adligo.i.adig.client.BaseGInvoker;
import org.adligo.i.adig.client.I_GCheckedInvoker;
import org.adligo.i.util.client.StringUtils;

public class CreateDirectoryInvoker extends BaseGInvoker implements I_GCheckedInvoker<String, Boolean> {

	public static final String WAS_NOT_ABLE_TO_CREATE_THE_DIRECTORY_S = " was NOT able to create the directory(s) ";
	public static final String REQUIRES_A_NON_NULL_DIRECTORY_STRING = " requires a non null directory string.";

	public CreateDirectoryInvoker() {
		super(String.class, Boolean.class);
	}

	@Override
	public Boolean invoke(String directory)
			throws InvocationException {
		
		if (StringUtils.isEmpty(directory)) {
			throw new InvocationException("" + this.getClass().getName() +
					REQUIRES_A_NON_NULL_DIRECTORY_STRING);
		}
		File fullDir = new File(directory);
		boolean result = fullDir.mkdirs();
		if (!result) {
			throw new InvocationException("" + this.getClass().getName() +
					WAS_NOT_ABLE_TO_CREATE_THE_DIRECTORY_S + directory);
		}
		return result;
	}
}
