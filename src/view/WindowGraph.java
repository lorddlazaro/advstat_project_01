package view;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class WindowGraph extends JFrame {
	
	private OutputGraph outputGraph;

	public void open(){
		setTitle("Graph");
        setSize(750, 460);
        outputGraph = new OutputGraph();
        add(outputGraph);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
		
	}
	
	public void close(){
		WindowEvent event = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(event);
	}
}
