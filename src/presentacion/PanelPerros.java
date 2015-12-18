package presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.JEditorPane;
import javax.swing.JSeparator;
import java.awt.Dimension;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PanelPerros extends JPanel {
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JPanel panel_datos;
	private JScrollPane scrollPane_tabla;
	private JEditorPane editorPane;
	private JButton btnBorrar;
	private JButton btnActualizar;
	private JPanel panel_foto;
	private JPanel panel_info;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane_1;
	private JLabel lblFotoperro;
	private JLabel lblNombre;
	private JLabel lblNewLabel;
	private JLabel lblRaza;
	private JLabel lblPeligroso;
	private JLabel lblNewLabel_1;
	private JLabel lblEstado;
	private JTable table;
	private JTextField tf_nombre;
	private JSpinner spinner;
	private JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	public PanelPerros() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{147, 150, 0};
		gridBagLayout.rowHeights = new int[]{331, 32, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		{
			btnNewButton = new JButton("Añadir perrete");
			btnNewButton.addActionListener(new BtnNewButtonActionListener());
			{
				{

				}
			}
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
					table = new JTable();
					scrollPane_tabla.setViewportView(table);
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
				gbl_panel_datos.rowHeights = new int[] {252, 4, 104};
				gbl_panel_datos.columnWeights = new double[]{0.0, 1.0};
				gbl_panel_datos.rowWeights = new double[]{1.0, 0.0, 1.0};
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
							lblFotoperro = new JLabel("FotoPerro");
							scrollPane_1.setViewportView(lblFotoperro);
						}
					}
					{
						btnNewButton_1 = new JButton("Seleccionar foto");
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
						spinner = new JSpinner();
						GridBagConstraints gbc_spinner = new GridBagConstraints();
						gbc_spinner.fill = GridBagConstraints.BOTH;
						gbc_spinner.insets = new Insets(0, 0, 5, 0);
						gbc_spinner.gridx = 1;
						gbc_spinner.gridy = 1;
						panel_info.add(spinner, gbc_spinner);
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
						lblPeligroso = new JLabel("Peligroso");
						GridBagConstraints gbc_lblPeligroso = new GridBagConstraints();
						gbc_lblPeligroso.anchor = GridBagConstraints.WEST;
						gbc_lblPeligroso.insets = new Insets(0, 0, 5, 5);
						gbc_lblPeligroso.gridx = 0;
						gbc_lblPeligroso.gridy = 3;
						panel_info.add(lblPeligroso, gbc_lblPeligroso);
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
						lblEstado = new JLabel("Estado");
						GridBagConstraints gbc_lblEstado = new GridBagConstraints();
						gbc_lblEstado.anchor = GridBagConstraints.WEST;
						gbc_lblEstado.insets = new Insets(0, 0, 0, 5);
						gbc_lblEstado.gridx = 0;
						gbc_lblEstado.gridy = 5;
						panel_info.add(lblEstado, gbc_lblEstado);
					}
					{
						comboBox = new JComboBox();
						comboBox.setModel(new DefaultComboBoxModel(new String[] {"Adoptado", "Reservado", "En celo", "Fallecido"}));
						GridBagConstraints gbc_comboBox = new GridBagConstraints();
						gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
						gbc_comboBox.gridx = 1;
						gbc_comboBox.gridy = 5;
						panel_info.add(comboBox, gbc_comboBox);
					}
				}
				{
					btnBorrar = new JButton("Borrar");
					GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
					gbc_btnBorrar.fill = GridBagConstraints.HORIZONTAL;
					gbc_btnBorrar.insets = new Insets(0, 0, 5, 5);
					gbc_btnBorrar.gridx = 0;
					gbc_btnBorrar.gridy = 1;
					panel_datos.add(btnBorrar, gbc_btnBorrar);
				}
				{
					btnActualizar = new JButton("Actualizar");
					GridBagConstraints gbc_btnActualizar = new GridBagConstraints();
					gbc_btnActualizar.fill = GridBagConstraints.HORIZONTAL;
					gbc_btnActualizar.insets = new Insets(0, 0, 5, 0);
					gbc_btnActualizar.gridx = 1;
					gbc_btnActualizar.gridy = 1;
					panel_datos.add(btnActualizar, gbc_btnActualizar);
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
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.fill = GridBagConstraints.BOTH;
			gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
			gbc_btnNewButton.gridx = 0;
			gbc_btnNewButton.gridy = 1;
			add(btnNewButton, gbc_btnNewButton);
		}

	}

	private class BtnNewButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
		}
	}
}
