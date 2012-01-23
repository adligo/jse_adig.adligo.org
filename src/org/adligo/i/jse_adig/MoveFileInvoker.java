package org.adligo.i.jse_adig;

import java.io.File;

import org.adligo.i.adi.client.InvocationException;
import org.adligo.i.adig.client.BaseGInvoker;
import org.adligo.i.adig.client.I_GCheckedInvoker;
import org.adligo.i.util.client.StringUtils;

public class MoveFileInvoker extends BaseGInvoker implements I_GCheckedInvoker<MoveFileToken, Boolean> {

	public static final String REQUIRES_A_TO_FILE_PATH_WITH_A_EXISTING_PARENT_DIRECTORY = " requires a to file path with a existing parent directory!";
	public static final String REQUIRES_A_VALID_FILE_PATH_IN_THE_MOVE_FILE_TOKEN_BUT_THE_FILE_DOESN_T_EXIST = " requires a valid file path in the MoveFileToken, but the file doesn't exist!";
	public static final String REQUIRES_A_NON_EMPTY_FROM_FILE_PATH_IN_THE_MOVE_FILE_TOKEN = " requires a non empty from file path in the MoveFileToken!";
	public static final String REQUIRES_A_NON_EMPTY_TO_FILE_PATH_IN_THE_MOVE_FILE_TOKEN = " requires a non empty to file path in the MoveFileToken!";

	public MoveFileInvoker() {
		super(MoveFileToken.class, Boolean.class);
	}

	@Override
	public Boolean invoke(MoveFileToken valueObject) throws InvocationException {
		String to = valueObject.getTo_file_path();
		String from = valueObject.getFrom_file_path();
		if (StringUtils.isEmpty(to)) {
			throw new InvocationException("" + this.getClass().getName() + 
					REQUIRES_A_NON_EMPTY_TO_FILE_PATH_IN_THE_MOVE_FILE_TOKEN);
		}
		if (StringUtils.isEmpty(from)) {
			throw new InvocationException("" + this.getClass().getName() + 
					REQUIRES_A_NON_EMPTY_FROM_FILE_PATH_IN_THE_MOVE_FILE_TOKEN);
		}
		File toFile = new File(to);
		File fromFile = new File(from);
		if (!fromFile.exists()) {
			throw new InvocationException("" + this.getClass().getName() + 
				REQUIRES_A_VALID_FILE_PATH_IN_THE_MOVE_FILE_TOKEN_BUT_THE_FILE_DOESN_T_EXIST);
		}
		File parentToFile = toFile.getParentFile();
		if (!parentToFile.exists()) {
			throw new InvocationException("" + this.getClass().getName() + 
				REQUIRES_A_TO_FILE_PATH_WITH_A_EXISTING_PARENT_DIRECTORY);
		}
		return fromFile.renameTo(toFile);
	}
}
