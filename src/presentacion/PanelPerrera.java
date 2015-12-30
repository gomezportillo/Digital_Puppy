package presentacion;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

@SuppressWarnings({"serial", "unused"})
public class PanelPerrera extends JPanel {

	private final int DEFAULT = 0;
	private final int PERRETE = 1;
	private final int RECTANGULO = 2;
	private final int TEXTO = 3;
	public int modo = DEFAULT;
	
	private JFrame frame;
	private JScrollPane scrollPane;
	private JSeparator separator;
	private JButton btnPerrete;
	private AreaDibujo areaDibujo;
	public AreaDibujo getAreaDibujo() {
		return areaDibujo;
	}

	private JButton btnBorrar;
	private JButton bntRectangulo;
	private JButton btnTexto;

	private Toolkit toolkit;

	private Image imgPerrete;
	private Image imgRectangulo;
	private Image imagTexto;

	private Cursor cursorPerrete;
	private Cursor cursorRectangulo;
	private Cursor cursorTexto;

	private int x, y;
	private JTextField txtTexto = new JTextField(); //transp 29
	private Color colorDibujado = Color.BLUE;
	public void setColorDibujado(Color c){
		this.colorDibujado = c;
	}
	/**
	 * Create the panel.
	 */
	public PanelPerrera(JFrame frame) {
		this.frame = frame;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {532, 0, 114, 0};
		gridBagLayout.rowHeights = new int[] {75, 75, 75, 75, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		{
			scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.gridheight = 4;
			gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 0;
			add(scrollPane, gbc_scrollPane);
			{
				areaDibujo = new AreaDibujo();
				areaDibujo.addMouseMotionListener(new AreaDibujoMouseMotionListener());
				areaDibujo.addMouseListener(new AreaDibujoMouseListener());
				areaDibujo.setHorizontalAlignment(SwingConstants.CENTER);
				areaDibujo.setIcon(new ImageIcon("data/mapa/perrera.png"));
				scrollPane.setViewportView(areaDibujo);
			}
		}
		{
			separator = new JSeparator();
			GridBagConstraints gbc_separator = new GridBagConstraints();
			gbc_separator.insets = new Insets(0, 0, 5, 5);
			gbc_separator.gridx = 1;
			gbc_separator.gridy = 0;
			add(separator, gbc_separator);
		}
		{
			btnPerrete = new JButton("Añadir perrete");
			btnPerrete.addActionListener(new AnadirPerrete());
			btnPerrete.setIcon(new ImageIcon("data/mapa/botones/perrete.png"));
			btnPerrete.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnPerrete.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPerrete.setHorizontalTextPosition(JButton.CENTER);

			GridBagConstraints gbc_btnPerrete = new GridBagConstraints();
			gbc_btnPerrete.fill = GridBagConstraints.BOTH;
			gbc_btnPerrete.insets = new Insets(0, 0, 5, 0);
			gbc_btnPerrete.gridx = 2;
			gbc_btnPerrete.gridy = 0;
			add(btnPerrete, gbc_btnPerrete);
		}
		{
			bntRectangulo = new JButton("Añadir rectangulo");
			bntRectangulo.addActionListener(new AnadirRectangulo());
			bntRectangulo.setIcon(new ImageIcon("data/mapa/botones/rectangulo.png"));
			bntRectangulo.setVerticalTextPosition(SwingConstants.BOTTOM);
			bntRectangulo.setHorizontalTextPosition(SwingConstants.CENTER);
			bntRectangulo.setHorizontalTextPosition(JButton.CENTER);

			GridBagConstraints gbc_bntRectangulo = new GridBagConstraints();
			gbc_bntRectangulo.fill = GridBagConstraints.BOTH;
			gbc_bntRectangulo.insets = new Insets(0, 0, 5, 0);
			gbc_bntRectangulo.gridx = 2;
			gbc_bntRectangulo.gridy = 1;
			add(bntRectangulo, gbc_bntRectangulo);
		}
		{
			btnTexto = new JButton("Añadir texto");
			btnTexto.addActionListener(new AndirTexto());
			btnTexto.setIcon(new ImageIcon("data/mapa/botones/texto.png"));
			btnTexto.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnTexto.setHorizontalTextPosition(SwingConstants.CENTER);
			btnTexto.setHorizontalTextPosition(JButton.CENTER);

			GridBagConstraints gbc_btnTexto = new GridBagConstraints();
			gbc_btnTexto.fill = GridBagConstraints.BOTH;
			gbc_btnTexto.insets = new Insets(0, 0, 5, 0);
			gbc_btnTexto.gridx = 2;
			gbc_btnTexto.gridy = 2;
			add(btnTexto, gbc_btnTexto);
		}
		{
			btnBorrar = new JButton("Borrar todo");
			btnBorrar.addActionListener(new BorrarImagenes());
			btnBorrar.setIcon(new ImageIcon("data/mapa/botones/borrar.png"));
			btnBorrar.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnBorrar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnBorrar.setHorizontalTextPosition(JButton.CENTER);

			GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
			gbc_btnBorrar.fill = GridBagConstraints.BOTH;
			gbc_btnBorrar.gridx = 2;
			gbc_btnBorrar.gridy = 3;
			add(btnBorrar, gbc_btnBorrar);
		}
		{
			toolkit = Toolkit.getDefaultToolkit();

			imgPerrete = toolkit.getImage("data/mapa/botones/perrete.png");
			imgRectangulo = toolkit.getImage("data/mapa/botones/Rectangulo.png");
			imagTexto = toolkit.getImage("data/mapa/botones/Texto.png");

			cursorPerrete = toolkit.createCustomCursor(imgPerrete, new Point(0,0),"CURSOR_PERRETE");
			cursorRectangulo = toolkit.createCustomCursor(imgRectangulo, new Point(0,0),"CURSOR_RECTANGULO");
			cursorTexto= toolkit.createCustomCursor(imagTexto, new Point(0,0),"CURSOR_TEXTO");



		}

	}


	private class AnadirPerrete implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			modo = PERRETE;
			frame.setCursor(cursorPerrete);
		}
	}
	private class AnadirRectangulo implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = RECTANGULO;
			frame.setCursor(cursorRectangulo);
		}
	}
	private class AndirTexto implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = TEXTO;
			frame.setCursor(cursorTexto);
		}
	}

	private class BorrarImagenes implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = DEFAULT;
			frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			areaDibujo.objetosGraficos = new ArrayList<ObjetoGrafico>();
			areaDibujo.repaint();
		}
	}
	
	/**
	 * Listener para cuando clickamos sobre el are de dibujo
	 */
	private class AreaDibujoMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			System.out.println(modo);
			x = e.getX();
			y = e.getY();

			switch (modo) {
			case PERRETE:
				areaDibujo.addObjetoGrafico(new ImagenGrafico(x,y,imgPerrete));
				areaDibujo.repaint();
				break;

			case RECTANGULO:
				areaDibujo.addObjetoGrafico(new RectanguloGrafico(x,y,x,y, colorDibujado));
				break;

			case TEXTO:
				txtTexto.setBounds(x, y, 200,30);
				txtTexto.setVisible(true);
				txtTexto.requestFocus();
				txtTexto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg) {

						if(!txtTexto.getText().equals("")) {
							areaDibujo.addObjetoGrafico(new TextoGrafico(x, y+15, txtTexto.getText(), colorDibujado));
						}
						txtTexto.setText("");
						txtTexto.setVisible(false);
						areaDibujo.repaint();
					}
				});
				areaDibujo.add(txtTexto);
				break;
			}
		}
	}

	/**
	 * Listener para cuando clickamos y arrastramos en el are de dibujo
	 */

	private class AreaDibujoMouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseDragged(MouseEvent e) {
			if (modo == RECTANGULO) {
				((RectanguloGrafico)areaDibujo.getUltimoObjetoGrafico()).setX1(e.getX());
				((RectanguloGrafico)areaDibujo.getUltimoObjetoGrafico()).setY1(e.getY());
				areaDibujo.repaint();
			}
		}
	}
}
