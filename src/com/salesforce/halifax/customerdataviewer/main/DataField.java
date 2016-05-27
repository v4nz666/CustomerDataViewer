package com.salesforce.halifax.customerdataviewer.main;

public enum DataField {
	AGE("Age"),
	FIRST_NAME("First Name"),
	LAST_NAME("Last Name"),
	BALANCE("Balance")
	;

	private final String text;

	private DataField(final String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}

