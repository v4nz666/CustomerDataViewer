package com.salesforce.halifax.customerdataviewer.main;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;

public class CdvModel {

	// TODO: Get rid of the poeople - move over to CustomerData
	private ArrayList<Person> people;
	CustomerDataCollection customerDataCollection;

	private String fileLocation = "";

	public CdvModel() {

		customerDataCollection = new CustomerDataCollection();

		this.fileLocation = "resources"; // TODO: Config File
		this.people = new ArrayList<Person>();
	}

	public ArrayList<Person> getPeople() {
		return this.people;
	}

	public void readDataFromInputFiles() {

		File folder = new File(fileLocation);
		File[] fileArray = folder.listFiles();

		Parser xmlParser = new XmlParser();
		Parser txtParser = new TxtParser();

		// TODO: Check the best syntax for this
		for (File file : fileArray) {
			// TODO: reduce code duplication
			if (FileTypeChecker.isXml(file)) {
				customerDataCollection.addAll(xmlParser.parse(file));
			}
			else if (FileTypeChecker.isTxt(file)) {
				customerDataCollection.addAll(txtParser.parse(file));
			}
			else {
				System.out.println("Unable to parse " + file.getName()
				+ ": Unsupported file type");
			}
		}

//		for (Integer customerId : customerDataCollection.getPeople().keySet()) {
//			System.out.println(customerDataCollection.getPeople().get(customerId).getFirstName());
//		}


	}

	public void sortData(boolean isDescending) {

		Comparator<Person> ageComparator = (p, o) -> p.getAge().compareTo(o.getAge());
		Comparator<Person> personComparator = ageComparator.thenComparing((p,o) -> p.getLastName().compareTo(o.getLastName()));

		if (isDescending) {
			people.sort(personComparator.reversed());
		}
		else {
			people.sort(personComparator);
		}
	}

}
