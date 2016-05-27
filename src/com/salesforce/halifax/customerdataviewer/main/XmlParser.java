package com.salesforce.halifax.customerdataviewer.main;

import java.io.File;

// TODO: avoid Exception swallowing

public class XmlParser implements Parser {

	@Override
	public CustomerDataCollection parse(File inputXmlFile) {

		CustomerDataCollection customerData = null;
		
		customerData = CustomerDataDocument.parseXml(inputXmlFile);
		
		return customerData;
	}

}
