package org.adligo.i.jse_adig;

import java.io.File;

import org.adligo.i.adig.client.BaseGInvoker;
import org.adligo.i.adig.client.I_GInvoker;
import org.adligo.i.util.client.StringUtils;

public class DirectoryExistsInvoker extends BaseGInvoker implements I_GInvoker<String, Boolean> {

	public DirectoryExistsInvoker() {
		super(String.class, Boolean.class);
	}

	@Override
	public Boolean invoke(String valueObject) {
		if (StringUtils.isEmpty(valueObject)) {
			return false;
		}
		File file = new File(valueObject);
		if (file.exists()) {
			if (file.isDirectory()) {
				return true;
			}
		}
		return false;
	}

}
