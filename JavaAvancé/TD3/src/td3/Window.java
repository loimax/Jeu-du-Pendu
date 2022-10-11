package td3;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Window extends JFrame {

	public String word;

	public Window(Pendu p, String word){
		super("Jeu du pendu");
		this.word = word;
		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		addWindowListener(l);

		JButton btnWord = new JButton("Nouveau Mot");
		btnWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setWord();
			}
		});

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);			
			}
		});
		

		JPanel pannel = new JPanel();
		pannel.add(btnWord);
		pannel.add(btnExit);
		
		setContentPane(pannel);
		pannel.add(new Dessin());
		pack();
		// setSize(1000,800);
		setVisible(true);
		
	}
	public int setWord() {
		Pendu p = new Pendu();
		this.word = p.recupRandomWord();
		return this.word.length();
	}
}