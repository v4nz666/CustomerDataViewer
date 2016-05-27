package com.salesforce.halifax.customerdataviewer.main;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class CdvTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private ArrayList<Person> people;

	public CdvTableModel(ArrayList<Person> people) {
		this.people = people;
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return people.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Person person = people.get(rowIndex);
		// TODO: Use ColumnHeader enum
		switch (columnIndex) {
		case 0:
			return person.getAge();
		case 1:
			return person.getLastName();
		case 2:
			return person.getFirstName();
		case 3:
			return person.getBalance();
		}
		return "";
	}
}
