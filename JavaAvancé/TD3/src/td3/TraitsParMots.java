package td3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class TraitsParMots extends JPanel {
  int nombreChar = 0;
  public TraitsParMots(int nbreChar) {
    this.setPreferredSize(new Dimension(1000, 800));
    this.setBackground(Color.WHITE);
    this.setOpaque(true);
    this.nombreChar = nbreChar;
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    g.drawLine(0, 0, this.getWidth(), this.getHeight());
  }
}