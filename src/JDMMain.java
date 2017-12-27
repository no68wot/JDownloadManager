/**
 * JDM (Java Download Manager)
 * Developed for Java SE 1.6 
 */
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JDMMain {

	private static void chooseFile () {
		JFrame frame = new JFrame();
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Textdateien", "txt");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(frame);
		if ( returnVal == JFileChooser.APPROVE_OPTION ) {
			File file = chooser.getSelectedFile();
			System.out.println("file.getname() : " + file.getName());
			System.out.println("file.getPath() : " + file.getPath());
			System.out.println("file.getAbsolutePath() : " + file.getAbsolutePath());
			try {
				System.out.println("file.getCanonicalPath() : " + file.getCanonicalPath());
			} 
			catch ( IOException e ) {
				e.printStackTrace();
			}
			System.out.println("file.getParent() : " + file.getParent());
		}
	}
	
	
	/**
	 * 
	 * @param strURL
	 * @return
	 */
	protected static boolean downloadFromURL (String strURL) {
		boolean status = false;
		BufferedInputStream in = null;
		FileOutputStream out = null;
		try {
			URL url = new URL(strURL);
			/* Get the name of destination file to be downloaded */
			String[] urlFragments = strURL.trim().split("/");
			String strDestFileName = urlFragments[urlFragments.length-1];
			/* Prepare objects for I/O operations */
			in = new BufferedInputStream(url.openStream());
			out = new FileOutputStream(strDestFileName);
			/* Read bytes and store them in an internal buffer */
			byte[] data = new byte[1024]; // Internal buffer to store read bytes in
			int readBytes = -1; // Number of bytes read
			while ( (readBytes = in.read(data, 0, 1024)) != -1 ) {
				out.write(data, 0, readBytes); // Write <readBytes> bytes from internal buffer <data> starting at index 0
			}
			/* Close I/O streams and release any system resources associated with them */
			in.close();
			out.flush();
			out.close();
			status = true;
		}
		catch ( MalformedURLException e ) {
			e.printStackTrace();
		}
		catch ( IOException e ) { 
			e.printStackTrace();
		}
		return status;
	}
	
	
	/**
	 * Main program
	 * @param args
	 */
	public static void main(String[] args) {
//		chooseFile();
//		final String URL_FILE = "E:/urls.txt";		
//		BufferedReader reader = null;		
//		try {
//			/* Read from source file line-by-line */
//			reader = new BufferedReader(new FileReader(URL_FILE));
//			String line = null;
//			if ( reader.ready() ) {				
//				while ( (line = reader.readLine()) != null ) {
//					if ( downloadFromURL(line) ) {
//						System.out.println("(100%) " + line);
//					}
//				}
//			}
//		} 
//		catch ( FileNotFoundException e ) {
//			e.printStackTrace();
//		}
//		catch ( IOException e ) {
//			e.printStackTrace();
//		}
		
		//frame.getContentPane().add(view, "Center");

	}
}
