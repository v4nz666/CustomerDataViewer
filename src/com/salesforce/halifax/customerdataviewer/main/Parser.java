package com.salesforce.halifax.customerdataviewer.main;

import java.io.File;

public interface Parser {
	
    public CustomerDataCollection parse(File inputFile);
}