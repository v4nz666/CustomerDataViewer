package com.salesforce.halifax.customerdataviewer.main;

import java.io.File;

public class FileTypeChecker {

	private static final String XML_FILE_EXTENSION = ".xml";
	private static final String TXT_FILE_EXTENSION = ".txt";


	// TODO: change method / reduce duplication - getFileType
	public static boolean isXml(File file) {
		if (file.getName().endsWith(XML_FILE_EXTENSION)) {
			return true;
		}
		return false;
	}

	public static boolean isTxt(File file) {
		if (file.getName().endsWith(TXT_FILE_EXTENSION)) {
			return true;
		}
		return false;
	}
	
	// TODO: put "acceptableFileFormat" somewhere

}
