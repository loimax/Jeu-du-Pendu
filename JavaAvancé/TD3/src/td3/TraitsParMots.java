package td3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class TraitsParMots extends JPanel {
  public int nbError = 0;

  public TraitsParMots(int nbError, int width, int height) {
    this.setPreferredSize(new Dimension(width, height));
    this.setBackground(Color.WHITE);
    this.setOpaque(true);
    this.nbError = nbError;
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    paintPendu(nbError, g);
  }
  private void paintPendu(int nbError, Graphics g) {
    switch (nbError) {
      case 0:
        break;
      case 1:
      	g.drawLine(0, 0, this.getWidth(), this.getHeight());
      case 2:
        break;
      case 3:
        break;
      case 4:
        break;
      case 5:
        break;
      case 6:
        break;
      case 7:
        break;
      case 8:
        break;
      default:
        break;
    }
  }
}