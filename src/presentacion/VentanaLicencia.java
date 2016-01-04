package presentacion;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaLicencia extends JFrame { 

	/**
	 * 
	 */
	private static final long serialVersionUID = -7518504297885688690L;
	private JScrollPane contentPane;
	private JLabel label;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VentanaLicencia() {
		setResizable(false);
		setTitle("Licencia - GPL v3");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 477, 348);
		contentPane = new JScrollPane();
		contentPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		{
			label = new JLabel("");
			label.setLocation(new Point(5, 5));
			label.setIconTextGap(5);
			label.setBounds(new Rectangle(10, 10, 0, 0));
			label.setAlignmentY(10.0f);
			label.setAlignmentX(10.0f);
			label.setHorizontalAlignment(SwingConstants.LEFT);
			label.setVerticalAlignment(SwingConstants.TOP);
			loadLicenseOnToLabel(label);
			contentPane.setViewportView(label);
		}
	}

	public void loadLicenseOnToLabel(JLabel label){
		File file = new File("data/licencia/LICENSE.txt");
		String licencia="<html><br>";
		try{
			FileReader fr = new FileReader (file.getAbsolutePath());
			BufferedReader br = new BufferedReader(fr);
			String line=null;
			while((line = br.readLine()) != null)
				licencia+=(line+"<br>");
			
			br.close();
			label.setText(licencia+"<br></html>");
		} catch (IOException ioe){
			System.out.println(ioe); 
		}
	}
}
