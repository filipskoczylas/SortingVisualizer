/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.FilipSkoczylas.View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import pl.polsl.FilipSkoczylas.Controller.AppController;

/**
 *
 * @author Filip
 */
public class TablePanel extends JPanel implements ActionListener{
    JTable table;
    AppController controller;
    public TablePanel(AppController controller){
        super(new BorderLayout());
        //Create table
        this.controller = controller;
        table = new JTable(new TableModel());
        table.setPreferredScrollableViewportSize(new Dimension(100, 200));

        //Add scroll panel
        JScrollPane scrollPane = new JScrollPane(table);
        
        //Create finish button
        JButton buttonSort = new JButton("Sort");
        buttonSort.setMnemonic(KeyEvent.VK_ENTER);
        
        //Create radio buttons
        JRadioButton buttonSelectionSorting = new JRadioButton("Selection sorting");
        JRadioButton buttonInsertionSorting = new JRadioButton("Insertion sorting");
        JRadioButton buttonQuickSorting = new JRadioButton("Quick sorting");
        
        //Add key bindings to radio buttons
        buttonSelectionSorting.setMnemonic('s');
        buttonInsertionSorting.setMnemonic('i');
        buttonQuickSorting.setMnemonic('q');
        
        //Group radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(buttonSelectionSorting);
        group.add(buttonInsertionSorting);
        group.add(buttonQuickSorting);
        
        JPanel buttonPanel = new JPanel(new GridLayout(0, 1));
        //Add components to panel
        buttonPanel.add(buttonSelectionSorting);
        buttonPanel.add(buttonInsertionSorting);
        buttonPanel.add(buttonQuickSorting);
        buttonPanel.add(buttonSort);
        
        add(buttonPanel, BorderLayout.LINE_START);
        add(scrollPane, BorderLayout.CENTER);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    class TableModel extends AbstractTableModel{
        private String[] columnNames = {"values"};
        private Object[][] data = 
        {
            {new Integer(20)}, 
            {new Integer(19)}, 
            {new Integer(18)}, 
            {new Integer(17)}, 
            {new Integer(16)}, 
            {new Integer(15)}, 
            {new Integer(14)}, 
            {new Integer(13)}, 
            {new Integer(12)}, 
            {new Integer(11)}, 
            {new Integer(10)}, 
            {new Integer(9)}, 
            {new Integer(8)}, 
            {new Integer(7)}, 
            {new Integer(6)}, 
            {new Integer(5)}, 
            {new Integer(4)}, 
            {new Integer(3)}, 
            {new Integer(2)}, 
            {new Integer(1)}, 
        };
        public int getRowCount() {
            return data.length;
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            return data[rowIndex][columnIndex];
        }
        
        public String getColumnName(int col) {
            return columnNames[col];
        }
    }
}
