package presentacion;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.AbstractListModel;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.MutableComboBoxModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("unchecked, rawtypes")
public class PanelPerros extends JPanel {
	private JFrame frame;
	private JButton btn_anadir;
	private JScrollPane scrollPane;
	private JPanel panel_datos;
	private JScrollPane scrollPane_tabla;
	private JEditorPane editorPane;
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
				gbl_panel_datos.columnWidths = new int[] {200, 1};
				gbl_panel_datos.rowHeights = new int[] {245, 47, 54};
				gbl_panel_datos.columnWeights = new double[]{0.0, 1.0};
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
					gbl_panel_foto.columnWidths = new int[]{0, 0};
					gbl_panel_foto.rowHeights = new int[]{0, 0, 0};
					gbl_panel_foto.columnWeights = new double[]{1.0, Double.MIN_VALUE};
					gbl_panel_foto.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
					panel_foto.setLayout(gbl_panel_foto);
					{
						scrollPane_1 = new JScrollPane();
						GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
						gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
						gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
						gbc_scrollPane_1.gridx = 0;
						gbc_scrollPane_1.gridy = 0;
						panel_foto.add(scrollPane_1, gbc_scrollPane_1);
						{
							lblFoto = new JLabel("");
							scrollPane_1.setViewportView(lblFoto);
						}
					}
					{
						btnNewButton_1 = new JButton("Seleccionar foto");
						btnNewButton_1.addActionListener(new SeleccionarFoto());
						GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
						gbc_btnNewButton_1.gridx = 0;
						gbc_btnNewButton_1.gridy = 1;
						panel_foto.add(btnNewButton_1, gbc_btnNewButton_1);
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
						sp_edad.setModel(new SpinnerNumberModel(0, 0, 20, 1));
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
						cb_estado.setSelectedIndex(-1);
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
					btn_actualizar = new JButton("Actualizar información");
					btn_actualizar.addActionListener(new ActualizarPerrete());
					GridBagConstraints gbc_btn_actualizar = new GridBagConstraints();
					gbc_btn_actualizar.fill = GridBagConstraints.HORIZONTAL;
					gbc_btn_actualizar.insets = new Insets(0, 0, 5, 0);
					gbc_btn_actualizar.gridx = 1;
					gbc_btn_actualizar.gridy = 1;
					panel_datos.add(btn_actualizar, gbc_btn_actualizar);
				}
				{
					editorPane = new JEditorPane();
					editorPane.setBorder(new TitledBorder(null, "Comentarios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					GridBagConstraints gbc_editorPane = new GridBagConstraints();
					gbc_editorPane.gridwidth = 2;
					gbc_editorPane.fill = GridBagConstraints.BOTH;
					gbc_editorPane.gridx = 0;
					gbc_editorPane.gridy = 2;
					panel_datos.add(editorPane, gbc_editorPane);
				}
			}
			GridBagConstraints gbc_btn_anadir = new GridBagConstraints();
			gbc_btn_anadir.fill = GridBagConstraints.BOTH;
			gbc_btn_anadir.insets = new Insets(0, 0, 0, 5);
			gbc_btn_anadir.gridx = 0;
			gbc_btn_anadir.gridy = 1;
			add(btn_anadir, gbc_btn_anadir);
		}
	}

	private void guardarArchivoPerrete() {
		
		
	}
	public void cargarArchivoPerrete() {
		
	}

	private class AnadirPerrete implements ActionListener { //añadir perrete
		public void actionPerformed(ActionEvent arg0) {
			int indice = list.getModel().getSize();
			((DefaultListModel) list.getModel()).addElement("Nuevo perrete");
			list.setSelectedIndex(indice);
			list.ensureIndexIsVisible(indice);	
		}
	}
	
	private class BorrarPerrete implements ActionListener { //borrar perrete
		public void actionPerformed(ActionEvent e) {
			tf_nombre.setText("");
			sp_edad.setValue(0);
			tf_raza.setText("");
			cb_peligroso.setEnabled(false);
			cb_esterilizado.setEnabled(false);
			cb_estado.setSelectedIndex(-1);
		}
	}
	
	private class ActualizarPerrete implements ActionListener { //actualizar perrete
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	
	private class SeleccionarFoto implements ActionListener { //seleccionar foto
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
		
	
}
