import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;

public class ItemIcon implements Icon {
	private final static int DEFAULT_THICKNESS = 5;
	private final static int DEFAULT_DIAMETER = 50;
	
	private int w = DEFAULT_DIAMETER;
	private int h = DEFAULT_DIAMETER;
	
	private int thick = DEFAULT_THICKNESS;
	private int borderThick = DEFAULT_THICKNESS;
	
	private int valA;
	private int valB;
	
	public ItemIcon(int valA, int valB) {
		this.valA = valA;
		this.valB = valB;
	}
	
	public ItemIcon(int valA, int valB, int dia) {
		this(valA, valB);
		setDiameter(dia);
	}
	
	public ItemIcon(ListItem listI) {
		this.valA = listI.getValA();
		this.valB = listI.getValB();
	}
	
	public ItemIcon(ListItem listI, int dia) {
		this(listI);
		setDiameter(dia);
	}
	
	public void setDiameter(int dia) {
		w = dia;
		h = dia;
	}
	
	public int getIconHeight() {
		return h + 2 * DEFAULT_THICKNESS;
	}
	
	public int getIconWidth() {
		return w + 2 * DEFAULT_THICKNESS;
	}
	
	public void paintIcon (Component c, Graphics g, int x, int y) {
		Graphics2D g0 = (Graphics2D) g;
		
		g0.setPaint(Color.gray);
		Stroke s = new BasicStroke(thick);
		g0.setStroke(s);
		
		Ellipse2D ellipse = new Ellipse2D.Float(x + borderThick, y + borderThick, h, w);
		g0.draw(ellipse);
		g0.setPaint(Color.white);
		g0.fill(ellipse);
		g0.setPaint(Color.black);
		
		Font f = new Font("Times", Font.BOLD, 18);
		FontMetrics fontM = g.getFontMetrics(f);
		String str = ((Integer) valA).toString() + " " + ((Integer) valB).toString();
		Rectangle2D rectangle = fontM.getStringBounds(str, g0);

		int textH = (int) rectangle.getHeight();
		int textW = (int) rectangle.getWidth();
		int panelH = getIconHeight();
		int panelW = getIconWidth();

		int offX = (panelW - textW) / 2;
		int offY = (panelH - textH) / 2 + fontM.getAscent();

		g0.setFont(f);
		g0.drawString(str, x + offX, y + offY);	}


}