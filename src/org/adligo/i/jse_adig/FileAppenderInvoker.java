package org.adligo.i.jse_adig;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

import org.adligo.i.adi.client.InvocationException;
import org.adligo.i.adig.client.BaseGInvoker;
import org.adligo.i.adig.client.I_GCheckedInvoker;

public class FileAppenderInvoker extends BaseGInvoker implements I_GCheckedInvoker<FileAppenderToken, Boolean>{

	public static final String A_IO_EXCEPTION_OCCURED_TRYING_TO_WRITE_DATA_TO_FILE = "A IOException occured trying to write data to file ";
	public static final String A_IO_EXCEPTION_OCCURED_TRYING_TO_WRITE_LINES_TO_FILE = "A IOException occured trying to write lines to file ";
	public static final String REQUIRES_A_NON_NULL_FILE_APPENDER_TOKEN = " requires a non Null FileAppenderToken.";

	FileAppenderInvoker() {
		super(FileAppenderToken.class, Boolean.class);
	}

	@Override
	public Boolean invoke(FileAppenderToken valueObject)
			throws InvocationException {
		if (valueObject == null) {
			throw new InvocationException("" + this.getClass().getName() +
						REQUIRES_A_NON_NULL_FILE_APPENDER_TOKEN);
		}
		FileAppender appender = valueObject.getAppender();
		String lineFeed = appender.getLineFeed();
		String fileName = appender.getFileName();
		
		if (valueObject.hasLines()) {
			Collection<String> lines = valueObject.getLines();
			try {
				for (String line: lines) {
					appender.append(line);
					appender.append(lineFeed);
				}
				appender.flush();
			} catch (IOException x) {
				InvocationException ie = new InvocationException(A_IO_EXCEPTION_OCCURED_TRYING_TO_WRITE_LINES_TO_FILE + fileName);
				ie.initCause(x);
				throw ie;
			}
		} else {
			try {
				String data = valueObject.getData();
				appender.append(data);
				if (valueObject.isLine()) {
					appender.append(lineFeed);
				}
				appender.flush();
			} catch (IOException x) {
				InvocationException ie = new InvocationException(A_IO_EXCEPTION_OCCURED_TRYING_TO_WRITE_DATA_TO_FILE + fileName);
				ie.initCause(x);
				throw ie;
			}
		}
		return true;
	}
}
