package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VentanaPrincipal{
	private JFrame frmDigitalPuppy;
	private JFrame ventanaAcercaDe;
	JLabel lblInfo;
	private JTabbedPane tabbedPane;
	private PanelPerretes pnl_perros;
	private PanelVoluntarios pnl_voluntarios;
	private PanelPerdidos pnl_perdidos;
	private PanelSocios pnl_socios;
	private PanelCuentas pnl_cuentas;
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
	private JMenuItem mntmLicencia;
	public VentanaLicencia ventanaLicencia;

	/**
	 * Launch the application.
	 */

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
		frmDigitalPuppy.setTitle(Messages.getString("VentanaPrincipal.0")); //$NON-NLS-1$
		frmDigitalPuppy.setBounds(100, 100, 751, 566);
		frmDigitalPuppy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDigitalPuppy.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/iconos/icono-small.png"))); //$NON-NLS-1$
		frmDigitalPuppy.setVisible(true);
		{
			lblInfo = new JLabel(Messages.getString("VentanaPrincipal.2")); //$NON-NLS-1$
			frmDigitalPuppy.getContentPane().add(lblInfo, BorderLayout.SOUTH);
		}
		{
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addChangeListener(new TabbedPaneChangeListener());
			frmDigitalPuppy.getContentPane().add(tabbedPane, BorderLayout.CENTER);
			{
				pnl_perros = new PanelPerretes(frmDigitalPuppy, this);
				tabbedPane.addTab(Messages.getString("VentanaPrincipal.3"), null, pnl_perros, null); //$NON-NLS-1$
			}
			{
				pnl_voluntarios = new PanelVoluntarios(frmDigitalPuppy, this);
				tabbedPane.addTab(Messages.getString("VentanaPrincipal.4"), null, pnl_voluntarios, null); //$NON-NLS-1$
			}
			{
				pnl_perdidos = new PanelPerdidos(frmDigitalPuppy, this);
				tabbedPane.addTab(Messages.getString("VentanaPrincipal.5"), null, pnl_perdidos, null); //$NON-NLS-1$
			}
			{
				pnl_socios = new PanelSocios(frmDigitalPuppy, this);
				tabbedPane.addTab(Messages.getString("VentanaPrincipal.6"), null, pnl_socios, null); //$NON-NLS-1$
			}
			{
				pnl_cuentas = new PanelCuentas(frmDigitalPuppy, this);
				tabbedPane.addTab(Messages.getString("VentanaPrincipal.7"), null, pnl_cuentas, null); //$NON-NLS-1$
			}
			{
				pnl_perrera = new PanelPerrera(frmDigitalPuppy);
				pnl_perrera.getAreaDibujo().setBackground(Color.WHITE);
				pnl_perrera.getAreaDibujo().setOpaque(true);
				pnl_perrera.getAreaDibujo().setForeground(Color.WHITE);
				tabbedPane.addTab(Messages.getString("VentanaPrincipal.8"), null, pnl_perrera, null); //$NON-NLS-1$
			}
		}	
		{
			menuBar = new JMenuBar();
			menuBar.addMouseMotionListener(new MenuBarMouseMotionListener());
			menuBar.addFocusListener(new MenuBarFocusListener());
			menuBar.addMouseListener(new MenuBarMouseListener());
			frmDigitalPuppy.setJMenuBar(menuBar);
			{
				mnArchivo = new JMenu(Messages.getString("VentanaPrincipal.9")); //$NON-NLS-1$
				mnArchivo.setMnemonic('A');
				menuBar.add(mnArchivo);
				{
					mntmSalir = new JMenuItem(Messages.getString("VentanaPrincipal.10")); //$NON-NLS-1$
					mntmSalir.addActionListener(new MntmSalirActionListener());
					mnArchivo.add(mntmSalir);
				}
			}
			{
				mnEdicin = new JMenu(Messages.getString("VentanaPrincipal.11")); //$NON-NLS-1$
				mnEdicin.setMnemonic('E');
				menuBar.add(mnEdicin);
				{
					mnMapas = new JMenu(Messages.getString("VentanaPrincipal.12")); //$NON-NLS-1$
					mnEdicin.add(mnMapas);
					{
						mnFuente = new JMenu(Messages.getString("VentanaPrincipal.13")); //$NON-NLS-1$
						mnMapas.add(mnFuente);
						{
							rdbtnmntmTimesRoman = new JRadioButtonMenuItem(Messages.getString("VentanaPrincipal.rdbtnmntmTimesRoman.text")); //$NON-NLS-1$ //$NON-NLS-1$
							rdbtnmntmTimesRoman.addActionListener(new RdbtnmntmTimesRomanActionListener());
							rdbtnmntmTimesRoman.setSelected(true);
							buttonGroup.add(rdbtnmntmTimesRoman);
							mnFuente.add(rdbtnmntmTimesRoman);
						}
						{
							rdbtnmntmComicSans = new JRadioButtonMenuItem(Messages.getString("VentanaPrincipal.rdbtnmntmComicSans.text")); //$NON-NLS-1$ //$NON-NLS-1$
							rdbtnmntmComicSans.addActionListener(new RdbtnmntmArialActionListener());
							buttonGroup.add(rdbtnmntmComicSans);
							mnFuente.add(rdbtnmntmComicSans);
						}
						{
							mntmCourierNew = new JRadioButtonMenuItem(Messages.getString("VentanaPrincipal.16")); //$NON-NLS-1$
							mntmCourierNew.addActionListener(new MntmCourierNewActionListener());
							buttonGroup.add(mntmCourierNew);
							mnFuente.add(mntmCourierNew);
						}
					}
					{
						mnTamaoFuente = new JMenu(Messages.getString("VentanaPrincipal.mnTamaoFuente.text")); //$NON-NLS-1$ //$NON-NLS-1$
						mnMapas.add(mnTamaoFuente);
						{
							rdbtnmntmGrande = new JRadioButtonMenuItem(Messages.getString("VentanaPrincipal.18")); //$NON-NLS-1$
							rdbtnmntmGrande.addActionListener(new RdbtnmntmGrandeActionListener());
							buttonGroup_tamano.add(rdbtnmntmGrande);
							mnTamaoFuente.add(rdbtnmntmGrande);
						}
						{
							rdbtnmntmMediano = new JRadioButtonMenuItem(Messages.getString("VentanaPrincipal.19")); //$NON-NLS-1$
							rdbtnmntmMediano.addActionListener(new RdbtnmntmMedianoActionListener());
							rdbtnmntmMediano.setSelected(true);
							buttonGroup_tamano.add(rdbtnmntmMediano);
							mnTamaoFuente.add(rdbtnmntmMediano);
						}
						{
							rdbtnmntmPequeo = new JRadioButtonMenuItem(Messages.getString("VentanaPrincipal.20")); //$NON-NLS-1$
							rdbtnmntmPequeo.addActionListener(new RdbtnmntmPequeoActionListener());
							buttonGroup_tamano.add(rdbtnmntmPequeo);
							mnTamaoFuente.add(rdbtnmntmPequeo);
						}
					}
					{
						mnColorFuente = new JMenu(Messages.getString("VentanaPrincipal.21")); //$NON-NLS-1$
						mnMapas.add(mnColorFuente);
						{
							rdbtnmntmRojo = new JRadioButtonMenuItem(Messages.getString("VentanaPrincipal.22")); //$NON-NLS-1$
							rdbtnmntmRojo.addActionListener(new RdbtnmntmRojoActionListener());
							buttonGroup_color.add(rdbtnmntmRojo);
							mnColorFuente.add(rdbtnmntmRojo);
						}
						{
							rdbtnmntmVerde = new JRadioButtonMenuItem(Messages.getString("VentanaPrincipal.23")); //$NON-NLS-1$
							rdbtnmntmVerde.addActionListener(new RdbtnmntmVerdeActionListener());
							buttonGroup_color.add(rdbtnmntmVerde);
							mnColorFuente.add(rdbtnmntmVerde);
						}
						{
							rdbtnmntmAzul = new JRadioButtonMenuItem(Messages.getString("VentanaPrincipal.24")); //$NON-NLS-1$
							rdbtnmntmAzul.addActionListener(new RdbtnmntmAzulActionListener());
							buttonGroup_color.add(rdbtnmntmAzul);
							rdbtnmntmAzul.setSelected(true);
							mnColorFuente.add(rdbtnmntmAzul);
						}
					}
				}
			}
			{
				mnAyuda = new JMenu(Messages.getString("VentanaPrincipal.25")); //$NON-NLS-1$
				menuBar.add(mnAyuda);
				{
					mntmAcercaDe = new JMenuItem(Messages.getString("VentanaPrincipal.26")); //$NON-NLS-1$
					mntmAcercaDe.addActionListener(new MntmAcercaDeActionListener());
					{
						mntmLicencia = new JMenuItem(Messages.getString("VentanaPrincipal.27")); //$NON-NLS-1$
						mntmLicencia.addActionListener(new MntmLicenciaActionListener());
						mnAyuda.add(mntmLicencia);
					}
					mnAyuda.add(mntmAcercaDe);
				}
			}
		}
	}

	private class TabbedPaneChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {
			frmDigitalPuppy.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			lblInfo.setText(Messages.getString("VentanaPrincipal.28")); //$NON-NLS-1$
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
			ventanaAcercaDe = new VentanaAcercaDe();
			ventanaAcercaDe.setVisible(true);
			
		}
	}
	private class RdbtnmntmTimesRomanActionListener implements ActionListener { //times roman
		public void actionPerformed(ActionEvent e) {
			pnl_perrera.getAreaDibujo().setFuente(Messages.getString("VentanaPrincipal.29")); //$NON-NLS-1$
		}
	}
	private class RdbtnmntmArialActionListener implements ActionListener { //arial
		public void actionPerformed(ActionEvent e) {
			pnl_perrera.getAreaDibujo().setFuente("Comic Sans MS"); //$NON-NLS-1$
		}
	}
	private class MntmCourierNewActionListener implements ActionListener { //courier new
		public void actionPerformed(ActionEvent e) {
			pnl_perrera.getAreaDibujo().setFuente("Courier New"); //$NON-NLS-1$
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
	private class MntmLicenciaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			ventanaLicencia = new VentanaLicencia();
			ventanaLicencia.setVisible(true);
			
		}
	}
}
