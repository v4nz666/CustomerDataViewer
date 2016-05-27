package com.salesforce.halifax.customerdataviewer.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CdvController implements ActionListener {

	private CdvModel model;
	private CdvView view;
	private CdvTableModel tableModel;

	public CdvController(CdvModel model,
			CdvView view,
			CdvTableModel tableModel) {
		this.model = model;
		this.view = view;
		this.tableModel = tableModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();

		if (command.equals("Sort Ascending")) {
			model.sortData(false);
		}
		else if (command.equals("Sort Descending")) {
			model.sortData(true);
		}
		view.updateTable(tableModel);
	}
}

