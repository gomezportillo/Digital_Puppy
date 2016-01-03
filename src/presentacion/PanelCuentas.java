package presentacion;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings({ "unused" })
public class PanelCuentas extends JPanel {
	private static final long serialVersionUID = -7518504297885688690L;
	private static final String nombreArchivoCuentas = "data/cuentas/cuentas.csv";
	private JFrame frame;
	private JPanel panel_datos;
	private JScrollPane scrollPane_tabla;
	private VentanaPrincipal ventanaPrincipal;
	private JTable table;
	private JPanel pnl_anadir;
	private JPanel pnl_borrar;
	private JPanel pnl_balance;
	private JButton btn_borrar;
	private JLabel lbl_balance;
	private JLabel lblRazn;
	private JButton btn_anadir;
	private JTextField tf_razon;
	private ModeloTablaCuentas modeloTabla;
	private JLabel label_cantidad;
	private JTextField tf_cantidad;
	private JPanel pnl_guardar;
	private JButton btn_guardar;
	private int filaSeleccionada = -1; 


	public PanelCuentas(JFrame frame, VentanaPrincipal ventanaPrincipal) {
		this.frame = frame;
		this.ventanaPrincipal = ventanaPrincipal;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{294, 150, 0};
		gridBagLayout.rowHeights = new int[]{331, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		{
			{
				scrollPane_tabla = new JScrollPane();
				scrollPane_tabla.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Hist\u00F3rico", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				GridBagConstraints gbc_scrollPane_tabla = new GridBagConstraints();
				gbc_scrollPane_tabla.insets = new Insets(0, 0, 0, 5);
				gbc_scrollPane_tabla.fill = GridBagConstraints.BOTH;
				gbc_scrollPane_tabla.gridx = 0;
				gbc_scrollPane_tabla.gridy = 0;
				add(scrollPane_tabla, gbc_scrollPane_tabla);
				{
					table = new JTable();
					table.setVerifyInputWhenFocusTarget(false);
					table.setUpdateSelectionOnSort(false);
					table.setFocusTraversalKeysEnabled(false);
					table.setRowHeight(20);
					table.setRowMargin(20);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.setName("");
					table.setMinimumSize(new Dimension(5, 5));
					table.setIntercellSpacing(new Dimension(0, 0));
					table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
					/**table.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
									"Razón", "Cantidad", "Fecha"
							}
							) {
						Class[] columnTypes = new Class[] {
								String.class, String.class, String.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});*/
					/**modeloTabla = new ModeloTablaCuentas(); //*****IMPORTANTE**** */
					modeloTabla = new ModeloTablaCuentas();
					table.setModel(modeloTabla);

					ListSelectionModel rowSM =  table.getSelectionModel();
					rowSM.addListSelectionListener(new ListSelectionListener() {
						public void valueChanged(ListSelectionEvent e) {
							ListSelectionModel lsm = (ListSelectionModel) e.getSource();
							if (!lsm.isSelectionEmpty()) {
								filaSeleccionada = lsm.getMinSelectionIndex();
								//String [] fila = modeloTabla.getRow(filaSeleccionada);
								//tf_razon.setText(fila[0]);
								//tf_cantidad.setText(fila[1]);
							}
						}
					});

					scrollPane_tabla.setViewportView(table);	
				}

				{
					panel_datos = new JPanel();
					panel_datos.setMaximumSize(new Dimension(1000, 1000));
					panel_datos.setMinimumSize(new Dimension(200, 200));
					panel_datos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Gestionar dinero", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					GridBagConstraints gbc_panel_datos = new GridBagConstraints();
					gbc_panel_datos.fill = GridBagConstraints.BOTH;
					gbc_panel_datos.gridx = 1;
					gbc_panel_datos.gridy = 0;
					add(panel_datos, gbc_panel_datos);
					GridBagLayout gbl_panel_datos = new GridBagLayout();
					gbl_panel_datos.columnWidths = new int[] {186};
					gbl_panel_datos.rowHeights = new int[] {129, 47, 0, 54};
					gbl_panel_datos.columnWeights = new double[]{1.0};
					gbl_panel_datos.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0};
					panel_datos.setLayout(gbl_panel_datos);
					{
						pnl_anadir = new JPanel();
						pnl_anadir.setBorder(new TitledBorder(null, "A\u00F1adir ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
						GridBagConstraints gbc_pnl_anadir = new GridBagConstraints();
						gbc_pnl_anadir.insets = new Insets(0, 0, 5, 0);
						gbc_pnl_anadir.fill = GridBagConstraints.BOTH;
						gbc_pnl_anadir.gridx = 0;
						gbc_pnl_anadir.gridy = 0;
						panel_datos.add(pnl_anadir, gbc_pnl_anadir);
						GridBagLayout gbl_pnl_anadir = new GridBagLayout();
						gbl_pnl_anadir.columnWidths = new int[]{77, 0, 0};
						gbl_pnl_anadir.rowHeights = new int[]{0, 0, 0, 0, 0};
						gbl_pnl_anadir.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
						gbl_pnl_anadir.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
						pnl_anadir.setLayout(gbl_pnl_anadir);
						{
							lblRazn = new JLabel("Razón");
							GridBagConstraints gbc_lblRazn = new GridBagConstraints();
							gbc_lblRazn.anchor = GridBagConstraints.EAST;
							gbc_lblRazn.insets = new Insets(0, 0, 5, 5);
							gbc_lblRazn.gridx = 0;
							gbc_lblRazn.gridy = 0;
							pnl_anadir.add(lblRazn, gbc_lblRazn);
						}
						{
							tf_razon = new JTextField();
							GridBagConstraints gbc_tf_razon = new GridBagConstraints();
							gbc_tf_razon.insets = new Insets(0, 0, 5, 0);
							gbc_tf_razon.fill = GridBagConstraints.HORIZONTAL;
							gbc_tf_razon.gridx = 1;
							gbc_tf_razon.gridy = 0;
							pnl_anadir.add(tf_razon, gbc_tf_razon);
							tf_razon.setColumns(10);
						}
						{
							label_cantidad = new JLabel("Cantidad");
							GridBagConstraints gbc_label_cantidad = new GridBagConstraints();
							gbc_label_cantidad.anchor = GridBagConstraints.EAST;
							gbc_label_cantidad.insets = new Insets(0, 0, 5, 5);
							gbc_label_cantidad.gridx = 0;
							gbc_label_cantidad.gridy = 1;
							pnl_anadir.add(label_cantidad, gbc_label_cantidad);
						}
						{
							tf_cantidad = new JTextField();
							tf_cantidad.setColumns(10);
							GridBagConstraints gbc_tf_cantidad = new GridBagConstraints();
							gbc_tf_cantidad.anchor = GridBagConstraints.NORTH;
							gbc_tf_cantidad.insets = new Insets(0, 0, 5, 0);
							gbc_tf_cantidad.fill = GridBagConstraints.HORIZONTAL;
							gbc_tf_cantidad.gridx = 1;
							gbc_tf_cantidad.gridy = 1;
							pnl_anadir.add(tf_cantidad, gbc_tf_cantidad);
						}
						{
							btn_anadir = new JButton("Añadir entrada");
							btn_anadir.addActionListener(new AnadirEntradaListener());
							GridBagConstraints gbc_btn_anadir = new GridBagConstraints();
							gbc_btn_anadir.anchor = GridBagConstraints.SOUTH;
							gbc_btn_anadir.fill = GridBagConstraints.HORIZONTAL;
							gbc_btn_anadir.gridwidth = 2;
							gbc_btn_anadir.gridx = 0;
							gbc_btn_anadir.gridy = 3;
							pnl_anadir.add(btn_anadir, gbc_btn_anadir);
						}
					}
					{
						pnl_borrar = new JPanel();
						pnl_borrar.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Borrar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
						GridBagConstraints gbc_pnl_borrar = new GridBagConstraints();
						gbc_pnl_borrar.insets = new Insets(0, 0, 5, 0);
						gbc_pnl_borrar.fill = GridBagConstraints.BOTH;
						gbc_pnl_borrar.gridx = 0;
						gbc_pnl_borrar.gridy = 1;
						panel_datos.add(pnl_borrar, gbc_pnl_borrar);
						GridBagLayout gbl_pnl_borrar = new GridBagLayout();
						gbl_pnl_borrar.columnWidths = new int[] {0};
						gbl_pnl_borrar.rowHeights = new int[] {0};
						gbl_pnl_borrar.columnWeights = new double[]{1.0};
						gbl_pnl_borrar.rowWeights = new double[]{1.0};
						pnl_borrar.setLayout(gbl_pnl_borrar);
						{
							btn_borrar = new JButton("Borrar entrada");
							btn_borrar.addActionListener(new BorrarEntradaListener());
							GridBagConstraints gbc_btn_borrar = new GridBagConstraints();
							gbc_btn_borrar.fill = GridBagConstraints.HORIZONTAL;
							gbc_btn_borrar.gridx = 0;
							gbc_btn_borrar.gridy = 0;
							pnl_borrar.add(btn_borrar, gbc_btn_borrar);
						}
					}
					{
						pnl_guardar = new JPanel();
						pnl_guardar.setBorder(new TitledBorder(null, "Guardar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
						GridBagConstraints gbc_pnl_guardar = new GridBagConstraints();
						gbc_pnl_guardar.insets = new Insets(0, 0, 5, 0);
						gbc_pnl_guardar.fill = GridBagConstraints.BOTH;
						gbc_pnl_guardar.gridx = 0;
						gbc_pnl_guardar.gridy = 2;
						panel_datos.add(pnl_guardar, gbc_pnl_guardar);
						GridBagLayout gbl_pnl_guardar = new GridBagLayout();
						gbl_pnl_guardar.columnWidths = new int[]{0, 0};
						gbl_pnl_guardar.rowHeights = new int[]{0, 0};
						gbl_pnl_guardar.columnWeights = new double[]{1.0, Double.MIN_VALUE};
						gbl_pnl_guardar.rowWeights = new double[]{1.0, Double.MIN_VALUE};
						pnl_guardar.setLayout(gbl_pnl_guardar);
						{
							btn_guardar = new JButton("Guardar cambios");
							btn_guardar.addActionListener(new GuardarCambiosListener());
							GridBagConstraints gbc_btn_guardar = new GridBagConstraints();
							gbc_btn_guardar.fill = GridBagConstraints.HORIZONTAL;
							gbc_btn_guardar.gridx = 0;
							gbc_btn_guardar.gridy = 0;
							pnl_guardar.add(btn_guardar, gbc_btn_guardar);
						}
					}
					{
						pnl_balance = new JPanel();
						pnl_balance.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Balance actual", TitledBorder.LEADING, TitledBorder.TOP, null, null));
						GridBagConstraints gbc_pnl_balance = new GridBagConstraints();
						gbc_pnl_balance.fill = GridBagConstraints.BOTH;
						gbc_pnl_balance.gridx = 0;
						gbc_pnl_balance.gridy = 3;
						panel_datos.add(pnl_balance, gbc_pnl_balance);
						GridBagLayout gbl_pnl_balance = new GridBagLayout();
						gbl_pnl_balance.columnWidths = new int[]{0, 0};
						gbl_pnl_balance.rowHeights = new int[]{0, 0};
						gbl_pnl_balance.columnWeights = new double[]{1.0, Double.MIN_VALUE};
						gbl_pnl_balance.rowWeights = new double[]{1.0, Double.MIN_VALUE};
						pnl_balance.setLayout(gbl_pnl_balance);
						{
							lbl_balance = new JLabel("");
							lbl_balance.setHorizontalAlignment(SwingConstants.CENTER);
							lbl_balance.setFont(new Font("Tahoma", Font.PLAIN, 50));
							GridBagConstraints gbc_lbl_balance = new GridBagConstraints();
							gbc_lbl_balance.gridx = 0;
							gbc_lbl_balance.gridy = 0;
							pnl_balance.add(lbl_balance, gbc_lbl_balance);
						}
					}
				}
			}
		}
		cargarDatosFinancieros();
	}

	public void cargarDatosFinancieros() {
		File file = new File(this.nombreArchivoCuentas);
		try{
			FileReader fr = new FileReader (file.getAbsolutePath());
			BufferedReader br = new BufferedReader(fr);
			double cantidadTotal = 0;
			String line = null, razon, cantidad, fecha;
			while((line = br.readLine()) != null) {
				String[] dato = line.split(";");
				razon = dato[0];
				cantidad = dato[1].replace(",", ".");
				fecha = dato[2];
				String[] fila = {razon, cantidad, fecha};
				modeloTabla.aniadeFila(fila);

				cantidadTotal+=Double.parseDouble(cantidad);
			}

			lbl_balance.setText(String.valueOf(cantidadTotal) + " €");
			ventanaPrincipal.lblInfo.setText("Cargado "+ file.getAbsolutePath());

		}catch(NumberFormatException e1){
			System.out.println(e1.toString());
		}catch(Exception e2){
			System.out.println(e2.toString());
		}
	}

	private class AnadirEntradaListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String razon = tf_razon.getText();
			String cantidad = tf_cantidad.getText().replace(",", ".");

			if (razon.length() >= 1 && cantidad.length() >= 1){

				String[] mydate = (java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime())).split(" ");
				String fecha = mydate[0];

				String[] fila = {razon, cantidad, fecha};
				modeloTabla.aniadeFila(fila);

				double cantidadTotal = Double.parseDouble((lbl_balance.getText().split(" ")[0])); 
				try{
					cantidadTotal+=Double.parseDouble(cantidad);
				}catch(NumberFormatException e1){
					JOptionPane.showMessageDialog(frame, "Por favor introduzca una cantidad válida", "Error", JOptionPane.WARNING_MESSAGE);
					return;
				}

				lbl_balance.setText(String.valueOf(cantidadTotal) + " €");
				modeloTabla.fireTableDataChanged();
				tf_razon.setText(null);
				tf_cantidad.setText(null);
			}else {
				JOptionPane.showMessageDialog(frame, "Por favor rellene ambos campos", "Error", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	private class BorrarEntradaListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (filaSeleccionada < 0) {
				JOptionPane.showMessageDialog(frame, "Por favor seleccione alguna fila", "Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			String fila = modeloTabla.getRowtoString(filaSeleccionada);

			String mensaje = "¿Seguro que quiere eliminar la entrada \""+fila+"\"?";
			int reply = JOptionPane.showConfirmDialog(frame, mensaje, "Eliminar", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				modeloTabla.eliminaFila(filaSeleccionada);
				modeloTabla.fireTableDataChanged();
			}

		}
	}
	private class GuardarCambiosListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int reply = JOptionPane.showConfirmDialog(frame, "¿Seguro que quiere guardar?", "Guardar", JOptionPane.YES_NO_OPTION);

			if (reply == JOptionPane.YES_OPTION) {
				File file = new File(nombreArchivoCuentas);
				try {
					String stringToSave = modeloTabla.getTableToCSV();
					FileWriter fw = new FileWriter (file, false);
					fw.write(stringToSave);
					fw.close();
					ventanaPrincipal.lblInfo.setText("Guardado "+ file.getAbsolutePath());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "Error guardando el archivo. Reinicie el programa y vuelva a intentarlo", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}

