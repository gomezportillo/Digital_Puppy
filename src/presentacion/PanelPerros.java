package presentacion;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
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

@SuppressWarnings({ "unchecked", "rawtypes" })
public class PanelPerros extends JPanel {
	private static final long serialVersionUID = -7518504297885688690L;
	private JFrame frame;
	private JButton btn_anadir;
	private JPanel panel_datos;
	private JScrollPane scrollPane_tabla;
	private JEditorPane tb_comentarios;
	private JButton bton_borrar;
	private JButton btn_actualizar;
	private JPanel panel_foto;
	private JPanel panel_info;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane_1;
	private JLabel lblFoto;
	private JLabel lblNombre;
	private JLabel lblNewLabel;
	private JLabel lblRaza;
	private JLabel lblPeligroso;
	private JLabel lblNewLabel_1;
	private JLabel lblEstado;
	private JTextField tf_nombre;
	private JSpinner sp_edad;
	private JComboBox cb_estado;
	private JList list;
	private JTextField tf_raza;
	private JCheckBox cb_peligroso;
	private JCheckBox cb_esterilizado;
	private JButton btnEliminarFoto;

	/**
	 * Create the panel.
	 */

	
	public PanelPerros(JFrame frame) {
		this.frame = frame;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{147, 150, 0};
		gridBagLayout.rowHeights = new int[]{331, 32, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		{
			btn_anadir = new JButton("Añadir nuevo perrete");
			btn_anadir.addActionListener(new AnadirPerrete());
			{
				scrollPane_tabla = new JScrollPane();
				scrollPane_tabla.setBorder(new TitledBorder(null, "Perretes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
					list.setToolTipText("");
					list.setVisibleRowCount(100);
					scrollPane_tabla.setColumnHeaderView(list);
				}
			}
			{
				panel_datos = new JPanel();
				panel_datos.setMaximumSize(new Dimension(1000, 1000));
				panel_datos.setMinimumSize(new Dimension(200, 200));
				panel_datos.setBorder(new TitledBorder(null, "Perrete", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				GridBagConstraints gbc_panel_datos = new GridBagConstraints();
				gbc_panel_datos.gridheight = 2;
				gbc_panel_datos.fill = GridBagConstraints.BOTH;
				gbc_panel_datos.gridx = 1;
				gbc_panel_datos.gridy = 0;
				add(panel_datos, gbc_panel_datos);
				GridBagLayout gbl_panel_datos = new GridBagLayout();
				gbl_panel_datos.columnWidths = new int[] {186, 209};
				gbl_panel_datos.rowHeights = new int[] {245, 47, 54};
				gbl_panel_datos.columnWeights = new double[]{1.0, 1.0};
				gbl_panel_datos.rowWeights = new double[]{1.0, 0.0, 0.0};
				panel_datos.setLayout(gbl_panel_datos);
				{
					panel_foto = new JPanel();
					panel_foto.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Foto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
							lblFoto = new JLabel("");
							lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
							scrollPane_1.setViewportView(lblFoto);
						}
					}
					{
						btnNewButton_1 = new JButton("Seleccionar foto");
						btnNewButton_1.addActionListener(new SeleccionarFoto());
						GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
						gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
						gbc_btnNewButton_1.gridx = 0;
						gbc_btnNewButton_1.gridy = 1;
						panel_foto.add(btnNewButton_1, gbc_btnNewButton_1);
					}
					{
						btnEliminarFoto = new JButton("Eliminar foto");
						btnEliminarFoto.addActionListener(new BtnEliminarFotoActionListener());
						GridBagConstraints gbc_btnEliminarFoto = new GridBagConstraints();
						gbc_btnEliminarFoto.gridx = 1;
						gbc_btnEliminarFoto.gridy = 1;
						panel_foto.add(btnEliminarFoto, gbc_btnEliminarFoto);
					}
				}
				{
					panel_info = new JPanel();
					panel_info.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					GridBagConstraints gbc_panel_info = new GridBagConstraints();
					gbc_panel_info.insets = new Insets(0, 0, 5, 0);
					gbc_panel_info.fill = GridBagConstraints.BOTH;
					gbc_panel_info.gridx = 1;
					gbc_panel_info.gridy = 0;
					panel_datos.add(panel_info, gbc_panel_info);
					GridBagLayout gbl_panel_info = new GridBagLayout();
					gbl_panel_info.columnWidths = new int[]{82, 0, 0};
					gbl_panel_info.rowHeights = new int[]{0, 37, 52, 51, 59, 92, 0};
					gbl_panel_info.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
					gbl_panel_info.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
					panel_info.setLayout(gbl_panel_info);
					{
						lblNombre = new JLabel("Nombre");
						GridBagConstraints gbc_lblNombre = new GridBagConstraints();
						gbc_lblNombre.anchor = GridBagConstraints.WEST;
						gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
						gbc_lblNombre.gridx = 0;
						gbc_lblNombre.gridy = 0;
						panel_info.add(lblNombre, gbc_lblNombre);
					}
					{
						tf_nombre = new JTextField();
						GridBagConstraints gbc_tf_nombre = new GridBagConstraints();
						gbc_tf_nombre.insets = new Insets(0, 0, 5, 0);
						gbc_tf_nombre.fill = GridBagConstraints.HORIZONTAL;
						gbc_tf_nombre.gridx = 1;
						gbc_tf_nombre.gridy = 0;
						panel_info.add(tf_nombre, gbc_tf_nombre);
						tf_nombre.setColumns(10);
					}
					{
						lblNewLabel = new JLabel("Edad");
						GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
						gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
						gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
						gbc_lblNewLabel.gridx = 0;
						gbc_lblNewLabel.gridy = 1;
						panel_info.add(lblNewLabel, gbc_lblNewLabel);
					}
					{
						sp_edad = new JSpinner();
						sp_edad.setModel(new SpinnerNumberModel(1, 1, 20, 1));
						GridBagConstraints gbc_sp_edad = new GridBagConstraints();
						gbc_sp_edad.anchor = GridBagConstraints.WEST;
						gbc_sp_edad.insets = new Insets(0, 0, 5, 0);
						gbc_sp_edad.gridx = 1;
						gbc_sp_edad.gridy = 1;
						panel_info.add(sp_edad, gbc_sp_edad);
					}
					{
						lblRaza = new JLabel("Raza");
						GridBagConstraints gbc_lblRaza = new GridBagConstraints();
						gbc_lblRaza.anchor = GridBagConstraints.WEST;
						gbc_lblRaza.insets = new Insets(0, 0, 5, 5);
						gbc_lblRaza.gridx = 0;
						gbc_lblRaza.gridy = 2;
						panel_info.add(lblRaza, gbc_lblRaza);
					}
					{
						tf_raza = new JTextField();
						GridBagConstraints gbc_tf_raza = new GridBagConstraints();
						gbc_tf_raza.insets = new Insets(0, 0, 5, 0);
						gbc_tf_raza.fill = GridBagConstraints.HORIZONTAL;
						gbc_tf_raza.gridx = 1;
						gbc_tf_raza.gridy = 2;
						panel_info.add(tf_raza, gbc_tf_raza);
						tf_raza.setColumns(10);
					}
					{
						lblPeligroso = new JLabel("Peligroso");
						GridBagConstraints gbc_lblPeligroso = new GridBagConstraints();
						gbc_lblPeligroso.anchor = GridBagConstraints.WEST;
						gbc_lblPeligroso.insets = new Insets(0, 0, 5, 5);
						gbc_lblPeligroso.gridx = 0;
						gbc_lblPeligroso.gridy = 3;
						panel_info.add(lblPeligroso, gbc_lblPeligroso);
					}
					{
						cb_peligroso = new JCheckBox("");
						GridBagConstraints gbc_cb_peligroso = new GridBagConstraints();
						gbc_cb_peligroso.anchor = GridBagConstraints.WEST;
						gbc_cb_peligroso.insets = new Insets(0, 0, 5, 0);
						gbc_cb_peligroso.gridx = 1;
						gbc_cb_peligroso.gridy = 3;
						panel_info.add(cb_peligroso, gbc_cb_peligroso);
					}
					{
						lblNewLabel_1 = new JLabel("Esterilizado");
						GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
						gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
						gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
						gbc_lblNewLabel_1.gridx = 0;
						gbc_lblNewLabel_1.gridy = 4;
						panel_info.add(lblNewLabel_1, gbc_lblNewLabel_1);
					}
					{
						cb_esterilizado = new JCheckBox("");
						GridBagConstraints gbc_cb_esterilizado = new GridBagConstraints();
						gbc_cb_esterilizado.anchor = GridBagConstraints.WEST;
						gbc_cb_esterilizado.insets = new Insets(0, 0, 5, 0);
						gbc_cb_esterilizado.gridx = 1;
						gbc_cb_esterilizado.gridy = 4;
						panel_info.add(cb_esterilizado, gbc_cb_esterilizado);
					}
					{
						lblEstado = new JLabel("Estado");
						GridBagConstraints gbc_lblEstado = new GridBagConstraints();
						gbc_lblEstado.anchor = GridBagConstraints.WEST;
						gbc_lblEstado.insets = new Insets(0, 0, 0, 5);
						gbc_lblEstado.gridx = 0;
						gbc_lblEstado.gridy = 5;
						panel_info.add(lblEstado, gbc_lblEstado);
					}
					{
						cb_estado = new JComboBox();
						cb_estado.setModel(new DefaultComboBoxModel(new String[] {"En perrera", "Reservado", "Adoptado", "Perdido", "Fallecido"}));
						GridBagConstraints gbc_cb_estado = new GridBagConstraints();
						gbc_cb_estado.fill = GridBagConstraints.HORIZONTAL;
						gbc_cb_estado.gridx = 1;
						gbc_cb_estado.gridy = 5;
						panel_info.add(cb_estado, gbc_cb_estado);
						cb_estado.setSelectedIndex(0);
					}
				}
				{
					bton_borrar = new JButton("Borrar perrete");
					bton_borrar.addActionListener(new BorrarPerrete());
					GridBagConstraints gbc_bton_borrar = new GridBagConstraints();
					gbc_bton_borrar.fill = GridBagConstraints.HORIZONTAL;
					gbc_bton_borrar.insets = new Insets(0, 0, 5, 5);
					gbc_bton_borrar.gridx = 0;
					gbc_bton_borrar.gridy = 1;
					panel_datos.add(bton_borrar, gbc_bton_borrar);
				}
				{
					btn_actualizar = new JButton("Guardar cambios");
					btn_actualizar.addActionListener(new GuardarPerrete());
					GridBagConstraints gbc_btn_actualizar = new GridBagConstraints();
					gbc_btn_actualizar.fill = GridBagConstraints.HORIZONTAL;
					gbc_btn_actualizar.insets = new Insets(0, 0, 5, 0);
					gbc_btn_actualizar.gridx = 1;
					gbc_btn_actualizar.gridy = 1;
					panel_datos.add(btn_actualizar, gbc_btn_actualizar);
				}
				{
					tb_comentarios = new JEditorPane();
					tb_comentarios.setBorder(new TitledBorder(null, "Comentarios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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

		cargarTodosPerretes();

	}

	/**
	 *  Abre el directorio data/perretes/ donde estan los archivos .perrete de 
	 *  todos los perros de la perrera y añade los nombres uno a uno a la JList.
	 *  Ojo, solo añade los nombres de los archivos. El unico archivo que abre 
	 *  es el ultimo, que es el que muestra al iniciar la aplicacion.
	 */
	public void cargarTodosPerretes() {
		File directorio = new File("data/perretes/");
		File[] archivosEnDirectorio = directorio.listFiles();
		if (archivosEnDirectorio != null) {
			String archivo = null;
			for (File child : archivosEnDirectorio) {
				archivo = child.getName();
				String extension = archivo.substring(archivo.length() - 8, archivo.length());
				if (extension.equals(".perrete"))
					anadirPerreteALista(archivo.substring(0, archivo.length() - 8));
			}
			cargarPerrete(archivo);
		}
	}

	/**
	 * A partir del nombre de un archivo, lo abre y llena los campos del panel con los datos que tiene
	 * @param nombrePerrete nombre del archivo
	 */
	public void cargarPerrete(String nombreArchivo) {
		limpiarCampos();
		File file = new File("data/perretes/" + nombreArchivo);
		System.out.println(file.getAbsolutePath());


		try{
			FileReader fr = new FileReader (file.getAbsolutePath());
			BufferedReader br = new BufferedReader(fr);

			tf_nombre.setText(br.readLine());
			sp_edad.setValue(new Integer(br.readLine()));
			tf_raza.setText(br.readLine());
			if (br.readLine().contains("true")) cb_peligroso.setSelected(true);
			if (br.readLine().contains("true")) cb_esterilizado.setSelected(true);
			cb_estado.setSelectedIndex(new Integer(br.readLine()));
			lblFoto.setIcon (new ImageIcon (br.readLine()));

			br.close();

		} catch (IOException ioe){
			//System.out.println(ioe);
		}
	}

	/**
	 * Vacia todos los campos del panel 
	 */
	public void limpiarCampos() {
		tf_nombre.setText("");
		sp_edad.setValue(0);
		tf_raza.setText("");
		cb_peligroso.setSelected(false);
		cb_esterilizado.setSelected(false);
		cb_estado.setSelectedIndex(-1);
		lblFoto.setIcon(null);
	}

	/**
	 * Listener para el boton "Añadir perrete". Desde aqui no lo guardamos, solo creamos una entrada
	 * en la tabla, y cuando le usuario termine de completarla de da a Guardar para guardarlo
	 */
	private class AnadirPerrete implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String nombre = JOptionPane.showInputDialog("Nombre del nuevo perrete");
			if (nombre != null && nombre.length()>1){
				System.out.println(nombre);
				anadirPerreteALista(nombre);
				tf_nombre.setText(nombre);
			}
			else if(nombre != null) JOptionPane.showConfirmDialog(frame, "Seleccione un nombre valido", "Guardar", JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * Listener para el botón "Borrar perrete". Borra el archivo con su información y lo elimina de la Jlist
	 */
	private class BorrarPerrete implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int index = list.getSelectedIndex();
			String perreteSeleccionado = list.getModel().getElementAt(index).toString();

			int reply = JOptionPane.showConfirmDialog(frame, "¿Seguro que quiere eliminar a "+perreteSeleccionado+"?", "Eliminar", JOptionPane.YES_NO_OPTION);

			if (reply == JOptionPane.YES_OPTION) {
				limpiarCampos();
				System.out.println("1");
				((DefaultListModel)list.getModel()).removeElementAt(index);
				System.out.println("2");
				try{
					File archivoPerrete = new File("data/perretes/" + perreteSeleccionado +".perrete");
					archivoPerrete.delete();
				}catch(Exception e1){
					//System.out.println(e1.toString());
				}
			}		
		}
	}


	/**
	 * Listener para el boton "Guardar cambios". Guardamos todos los campos en texto plano 
	 * en un archivo con extensión ".perrete" para luego cargarlos desde el programa.
	 */
	private class GuardarPerrete implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nombrePerrete = tf_nombre.getText().equals("") ? "Perrete"+(new Random()).nextInt(998) : tf_nombre.getText();
			String razaPerrete = tf_raza.getText().equals("") ? "Mestizo" : tf_raza.getText();
			String stringToSave = 	nombrePerrete +"\r\n"+
					sp_edad.getValue() +"\r\n"+
					razaPerrete +"\r\n"+
					cb_peligroso.isSelected() +"\r\n"+
					cb_esterilizado.isSelected() +"\r\n"+
					cb_estado.getSelectedIndex() +"\r\n"+
					lblFoto.getIcon() +"\r\n"+
					tb_comentarios.getText();
			//System.out.println(stringToSave);
			int reply = JOptionPane.showConfirmDialog(frame, "¿Seguro que quiere guardar?", "Guardar", JOptionPane.YES_NO_OPTION);

			if (reply == JOptionPane.YES_OPTION) {
				File fileName = new File("data/perretes/" + nombrePerrete + ".perrete");
				BufferedWriter outFile;
				try {
					outFile = new BufferedWriter(new FileWriter(fileName));
					outFile.write(stringToSave);
					outFile.close();
					JOptionPane.showMessageDialog(frame, "Archivo guardado correctamente", "Guardar", JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e1) {
					System.out.println("Error guardando el archivo. Reinicie el programa y vuelva a intentarlo");
				}
			}	else{
				System.out.println("Guardado cancelado por el usuario");
			}
		}
	}

	/**
	 * Listener para añadir una foto al perrete en cuestión
	 */
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

	/**
	 * Listener del boton "Borrar foto"
	 */
	private class BtnEliminarFotoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			lblFoto.setIcon(null);
		}
	}

	/**
	 * Este listener se ejecutará cuando pinchemos en un elemento de la lista
	 */
	private class ListListSelectionListener implements ListSelectionListener { 
		public void valueChanged(ListSelectionEvent arg0) {
			String perreteSeleccionado = null;
			try{
				perreteSeleccionado = list.getModel().getElementAt(list.getSelectedIndex()).toString();
				
			}catch(Exception e1) { //se ralla con los index cuando se borra un elemento de la lista
				perreteSeleccionado = list.getModel().getElementAt(0).toString();
				list.setSelectedIndex(0);
			}
			if (!list.getValueIsAdjusting())
				cargarPerrete(perreteSeleccionado+".perrete");
		}
	}

	/**
	 * Este metodo será ejecutado cuando queramos añadir un nuevo elemento a la lista
	 * @param name String con el elemento que queremos añadir
	 */
	public void anadirPerreteALista(String name) {
		int indice = list.getModel().getSize();
		((DefaultListModel) list.getModel()).addElement(name);
		list.setSelectedIndex(indice);
		list.ensureIndexIsVisible(indice);
		limpiarCampos();
	}
}

