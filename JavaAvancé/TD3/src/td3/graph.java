package td3;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class graph extends JFrame {
	public void window()
	{
		JFrame f = new JFrame("Ma fenetre");
		JPanel pannel = new JPanel();
		f.setSize(300, 300);;

		Pendu p = new Pendu();
		JButton btnWord = new JButton("Nouveau Mot");
		JButton btnExit = new JButton("Exit");
		List<String> w = new ArrayList<String>();
		
		btnWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				w.add(p.recupRandomWord());
			}
		}
		);
		String word = w.get(0);

		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);			}
		});
		JTextField testField = new JTextField("my text");
		pannel.add(testField);
		pannel.add(btnWord);
		pannel.add(btnExit);

		f.getContentPane().add(pannel);
		f.setVisible(true);
	}	
}