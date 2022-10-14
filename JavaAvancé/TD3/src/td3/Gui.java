package td3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class Gui extends JFrame{

	public JFrame frame;
	public JPanel panel;
	public JPanel panel2;
	public JPanel panel3;
	public JPanel panel4;

    public Gui(){
		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		addWindowListener(l);

		backend p = new backend();

		//Liste pour recuperer le mot aleatoire
		List<String> leMot = new ArrayList<String>();

		this.frame = new JFrame("Jeu du Pendu :");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,600);

		//Panels :
		this.panel = new JPanel();
		this.panel2 = new JPanel();
		this.panel3 = new JPanel();
		this.panel4 = new JPanel();
		// JLabel word = new JLabel("Longueur du mot : 0");
		JLabel motAdeviner = new JLabel("", SwingConstants.CENTER);
	    JButton btnWord = new JButton("Nouveau Mot");
		btnWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				leMot.clear();
				String mot = p.recupRandomWord();
				leMot.add(mot);
				System.out.println(leMot);

				int nombreChar = mot.length();
				// word.setText("Longueur du mot : "+ nombreChar);
				String traits = "";
				for(int i = 0; i<nombreChar; i++){
					traits = traits + "_" + "      ";
				}
				// System.out.println(nombreChar + traits + traits.length() + mot);
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
				System.out.println(p.checkCharInWord(leMot.get(0), strText));
			}
		});

		panel.add(btnWord);
		panel.add(btnExit);
		frame.getContentPane().add(panel, BorderLayout.PAGE_START);

		// panel2.add(word);
		panel2.add(motAdeviner);
		frame.getContentPane().add(panel2, BorderLayout.CENTER);

		panel3.add(labelEntrerLettre);
		panel3.add(text);
		// JButton btn1 = new JButton("A");
		// JButton btn2 = new JButton("B");
		// JButton btn3 = new JButton("C");
		// panel3.add(btn1);
		// panel3.add(btn2);
		// panel3.add(btn3);   ET FAIRE DES LISTENERS POUR RECUP LA LETTRE APRES EZ
		

		frame.getContentPane().add(panel3, BorderLayout.PAGE_END);
		// frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JLabel label = new JLabel(); //JLabel Creation
        label.setIcon(new ImageIcon("JavaAvancé/TD3/src/td3/Images/pendu0.png")); //Sets the image to be displayed as an icon
        Dimension size = label.getMaximumSize(); //Gets the size of the image
        label.setBounds(500, 180, size.width, size.height);
		panel4.add(label);
		frame.getContentPane().add(panel4, BorderLayout.LINE_START);

		frame.setVisible(true);
    }
		
	// }
	public void updateLabel(List<JLabel> labelLettre){
		
	}

}