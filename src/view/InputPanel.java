package view;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.event.ChangeListener;

import net.miginfocom.swing.MigLayout;

public class InputPanel extends JPanel {
		private JLabel xLabel;
	    private JSpinner xLowerSpinner;
	    private JLabel toLabel;
	    private JSpinner xUpperSpinner;
	    private JLabel NLabel;
	    private JTextField NField;
	    private JSlider NSlider;
	    private JComboBox NComboBox;
	    private JLabel meanLabel_1;
	    private JLabel meanValueLabel_1;
	    private JLabel varLabel_1;
	    private JLabel varValueLabel_1;
	    private JLabel nLabel;
	    private JTextField nField;
	    private JSlider nSlider;
	    private JLabel meanLabel_2;
	    private JLabel meanValueLabel_2;
	    private JLabel varLabel_2;
	    private JLabel varValueLabel_2;
	    private JCheckBox graphWindowCheck;
	    
	    public InputPanel() {
	        setLayout(new MigLayout("", "[][30][30, center][30]"));
	        initComponents();
	        addComponents();
	    }
	    
	    private void initComponents() {
	    	
	    	// x
	        xLabel = new JLabel("x: ");
	        
	        xLowerSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 1000, 1));
	        JComponent field = ((JSpinner.DefaultEditor) xLowerSpinner.getEditor());
	        Dimension prefSize = field.getPreferredSize();
	        prefSize = new Dimension(30, prefSize.height);
	        field.setPreferredSize(prefSize);
	        
	        toLabel = new JLabel("to: ");
	        
	        xUpperSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 1000, 1));
	        field = ((JSpinner.DefaultEditor) xUpperSpinner.getEditor());
	        prefSize = field.getPreferredSize();
	        prefSize = new Dimension(30, prefSize.height);
	        field.setPreferredSize(prefSize);
	        
	        //N
	        NLabel = new JLabel("N: ");
	        NField = new JTextField(6);
	        NField.setHorizontalAlignment(JTextField.RIGHT);
	        NSlider = new JSlider(JSlider.HORIZONTAL, 0, 1000, 500);
	        NComboBox = new JComboBox (new Object[] { "Uniform", "Skewed", "Bimodal","Normal","Random Distribution" });
	        
	        //value_1
	        meanLabel_1 = new JLabel("mean: ");
	        meanValueLabel_1 = new JLabel("");
	        varLabel_1 = new JLabel("variance: ");
	        varValueLabel_1 = new JLabel("");
	        
	        //n
	        nLabel = new JLabel("n: ");
	        nField = new JTextField(6);
	        nField.setHorizontalAlignment(JTextField.RIGHT);
	        nSlider = new JSlider(JSlider.HORIZONTAL, 0, 1000, 500);
	        
	        //value_2
	        meanLabel_2 = new JLabel("mean: ");
	        meanValueLabel_2 = new JLabel("");
	        varLabel_2 = new JLabel("variance: ");
	        varValueLabel_2 = new JLabel("");
	        
	       //checkbox
	        graphWindowCheck = new JCheckBox("Open graph in new window");
	        graphWindowCheck.addItemListener(check());
	        
	    }
	    
	    private void addComponents() {
	        add(xLabel);
	        add(xLowerSpinner);
	        add(toLabel);
	        add(xUpperSpinner, "wrap");
	        add(NLabel);
	        add(NField, "span, split");
	        add(NSlider);
	        add(NComboBox, "wrap 15");
	        add(meanLabel_1);
	        add(meanValueLabel_1);
	        add(varLabel_1);
	        add(varValueLabel_1, "wrap 15");
	        add(nLabel);
	        add(nField, "span, split");
	        add(nSlider, "wrap 15");
	        add(meanLabel_2);
	        add(meanValueLabel_2);
	        add(varLabel_2);
	        add(varValueLabel_2,"wrap 15");
	        add(graphWindowCheck, "span, split");
	    }
	    
	    //---------------getters and setters----------
	    //x
	    public int getXLower() {
	        return (Integer) xLowerSpinner.getValue();
	    }
	    
	    public int getXUpper() {
	        return (Integer) xUpperSpinner.getValue();
	    }
	    
	    public void setXLower(int x) {
	        xLowerSpinner.setValue(x);
	    }
	    
	    public void setXUpper(int x) {
	        xUpperSpinner.setValue(x);
	    }
	    
	    //N
	    public double getN() {
	        return Integer.valueOf(NField.getText());
	    }
	    
	    public int getNSlider() {
	        return (Integer) (NSlider.getValue());
	    }
	    
	    public String getNComboBox(){
	    	return NComboBox.getSelectedItem().toString();
	    }
	    
	    public void setN(int N) {
	        NField.setText(Integer.toString(N));
	    }
	    
	    public void setNSlider(int N) {
	        NSlider.setValue(N);
	    }
	    
	    //value_1
	    public void setMeanValue_1(double mean_1) {
	        meanValueLabel_1.setText(Double.toString(mean_1));
	    }
	    
	    public void setVarValue_1(double var_1) {
	        varValueLabel_1.setText(Double.toString(var_1));
	    }
	    
	    //n
	    public double getn() {
	        return Integer.valueOf(nField.getText());
	    }
	    
	    public int getnSlider() {
	        return (Integer) (nSlider.getValue());
	    }
	    
	    public void setn(int n) {
	        nField.setText(Integer.toString(n));
	    }
	    
	    public void setnSlider(int n) {
	        nSlider.setValue(n);
	    }
	    
	    //value_2
	    public void setMeanValue_2(double mean_2) {
	        meanValueLabel_1.setText(Double.toString(mean_2));
	    }
	    
	    public void setVarValue_2(double var_2) {
	        varValueLabel_1.setText(Double.toString(var_2));
	    }
	    
	    private ItemListener check() {
	    	return new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				WindowGraph graph = new WindowGraph();
				if (graphWindowCheck.isSelected()) 
					graph.open();
				else
					graph.close();
				
			}
			};
	    }
	    // Listener setters---------------------------------
	    public void addNSliderListener(ChangeListener listener) {
	        NSlider.addChangeListener(listener);
	    }
	    
	    public void addnSliderListener(ChangeListener listener) {
	        nSlider.addChangeListener(listener);
	    }
	    
	    public void addCheckListener(ItemListener listener) {
	    	graphWindowCheck.addItemListener(listener);
	    }
}
