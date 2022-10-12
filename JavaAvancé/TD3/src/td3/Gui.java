package td3;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Gui extends JFrame{

	public JFrame frame;
	public JPanel panel;
	public JPanel panel2;
	public JPanel panel3;

    public Gui(){
		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		addWindowListener(l);

		Pendu p = new Pendu();
		
		this.frame = new JFrame("Jeu du Pendu :");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,600);

		//Panels :
		this.panel = new JPanel();
		this.panel2 = new JPanel();
		this.panel3 = new JPanel();

		JLabel word = new JLabel("Longueur du mot : 0");
	    JButton btnWord = new JButton("Nouveau Mot");
		btnWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nombreChar = p.recupRandomWord().length();
				word.setText("Longueur du mot : "+ p.recupRandomWord().length());
				for(int i = 0; i < nombreChar; i++){
					JLabel text = new JLabel("_", SwingConstants.CENTER);
					panel2.add(text);
				}
			}
		});

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);			
			}
		});
		
		JLabel l1 = new JLabel("Entrez la lettre :", SwingConstants.RIGHT);
		//ajoutez un listener ici pour text
		JTextField text = new JTextField("", 1);
		text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// updateLabel();
			}
		});

		panel.add(btnWord);
		panel.add(btnExit);
		frame.getContentPane().add(panel, "North");

		panel2.add(word);
		// panel2.add(new TraitsParMots(5));
		frame.getContentPane().add(panel2, "West");

		panel3.add(l1);
		panel3.add(text);
		frame.getContentPane().add(panel3, "South");
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		// frame.pack();
		frame.setVisible(true);
    }

	// public List<JLabel> displayLines(int nbChar){
	// 	List<JLabel> labelLettre = new ArrayList<JLabel>();
		
		
	// }
	public void updateLabel(List<JLabel> labelLettre){
		
	}

}