package presentacion;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;
import javax.swing.SpinnerListModel;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class PanelSocios extends JPanel {
	private static final long serialVersionUID = -7518504297885688690L;
	private JFrame frame;
	private JButton btn_anadir;
	private JPanel panel_datos;
	private JScrollPane scrollPane_tabla;
	private JTextArea tb_comentarios;
	private JButton bton_borrar;
	private JButton btn_actualizar;
	private JPanel panel_foto;
	private JPanel panel_info;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane_1;
	private JLabel lblFoto;
	private JLabel lblNombre;
	private JLabel lblEdad;
	private JLabel lblEmail;
	private JLabel lblTelefono;
	private JLabel lblDatosBancarios;
	private JLabel lblCuota;
	private JTextField tf_nombre;
	private JList list;
	private JTextField tf_email;
	private JButton btnEliminarFoto;
	private VentanaPrincipal vp;
	private JTextField tf_telefono;
	private JTextField tf_datosbancarios;
	private JSpinner sp_edad;
	private JSpinner sp_cuota;


	public PanelSocios(JFrame frame, VentanaPrincipal ventanaPrincipal) {
		this.frame = frame;
		this.vp = ventanaPrincipal;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{147, 150, 0};
		gridBagLayout.rowHeights = new int[]{331, 32, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		{
			btn_anadir = new JButton(Messages.getString("PanelSocios.0")); //$NON-NLS-1$
			btn_anadir.addActionListener(new AnadirPerrete());
			{
				scrollPane_tabla = new JScrollPane();
				scrollPane_tabla.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), Messages.getString("PanelSocios.2"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$ //$NON-NLS-2$
				GridBagConstraints gbc_scrollPane_tabla = new GridBagConstraints();
				gbc_scrollPane_tabla.insets = new Insets(0, 0, 5, 5);
				gbc_scrollPane_tabla.fill = GridBagConstraints.BOTH;
				gbc_scrollPane_tabla.gridx = 0;
				gbc_scrollPane_tabla.gridy = 0;
				add(scrollPane_tabla, gbc_scrollPane_tabla);
				{
					list = new JList();
					list.addListSelectionListener(new ListListSelectionListener());
					// list.setModel(new DefaultListModel()); **IMPORTANTE** 
					list.setModel(new DefaultListModel());
					list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					list.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
					list.setValueIsAdjusting(true);
					list.setToolTipText(""); //$NON-NLS-1$
					list.setVisibleRowCount(100);
					scrollPane_tabla.setColumnHeaderView(list);
				}
			}
			{
				panel_datos = new JPanel();
				panel_datos.setMaximumSize(new Dimension(1000, 1000));
				panel_datos.setMinimumSize(new Dimension(200, 200));
				panel_datos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), Messages.getString("PanelSocios.5"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$ //$NON-NLS-2$
				GridBagConstraints gbc_panel_datos = new GridBagConstraints();
				gbc_panel_datos.gridheight = 2;
				gbc_panel_datos.fill = GridBagConstraints.BOTH;
				gbc_panel_datos.gridx = 1;
				gbc_panel_datos.gridy = 0;
				add(panel_datos, gbc_panel_datos);
				GridBagLayout gbl_panel_datos = new GridBagLayout();
				gbl_panel_datos.columnWidths = new int[] {186, 209};
				gbl_panel_datos.rowHeights = new int[] {245, 47, 54};
				gbl_panel_datos.columnWeights = new double[]{0.0, 1.0};
				gbl_panel_datos.rowWeights = new double[]{1.0, 0.0, 0.0};
				panel_datos.setLayout(gbl_panel_datos);
				{
					panel_foto = new JPanel();
					panel_foto.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), Messages.getString("PanelSocios.7"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$ //$NON-NLS-2$
					GridBagConstraints gbc_panel_foto = new GridBagConstraints();
					gbc_panel_foto.insets = new Insets(0, 0, 5, 5);
					gbc_panel_foto.fill = GridBagConstraints.BOTH;
					gbc_panel_foto.gridx = 0;
					gbc_panel_foto.gridy = 0;
					panel_datos.add(panel_foto, gbc_panel_foto);
					GridBagLayout gbl_panel_foto = new GridBagLayout();
					gbl_panel_foto.columnWidths = new int[]{106, 0, 0};
					gbl_panel_foto.rowHeights = new int[]{0, 0, 0};
					gbl_panel_foto.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
					gbl_panel_foto.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
					panel_foto.setLayout(gbl_panel_foto);
					{
						scrollPane_1 = new JScrollPane();
						GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
						gbc_scrollPane_1.gridwidth = 2;
						gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
						gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
						gbc_scrollPane_1.gridx = 0;
						gbc_scrollPane_1.gridy = 0;
						panel_foto.add(scrollPane_1, gbc_scrollPane_1);
						{
							lblFoto = new JLabel(""); //$NON-NLS-1$
							lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
							scrollPane_1.setViewportView(lblFoto);
						}
					}
					{
						btnNewButton_1 = new JButton(Messages.getString("PanelSocios.9")); //$NON-NLS-1$
						btnNewButton_1.addActionListener(new SeleccionarFoto());
						GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
						gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
						gbc_btnNewButton_1.gridx = 0;
						gbc_btnNewButton_1.gridy = 1;
						panel_foto.add(btnNewButton_1, gbc_btnNewButton_1);
					}
					{
						btnEliminarFoto = new JButton(Messages.getString("PanelSocios.10")); //$NON-NLS-1$
						btnEliminarFoto.addActionListener(new BtnEliminarFotoActionListener());
						GridBagConstraints gbc_btnEliminarFoto = new GridBagConstraints();
						gbc_btnEliminarFoto.gridx = 1;
						gbc_btnEliminarFoto.gridy = 1;
						panel_foto.add(btnEliminarFoto, gbc_btnEliminarFoto);
					}
				}
				{
					panel_info = new JPanel();
					panel_info.setBorder(new TitledBorder(null, Messages.getString("PanelSocios.11"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
					GridBagConstraints gbc_panel_info = new GridBagConstraints();
					gbc_panel_info.insets = new Insets(0, 0, 5, 0);
					gbc_panel_info.fill = GridBagConstraints.BOTH;
					gbc_panel_info.gridx = 1;
					gbc_panel_info.gridy = 0;
					panel_datos.add(panel_info, gbc_panel_info);
					GridBagLayout gbl_panel_info = new GridBagLayout();
					gbl_panel_info.columnWidths = new int[]{82, 0, 0};
					gbl_panel_info.rowHeights = new int[] {0, 40, 40, 40, 40, 40, 0};
					gbl_panel_info.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
					gbl_panel_info.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
					panel_info.setLayout(gbl_panel_info);
					{
						lblNombre = new JLabel(Messages.getString("PanelSocios.12")); //$NON-NLS-1$
						GridBagConstraints gbc_lblNombre = new GridBagConstraints();
						gbc_lblNombre.anchor = GridBagConstraints.WEST;
						gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
						gbc_lblNombre.gridx = 0;
						gbc_lblNombre.gridy = 0;
						panel_info.add(lblNombre, gbc_lblNombre);
					}
					{
						tf_nombre = new JTextField();
						tf_nombre.setText(" "); //$NON-NLS-1$
						GridBagConstraints gbc_tf_nombre = new GridBagConstraints();
						gbc_tf_nombre.insets = new Insets(0, 0, 5, 0);
						gbc_tf_nombre.fill = GridBagConstraints.HORIZONTAL;
						gbc_tf_nombre.gridx = 1;
						gbc_tf_nombre.gridy = 0;
						panel_info.add(tf_nombre, gbc_tf_nombre);
						tf_nombre.setColumns(10);
					}
					{
						lblEdad = new JLabel(Messages.getString("PanelSocios.14")); //$NON-NLS-1$
						GridBagConstraints gbc_lblEdad = new GridBagConstraints();
						gbc_lblEdad.anchor = GridBagConstraints.WEST;
						gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
						gbc_lblEdad.gridx = 0;
						gbc_lblEdad.gridy = 1;
						panel_info.add(lblEdad, gbc_lblEdad);
					}
					{
						sp_edad = new JSpinner();
						sp_edad.setToolTipText("1"); //$NON-NLS-1$
						sp_edad.setModel(new SpinnerNumberModel(1, 0, 100, 1));
						GridBagConstraints gbc_sp_edad = new GridBagConstraints();
						gbc_sp_edad.anchor = GridBagConstraints.WEST;
						gbc_sp_edad.insets = new Insets(0, 0, 5, 0);
						gbc_sp_edad.gridx = 1;
						gbc_sp_edad.gridy = 1;
						panel_info.add(sp_edad, gbc_sp_edad);
					}
					{
						lblEmail = new JLabel(Messages.getString("PanelSocios.16")); //$NON-NLS-1$
						GridBagConstraints gbc_lblEmail = new GridBagConstraints();
						gbc_lblEmail.anchor = GridBagConstraints.WEST;
						gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
						gbc_lblEmail.gridx = 0;
						gbc_lblEmail.gridy = 2;
						panel_info.add(lblEmail, gbc_lblEmail);
					}
					{
						tf_email = new JTextField();
						GridBagConstraints gbc_tf_email = new GridBagConstraints();
						gbc_tf_email.insets = new Insets(0, 0, 5, 0);
						gbc_tf_email.fill = GridBagConstraints.HORIZONTAL;
						gbc_tf_email.gridx = 1;
						gbc_tf_email.gridy = 2;
						panel_info.add(tf_email, gbc_tf_email);
						tf_email.setColumns(10);
					}
					{
						lblTelefono = new JLabel(Messages.getString("PanelSocios.17")); //$NON-NLS-1$
						GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
						gbc_lblTelefono.anchor = GridBagConstraints.WEST;
						gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
						gbc_lblTelefono.gridx = 0;
						gbc_lblTelefono.gridy = 3;
						panel_info.add(lblTelefono, gbc_lblTelefono);
					}
					{
						GridBagConstraints gbc_tf_telefono = new GridBagConstraints();
						gbc_tf_telefono.insets = new Insets(0, 0, 5, 0);
						gbc_tf_telefono.fill = GridBagConstraints.HORIZONTAL;
						gbc_tf_telefono.gridx = 1;
						gbc_tf_telefono.gridy = 3;
						
						MaskFormatter formatoTlfno;
						try {
							formatoTlfno = new MaskFormatter("###-###-###"); //$NON-NLS-1$
							formatoTlfno.setPlaceholderCharacter('*');
							tf_telefono = new JFormattedTextField(formatoTlfno);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						panel_info.add(tf_telefono, gbc_tf_telefono);

					}
					{
						lblDatosBancarios = new JLabel(Messages.getString("PanelSocios.19")); //$NON-NLS-1$
						GridBagConstraints gbc_lblDatosBancarios = new GridBagConstraints();
						gbc_lblDatosBancarios.anchor = GridBagConstraints.WEST;
						gbc_lblDatosBancarios.insets = new Insets(0, 0, 5, 5);
						gbc_lblDatosBancarios.gridx = 0;
						gbc_lblDatosBancarios.gridy = 4;
						panel_info.add(lblDatosBancarios, gbc_lblDatosBancarios);
					}
					{
						tf_datosbancarios = new JTextField();
						tf_datosbancarios.setColumns(10);
						GridBagConstraints gbc_tf_datosbancarios = new GridBagConstraints();
						gbc_tf_datosbancarios.insets = new Insets(0, 0, 5, 0);
						gbc_tf_datosbancarios.fill = GridBagConstraints.HORIZONTAL;
						gbc_tf_datosbancarios.gridx = 1;
						gbc_tf_datosbancarios.gridy = 4;
						panel_info.add(tf_datosbancarios, gbc_tf_datosbancarios);
					}
					{
						lblCuota = new JLabel(Messages.getString("PanelSocios.20")); //$NON-NLS-1$
						lblCuota.setHorizontalAlignment(SwingConstants.LEFT);
						GridBagConstraints gbc_lblCuota = new GridBagConstraints();
						gbc_lblCuota.anchor = GridBagConstraints.WEST;
						gbc_lblCuota.insets = new Insets(0, 0, 0, 5);
						gbc_lblCuota.gridx = 0;
						gbc_lblCuota.gridy = 5;
						panel_info.add(lblCuota, gbc_lblCuota);
					}
					{
						sp_cuota = new JSpinner();
						sp_cuota.setModel(new SpinnerListModel(new String[] {"5\u20AC", "10\u20AC", "15\u20AC", "20\u20AC", "50\u20AC", "100\u20AC", "150\u20AC", "200\u20AC", "500\u20AC"})); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$
						sp_cuota.setToolTipText("1"); //$NON-NLS-1$
						GridBagConstraints gbc_sp_cuota = new GridBagConstraints();
						gbc_sp_cuota.anchor = GridBagConstraints.WEST;
						gbc_sp_cuota.ipadx = 20;
						gbc_sp_cuota.gridx = 1;
						gbc_sp_cuota.gridy = 5;
						panel_info.add(sp_cuota, gbc_sp_cuota);
					}
				}
				{
					bton_borrar = new JButton(Messages.getString("PanelSocios.31")); //$NON-NLS-1$
					bton_borrar.addActionListener(new Borrarsocio());
					GridBagConstraints gbc_bton_borrar = new GridBagConstraints();
					gbc_bton_borrar.fill = GridBagConstraints.HORIZONTAL;
					gbc_bton_borrar.insets = new Insets(0, 0, 5, 5);
					gbc_bton_borrar.gridx = 0;
					gbc_bton_borrar.gridy = 1;
					panel_datos.add(bton_borrar, gbc_bton_borrar);
				}
				{
					btn_actualizar = new JButton(Messages.getString("PanelSocios.32")); //$NON-NLS-1$
					btn_actualizar.addActionListener(new Guardarsocio());
					GridBagConstraints gbc_btn_actualizar = new GridBagConstraints();
					gbc_btn_actualizar.fill = GridBagConstraints.HORIZONTAL;
					gbc_btn_actualizar.insets = new Insets(0, 0, 5, 0);
					gbc_btn_actualizar.gridx = 1;
					gbc_btn_actualizar.gridy = 1;
					panel_datos.add(btn_actualizar, gbc_btn_actualizar);
				}
				{
					tb_comentarios = new JTextArea();
					tb_comentarios.setBorder(new TitledBorder(null, Messages.getString("PanelSocios.33"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
					GridBagConstraints gbc_tb_comentarios = new GridBagConstraints();
					gbc_tb_comentarios.gridwidth = 2;
					gbc_tb_comentarios.fill = GridBagConstraints.BOTH;
					gbc_tb_comentarios.gridx = 0;
					gbc_tb_comentarios.gridy = 2;
					panel_datos.add(tb_comentarios, gbc_tb_comentarios);
				}
			}
			GridBagConstraints gbc_btn_anadir = new GridBagConstraints();
			gbc_btn_anadir.fill = GridBagConstraints.BOTH;
			gbc_btn_anadir.insets = new Insets(0, 0, 0, 5);
			gbc_btn_anadir.gridx = 0;
			gbc_btn_anadir.gridy = 1;
			add(btn_anadir, gbc_btn_anadir);
		}

		cargarTodosSocios();
	}


	public void cargarTodosSocios() {
		File directorio = new File("data/socios/"); //$NON-NLS-1$
		File[] archivosEnDirectorio = directorio.listFiles();
		if (archivosEnDirectorio != null) {
			String archivo = null;
			for (File child : archivosEnDirectorio) {
				archivo = child.getName();
				String extension = archivo.substring(archivo.length() -6 , archivo.length());
				if (extension.equals(".socio")) //$NON-NLS-1$
					anadirALista(archivo.substring(0, archivo.length() - 6));
			}
			cargarsocio(archivo);
		}
	}

	public void cargarsocio(String nombreArchivo) {
		limpiarCampos();
		File file = new File("data/socios/" + nombreArchivo); //$NON-NLS-1$

		try{
			FileReader fr = new FileReader (file.getAbsolutePath());
			BufferedReader br = new BufferedReader(fr);

			tf_nombre.setText(br.readLine());
			sp_edad.setValue(new Integer(br.readLine()));
			tf_email.setText(br.readLine());
			tf_telefono.setText(br.readLine());
			tf_datosbancarios.setText(br.readLine());
			sp_cuota.setValue(new String(br.readLine()));
			lblFoto.setIcon (new ImageIcon (br.readLine()));
			String txt = null;
			while((txt = br.readLine()) != null) tb_comentarios.append(txt+'\n');

			br.close();
			vp.lblInfo.setText(Messages.getString("PanelSocios.37")+ file.getAbsolutePath()); //$NON-NLS-1$
		} catch (IOException ioe){
			//System.out.println(ioe);
		} catch(NumberFormatException nume){
			System.out.println(nume);
		}
	}

	public void limpiarCampos() {
		tf_nombre.setText(null);
		sp_edad.setValue(1);
		tf_email.setText(null);
		tf_telefono.setText(null);
		tf_datosbancarios.setText(null);
		sp_cuota.setValue("5€"); //$NON-NLS-1$
		lblFoto.setIcon(null);
		tb_comentarios.setText(null);
	}

	private class AnadirPerrete implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String nombre = JOptionPane.showInputDialog(Messages.getString("PanelSocios.39")); //$NON-NLS-1$
			if (nombre != null && nombre.length()>1){
				System.out.println(nombre);
				anadirALista(nombre);
				tf_nombre.setText(nombre);
			}
			else if(nombre != null) JOptionPane.showMessageDialog(frame, Messages.getString("PanelSocios.40"), Messages.getString("PanelSocios.41"), JOptionPane.WARNING_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
	private class Borrarsocio implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int index = list.getSelectedIndex();
			String seleccionado = list.getModel().getElementAt(index).toString();

			int reply = JOptionPane.showConfirmDialog(frame, Messages.getString("PanelSocios.42")+seleccionado+"?", Messages.getString("PanelSocios.44"), JOptionPane.YES_NO_OPTION); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

			if (reply == JOptionPane.YES_OPTION) {
				limpiarCampos();
				((DefaultListModel)list.getModel()).removeElementAt(index);
		
				try{
					File archivo = new File("data/socios/" + seleccionado +".socio"); //$NON-NLS-1$ //$NON-NLS-2$
					archivo.delete();
				}catch(Exception e1){
					//System.out.println(e1.toString());
				}
			}		
		}
	}

	private class Guardarsocio implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nombre = tf_nombre.getText().equals("") ? "socio"+(new Random()).nextInt(998) : tf_nombre.getText(); //$NON-NLS-1$ //$NON-NLS-2$
			String direccion = tf_email.getText().equals("") ? Messages.getString("PanelSocios.50") : tf_email.getText(); //$NON-NLS-1$ //$NON-NLS-2$
			String telefono = tf_telefono.getText().equals("") ? Messages.getString("PanelSocios.52") : tf_telefono.getText(); //$NON-NLS-1$ //$NON-NLS-2$
			String nif = tf_datosbancarios.getText().equals("") ? Messages.getString("PanelSocios.1") : tf_datosbancarios.getText(); //$NON-NLS-1$ //$NON-NLS-2$
			String stringToSave = 	nombre +"\r\n"+ //$NON-NLS-1$
					sp_edad.getValue() +"\r\n"+ //$NON-NLS-1$
					direccion +"\r\n"+ //$NON-NLS-1$
					telefono +"\r\n"+ //$NON-NLS-1$
					nif +"\r\n"+ //$NON-NLS-1$
					sp_cuota.getValue().toString() +"\r\n"+ //$NON-NLS-1$
					lblFoto.getIcon() +"\r\n"+ //$NON-NLS-1$
					tb_comentarios.getText();
			System.out.println(stringToSave);

			int reply = JOptionPane.showConfirmDialog(frame, Messages.getString("PanelSocios.62"), Messages.getString("PanelSocios.63"), JOptionPane.YES_NO_OPTION); //$NON-NLS-1$ //$NON-NLS-2$

			if (reply == JOptionPane.YES_OPTION) {
				File file = new File("data/socios/" + nombre + Messages.getString("PanelSocios.65")); //$NON-NLS-1$ //$NON-NLS-2$

				try {
					FileWriter fw = new FileWriter (file, false);
					fw.write(stringToSave);
					fw.close();
					vp.lblInfo.setText(Messages.getString("PanelSocios.66")+ file.getAbsolutePath()); //$NON-NLS-1$
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, Messages.getString("PanelSocios.67"), Messages.getString("PanelSocios.68"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
				}

			} else {
				System.out.println(Messages.getString("PanelSocios.69")); //$NON-NLS-1$
			}
		}
	}

	private class SeleccionarFoto implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser  fcAbrir = new JFileChooser();
			fcAbrir.setFileFilter (new ImageFilter());
			int valorDevuelto  = fcAbrir.showOpenDialog (frame);
			if (valorDevuelto  == JFileChooser.APPROVE_OPTION)  {
				File file = fcAbrir.getSelectedFile();
				lblFoto.setIcon (new ImageIcon (file.getAbsolutePath()));
			}
		}
	}

	private class BtnEliminarFotoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			lblFoto.setIcon(null);
		}
	}

	private class ListListSelectionListener implements ListSelectionListener { 
		public void valueChanged(ListSelectionEvent arg0) {
			String socioSeleccionado = null;
			try{
				socioSeleccionado = list.getModel().getElementAt(list.getSelectedIndex()).toString();

			}catch(Exception e1) { //se ralla con los index cuando se borra un elemento de la lista
				socioSeleccionado = list.getModel().getElementAt(0).toString();
				list.setSelectedIndex(0);
			}
			if (!list.getValueIsAdjusting())
				cargarsocio(socioSeleccionado+".socio"); //$NON-NLS-1$
		}
	}

	public void anadirALista(String name) {
		int indice = list.getModel().getSize();
		((DefaultListModel) list.getModel()).addElement(name);
		list.setSelectedIndex(indice);
		list.ensureIndexIsVisible(indice);
		limpiarCampos();
	}
}

