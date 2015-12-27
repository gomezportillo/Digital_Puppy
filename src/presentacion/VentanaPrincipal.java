package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

public class VentanaPrincipal {

	private JFrame frmDigitalPuppy;
	private JLabel lblInformation;
	private JTabbedPane tabbedPane;
	private PanelPerros pnl_perros;
	private JPanel pnl_voluntarios;
	private JPanel pnl_perdidos;
	private JPanel pnl_socios;
	private JPanel pnl_cuentas;
	private JPanel pnl_perrera;

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
		frmDigitalPuppy.setBounds(100, 100, 746, 490);
		frmDigitalPuppy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		{
			lblInformation = new JLabel("Information");
			frmDigitalPuppy.getContentPane().add(lblInformation, BorderLayout.SOUTH);
		}
		{
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			frmDigitalPuppy.getContentPane().add(tabbedPane, BorderLayout.CENTER);
			{
				pnl_perros = new PanelPerros(frmDigitalPuppy);
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
				pnl_perrera = new JPanel();
				tabbedPane.addTab("Perrera", null, pnl_perrera, null);
			}
		}	
	}

}
