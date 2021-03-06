package org.adligo.i.jse_adig;

import java.io.File;

import org.adligo.i.adig.shared.BaseGInvoker;
import org.adligo.i.adig.shared.I_GInvoker;
import org.adligo.i.util.shared.StringUtils;

public class FileExistsInvoker extends BaseGInvoker implements I_GInvoker<String, Boolean> {

	FileExistsInvoker() {
		super(String.class, Boolean.class);
	}

	@Override
	public Boolean invoke(String valueObject) {
		if (StringUtils.isEmpty(valueObject)) {
			return false;
		}
		File file = new File(valueObject);
		if (file.exists()) {
			if (file.isFile()) {
				return true;
			}
		}
		return false;
	}

}
