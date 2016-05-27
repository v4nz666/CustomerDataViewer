package com.salesforce.halifax.customerdataviewer.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class CdvView extends JFrame {	

	private static final long serialVersionUID = 1L;
	private	JPanel topPanel;
	private	JTable table;
	private	JScrollPane scrollPane;
	private JPanel buttonsPanel;
	private JButton ascendingButton;
	private JButton descendingButton;

	public CdvView() {

		setTitle("Data Processor");
		setSize(500, 700);
		setBackground(Color.gray);

		buttonsPanel = new JPanel();
		ascendingButton = new JButton("Sort Ascending");
		descendingButton = new JButton("Sort Descending");
		buttonsPanel.add(ascendingButton);
		buttonsPanel.add(descendingButton);

		add(buttonsPanel, BorderLayout.NORTH);
		buttonsPanel.setLayout(new GridLayout(2, 2));

		topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		getContentPane().add(topPanel);

	}

	public void addDataTable(CdvTableModel tableModel) {

		String columnNames[] = {DataField.AGE.toString(),
				DataField.LAST_NAME.toString(),
				DataField.FIRST_NAME.toString(),
				DataField.BALANCE.toString()
		};

		table = new JTable(tableModel);

		for (int i = 0; i < table.getColumnCount(); i++) {
			TableColumn tableColumn = table.getTableHeader().getColumnModel().getColumn(i);

			tableColumn.setHeaderValue(columnNames[i]);
		} 


		scrollPane = new JScrollPane(table);
		topPanel.add(scrollPane, BorderLayout.CENTER);
	}

	/**
	 * Register the controller as the listener to the buttons
	 * @param controller The event handler for the data processor
	 */
	public void registerListener(CdvController controller) {

		ascendingButton.addActionListener(controller);
		descendingButton.addActionListener(controller);

	}

	public void updateTable(CdvTableModel tableModel) {
		tableModel.fireTableDataChanged();
	}
}

