package td3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
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
		
		// Liste pour récupérer le nombre d'erreurs
		List<Integer> erreur = new ArrayList<Integer>();
		erreur.add(0);

		this.frame = new JFrame("Jeu du Pendu :");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,600);

		//Panels :
		this.panel = new JPanel();
		this.panel2 = new JPanel();
		this.panel3 = new JPanel();
		this.panel4 = new JPanel();

		JLabel labelImage = new JLabel();
		// JLabel word = new JLabel("Longueur du mot : 0");
		JLabel motAdeviner = new JLabel("", SwingConstants.CENTER);

		////////////////
		//
		// IL FAUT TOUT RESET LORS DE L'APPUI SUR NOUVEAU MOT, 
		// PAS FORCEMENT A LA FIN DU JEU (SURTOUT POUR L'IMAGE)
		//
		////////////////
	    JButton btnWord = new JButton("Nouveau Mot");
		btnWord.setBounds(70,80,100,30);
		btnWord.setBackground(Color.decode("0x2F849F"));
		btnWord.setOpaque(true);
		btnWord.setBorderPainted(false);
		btnWord.addMouseListener(new MouseListener() {
		    public void mouseReleased(MouseEvent arg0) {}
		    public void mousePressed(MouseEvent arg0) {}
		    public void mouseEntered(MouseEvent arg0) {
		    	btnWord.setBackground(Color.decode("0x03da00"));
		    }
		    public void mouseExited(MouseEvent arg0) {
		    	btnWord.setBackground(Color.decode("0x2F849F"));
		    }
		    public void mouseClicked(MouseEvent arg0) {}
		});
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
				btnWord.setEnabled(false);
			}
		});

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(70,80,100,30);
		btnExit.setBackground(Color.decode("0x2F849F"));
		btnExit.setOpaque(true);
		btnExit.setBorderPainted(false);
		btnExit.addMouseListener(new MouseListener() {
		    public void mouseReleased(MouseEvent arg0) {}
		    public void mousePressed(MouseEvent arg0) {}
		    public void mouseEntered(MouseEvent arg0) {
		    	btnExit.setBackground(Color.decode("0xff5555"));
		    }
		    public void mouseExited(MouseEvent arg0) {
		    	btnExit.setBackground(Color.decode("0x2F849F"));
		    }
		    public void mouseClicked(MouseEvent arg0) {}
		});
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
				List<Integer> index = new ArrayList<Integer>();
				String strText = text.getText();
				String motAdevoiler = motAdeviner.getText();
				
				if(strText.length() >=2){
					JOptionPane.showMessageDialog(panel2, "Veuillez entrer une seule lettre seulement", "InfoBox: ", JOptionPane.WARNING_MESSAGE);
				} 
				
				//tout le programme en dessous peut etre fait dans checkCharInWord, pour plus de logique entre backend et frontend
				index = p.checkCharInWord(leMot.get(0), strText); //retourne liste d'index pour lesquels le caractere est dans le mot 
				if(index.size() != 0){				
					String motCache = leMot.get(0);
					for(int i = 0; i < motCache.length(); i++){
						
						motAdevoiler = motAdevoiler.replaceAll(" ", "");
						
						if (motCache.charAt(i) == strText.charAt(0)){
							motAdevoiler= motAdevoiler.substring(0, i) + strText.charAt(0) + motAdevoiler.substring(i + 1);
							// System.out.println(motAdevoiler);
						}
					}
					String newMot = "";
					for(int i = 0; i<motCache.length(); i++){
						newMot = newMot + motAdevoiler.charAt(i) + "      ";
					}
					motAdeviner.setText(newMot);
					if (motAdevoiler.equals(motCache)){
						System.out.println("Bravo gagné ta race");
						JOptionPane.showMessageDialog(panel2, "Bravo, vous avez gagné !", "InfoBox: ", JOptionPane.WARNING_MESSAGE);
						btnWord.setEnabled(true);
						leMot.clear();
						motAdeviner.setText("");
					}
				}	
				else{
					erreur.set(0, erreur.get(0)+1);
					if(erreur.get(0) == 8){
						labelImage.setIcon(new ImageIcon("TD3/src/td3/Images/pendu" + erreur.get(0) +".png"));
						JOptionPane.showMessageDialog(panel2, "Vous avez perdu !", "InfoBox: ", JOptionPane.WARNING_MESSAGE);
						erreur.set(0, 0);
						btnWord.setEnabled(true);
						leMot.clear();
						motAdeviner.setText("");
					}
					labelImage.setIcon(new ImageIcon("TD3/src/td3/Images/pendu" + erreur.get(0) +".png"));
					// System.out.println("Erreur ; nombre d'erreurs : " + erreur.get(0));
					

				}

				text.setText("");
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
		
		 //JLabel Creation
        labelImage.setIcon(new ImageIcon("TD3/src/td3/Images/pendu0.png")); 
        Dimension size = labelImage.getMaximumSize(); //Gets the size of the image
        labelImage.setBounds(500, 180, size.width, size.height);
		panel4.add(labelImage);
		frame.getContentPane().add(panel4, BorderLayout.LINE_START);

		frame.setVisible(true);
    }
		
	// }
	public void updateLabel(List<JLabel> labelLettre){
		
	}

}