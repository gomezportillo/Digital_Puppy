package presentacion;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Rectangle;
import java.awt.Point;

public class VentanaLicencia extends JFrame { 

	private JScrollPane contentPane;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLicencia frame = new VentanaLicencia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
