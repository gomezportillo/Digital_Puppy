package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class VentanaLogin extends JFrame{

	public JFrame getFrame() {
		return frmLogin;
	}

	public void setFrame(JFrame frame) {
		this.frmLogin = frame;
	}
	private JFrame frmLogin;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblInfo_user;
	private JButton btn_español;
	private JButton btn_ingles;
	private JButton btnNewButton_2;
	private JTextField tf_nombre;
	private JPasswordField tf_contrasena;
	private JLabel lblNewLabel_2;
	private VentanaPrincipal ventanaPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin window = new VentanaLogin();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaLogin.class.getResource("/iconos/icono-small.png")));
		frmLogin.setTitle(Messages.getString("VentanaLogin.frmLogin.title")); //$NON-NLS-1$
		frmLogin.setResizable(false);
		frmLogin.setBounds(100, 100, 650, 265);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {58, 77, 273, 41, 0, 0, 30, 20};
		gridBagLayout.rowHeights = new int[]{35, 0, 0, 33, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmLogin.getContentPane().setLayout(gridBagLayout);
		{
			lblNewLabel_2 = new JLabel(Messages.getString("VentanaLogin.lblNewLabel_2.text")); //$NON-NLS-1$ //$NON-NLS-1$
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.SOUTH;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 0;
			frmLogin.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			lblNewLabel = new JLabel(Messages.getString("VentanaLogin.1")); //$NON-NLS-1$
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 1;
			frmLogin.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			tf_nombre = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 2;
			gbc_textField.gridy = 1;
			frmLogin.getContentPane().add(tf_nombre, gbc_textField);
			tf_nombre.setColumns(10);
		}
		{
			btn_español = new JButton(Messages.getString("VentanaLogin.2"));
			btn_español.setIcon(new ImageIcon(VentanaLogin.class.getResource("/iconos/banderaEsp.gif")));
			btn_español.setEnabled(false);
			btn_español.addActionListener(new EspanolListener());
			GridBagConstraints gbc_btn_español = new GridBagConstraints();
			gbc_btn_español.insets = new Insets(0, 0, 5, 5);
			gbc_btn_español.gridx = 4;
			gbc_btn_español.gridy = 1;
			frmLogin.getContentPane().add(btn_español, gbc_btn_español);
		}
		{
			btn_ingles = new JButton(Messages.getString("VentanaLogin.3"));
			btn_ingles.setIcon(new ImageIcon(VentanaLogin.class.getResource("/iconos/banderaIng.gif")));
			btn_ingles.addActionListener(new InglesListener());
			GridBagConstraints gbc_btn_ingles = new GridBagConstraints();
			gbc_btn_ingles.insets = new Insets(0, 0, 5, 5);
			gbc_btn_ingles.gridx = 5;
			gbc_btn_ingles.gridy = 1;
			frmLogin.getContentPane().add(btn_ingles, gbc_btn_ingles);
		}
		{
			lblNewLabel_1 = new JLabel(Messages.getString("VentanaLogin.4")); //$NON-NLS-1$
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 2;
			frmLogin.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			tf_contrasena = new JPasswordField();
			GridBagConstraints gbc_passwordField = new GridBagConstraints();
			gbc_passwordField.insets = new Insets(0, 0, 5, 5);
			gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
			gbc_passwordField.gridx = 2;
			gbc_passwordField.gridy = 2;
			frmLogin.getContentPane().add(tf_contrasena, gbc_passwordField);
		}
		{
			btnNewButton_2 = new JButton(Messages.getString("VentanaLogin.5")); //$NON-NLS-1$
			btnNewButton_2.addActionListener(new LoginListener());
			GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
			gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
			gbc_btnNewButton_2.gridwidth = 2;
			gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
			gbc_btnNewButton_2.gridx = 4;
			gbc_btnNewButton_2.gridy = 3;
			frmLogin.getContentPane().add(btnNewButton_2, gbc_btnNewButton_2);
		}
		{
			lblInfo_user = new JLabel(Messages.getString("VentanaLogin.6")); //$NON-NLS-1$
			lblInfo_user.setIcon(new ImageIcon(VentanaLogin.class.getResource("/iconos/icono-small.png")));
			lblInfo_user.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 14)); //$NON-NLS-1$
			GridBagConstraints gbc_lblInfo_user = new GridBagConstraints();
			gbc_lblInfo_user.gridwidth = 3;
			gbc_lblInfo_user.anchor = GridBagConstraints.SOUTHWEST;
			gbc_lblInfo_user.insets = new Insets(0, 0, 5, 5);
			gbc_lblInfo_user.gridx = 2;
			gbc_lblInfo_user.gridy = 4;
			frmLogin.getContentPane().add(lblInfo_user, gbc_lblInfo_user);
		}
	}

	@SuppressWarnings("deprecation")
	private class LoginListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String nombre = tf_nombre.getText();
			if (nombre.equals("admin") && tf_contrasena.getText().equals("admin")){
				String ultima_conexion = cargarFechaYActualizarla();
				String mensaje = "¡Bienbenido "+nombre+"! Su última conexión fue el "+ultima_conexion;
				JOptionPane.showMessageDialog(frmLogin, mensaje, "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
				ventanaPrincipal = new VentanaPrincipal();
				frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frmLogin.dispose();	
			}else{
				JOptionPane.showMessageDialog(frmLogin, "Usuario o contraseña no reconocidos", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}

		private String cargarFechaYActualizarla() {
			File file = new File("data/login/users.txt");
			String ultima_conextion = null;
			try{
				
				/**Cargamos la última conexión*/
				FileReader fr = new FileReader (file.getAbsolutePath());
				BufferedReader br = new BufferedReader(fr);
				ultima_conextion = br.readLine();
				
				/**Guardamos la nueva conexión*/
				String[] mydate = (java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime())).split(" ");
				String fecha_actual = mydate[0];
				System.out.println(fecha_actual);
				FileWriter fw = new FileWriter (file, false);
				fw.write(fecha_actual);
				fw.close();
			}catch(Exception e){ 
				System.out.println(e.toString());
			}
			return ultima_conextion;
		}
	}
	
	
	private class InglesListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Messages.setIdioma("inglés");
			VentanaLogin ventana = new VentanaLogin();
			ventana.getFrame().setVisible(true);
			frmLogin.dispose();
			ventana.btn_ingles.setEnabled(false);
			ventana.btn_español.setEnabled(true);
		}
	}
	private class EspanolListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Messages.setIdioma("español");
			VentanaLogin ventana = new VentanaLogin();
			ventana.getFrame().setVisible(true);
			frmLogin.dispose();
			ventana.btn_español.setEnabled(false);
			ventana.btn_ingles.setEnabled(true);
		}
	}
}
