/**
 * JDM (Java Download Manager)
 * Developed for Java SE 1.6 
 */
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class JDMView extends JFrame {

	private JMenuBar menuBar;
	private JMenu menuFile, menuRun, menuHelp;
	private JMenuItem menuItemOpen, menuItemExit, menuItemStart;
	
	private JPanel paneDownloadDir; // where to store the downloaded files
	private JTextPane txtDownloadDirTitle, txtDownloadDirPath;
	private JButton btnDownloadDir; // choose (change) path of download location
	
	public JDMView () {
		super("Java Download Manager");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowListener() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub				
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub				
			}			
		});
		
		menuBar = new JMenuBar();
		menuFile = new JMenu("File");
		menuRun = new JMenu("Run");
		menuHelp = new JMenu("Help");
		menuItemOpen = new JMenuItem("Open file..");
		menuItemExit = new JMenuItem("Exit");
		menuItemStart = new JMenuItem("Start download");
		menuFile.add(menuItemOpen);
		menuFile.addSeparator();
		menuFile.add(menuItemExit);
		menuRun.add(menuItemStart);
		menuBar.add(menuFile);
		menuBar.add(menuRun);
		menuBar.add(menuHelp);		
		menuItemExit.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent evt) {
					System.exit(0);
				}				
		});		
		this.setJMenuBar(menuBar);
		
		paneDownloadDir = new JPanel();	
		txtDownloadDirTitle = new JTextPane();
		txtDownloadDirPath = new JTextPane();
		btnDownloadDir = new JButton("Change");
		
		txtDownloadDirTitle.setText("Download to:");
		txtDownloadDirPath.setText(new File(".").getAbsolutePath()); // new File(".") creates a new file where your program is actually in.
		paneDownloadDir.add(txtDownloadDirTitle);
		paneDownloadDir.add(txtDownloadDirPath);
		paneDownloadDir.add(btnDownloadDir);
		
		this.setSize(this.getPreferredSize());
		this.add(paneDownloadDir);
		this.pack();
		this.setVisible(true);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(600,400);
	}
	
	public static void main(String[] args) {
		new JDMView();
	}
}
