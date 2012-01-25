package org.adligo.i.jse_adig;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.adligo.i.adi.client.InvocationException;
import org.adligo.i.adig.client.BaseGInvoker;
import org.adligo.i.adig.client.I_GCheckedInvoker;
import org.adligo.i.util.client.StringUtils;

public class FileAppenderFactoryInvoker extends BaseGInvoker implements I_GCheckedInvoker<FileAppenderParams, FileAppender>{

	public static final String FOR_WRITING = " for writing.";
	public static final String WAS_NOT_ABLE_TO_OPEN_FILE = " was not able to open file ";
	public static final String COULD_NOT_CREATE_NEW_FILE = " could NOT create new file ";
	public static final String REQUIRES_A_NON_NULL_FILE_APPENDER_PARAMS_ARGUMENT = 
							" requires a non null FileAppenderParams argument.";

	public FileAppenderFactoryInvoker() {
		super(FileAppenderParams.class, FileAppender.class);
	}

	@Override
	public FileAppender invoke(FileAppenderParams valueObject)
			throws InvocationException {
		if (valueObject == null) {
			throw new InvocationException("" + this.getClass().getName() +
					REQUIRES_A_NON_NULL_FILE_APPENDER_PARAMS_ARGUMENT);
		}
		String fileName = valueObject.getFileName();
		if (StringUtils.isEmpty(fileName)) {
			InvocationException ix = new InvocationException(
					"" + this.getClass().getName() + 
					COULD_NOT_CREATE_NEW_FILE + fileName);
			throw ix;
		}
		File file = new File(fileName);
		try {
			boolean result = file.createNewFile();
			if (!result) {
				throw new InvocationException(
						"" + this.getClass().getName() + 
						COULD_NOT_CREATE_NEW_FILE + fileName);
			}
		} catch (IOException x) {
			InvocationException ix = new InvocationException(
					"" + this.getClass().getName() + 
					COULD_NOT_CREATE_NEW_FILE + fileName);
			ix.initCause(x);
			throw ix;
		}
		FileWriter writer;
		try {
			writer = new FileWriter(file);
		} catch (IOException x) {
			InvocationException ix = new InvocationException(
					"" + this.getClass().getName() + 
					WAS_NOT_ABLE_TO_OPEN_FILE + fileName + FOR_WRITING);
			ix.initCause(x);
			throw ix;
		}
		String lineFeed = valueObject.getLineFeed();
		if (lineFeed == null) {
			lineFeed = FileAppenderParams.UNIX_LINE_FEED;
		}
		FileAppender toRet = new FileAppender(writer, lineFeed);
		return toRet;
	}

}
