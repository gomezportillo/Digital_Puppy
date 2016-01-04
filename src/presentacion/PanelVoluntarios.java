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
import javax.swing.JFormattedTextField;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class PanelVoluntarios extends JPanel {
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
	private JLabel lbVeterinario;
	private JTextField tf_nombre;
	private JList list;
	private JTextField tf_direccion;
	private JButton btnEliminarFoto;
	private VentanaPrincipal vp;
	private JCheckBox cb_veterinario;
	private JSpinner sp_edad;
	private JFormattedTextField tf_telefono;
	private JFormattedTextField tf_NIF;


	public PanelVoluntarios(JFrame frame, VentanaPrincipal ventanaPrincipal) {
		this.frame = frame;
		this.vp = ventanaPrincipal;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{147, 150, 0};
		gridBagLayout.rowHeights = new int[]{331, 32, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		{
			btn_anadir = new JButton(Messages.getString("PanelVoluntarios.0")); //$NON-NLS-1$
			btn_anadir.addActionListener(new Anadirvoluntario());
			{
				scrollPane_tabla = new JScrollPane();
				scrollPane_tabla.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), Messages.getString("PanelVoluntarios.2"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$ //$NON-NLS-2$
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
				panel_datos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), Messages.getString("PanelVoluntarios.5"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$ //$NON-NLS-2$
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
					panel_foto.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), Messages.getString("PanelVoluntarios.7"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$ //$NON-NLS-2$
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
						btnNewButton_1 = new JButton(Messages.getString("PanelVoluntarios.9")); //$NON-NLS-1$
						btnNewButton_1.addActionListener(new SeleccionarFoto());
						GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
						gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
						gbc_btnNewButton_1.gridx = 0;
						gbc_btnNewButton_1.gridy = 1;
						panel_foto.add(btnNewButton_1, gbc_btnNewButton_1);
					}
					{
						btnEliminarFoto = new JButton(Messages.getString("PanelVoluntarios.10")); //$NON-NLS-1$
						btnEliminarFoto.addActionListener(new BtnEliminarFotoActionListener());
						GridBagConstraints gbc_btnEliminarFoto = new GridBagConstraints();
						gbc_btnEliminarFoto.gridx = 1;
						gbc_btnEliminarFoto.gridy = 1;
						panel_foto.add(btnEliminarFoto, gbc_btnEliminarFoto);
					}
				}
				{
					panel_info = new JPanel();
					panel_info.setBorder(new TitledBorder(null, Messages.getString("PanelVoluntarios.11"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
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
						lblNombre = new JLabel(Messages.getString("PanelVoluntarios.12")); //$NON-NLS-1$
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
						lblEdad = new JLabel(Messages.getString("PanelVoluntarios.14")); //$NON-NLS-1$
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
						lblDireccion = new JLabel(Messages.getString("PanelVoluntarios.16")); //$NON-NLS-1$
						GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
						gbc_lblDireccion.anchor = GridBagConstraints.WEST;
						gbc_lblDireccion.insets = new Insets(0, 0, 5, 5);
						gbc_lblDireccion.gridx = 0;
						gbc_lblDireccion.gridy = 2;
						panel_info.add(lblDireccion, gbc_lblDireccion);
					}
					{
						tf_direccion = new JTextField();
						GridBagConstraints gbc_tf_direccion = new GridBagConstraints();
						gbc_tf_direccion.insets = new Insets(0, 0, 5, 0);
						gbc_tf_direccion.fill = GridBagConstraints.HORIZONTAL;
						gbc_tf_direccion.gridx = 1;
						gbc_tf_direccion.gridy = 2;
						panel_info.add(tf_direccion, gbc_tf_direccion);
						tf_direccion.setColumns(10);
					}
					{
						lblTelefono = new JLabel(Messages.getString("PanelVoluntarios.17")); //$NON-NLS-1$
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
						lblNIF = new JLabel(Messages.getString("PanelVoluntarios.19")); //$NON-NLS-1$
						GridBagConstraints gbc_lblNIF = new GridBagConstraints();
						gbc_lblNIF.anchor = GridBagConstraints.EAST;
						gbc_lblNIF.insets = new Insets(0, 0, 5, 5);
						gbc_lblNIF.gridx = 0;
						gbc_lblNIF.gridy = 4;
						panel_info.add(lblNIF, gbc_lblNIF);
					}
					{
						GridBagConstraints gbc_tf_NIF = new GridBagConstraints();
						gbc_tf_NIF.insets = new Insets(0, 0, 5, 0);
						gbc_tf_NIF.fill = GridBagConstraints.HORIZONTAL;
						gbc_tf_NIF.gridx = 1;
						gbc_tf_NIF.gridy = 4;
						MaskFormatter formatoDNI;
						try {
							formatoDNI = new MaskFormatter("########'-U"); //$NON-NLS-1$
							formatoDNI.setPlaceholderCharacter('X');
							tf_NIF = new JFormattedTextField(formatoDNI);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						panel_info.add(tf_NIF, gbc_tf_NIF);
					}
					{
						lbVeterinario = new JLabel(Messages.getString("PanelVoluntarios.3")); //$NON-NLS-1$
						GridBagConstraints gbc_lbVeterinario = new GridBagConstraints();
						gbc_lbVeterinario.anchor = GridBagConstraints.WEST;
						gbc_lbVeterinario.insets = new Insets(0, 0, 0, 5);
						gbc_lbVeterinario.gridx = 0;
						gbc_lbVeterinario.gridy = 5;
						panel_info.add(lbVeterinario, gbc_lbVeterinario);
					}
					{
						cb_veterinario = new JCheckBox(""); //$NON-NLS-1$
						GridBagConstraints gbc_cb_veterinario = new GridBagConstraints();
						gbc_cb_veterinario.anchor = GridBagConstraints.WEST;
						gbc_cb_veterinario.gridx = 1;
						gbc_cb_veterinario.gridy = 5;
						panel_info.add(cb_veterinario, gbc_cb_veterinario);
					}
				}
				{
					bton_borrar = new JButton(Messages.getString("PanelVoluntarios.23")); //$NON-NLS-1$
					bton_borrar.addActionListener(new BorrarVoluntario());
					GridBagConstraints gbc_bton_borrar = new GridBagConstraints();
					gbc_bton_borrar.fill = GridBagConstraints.HORIZONTAL;
					gbc_bton_borrar.insets = new Insets(0, 0, 5, 5);
					gbc_bton_borrar.gridx = 0;
					gbc_bton_borrar.gridy = 1;
					panel_datos.add(bton_borrar, gbc_bton_borrar);
				}
				{
					btn_actualizar = new JButton(Messages.getString("PanelVoluntarios.24")); //$NON-NLS-1$
					btn_actualizar.addActionListener(new GuardarVoluntario());
					GridBagConstraints gbc_btn_actualizar = new GridBagConstraints();
					gbc_btn_actualizar.fill = GridBagConstraints.HORIZONTAL;
					gbc_btn_actualizar.insets = new Insets(0, 0, 5, 0);
					gbc_btn_actualizar.gridx = 1;
					gbc_btn_actualizar.gridy = 1;
					panel_datos.add(btn_actualizar, gbc_btn_actualizar);
				}
				{
					tb_comentarios = new JTextArea();
					tb_comentarios.setBorder(new TitledBorder(null, Messages.getString("PanelVoluntarios.25"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
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

		cargarTodosVoluntarios();
	}


	public void cargarTodosVoluntarios() {
		File directorio = new File("data/voluntarios/"); //$NON-NLS-1$
		File[] archivosEnDirectorio = directorio.listFiles();
		if (archivosEnDirectorio != null) {
			String archivo = null;
			for (File child : archivosEnDirectorio) {
				archivo = child.getName();
				String extension = archivo.substring(archivo.length() -11 , archivo.length());
				if (extension.equals(".voluntario")) //$NON-NLS-1$
					anadirALista(archivo.substring(0, archivo.length() - 11));
			}
			cargarVoluntario(archivo);
		}
	}

	public void cargarVoluntario(String nombreArchivo) {
		limpiarCampos();
		File file = new File("data/voluntarios/" + nombreArchivo); //$NON-NLS-1$

		try{
			FileReader fr = new FileReader (file.getAbsolutePath());
			BufferedReader br = new BufferedReader(fr);

			tf_nombre.setText(br.readLine());
			sp_edad.setValue(new Integer(br.readLine()));
			tf_direccion.setText(br.readLine());
			tf_telefono.setText(br.readLine());
			tf_NIF.setText(br.readLine());
			if (br.readLine().contains("true")) cb_veterinario.setSelected(true); //$NON-NLS-1$
			lblFoto.setIcon (new ImageIcon (br.readLine()));
			String txt = null;
			while((txt = br.readLine()) != null) tb_comentarios.append(txt+'\n');

			br.close();
			vp.lblInfo.setText(Messages.getString("PanelVoluntarios.30")+ file.getAbsolutePath()); //$NON-NLS-1$
		} catch (IOException ioe){
			//System.out.println(ioe);
		} catch(NumberFormatException nume){
			System.out.println("no problem"); //$NON-NLS-1$
		}
	}

	public void limpiarCampos() {
		tf_nombre.setText(null);
		sp_edad.setValue(1);
		tf_direccion.setText(null);
		tf_telefono.setText(null);
		tf_NIF.setText(null);
		cb_veterinario.setSelected(false);
		lblFoto.setIcon(null);
		tb_comentarios.setText(null);
	}

	private class Anadirvoluntario implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String nombre = JOptionPane.showInputDialog(Messages.getString("PanelVoluntarios.32")); //$NON-NLS-1$
			if (nombre != null && nombre.length()>1){
				System.out.println(nombre);
				anadirALista(nombre);
				tf_nombre.setText(nombre);
			}
			else if(nombre != null) JOptionPane.showMessageDialog(frame, Messages.getString("PanelVoluntarios.33"), Messages.getString("PanelVoluntarios.34"), JOptionPane.WARNING_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
	private class BorrarVoluntario implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int index = list.getSelectedIndex();
			String seleccionado = list.getModel().getElementAt(index).toString();

			int reply = JOptionPane.showConfirmDialog(frame, Messages.getString("PanelVoluntarios.35")+seleccionado+"?", Messages.getString("PanelVoluntarios.1"), JOptionPane.YES_NO_OPTION); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

			if (reply == JOptionPane.YES_OPTION) {
				limpiarCampos();
				((DefaultListModel)list.getModel()).removeElementAt(index);
		
				try{
					File archivo = new File("data/voluntarios/" + seleccionado +".voluntario"); //$NON-NLS-1$ //$NON-NLS-2$
					archivo.delete();
				}catch(Exception e1){
					//System.out.println(e1.toString());
				}
			}		
		}
	}

	private class GuardarVoluntario implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nombre = tf_nombre.getText().equals("") ? Messages.getString("PanelVoluntarios.41")+(new Random()).nextInt(998) : tf_nombre.getText(); //$NON-NLS-1$ //$NON-NLS-2$
			String direccion = tf_direccion.getText().equals("") ? Messages.getString("PanelVoluntarios.43") : tf_direccion.getText(); //$NON-NLS-1$ //$NON-NLS-2$
			String telefono = tf_telefono.getText().equals("") ? Messages.getString("PanelVoluntarios.45") : tf_telefono.getText(); //$NON-NLS-1$ //$NON-NLS-2$
			String nif = tf_NIF.getText().equals("") ? Messages.getString("PanelVoluntarios.47") : tf_NIF.getText(); //$NON-NLS-1$ //$NON-NLS-2$
			String stringToSave = 	nombre +"\r\n"+ //$NON-NLS-1$
					sp_edad.getValue() +"\r\n"+ //$NON-NLS-1$
					direccion +"\r\n"+ //$NON-NLS-1$
					telefono +"\r\n"+ //$NON-NLS-1$
					nif +"\r\n"+ //$NON-NLS-1$
					cb_veterinario.isSelected() +"\r\n"+ //$NON-NLS-1$
					lblFoto.getIcon() +"\r\n"+ //$NON-NLS-1$
					tb_comentarios.getText();
			//System.out.println(stringToSave);

			int reply = JOptionPane.showConfirmDialog(frame, Messages.getString("PanelVoluntarios.55"), Messages.getString("PanelVoluntarios.56"), JOptionPane.YES_NO_OPTION); //$NON-NLS-1$ //$NON-NLS-2$

			if (reply == JOptionPane.YES_OPTION) {
				File file = new File("data/voluntarios/" + nombre + ".voluntario"); //$NON-NLS-1$ //$NON-NLS-2$

				try {
					FileWriter fw = new FileWriter (file, false);
					fw.write(stringToSave);
					fw.close();
					vp.lblInfo.setText(Messages.getString("PanelVoluntarios.59")+ file.getAbsolutePath()); //$NON-NLS-1$
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, Messages.getString("PanelVoluntarios.60"), "Error", JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
				}

			} else {
				System.out.println(Messages.getString("PanelVoluntarios.62")); //$NON-NLS-1$
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
			String voluntarioSeleccionado = null;
			try{
				voluntarioSeleccionado = list.getModel().getElementAt(list.getSelectedIndex()).toString();

			}catch(Exception e1) { //se ralla con los index cuando se borra un elemento de la lista
				voluntarioSeleccionado = list.getModel().getElementAt(0).toString();
				list.setSelectedIndex(0);
			}
			if (!list.getValueIsAdjusting())
				cargarVoluntario(voluntarioSeleccionado+".voluntario"); //$NON-NLS-1$
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

