package com.salesforce.halifax.customerdataviewer.main;

import java.util.HashMap;

public class CustomerDataCollection {

	HashMap<Integer, Person> customerDataMap;

	public CustomerDataCollection(Integer maxId) {

		customerDataMap = new HashMap<Integer, Person>();
		for (int idValue = 1; idValue < maxId.intValue(); idValue++) {
			customerDataMap.put(idValue, null);
		}
	}

	public CustomerDataCollection() {
		customerDataMap = new HashMap<Integer, Person>();
	}

	public void addPerson(Person person) {

		if (person.getId() == null) {
			person.setId(MasterDataCollection.getNextAvailableId());
		}

		if (customerDataMap.get(person.getId()) == null) {
			customerDataMap.put(person.getId(), person);
		}
		// logger - print warning
	}

	public void addPeople(HashMap<Integer, Person> people) {
		for (Person person : people.values()) {
			addPerson(person);
		}
	}

	public HashMap<Integer, Person> getPeople() {
		return customerDataMap;

	}

	public void addAll(CustomerDataCollection dataCollection) {
		addPeople(dataCollection.getPeople());
	}
}
