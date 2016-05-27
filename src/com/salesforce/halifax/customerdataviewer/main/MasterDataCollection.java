package com.salesforce.halifax.customerdataviewer.main;

public class MasterDataCollection {

	public static final Integer MAX_ID = 1000;
	private static CustomerDataCollection customerDataCollection;
	
	public MasterDataCollection() {
		customerDataCollection = new CustomerDataCollection(MAX_ID);
	}
	
	public CustomerDataCollection getCustomerDataCollection() {
		return customerDataCollection;
	}

	public void setCustomerDataCollection(CustomerDataCollection customerDataCollection) {
		MasterDataCollection.customerDataCollection = customerDataCollection;
	}

	public static Integer getNextAvailableId() {
		for (int i = 0; i <= MAX_ID; i++) {
			if (customerDataCollection.getPeople().get(Integer.valueOf(i)) == null) {
				return Integer.valueOf(i);
			}
		}
		// TODO - this could cause issues if multiple with -1 value
		return -1;
	}

}
