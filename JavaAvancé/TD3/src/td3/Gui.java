package td3;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Gui extends JFrame{

    public Gui(){
		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		addWindowListener(l);

		Pendu p = new Pendu();
		
		JFrame frame = new JFrame("Jeu du Pendu :");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,600);

		JLabel w = new JLabel("Longueur du mot : 0");
	    JButton btnWord = new JButton("Nouveau Mot");
		btnWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				w.setText("Longueur du mot : "+ p.recupRandomWord().length());
			}
		});

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);			
			}
		});

		JPanel panel = new JPanel();
		panel.add(btnWord);
		panel.add(btnExit);
		frame.getContentPane().add(panel);

		
		JPanel panel2 = new JPanel();
		panel2.add(w);
		panel2.add(new Dessin());
		frame.getContentPane().add(panel2, "South");

		frame.pack();
		frame.setVisible(true);
    }
}