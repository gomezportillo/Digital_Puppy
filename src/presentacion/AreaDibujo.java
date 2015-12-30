package presentacion;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class AreaDibujo extends JLabel{

	public ArrayList<ObjetoGrafico> objetosGraficos = new ArrayList<ObjetoGrafico>();
	
	private int tamFuente = 20;
	public void setTamFuente(int t){
		this.tamFuente = t;
	}
	private String fuente = "TimesRoman";
	public void setFuente(String s){
		
		this.fuente = s;
	}
	public AreaDibujo(){ 
	}

	void addObjetoGrafico(ObjetoGrafico objg) {
		objetosGraficos.add(objg);
	}

	public ObjetoGrafico getUltimoObjetoGrafico(){
		return objetosGraficos.get(objetosGraficos.size()-1);
	}

	public void paint(Graphics g){
		super.paint(g);

		for (int i = 0; i < objetosGraficos.size(); i++) {
			ObjetoGrafico objg = objetosGraficos.get(i);
			if (objg instanceof ImagenGrafico) {
				g.drawImage(((ImagenGrafico)objg).getImagen(), objg.getX(), objg.getY(), null);
			}

			else if (objg instanceof RectanguloGrafico) {
				g.setColor(((RectanguloGrafico)objg).getColor());
				int w = ((RectanguloGrafico)objg).getX1() - objg.getX();
				int h = ((RectanguloGrafico)objg).getY1() - objg.getY();
				g.drawRect(objg.getX(),objg.getY(),w,h);
			}
			else {  //Es un objeto de tipo TextoGrafico a la fuerza
				g.setColor(((TextoGrafico)objg).getColor());      
				g.setFont(new Font(fuente, Font.PLAIN, tamFuente)); 
				g.drawString(((TextoGrafico)objg).getTexto(),objg.getX(),objg.getY()); 
			}
		}
	}
}