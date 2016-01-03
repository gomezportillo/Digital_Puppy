package presentacion;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings({ "rawtypes", "serial" })
class ModeloTablaCuentas extends AbstractTableModel
{
	private String [] nombreColumnas= { "Razón", "Cantidad (€)", "Fecha (d/M/A)"};


	private Vector<String[]> datos = new Vector<String[]>();

	public int getColumnCount(){
		return nombreColumnas.length;
	}
	public int getRowCount(){
		return datos.size ();
	}

	public String getColumnName(int col) {
		return nombreColumnas[col];}

	public Object getValueAt(int row, int col) {
		Object [] fila = (Object[])datos.elementAt(row);
		return fila[col];
	}
	public String[] getRow(int row) {
		String [] fila = (String[])datos.elementAt(row);
		return fila;
	}

	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	public boolean isCellEditable (int row, int col) {
		return false;
	}
	public void setValueAt(Object value, int row, int col) {
		if (row < getRowCount () && col < getColumnCount()){
			Object[] fila = (Object[])datos.elementAt(row);
			fila[col] = value;
			fireTableCellUpdated(row, col);
		}
	}

	public void eliminaFila(int row){ 
		datos.remove(row);
	}
	public void aniadeFila(String[] row){ 
		datos.add (row);
	}
	public String getRowtoString(int row) {
		String [] fila = this.getRow(row);

		return fila[0] + " / " + fila[1] +"€ / " + fila[2];		
	}

	/**
	 * El formato CSV (comma sepparated values) es texto plano que separa
	 * datos por separadores, en este caso punto y coma (;). 
	 * @return
	 */
	public String getTableToCSV(){
		String resultado = "";
		char separador = ';';
		for (String[] fila : datos) resultado+=fila[0]+separador+fila[1]+separador+fila[2]+"\r\n";
		return resultado;
	}
}