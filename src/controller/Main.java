package controller;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.InputPanel;
import view.MainFrame;
import view.MainPanel;
import view.OutputGraph;
import view.OutputTable;

public class Main {
	private MainPanel mainPanel;
    private InputPanel inputPanel;
    private OutputTable outputTable;
    private OutputGraph outputGraph;
    
    public static void main(String[] args) {
        new Main();
    }
    
    public Main() {
        MainFrame frame = new MainFrame();
        mainPanel = new MainPanel();
        frame.setPanel(mainPanel);
        inputPanel = mainPanel.getInputPanel();
        initInputs();
        outputTable = mainPanel.getOutputTable();
        outputGraph = mainPanel.getOutputGraph();
    }
    
    private void initInputs() {
        inputPanel.setXLower(0);
        inputPanel.setXUpper(5);
        inputPanel.setN(10);
        inputPanel.setn(2);
        
        inputPanel.addNSliderListener(NSlider());
        inputPanel.addnSliderListener(nSlider());
        
    }
    
    private ChangeListener NSlider() {
        return new ChangeListener() {

        @Override
        public void stateChanged(ChangeEvent arg0) {
            
            int N = inputPanel.getNSlider();
            
            inputPanel.setN(N);
        }
        };
    }
    
    private ChangeListener nSlider() {
        return new ChangeListener() {

        @Override
        public void stateChanged(ChangeEvent arg0) {
            
            int n = inputPanel.getnSlider();
            
            inputPanel.setn(n);
        }
        };
    }
}
