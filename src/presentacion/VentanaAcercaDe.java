package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;

public class VentanaAcercaDe extends JFrame {

	private JPanel contentPane;
	private JLabel lbl_pedroma_nombre;
	private JLabel lbl_pedroma_correo;
	private JLabel lbl_diego_nombre;
	private JLabel lbl_diego_correo;
	private JLabel lbl_github_link;
	private JLabel lbl_github_nombre;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAcercaDe frame = new VentanaAcercaDe();
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
	public VentanaAcercaDe() {
		setResizable(false);
		setTitle("Desarrolladores");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 338, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {30, 30, 30};
		gbl_contentPane.rowHeights = new int[] {30, 30, 30, 30, 30, 0, 30, 30, 30, 30, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		{
			lbl_pedroma_nombre = new JLabel("Pedro Manuel Gómez-Portillo López");
			GridBagConstraints gbc_lbl_pedroma_nombre = new GridBagConstraints();
			gbc_lbl_pedroma_nombre.anchor = GridBagConstraints.SOUTHWEST;
			gbc_lbl_pedroma_nombre.insets = new Insets(0, 0, 5, 0);
			gbc_lbl_pedroma_nombre.gridx = 1;
			gbc_lbl_pedroma_nombre.gridy = 1;
			contentPane.add(lbl_pedroma_nombre, gbc_lbl_pedroma_nombre);
		}
		{
			String correo_pedroma = "PedroManuel.GomezPortillo@alu.uclm.es";
			lbl_pedroma_correo = new JLabel("<HTML><FONT color=\"#000099\"><U>"+correo_pedroma+"</U></FONT></HTML>");
			lbl_pedroma_correo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lbl_pedroma_correo.addMouseListener(new LinkMouseListener(correo_pedroma));
			GridBagConstraints gbc_lbl_pedroma_correo = new GridBagConstraints();
			gbc_lbl_pedroma_correo.insets = new Insets(0, 0, 5, 0);
			gbc_lbl_pedroma_correo.anchor = GridBagConstraints.SOUTHWEST;
			gbc_lbl_pedroma_correo.gridx = 1;
			gbc_lbl_pedroma_correo.gridy = 2;
			contentPane.add(lbl_pedroma_correo, gbc_lbl_pedroma_correo);
		}
		{
			lbl_diego_nombre = new JLabel("Diego Molero Marín");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.WEST;
			gbc_label.insets = new Insets(0, 0, 5, 0);
			gbc_label.gridx = 1;
			gbc_label.gridy = 4;
			contentPane.add(lbl_diego_nombre, gbc_label);
		}
		{
			String correo_diego = "Diego.Molero@alu.uclm.es";
			lbl_diego_correo = new JLabel("<HTML><FONT color=\"#000099\"><U>"+correo_diego+"</U></FONT></HTML>");
			lbl_diego_correo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lbl_diego_correo.addMouseListener(new LinkMouseListener(correo_diego));
			GridBagConstraints gbc_label_1 = new GridBagConstraints();
			gbc_label_1.insets = new Insets(0, 0, 5, 0);
			gbc_label_1.anchor = GridBagConstraints.WEST;
			gbc_label_1.gridx = 1;
			gbc_label_1.gridy = 5;
			contentPane.add(lbl_diego_correo, gbc_label_1);
		}
		{
			label = new JLabel("Versión actual del software v1.00");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.WEST;
			gbc_label.insets = new Insets(0, 0, 5, 0);
			gbc_label.gridx = 1;
			gbc_label.gridy = 7;
			contentPane.add(label, gbc_label);
		}
		{
			lbl_github_nombre = new JLabel("Visítanos en GitHub");
			GridBagConstraints gbc_label_1 = new GridBagConstraints();
			gbc_label_1.anchor = GridBagConstraints.WEST;
			gbc_label_1.insets = new Insets(0, 0, 5, 0);
			gbc_label_1.gridx = 1;
			gbc_label_1.gridy = 9;
			contentPane.add(lbl_github_nombre, gbc_label_1);
		}
		{
			lbl_github_link = new JLabel("");
			lbl_github_link.setIcon(new ImageIcon("data/iconos/github.png"));
			lbl_github_link.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			String url = "https://github.com/pedroma-gomezp/Digital_Puppy";
			lbl_github_link.addMouseListener(new LinkMouseListener(url));
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.gridx = 1;
			gbc_label.gridy = 10;
			contentPane.add(lbl_github_link, gbc_label);
		}
	}

	private class LinkMouseListener extends MouseAdapter {
		String direccion=null;
		public LinkMouseListener(String d) {
			this.direccion = d;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			if (direccion.charAt(0) != 'h') direccion="mailto:"+direccion; //http...

			try {
				URI uri = new URI(direccion);
				System.out.println(uri);
				Desktop.getDesktop().browse(uri);
			} 
			catch (IOException e1) {}
			catch (URISyntaxException e2) {}


		}
	}


}
