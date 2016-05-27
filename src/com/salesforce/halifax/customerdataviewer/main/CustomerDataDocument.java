package com.salesforce.halifax.customerdataviewer.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CustomerDataDocument {

	public static CustomerDataCollection parseXml(File inputXmlFile) {

		CustomerDataCollection customerData = new CustomerDataCollection();

		try {

			File file = new File(inputXmlFile.toString());
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);

			NodeList nodeList = doc.getElementsByTagName("person");

			for (int temp = 0; temp < nodeList.getLength(); temp++) {

				Node nNode = nodeList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					Person person = new Person();

					person.setId(eElement.getElementsByTagName("id").item(0).getTextContent());
					person.setAge(eElement.getElementsByTagName("age").item(0).getTextContent());
					person.setFirstName(eElement.getElementsByTagName("firstname").item(0).getTextContent());
					person.setLastName(eElement.getElementsByTagName("lastname").item(0).getTextContent());
					person.setBalance(eElement.getElementsByTagName("balance").item(0).getTextContent());

					customerData.addPerson(person);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		return customerData;
	}

	// TODO: Rewrite and clean up - use csv parser
	public static CustomerDataCollection parseTxt(File inputTxtFile) {

		CustomerDataCollection customerData = new CustomerDataCollection();

		ArrayList<String> normalizedFileData = normalizeTextFile(inputTxtFile);

		// TODO: find cleaner way to do this
		HashMap<Integer, String> headerIndexMap = new HashMap<Integer, String>();

		for (String line : normalizedFileData) {

			if (line != null) {

				String[] values = line.split("\t");


				if (headerIndexMap.isEmpty()) {

					// TODO: Make constant for # columns (but where to put?)
					for (int j = 0; j < 4; j++) {
						String value = values[j].trim();
						headerIndexMap.put(j, value.toUpperCase());
					}
				}
				else {
					Person person = new Person();
					for (int j = 0; j < 4; j++) {
						String value = values[j].trim();

						String column = headerIndexMap.get(j);

						// TODO : clean this up
						if (column.equalsIgnoreCase("AGE")) {

							person.setAge(value);
						}
						else if (column.equalsIgnoreCase("FIRSTNAME")) {
							person.setFirstName(value);
						}
						else if (column.equalsIgnoreCase("LASTNAME")) {
							person.setLastName(value);
						}
						else if (column.equalsIgnoreCase("BALANCE")) {
							person.setBalance(value);
						}
						else {
							// SOMETHING WENT WRONG
							System.out.println("ERROR - " + values[j]);
							// TODO: Add proper error logging
						}
					}
					customerData.addPerson(person);
				}
			}
		}
		return customerData;
	}

	// TODO: static (does it have tobe?)
	private static ArrayList<String> normalizeTextFile(File file) {

		// TODO: csv parser? this should be simpler

		ArrayList<String> normalizedFileData = new ArrayList<String>();

		Scanner scanner;
		try {
			scanner = new Scanner(file);
			scanner.useDelimiter("\n");
			while (scanner.hasNext()) {
				String line = "";
				line = scanner.next();
				line = line.replaceAll("\",\"", "\"\t\"");
				line = line.replaceAll("\"", "");

				normalizedFileData.add(line);
			}
			scanner.close();
		}
		catch (FileNotFoundException e) {
			// TODO: Add proper error logging
			e.printStackTrace();
		}
		return normalizedFileData;
	}
}
