package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class OutputGraph extends JPanel{
	DefaultCategoryDataset dataset2;
	JFreeChart barChart;
	
	public OutputGraph() {
		dataset2 = new DefaultCategoryDataset();
		barChart = ChartFactory.createBarChart("Population Distribution & Sample Distribution of the Sample Means", "x", "f(x)", dataset2, PlotOrientation.VERTICAL, true, true, false);
		ChartPanel panel =new ChartPanel(barChart);
		add(panel, BorderLayout.CENTER);   
		
	 }
}
