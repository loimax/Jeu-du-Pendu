package td3;

import java.awt.BorderLayout;
import java.awt.Color;
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
		
		// Liste pour récupérer le nombre d'erreurs
		List<Integer> erreur = new ArrayList<Integer>();
		erreur.add(0);

		// Liste pour récupérer les lettres déjà jouées
		List<String> lettresJouees = new ArrayList<String>();

		this.frame = new JFrame("Jeu du Pendu :");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,500);

		//Panels :
		this.panel = new JPanel();
		this.panel2 = new JPanel();
		this.panel3 = new JPanel();
		this.panel4 = new JPanel();
		Dimension p4MiniSize = new Dimension(frame.getWidth()/3, (frame.getHeight()/2+frame.getHeight()/4));
		this.panel4.setMinimumSize(p4MiniSize);
		
		JLabel motAdeviner = new JLabel("", SwingConstants.CENTER);
		TraitsParMots drawin = new TraitsParMots(panel4.getWidth(), panel4.getHeight(), erreur.get(0));

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
				String mot = p.recupRandomWord();
				leMot.add(mot);
				System.out.println("Le mot est : " + leMot.get(0));

				int nombreChar = mot.length();
				String traits = "";
				for(int i = 0; i<nombreChar; i++){
					traits = traits + "_" + "      ";
				}
				motAdeviner.setText(traits);
				btnWord.setEnabled(false);

				//reset du nombre d'erreur
				erreur.set(0, 0);
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

		JLabel labelLettresJouees = new JLabel("Lettres déjà jouées : ", SwingConstants.CENTER);
		JLabel labelEntrerLettre = new JLabel("Entrez la lettre, puis appuyez sur entrée :");
		JTextField text = new JTextField("", 10);

		text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Integer> index = new ArrayList<Integer>();
				String strText = text.getText();
				String motAdevoiler = motAdeviner.getText();
				if(leMot.isEmpty()){
					JOptionPane.showMessageDialog(panel2, "Le jeu n'a pas encore été lancé ; appuyez sur le boutton 'Nouveau Mot' pour commencer", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(strText.length() >=2){
					JOptionPane.showMessageDialog(panel2, "Veuillez entrer une seule lettre seulement", "InfoBox: ", JOptionPane.WARNING_MESSAGE);
				}
				else if(lettresJouees.contains(strText)){
					JOptionPane.showMessageDialog(panel2, "Vous avez déjà entrer cette lettre", "InfoBox: ", JOptionPane.WARNING_MESSAGE);
				} 
				else{
					//tout le programme en dessous peut etre fait dans checkCharInWord, pour plus de logique entre backend et frontend
					index = p.checkCharInWord(leMot.get(0), strText); 
					lettresJouees.add(strText);
					String lettresJoueesStr = "| ";
					for(int i = 0; i<lettresJouees.size(); i++){
						lettresJoueesStr = lettresJoueesStr + lettresJouees.get(i).toUpperCase() + " | ";
					}
					labelLettresJouees.setText("Lettres déjà jouées : " + lettresJoueesStr);
					if(index.size() != 0){				
						String motCache = leMot.get(0);
						for(int i = 0; i < motCache.length(); i++){
							motAdevoiler = motAdevoiler.replaceAll(" ", "");
							if (motCache.charAt(i) == strText.charAt(0)){
								motAdevoiler= motAdevoiler.substring(0, i) + strText.charAt(0) + motAdevoiler.substring(i + 1);	
							}
						}
						String newMot = "";
						for(int i = 0; i<motCache.length(); i++){
							newMot = newMot + motAdevoiler.charAt(i) + "      ";
						}
						motAdeviner.setText(newMot);
						if (motAdevoiler.equals(motCache)){
							JOptionPane.showMessageDialog(panel2, "Bravo, vous avez gagné !", "InfoBox: ", JOptionPane.WARNING_MESSAGE);
							btnWord.setEnabled(true);
							motAdeviner.setText("");
							labelLettresJouees.setText("Lettres déjà jouées : ");
							drawin.setNbError(0);
							drawin.repaint();
							lettresJouees.clear();
							leMot.clear();
						}
					}	
					else{
						erreur.set(0, erreur.get(0)+1);
						drawin.setNbError(erreur.get(0));
						drawin.repaint();
						if(erreur.get(0) == 11){
							JOptionPane.showMessageDialog(panel2, "Vous avez perdu !", "InfoBox: ", JOptionPane.WARNING_MESSAGE);
							btnWord.setEnabled(true);
							motAdeviner.setText("");
							labelLettresJouees.setText("Lettres déjà jouées : ");
							drawin.setNbError(0);
							drawin.repaint();
							lettresJouees.clear();
							leMot.clear();
						}
					}
				}
				text.setText("");
			}
		});

		panel.add(btnWord);
		panel.add(btnExit);
		// frame.getContentPane().add(panel, BorderLayout.PAGE_START);
		frame.add(panel, BorderLayout.PAGE_START);

		panel2.add(motAdeviner);
		panel2.add(labelLettresJouees);
		// frame.getContentPane().add(panel2, BorderLayout.CENTER);
		frame.add(panel2, BorderLayout.CENTER);
		
		panel3.add(labelEntrerLettre);
		panel3.add(text);

		// frame.getContentPane().add(panel3, BorderLayout.PAGE_END);
		frame.add(panel3, BorderLayout.PAGE_END);

		panel4.add(drawin);
		panel4.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e){
				panel4.setSize(frame.getWidth()/3, (frame.getHeight()/2+frame.getHeight()/4));
				drawin.setPreferredSize(new Dimension(panel4.getWidth(), panel4.getHeight()));
			}
		});
		// frame.getContentPane().add(panel4, BorderLayout.LINE_START);
		frame.add(panel4, BorderLayout.LINE_START);

		// frame.pack();
		frame.setVisible(true);
    }
}