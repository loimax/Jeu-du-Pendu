package td3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Dessin extends JPanel {
  public Dessin() {
    this.setPreferredSize(new Dimension(1000, 800));
    this.setBackground(Color.WHITE);
    this.setOpaque(true);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawLine(0, 0, this.getWidth(), this.getHeight());
  }
}