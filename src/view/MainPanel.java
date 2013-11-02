package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import net.miginfocom.swing.MigLayout;

public class MainPanel extends JPanel {
    private InputPanel inputPanel;
    private JTabbedPane tabbedPane;
    private OutputTable outputTable;
    private OutputGraph outputGraph;
    private JScrollPane scroll;
    
    public MainPanel() {
        setLayout(new MigLayout());
        initComponents();
        addComponents();
    }
    
    private void initComponents() {
        inputPanel = new InputPanel();
        tabbedPane = new JTabbedPane();
        outputTable = new OutputTable();
        outputGraph = new OutputGraph();
        scroll = new JScrollPane(outputTable);
        tabbedPane.addTab("Table", scroll);
        tabbedPane.addTab("Graph", outputGraph);
    }
    
    private void addComponents() {
        add(inputPanel, "wrap");
        add(tabbedPane, "span, split");
    }
    
    public InputPanel getInputPanel() {
        return inputPanel;
    }
    
    public OutputTable getOutputTable() {
        return outputTable;
    }
    
    public OutputGraph getOutputGraph() {
        return outputGraph;
    }
}
