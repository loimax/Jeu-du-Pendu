package td3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class TraitsParMots extends JPanel {
	
	public int nbError;
	public int flag;
	public TraitsParMots(int width, int height, int nbError) {
	this.setPreferredSize(new Dimension(width, height));
	this.setBackground(Color.WHITE);
	this.setOpaque(true);
	this.nbError = 0;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (this.nbError == 0) {
			g.drawLine(0, 0, 0, 0);
		}
		if (this.nbError == 1) {
			drawBase(g);
		}
		if (this.nbError == 2) {
			drawBase(g);
			drawPole(g);
		}
		if (this.nbError == 3) {
			drawBase(g);
			drawPole(g);
			drawBar(g);
		}
		if (this.nbError == 4) {
			drawBase(g);
			drawPole(g);
			drawBar(g);
			drawReliure(g);
		}
		if (this.nbError == 5) {
			drawBase(g);
			drawPole(g);
			drawBar(g);
			drawReliure(g);
			drawCorde(g);
		}
		if (this.nbError == 6) {
			drawBase(g);
			drawPole(g);
			drawBar(g);
			drawReliure(g);
			drawCorde(g);
			drawTete(g);
		}
		if (this.nbError == 7) {
			drawBase(g);
			drawPole(g);
			drawBar(g);
			drawReliure(g);
			drawCorde(g);
			drawTete(g);
			drawCorps(g);
		}
		if (this.nbError == 8) {
			drawBase(g);
			drawPole(g);
			drawBar(g);
			drawReliure(g);
			drawCorde(g);
			drawTete(g);
			drawCorps(g);
			drawBrasGauche(g);
		}
		if (this.nbError == 9) {
			drawBase(g);
			drawPole(g);
			drawBar(g);
			drawReliure(g);
			drawCorde(g);
			drawTete(g);
			drawCorps(g);
			drawBrasGauche(g);
			drawBrasDroit(g);
		}
		if (this.nbError == 10) {
			drawBase(g);
			drawPole(g);
			drawBar(g);
			drawReliure(g);
			drawCorde(g);
			drawTete(g);
			drawCorps(g);
			drawBrasGauche(g);
			drawBrasDroit(g);
			drawJambeGauche(g);
		}
		if (this.nbError == 11) {
			drawBase(g);
			drawPole(g);
			drawBar(g);
			drawReliure(g);
			drawCorde(g);
			drawTete(g);
			drawCorps(g);
			drawBrasGauche(g);
			drawBrasDroit(g);
			drawJambeGauche(g);
			drawJambeDroite(g);
		}
	}
	
	public void setNbError(int nbError) {
		this.nbError = nbError;
	}
	public void drawBase(Graphics g) {
		int w = this.getWidth();
		int h = this.getHeight();
		g.drawLine(10, h - 10, w/2, h - 10); //base
	}
	public void drawPole(Graphics g) {
		int w = this.getWidth();
		int h = this.getHeight();
		g.drawLine(w/4, h - 10, w/4, 10); // poteau
	}
	public void drawReliure(Graphics g) {
		int w = this.getWidth();
		int h = this.getHeight();
		g.drawLine(w/4, w/4, w/3, 10);
	}
	public void drawBar(Graphics g) {
		int w = this.getWidth();
		int h = this.getHeight();
		g.drawLine(w/4, 10, 3*w/4, 10); // barre
	}
	public void drawCorde(Graphics g) {
		int w = this.getWidth();
		int h = this.getHeight();
		g.drawLine(3*w/4, 10, 3*w/4, h/5); // reliure
	}
	public void drawTete(Graphics g) {
		int w = this.getWidth();
		int h = this.getHeight();
		g.drawOval(3*w/4 - 17, h/5, 35, 35); // tete
	}
	public void drawCorps(Graphics g) {
		int w = this.getWidth();
		int h = this.getHeight();
		g.drawLine(3*w/4, h/5+35, 3*w/4, h/5+120); // corps
	}
	public void drawBrasGauche(Graphics g) {
		int w = this.getWidth();
		int h = this.getHeight();
		g.drawLine(3*w/4, h/5+45, 3*w/4 - 40, h/5+65); // bras gauche
	}
	public void drawBrasDroit(Graphics g) {
		int w = this.getWidth();
		int h = this.getHeight();
		g.drawLine(3*w/4, h/5+45, 3*w/4 + 40, h/5+65); // bras droit
	}
	public void drawJambeGauche(Graphics g) {
		int w = this.getWidth();
		int h = this.getHeight();
		g.drawLine(3*w/4, h/5+120, 3*w/4 - 40, h/5+170); // jambe gauche
	}
	public void drawJambeDroite(Graphics g) {
		int w = this.getWidth();
		int h = this.getHeight();
		g.drawLine(3*w/4, h/5+120, 3*w/4 + 40, h/5+170); // jambe droite
	}
	public void drawPendu(Graphics g){
		drawBase(g);
		drawPole(g);
		drawReliure(g);
		drawBar(g);
		drawCorde(g);
		drawTete(g);
		drawCorps(g);
		drawBrasGauche(g);
		drawBrasDroit(g);
		drawJambeGauche(g);
		drawJambeDroite(g);
	}
}