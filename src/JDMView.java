/**
 * JDM (Java Download Manager)
 * Developed for Java SE 1.6 
 */
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JDMView extends JPanel {

	private JButton btnOpenFile; // open source file of download links
	private JButton btnSelectDirectory; // select where to store the files downloaded
	
	public JDMView () {
		btnOpenFile = new JButton("Open File..");
		btnSelectDirectory = new JButton("Directory");
		/* Add action listeners to buttons */
		btnOpenFile.addActionListener(
				new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent evt) {
						System.out.println(evt.getSource().toString());
					}
				}
		);
		/* Add UI elements to view (panel) */
		this.add(btnOpenFile);
	}
	
	public Dimension getPreferredSize () {
		return new Dimension(600,400);
	}
}
