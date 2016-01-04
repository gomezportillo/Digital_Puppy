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
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class PanelPerdidos extends JPanel {
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
	private JLabel lblDireccion;
	private JLabel lblTelefono;
	private JLabel lblNIF;
	private JTextField tf_nombre;
	private JList list;
	private JButton btnEliminarFoto;
	private VentanaPrincipal vp;
	private JTextField tf_telefono;
	private JSpinner sp_edad;
	private JComboBox cb_tamaño;
	private JLabel lbRaza;
	private JTextField tf_raza;
	private JDateChooser datechooser;


	public PanelPerdidos(JFrame frame, VentanaPrincipal ventanaPrincipal) {
		this.frame = frame;
		this.vp = ventanaPrincipal;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{147, 150, 0};
		gridBagLayout.rowHeights = new int[]{331, 32, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		{
			btn_anadir = new JButton(Messages.getString("PanelPerdidos.0")); //$NON-NLS-1$
			btn_anadir.addActionListener(new AnadirPerdido());
			{
				scrollPane_tabla = new JScrollPane();
				scrollPane_tabla.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), Messages.getString("PanelPerdidos.2"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$ //$NON-NLS-2$
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
				panel_datos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), Messages.getString("PanelPerdidos.5"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$ //$NON-NLS-2$
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
					panel_foto.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), Messages.getString("PanelPerdidos.7"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$ //$NON-NLS-2$
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
						btnNewButton_1 = new JButton(Messages.getString("PanelPerdidos.9")); //$NON-NLS-1$
						btnNewButton_1.addActionListener(new SeleccionarFoto());
						GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
						gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
						gbc_btnNewButton_1.gridx = 0;
						gbc_btnNewButton_1.gridy = 1;
						panel_foto.add(btnNewButton_1, gbc_btnNewButton_1);
					}
					{
						btnEliminarFoto = new JButton(Messages.getString("PanelPerdidos.10")); //$NON-NLS-1$
						btnEliminarFoto.addActionListener(new BtnEliminarFotoActionListener());
						GridBagConstraints gbc_btnEliminarFoto = new GridBagConstraints();
						gbc_btnEliminarFoto.gridx = 1;
						gbc_btnEliminarFoto.gridy = 1;
						panel_foto.add(btnEliminarFoto, gbc_btnEliminarFoto);
					}
				}
				{
					panel_info = new JPanel();
					panel_info.setBorder(new TitledBorder(null, Messages.getString("PanelPerdidos.11"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
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
						lblNombre = new JLabel(Messages.getString("PanelPerdidos.12")); //$NON-NLS-1$
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
						lblEdad = new JLabel(Messages.getString("PanelPerdidos.14")); //$NON-NLS-1$
						GridBagConstraints gbc_lblEdad = new GridBagConstraints();
						gbc_lblEdad.anchor = GridBagConstraints.WEST;
						gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
						gbc_lblEdad.gridx = 0;
						gbc_lblEdad.gridy = 1;
						panel_info.add(lblEdad, gbc_lblEdad);
					}
					{
						sp_edad = new JSpinner();
						sp_edad.setToolTipText(Messages.getString("PanelPerdidos.15")); //$NON-NLS-1$
						sp_edad.setModel(new SpinnerNumberModel(1, 0, 20, 1));
						GridBagConstraints gbc_sp_edad = new GridBagConstraints();
						gbc_sp_edad.anchor = GridBagConstraints.WEST;
						gbc_sp_edad.insets = new Insets(0, 0, 5, 0);
						gbc_sp_edad.gridx = 1;
						gbc_sp_edad.gridy = 1;
						panel_info.add(sp_edad, gbc_sp_edad);
					}
					{
						lbRaza = new JLabel(Messages.getString("PanelPerdidos.16")); //$NON-NLS-1$
						GridBagConstraints gbc_lbRaza = new GridBagConstraints();
						gbc_lbRaza.anchor = GridBagConstraints.WEST;
						gbc_lbRaza.insets = new Insets(0, 0, 5, 5);
						gbc_lbRaza.gridx = 0;
						gbc_lbRaza.gridy = 2;
						panel_info.add(lbRaza, gbc_lbRaza);
					}
					{
						tf_raza = new JTextField();
						tf_raza.setText(" "); //$NON-NLS-1$
						tf_raza.setColumns(10);
						GridBagConstraints gbc_tf_raza = new GridBagConstraints();
						gbc_tf_raza.insets = new Insets(0, 0, 5, 0);
						gbc_tf_raza.fill = GridBagConstraints.HORIZONTAL;
						gbc_tf_raza.gridx = 1;
						gbc_tf_raza.gridy = 2;
						panel_info.add(tf_raza, gbc_tf_raza);
					}
					{
						lblTelefono = new JLabel(Messages.getString("PanelPerdidos.18")); //$NON-NLS-1$
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
						lblDireccion = new JLabel(Messages.getString("PanelPerdidos.20")); //$NON-NLS-1$
						GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
						gbc_lblDireccion.anchor = GridBagConstraints.WEST;
						gbc_lblDireccion.insets = new Insets(0, 0, 5, 5);
						gbc_lblDireccion.gridx = 0;
						gbc_lblDireccion.gridy = 4;
						panel_info.add(lblDireccion, gbc_lblDireccion);
					}
					{
						datechooser = new JDateChooser();
						datechooser.setDateFormatString("dow mon dd hh:mm:ss zzz yyyy"); //$NON-NLS-1$
						GridBagConstraints gbc_datechooser = new GridBagConstraints();
						gbc_datechooser.anchor = GridBagConstraints.ABOVE_BASELINE;
						gbc_datechooser.insets = new Insets(0, 0, 5, 0);
						gbc_datechooser.fill = GridBagConstraints.HORIZONTAL;
						gbc_datechooser.gridx = 1;
						gbc_datechooser.gridy = 4;
						panel_info.add(datechooser, gbc_datechooser);
					}
					{
						lblNIF = new JLabel(Messages.getString("PanelPerdidos.22")); //$NON-NLS-1$
						GridBagConstraints gbc_lblNIF = new GridBagConstraints();
						gbc_lblNIF.anchor = GridBagConstraints.WEST;
						gbc_lblNIF.insets = new Insets(0, 0, 0, 5);
						gbc_lblNIF.gridx = 0;
						gbc_lblNIF.gridy = 5;
						panel_info.add(lblNIF, gbc_lblNIF);
					}
					{
						cb_tamaño = new JComboBox();
						cb_tamaño.setModel(new DefaultComboBoxModel(new String[] {Messages.getString("PanelPerdidos.23"), Messages.getString("PanelPerdidos.24"), Messages.getString("PanelPerdidos.25")})); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						cb_tamaño.setToolTipText(""); //$NON-NLS-1$
						GridBagConstraints gbc_cb_tamaño = new GridBagConstraints();
						gbc_cb_tamaño.fill = GridBagConstraints.HORIZONTAL;
						gbc_cb_tamaño.gridx = 1;
						gbc_cb_tamaño.gridy = 5;
						panel_info.add(cb_tamaño, gbc_cb_tamaño);
					}
				}
				{
					bton_borrar = new JButton(Messages.getString("PanelPerdidos.27")); //$NON-NLS-1$
					bton_borrar.addActionListener(new BorrarPerdido());
					GridBagConstraints gbc_bton_borrar = new GridBagConstraints();
					gbc_bton_borrar.fill = GridBagConstraints.HORIZONTAL;
					gbc_bton_borrar.insets = new Insets(0, 0, 5, 5);
					gbc_bton_borrar.gridx = 0;
					gbc_bton_borrar.gridy = 1;
					panel_datos.add(bton_borrar, gbc_bton_borrar);
				}
				{
					btn_actualizar = new JButton(Messages.getString("PanelPerdidos.28")); //$NON-NLS-1$
					btn_actualizar.addActionListener(new GuardarPerdido());
					GridBagConstraints gbc_btn_actualizar = new GridBagConstraints();
					gbc_btn_actualizar.fill = GridBagConstraints.HORIZONTAL;
					gbc_btn_actualizar.insets = new Insets(0, 0, 5, 0);
					gbc_btn_actualizar.gridx = 1;
					gbc_btn_actualizar.gridy = 1;
					panel_datos.add(btn_actualizar, gbc_btn_actualizar);
				}
				{
					tb_comentarios = new JTextArea();
					tb_comentarios.setBorder(new TitledBorder(null, Messages.getString("PanelPerdidos.29"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
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

		cargarTodosPerdidos();
	}

	public void cargarTodosPerdidos() {
		File directorio = new File("data/perdidos/"); //$NON-NLS-1$
		File[] archivosEnDirectorio = directorio.listFiles();
		if (archivosEnDirectorio != null) {
			String archivo = null;
			for (File child : archivosEnDirectorio) {
				archivo = child.getName();
				String extension = archivo.substring(archivo.length() -8 , archivo.length());
				if (extension.equals(".perdido")) //$NON-NLS-1$
					anadirALista(archivo.substring(0, archivo.length() - 8));
			}
			cargarPerdido(archivo);
		}
	}

	public void cargarPerdido(String nombreArchivo) {
		limpiarCampos();
		File file = new File("data/perdidos/" + nombreArchivo); //$NON-NLS-1$

		try{
			FileReader fr = new FileReader (file.getAbsolutePath());
			BufferedReader br = new BufferedReader(fr);
			tf_nombre.setText(br.readLine());
			sp_edad.setValue(new Integer(br.readLine()));
			tf_raza.setText(br.readLine());
			tf_telefono.setText(br.readLine());
			datechooser.setDate(parseFecha(br.readLine()));
			cb_tamaño.setSelectedIndex(new Integer(br.readLine()));
			String image = br.readLine();
			if (image.equals("null")) image = "data/perdidos/default.jpg";
			lblFoto.setIcon (new ImageIcon (image));
			String txt = null;
			while((txt = br.readLine()) != null) tb_comentarios.append(txt+'\n');

			br.close();
			vp.lblInfo.setText(Messages.getString("PanelPerdidos.33")+ file.getAbsolutePath()); //$NON-NLS-1$
		} catch (IOException ioe){
			//System.out.println(ioe);
		} catch(NumberFormatException nume){
			//System.out.println("no problem"); //$NON-NLS-1$
		}
	}
	public void limpiarCampos() {
		tf_nombre.setText(null);
		sp_edad.setValue(1);
		tf_raza.setText(null);
		tf_telefono.setText(null);
		datechooser.setDate(parseFecha(Messages.getString("PanelPerdidos.35"))); //$NON-NLS-1$
		cb_tamaño.setSelectedIndex(-1);
		lblFoto.setIcon(null);
		tb_comentarios.setText(null);
	}

	private class AnadirPerdido implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String nombre = JOptionPane.showInputDialog(Messages.getString("PanelPerdidos.36")); //$NON-NLS-1$
			if (nombre != null && nombre.length()>1){
				anadirALista(nombre);
				tf_nombre.setText(nombre);
			}
			else if(nombre != null) JOptionPane.showMessageDialog(frame, Messages.getString("PanelPerdidos.37"), Messages.getString("PanelPerdidos.38"), JOptionPane.WARNING_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	private class BorrarPerdido implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int index = list.getSelectedIndex();
			String seleccionado = list.getModel().getElementAt(index).toString();

			int reply = JOptionPane.showConfirmDialog(frame, Messages.getString("PanelPerdidos.39")+seleccionado+"?", Messages.getString("PanelPerdidos.41"), JOptionPane.YES_NO_OPTION); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

			if (reply == JOptionPane.YES_OPTION) {
				limpiarCampos();
				((DefaultListModel)list.getModel()).removeElementAt(index);
		
				try{
					File archivo = new File("data/perdidos/" + seleccionado +".perdido"); //$NON-NLS-1$ //$NON-NLS-2$
					archivo.delete();
				}catch(Exception e1){
					//System.out.println(e1.toString());
				}
			}		
		}
	}
	private class GuardarPerdido implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nombre = tf_nombre.getText().equals("") ? Messages.getString("PanelPerdidos.45")+(new Random()).nextInt(998) : tf_nombre.getText(); //$NON-NLS-1$ //$NON-NLS-2$
			String raza = tf_raza.getText().equals("") ? Messages.getString("PanelPerdidos.47") : tf_raza.getText(); //$NON-NLS-1$ //$NON-NLS-2$
			String telefono = tf_telefono.getText().equals("") ? Messages.getString("PanelPerdidos.49") : tf_telefono.getText(); //$NON-NLS-1$ //$NON-NLS-2$
			String stringToSave = 	nombre +"\r\n"+ //$NON-NLS-1$
					sp_edad.getValue() +"\r\n"+ //$NON-NLS-1$
					raza +"\r\n"+ //$NON-NLS-1$
					telefono +"\r\n"+ //$NON-NLS-1$
					parseFecha(datechooser.getDate())+"\r\n"+ //$NON-NLS-1$
					cb_tamaño.getSelectedIndex() +"\r\n"+ //$NON-NLS-1$
					lblFoto.getIcon() +"\r\n"+ //$NON-NLS-1$
					tb_comentarios.getText();
			//System.out.println(stringToSave);

			int reply = JOptionPane.showConfirmDialog(frame, Messages.getString("PanelPerdidos.57"), Messages.getString("PanelPerdidos.58"), JOptionPane.YES_NO_OPTION); //$NON-NLS-1$ //$NON-NLS-2$

			if (reply == JOptionPane.YES_OPTION) {
				File file = new File("data/perdidos/" + nombre + ".perdido"); //$NON-NLS-1$ //$NON-NLS-2$

				try {
					FileWriter fw = new FileWriter (file, false);
					fw.write(stringToSave);
					fw.close();
					vp.lblInfo.setText(Messages.getString("PanelPerdidos.61")+ file.getAbsolutePath()); //$NON-NLS-1$
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, Messages.getString("PanelPerdidos.62"), Messages.getString("PanelPerdidos.63"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
				}

			} else {
				//System.out.println(Messages.getString("PanelPerdidos.64")); //$NON-NLS-1$
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
			String seleccionado = null;
			try{
				seleccionado = list.getModel().getElementAt(list.getSelectedIndex()).toString();

			}catch(Exception e1) { 
				seleccionado = list.getModel().getElementAt(0).toString();
				list.setSelectedIndex(0);
			}
			if (!list.getValueIsAdjusting())
				cargarPerdido(seleccionado+".perdido"); //$NON-NLS-1$
		}
	}

	public void anadirALista(String name) {
		int indice = list.getModel().getSize();
		((DefaultListModel) list.getModel()).addElement(name);
		list.setSelectedIndex(indice);
		list.ensureIndexIsVisible(indice);
		limpiarCampos();
	}
	 public static Date parseFecha(String fecha){
	        SimpleDateFormat formato = new SimpleDateFormat("dd-MMM-yyyy"); //$NON-NLS-1$
	        Date fechaDate = null;
	        try {
	            fechaDate = formato.parse(fecha);
	        } 
	        catch (ParseException ex) 
	        {
	        }
	        return fechaDate;
	    }
	 public static String parseFecha(Date fecha){
	        String fechastr=fecha.toString();
	        String dia=fechastr.substring(8,10);
	        String mes=fechastr.substring(4,7).toLowerCase();
	        String año=fechastr.substring(24,28);
	        if(mes.equals("jan")) mes="ene"; //$NON-NLS-1$ //$NON-NLS-2$
	        fechastr=dia+"-"+mes+"-"+año; //$NON-NLS-1$ //$NON-NLS-2$
	        //System.out.println(fechastr);
	        return fechastr;
	 }
}

