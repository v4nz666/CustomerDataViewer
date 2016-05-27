package com.salesforce.halifax.customerdataviewer.main;

import java.io.File;

public class TxtParser implements Parser {

	@Override
	public CustomerDataCollection parse(File inputTxtFile) {
		
		CustomerDataCollection customerData = null;
		
		customerData = CustomerDataDocument.parseTxt(inputTxtFile);
		
		return customerData;
	}

}
