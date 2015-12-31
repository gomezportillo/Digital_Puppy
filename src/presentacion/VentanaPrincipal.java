package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseMotionAdapter;

public class VentanaPrincipal {

	private JFrame frmDigitalPuppy;
	JLabel lblInfo;
	private JTabbedPane tabbedPane;
	private PanelPerretes pnl_perros;
	private JPanel pnl_voluntarios;
	private JPanel pnl_perdidos;
	private JPanel pnl_socios;
	private JPanel pnl_cuentas;
	private PanelPerrera pnl_perrera;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnEdicin;
	private JMenu mnTamaoFuente;
	private JMenu mnColorFuente;
	private JRadioButtonMenuItem rdbtnmntmGrande;
	private JRadioButtonMenuItem rdbtnmntmMediano;
	private JRadioButtonMenuItem rdbtnmntmPequeo;
	private JRadioButtonMenuItem rdbtnmntmRojo;
	private JRadioButtonMenuItem rdbtnmntmVerde;
	private JRadioButtonMenuItem rdbtnmntmAzul;
	private JMenu mnMapas;
	private final ButtonGroup buttonGroup_tamano = new ButtonGroup();
	private final ButtonGroup buttonGroup_color = new ButtonGroup();
	private JMenu mnAyuda;
	private JMenuItem mntmAcercaDe;
	private JMenu mnFuente;
	private JRadioButtonMenuItem rdbtnmntmTimesRoman;
	private JRadioButtonMenuItem rdbtnmntmComicSans;
	private JRadioButtonMenuItem mntmCourierNew;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frmDigitalPuppy.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDigitalPuppy = new JFrame();
		frmDigitalPuppy.setTitle("Digital Puppy");
		frmDigitalPuppy.setBounds(100, 100, 751, 566);
		frmDigitalPuppy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		{
			lblInfo = new JLabel("Informacion");
			frmDigitalPuppy.getContentPane().add(lblInfo, BorderLayout.SOUTH);
		}
		{
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addChangeListener(new TabbedPaneChangeListener());
			frmDigitalPuppy.getContentPane().add(tabbedPane, BorderLayout.CENTER);
			{
				pnl_perros = new PanelPerretes(frmDigitalPuppy, this);
				tabbedPane.addTab("Perros", null, pnl_perros, null);
			}
			{
				pnl_voluntarios = new JPanel();
				tabbedPane.addTab("Voluntarios", null, pnl_voluntarios, null);
			}
			{
				pnl_perdidos = new JPanel();
				tabbedPane.addTab("Perdidos", null, pnl_perdidos, null);
			}
			{
				pnl_socios = new JPanel();
				tabbedPane.addTab("Socios", null, pnl_socios, null);
			}
			{
				pnl_cuentas = new JPanel();
				tabbedPane.addTab("Cuentas", null, pnl_cuentas, null);
			}
			{
				pnl_perrera = new PanelPerrera(frmDigitalPuppy);
				pnl_perrera.getAreaDibujo().setBackground(Color.WHITE);
				pnl_perrera.getAreaDibujo().setOpaque(true);
				pnl_perrera.getAreaDibujo().setForeground(Color.WHITE);
				tabbedPane.addTab("Perrera", null, pnl_perrera, null);
			}
		}	
		{
			menuBar = new JMenuBar();
			menuBar.addMouseMotionListener(new MenuBarMouseMotionListener());
			menuBar.addFocusListener(new MenuBarFocusListener());
			menuBar.addMouseListener(new MenuBarMouseListener());
			frmDigitalPuppy.setJMenuBar(menuBar);
			{
				mnArchivo = new JMenu("Archivo");
				mnArchivo.setMnemonic('A');
				menuBar.add(mnArchivo);
				{
					mntmSalir = new JMenuItem("Salir");
					mntmSalir.addActionListener(new MntmSalirActionListener());
					mnArchivo.add(mntmSalir);
				}
			}
			{
				mnEdicin = new JMenu("Edición");
				mnEdicin.setMnemonic('E');
				menuBar.add(mnEdicin);
				{
					mnMapas = new JMenu("Mapas");
					mnEdicin.add(mnMapas);
					{
						mnFuente = new JMenu("Fuente");
						mnMapas.add(mnFuente);
						{
							rdbtnmntmTimesRoman = new JRadioButtonMenuItem("Times Roman");
							rdbtnmntmTimesRoman.addActionListener(new RdbtnmntmTimesRomanActionListener());
							rdbtnmntmTimesRoman.setSelected(true);
							buttonGroup.add(rdbtnmntmTimesRoman);
							mnFuente.add(rdbtnmntmTimesRoman);
						}
						{
							rdbtnmntmComicSans = new JRadioButtonMenuItem("Comic Sans");
							rdbtnmntmComicSans.addActionListener(new RdbtnmntmArialActionListener());
							buttonGroup.add(rdbtnmntmComicSans);
							mnFuente.add(rdbtnmntmComicSans);
						}
						{
							mntmCourierNew = new JRadioButtonMenuItem("Courier New");
							mntmCourierNew.addActionListener(new MntmCourierNewActionListener());
							buttonGroup.add(mntmCourierNew);
							mnFuente.add(mntmCourierNew);
						}
					}
					{
						mnTamaoFuente = new JMenu("Tamaño fuente");
						mnMapas.add(mnTamaoFuente);
						{
							rdbtnmntmGrande = new JRadioButtonMenuItem("Grande");
							rdbtnmntmGrande.addActionListener(new RdbtnmntmGrandeActionListener());
							buttonGroup_tamano.add(rdbtnmntmGrande);
							mnTamaoFuente.add(rdbtnmntmGrande);
						}
						{
							rdbtnmntmMediano = new JRadioButtonMenuItem("Mediano");
							rdbtnmntmMediano.addActionListener(new RdbtnmntmMedianoActionListener());
							rdbtnmntmMediano.setSelected(true);
							buttonGroup_tamano.add(rdbtnmntmMediano);
							mnTamaoFuente.add(rdbtnmntmMediano);
						}
						{
							rdbtnmntmPequeo = new JRadioButtonMenuItem("Pequeño");
							rdbtnmntmPequeo.addActionListener(new RdbtnmntmPequeoActionListener());
							buttonGroup_tamano.add(rdbtnmntmPequeo);
							mnTamaoFuente.add(rdbtnmntmPequeo);
						}
					}
					{
						mnColorFuente = new JMenu("Color");
						mnMapas.add(mnColorFuente);
						{
							rdbtnmntmRojo = new JRadioButtonMenuItem("Rojo");
							rdbtnmntmRojo.addActionListener(new RdbtnmntmRojoActionListener());
							buttonGroup_color.add(rdbtnmntmRojo);
							mnColorFuente.add(rdbtnmntmRojo);
						}
						{
							rdbtnmntmVerde = new JRadioButtonMenuItem("Verde");
							rdbtnmntmVerde.addActionListener(new RdbtnmntmVerdeActionListener());
							buttonGroup_color.add(rdbtnmntmVerde);
							mnColorFuente.add(rdbtnmntmVerde);
						}
						{
							rdbtnmntmAzul = new JRadioButtonMenuItem("Azul");
							rdbtnmntmAzul.addActionListener(new RdbtnmntmAzulActionListener());
							buttonGroup_color.add(rdbtnmntmAzul);
							rdbtnmntmAzul.setSelected(true);
							mnColorFuente.add(rdbtnmntmAzul);
						}
					}
				}
			}
			{
				mnAyuda = new JMenu("Ayuda");
				menuBar.add(mnAyuda);
				{
					mntmAcercaDe = new JMenuItem("Acerca de...");
					mntmAcercaDe.addActionListener(new MntmAcercaDeActionListener());
					mnAyuda.add(mntmAcercaDe);
				}
			}
		}
	}

	private class TabbedPaneChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {
			frmDigitalPuppy.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			lblInfo.setText("Información");
		}
	}
	private class RdbtnmntmGrandeActionListener implements ActionListener { //tamaño de fuente grande
		public void actionPerformed(ActionEvent e) {
			pnl_perrera.getAreaDibujo().setTamFuente(30);
		}
	}
	private class RdbtnmntmMedianoActionListener implements ActionListener { //tamaño de fuente mediano
		public void actionPerformed(ActionEvent e) {
			pnl_perrera.getAreaDibujo().setTamFuente(20);
		}
	}
	private class RdbtnmntmPequeoActionListener implements ActionListener { //tamaño de fuente pequeño
		public void actionPerformed(ActionEvent e) {
			pnl_perrera.getAreaDibujo().setTamFuente(10);
		}
	}
	private class RdbtnmntmRojoActionListener implements ActionListener { //color rojo
		public void actionPerformed(ActionEvent e) {
			pnl_perrera.setColorDibujado(Color.RED);
		}
	}
	private class RdbtnmntmVerdeActionListener implements ActionListener { //color verde
		public void actionPerformed(ActionEvent e) {
			pnl_perrera.setColorDibujado(Color.GREEN);
		}
	}
	private class RdbtnmntmAzulActionListener implements ActionListener { //color azul
		public void actionPerformed(ActionEvent e) {
			pnl_perrera.setColorDibujado(Color.BLUE);
		}
	}
	private class MntmAcercaDeActionListener implements ActionListener { //Acerca de...
		public void actionPerformed(ActionEvent e) {
			String mensaje =  "Pedro Manuel Gómez-Portillo López\nPedroManuel.GomezPortillo@alu.uclm.es \n\n"
					+ "Diego Molero Marín\nDiego.Molero@alu.uclm.es \n\n"; 

			JOptionPane.showMessageDialog(frmDigitalPuppy, mensaje, "Desarrolladores", JOptionPane.PLAIN_MESSAGE);
		}
	}
	private class RdbtnmntmTimesRomanActionListener implements ActionListener { //times roman
		public void actionPerformed(ActionEvent e) {
			pnl_perrera.getAreaDibujo().setFuente("TimesRoman");
		}
	}
	private class RdbtnmntmArialActionListener implements ActionListener { //arial
		public void actionPerformed(ActionEvent e) {
			pnl_perrera.getAreaDibujo().setFuente("Comic Sans MS");
		}
	}
	private class MntmCourierNewActionListener implements ActionListener { //courier new
		public void actionPerformed(ActionEvent e) {
			pnl_perrera.getAreaDibujo().setFuente("Courier New");
		}
	}
	private class MenuBarMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {

		}
	}
	private class MenuBarFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent arg0) {
			frmDigitalPuppy.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	}
	private class MenuBarMouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseMoved(MouseEvent arg0) {
			pnl_perrera.modo = 0;
			frmDigitalPuppy.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	}
	private class MntmSalirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			frmDigitalPuppy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmDigitalPuppy.dispose();		
		}
	}
}
