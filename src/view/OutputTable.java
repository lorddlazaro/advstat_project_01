package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class OutputTable extends JPanel {
    JScrollPane scrollPane;
    JScrollPane scrollPane2;
    JScrollPane scrollPane3;
    JTable table;
    JTable table2;
    JTable table3;
    DefaultTableModel model;
    DefaultTableModel model2;
    DefaultTableModel model3;
    
    public OutputTable() {
        initComponents();
        addComponents();
    }
    
    private void initComponents() {
        String[] columnNames1 = new String[] {"x", "f(x)"};
        String[] columnNames2 = new String[] {"Sample", "Sample mean"};
        String[] columnNames3 = new String[] {"Sample mean", "f(sample mean)"};
        
        model = new DefaultTableModel(columnNames1, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        model2 = new DefaultTableModel(columnNames2, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        model3 = new DefaultTableModel(columnNames3, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFocusable(false);
        table.setRowSelectionAllowed(false);
        scrollPane = new JScrollPane(table);
        
       

        table2 = new JTable(model2);
        table2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table2.setFocusable(false);
        table2.setRowSelectionAllowed(false);
        scrollPane2 = new JScrollPane(table2);
        
        table3 = new JTable(model3);
        table3.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table3.setFocusable(false);
        table3.setRowSelectionAllowed(false);
        scrollPane3 = new JScrollPane(table3);
    }
    
    private void addComponents() {
        add(scrollPane);
        add(scrollPane2);
        add(scrollPane3);
    }
    
}