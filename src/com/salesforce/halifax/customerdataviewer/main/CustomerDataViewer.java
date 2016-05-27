package com.salesforce.halifax.customerdataviewer.main;

import javax.swing.JFrame;

public class CustomerDataViewer {

	public static MasterDataCollection masterDataCollection;

	public static void main(String[] args) {

		masterDataCollection = new MasterDataCollection();

		CdvModel model = new CdvModel();
		model.readDataFromInputFiles();

		CdvTableModel tableModel = new CdvTableModel(model.getPeople());
		CdvView view = new CdvView();

		CdvController controller = new CdvController(model, view, tableModel);

		view.addDataTable(tableModel);
		view.registerListener(controller);

		/* start */
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setVisible(true);
	}
}
