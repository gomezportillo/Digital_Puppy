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
import javax.swing.border.TitledBorder;

@SuppressWarnings({"serial", "unused"})
public class PanelPerrera extends JPanel {

	private final int DEFAULT = 0;
	private final int PERRETE = 1;
	private final int RECTANGULO = 2;
	private final int TEXTO = 3;
	public int modo = DEFAULT;
	
	private JFrame frame;
	private JScrollPane pnl_mapa;
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
	private JPanel pnl_herramientas;
	public void setColorDibujado(Color c){
		this.colorDibujado = c;
	}
	/**
	 * Create the panel.
	 */
	public PanelPerrera(JFrame frame) {
		this.frame = frame;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {532, 114, 0};
		gridBagLayout.rowHeights = new int[] {75, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		{
			pnl_mapa = new JScrollPane();
			pnl_mapa.setViewportBorder(new TitledBorder(null, "Mapa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GridBagConstraints gbc_pnl_mapa = new GridBagConstraints();
			gbc_pnl_mapa.insets = new Insets(0, 0, 0, 5);
			gbc_pnl_mapa.fill = GridBagConstraints.BOTH;
			gbc_pnl_mapa.gridx = 0;
			gbc_pnl_mapa.gridy = 0;
			add(pnl_mapa, gbc_pnl_mapa);
			{
				areaDibujo = new AreaDibujo();
				areaDibujo.addMouseMotionListener(new AreaDibujoMouseMotionListener());
				areaDibujo.addMouseListener(new AreaDibujoMouseListener());
				areaDibujo.setHorizontalAlignment(SwingConstants.CENTER);
				areaDibujo.setIcon(new ImageIcon("data/mapa/perrera.png"));
				pnl_mapa.setViewportView(areaDibujo);
			}
		}
		{
		}
		{
			{
				pnl_herramientas = new JPanel();
				pnl_herramientas.setBorder(new TitledBorder(null, "Herramientas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				GridBagConstraints gbc_pnl_herramientas = new GridBagConstraints();
				gbc_pnl_herramientas.fill = GridBagConstraints.BOTH;
				gbc_pnl_herramientas.gridx = 1;
				gbc_pnl_herramientas.gridy = 0;
				add(pnl_herramientas, gbc_pnl_herramientas);
				GridBagLayout gbl_pnl_herramientas = new GridBagLayout();
				gbl_pnl_herramientas.columnWidths = new int[] {};
				gbl_pnl_herramientas.rowHeights = new int[] {40, 40, 40, 40};
				gbl_pnl_herramientas.columnWeights = new double[]{0.0};
				gbl_pnl_herramientas.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0};
				pnl_herramientas.setLayout(gbl_pnl_herramientas);
				{
					btnPerrete = new JButton("Añadir perrete");
					GridBagConstraints gbc_btnPerrete = new GridBagConstraints();
					gbc_btnPerrete.fill = GridBagConstraints.BOTH;
					gbc_btnPerrete.insets = new Insets(0, 0, 5, 0);
					gbc_btnPerrete.gridx = 0;
					gbc_btnPerrete.gridy = 0;
					pnl_herramientas.add(btnPerrete, gbc_btnPerrete);
					btnPerrete.addActionListener(new AnadirPerrete());
					btnPerrete.setIcon(new ImageIcon("data/mapa/botones/perrete.png"));
					btnPerrete.setVerticalTextPosition(SwingConstants.BOTTOM);
					btnPerrete.setHorizontalTextPosition(SwingConstants.CENTER);
					btnPerrete.setHorizontalTextPosition(JButton.CENTER);
				}
				bntRectangulo = new JButton("Añadir rectangulo");
				GridBagConstraints gbc_bntRectangulo = new GridBagConstraints();
				gbc_bntRectangulo.fill = GridBagConstraints.BOTH;
				gbc_bntRectangulo.insets = new Insets(0, 0, 5, 0);
				gbc_bntRectangulo.gridx = 0;
				gbc_bntRectangulo.gridy = 1;
				pnl_herramientas.add(bntRectangulo, gbc_bntRectangulo);
				bntRectangulo.addActionListener(new AnadirRectangulo());
				bntRectangulo.setIcon(new ImageIcon("data/mapa/botones/rectangulo.png"));
				bntRectangulo.setVerticalTextPosition(SwingConstants.BOTTOM);
				bntRectangulo.setHorizontalTextPosition(SwingConstants.CENTER);
				bntRectangulo.setHorizontalTextPosition(JButton.CENTER);
				{
					btnTexto = new JButton("Añadir texto");
					GridBagConstraints gbc_btnTexto = new GridBagConstraints();
					gbc_btnTexto.fill = GridBagConstraints.BOTH;
					gbc_btnTexto.insets = new Insets(0, 0, 5, 0);
					gbc_btnTexto.gridx = 0;
					gbc_btnTexto.gridy = 2;
					pnl_herramientas.add(btnTexto, gbc_btnTexto);
					btnTexto.addActionListener(new AndirTexto());
					btnTexto.setIcon(new ImageIcon("data/mapa/botones/texto.png"));
					btnTexto.setVerticalTextPosition(SwingConstants.BOTTOM);
					btnTexto.setHorizontalTextPosition(SwingConstants.CENTER);
					btnTexto.setHorizontalTextPosition(JButton.CENTER);
				}
				btnBorrar = new JButton("Borrar todo");
				GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
				gbc_btnBorrar.fill = GridBagConstraints.BOTH;
				gbc_btnBorrar.gridx = 0;
				gbc_btnBorrar.gridy = 3;
				pnl_herramientas.add(btnBorrar, gbc_btnBorrar);
				btnBorrar.addActionListener(new BorrarImagenes());
				btnBorrar.setIcon(new ImageIcon("data/mapa/botones/borrar.png"));
				btnBorrar.setVerticalTextPosition(SwingConstants.BOTTOM);
				btnBorrar.setHorizontalTextPosition(SwingConstants.CENTER);
				btnBorrar.setHorizontalTextPosition(JButton.CENTER);
			}
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
