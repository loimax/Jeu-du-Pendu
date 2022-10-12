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

		// JLabel word = new JLabel("Longueur du mot : 0");
		JLabel motAdeviner = new JLabel("", SwingConstants.CENTER);
	    JButton btnWord = new JButton("Nouveau Mot");
		btnWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mot = p.recupRandomWord();
				int nombreChar = mot.length();
				// word.setText("Longueur du mot : "+ nombreChar);
				String traits = "";
				for(int i = 0; i<nombreChar; i++){
					traits = traits + "_" + "      ";
				}
				System.out.println(nombreChar + traits + traits.length() + mot);
				motAdeviner.setText(traits);
				//recuperer mot créer 
			}
		});

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);			
			}
		});
		
		JLabel labelEntrerLettre = new JLabel("Entrez la lettre, puis appuyez sur entrée :", SwingConstants.RIGHT);
		//ajoutez un listener ici pour text
		JTextField text = new JTextField("", 10);
		text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strText = text.getText();
				if(strText.length() >=2){
					JOptionPane.showMessageDialog(panel2, "Veuillez entrer une seule lettre seulement", "InfoBox: ", JOptionPane.WARNING_MESSAGE);
				} else {
					System.out.println(strText);
				}
				text.setText("");
			}
		});

		panel.add(btnWord);
		panel.add(btnExit);
		frame.getContentPane().add(panel, "North");

		// panel2.add(word);
		panel2.add(motAdeviner);
		frame.getContentPane().add(panel2, "West");

		panel3.add(labelEntrerLettre);
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