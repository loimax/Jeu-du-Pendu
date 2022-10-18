package td3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class Gui extends JFrame{

	public JFrame frame;
	public JPanel panel;
	public JPanel panel1;
	public JPanel panel2;
	public JPanel panel3;
	public JPanel panel4;
	public JPanel temp2;

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
		List<String> lalettre = new ArrayList<String>();
		
		// Liste pour récupérer le nombre d'erreurs
		List<Integer> erreur = new ArrayList<Integer>();
		erreur.add(0);

		// Liste pour récupérer les lettres déjà jouées
		List<String> lettresJouees = new ArrayList<String>();

		List<JButton[]> listeBoutons = new ArrayList<JButton[]>();

		this.frame = new JFrame("Jeu du Pendu");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(0,223));
		frame.setSize(1000,750);
		frame.setLocationRelativeTo(null);

		//Panels :
		this.panel = new JPanel();
		this.panel1 = new JPanel();
		this.panel2 = new JPanel();
		this.panel3 = new JPanel();
		this.panel4 = new JPanel();
		this.temp2 = new JPanel();

		DrawingPendu drawin = new DrawingPendu(panel4.getWidth(), frame.getHeight()-panel3.getHeight() - 223, erreur.get(0));
		// panel4.add(bouton);
		panel4.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e){
				panel4.setSize(new Dimension(frame.getWidth()/3, frame.getHeight()-panel3.getHeight() - 223));
				drawin.setPreferredSize(new Dimension(frame.getWidth()/3, frame.getHeight()-panel3.getHeight() - 223));
			}
		});

		JLabel labelTitre = new JLabel("Le Jeu du Pendu");
		JLabel motAdeviner = new JLabel("", SwingConstants.CENTER);
		JLabel labelLettresJouees = new JLabel("Lettres déjà jouées : ", SwingConstants.CENTER);
		JLabel labelLettresJouees2 = new JLabel("", SwingConstants.CENTER);

		labelTitre.setFont(new Font("Brush Script MT", Font.PLAIN, 70));
		labelTitre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		motAdeviner.setFont(new Font("Arial", Font.BOLD, 20));
		labelLettresJouees.setFont(new Font("Arial", Font.BOLD, 23));
		labelLettresJouees2.setFont(new Font("Arial", Font.BOLD, 20));
		
	    JButton btnWord = new JButton("Nouveau Mot");
		JButton btnExit = new JButton("Exit");
		btnWord.setFont(new Font("Arial", Font.BOLD, 20));
		btnExit.setFont(new Font("Arial", Font.BOLD, 20));

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
				lettresJouees.clear();
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
		
		// lettres a utimliser en ordre alphabetique
		String firstRow[] = {"A", "Z", "E", "R", "T", "Y", "U", "I", "O", "P"};
		String secondRow[] = {"Q", "S", "D", "F", "G", "H", "J", "K", "L", "M"};
		String thirdRow[] = {"W", "X", "C", "V", "B", "N"};
		
		//tableau de  boutons pour economiser ligne de code
		JButton first[] = new JButton[firstRow.length];
		JButton second[] = new JButton[secondRow.length];
		JButton third[] = new JButton[thirdRow.length];
		
		//1ere ligne de boutons
		JPanel temp = new JPanel(new GridLayout(1, firstRow.length));
		for(int i = 0; i < firstRow.length; ++i) {
			JButton b= new JButton(firstRow[i]);
			b.setPreferredSize(new Dimension(100,50));
			first[i] = b;
			temp.add(first[i]);
		}
		panel3.add(temp);
		
		//2eme ligne de boutons
		temp = new JPanel(new GridLayout(1, secondRow.length));
		for(int i = 0; i < secondRow.length; ++i) 
		{
			second[i] = new JButton(secondRow[i]);
			temp.add(second[i]);
		}
		panel3.add(temp);
		
		//3eme ligne de boutons
		temp = new JPanel(new GridLayout(1, thirdRow.length));
		for(int i = 0; i < thirdRow.length; ++i){
			third[i] = new JButton(thirdRow[i]);
			temp.add(third[i]);
		}
		panel3.add(temp);

		listeBoutons.add(first);
		listeBoutons.add(second);
		listeBoutons.add(third);
		resetButtons(listeBoutons);
		
		
		int j=0;
		for(JButton b : first) {
		//b.addKeyListener(this);
			j++;
			final int y = j;
			b.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					lalettre.add(b.getName());
					int z=y;
					List<Integer> index = new ArrayList<Integer>();

						String strText = firstRow[z-1];
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
							index = p.checkCharInWord(leMot.get(0), strText); 
							lettresJouees.add(strText);
							String lettresJoueesStr = "| ";
							for(int i = 0; i<lettresJouees.size(); i++){
								lettresJoueesStr = lettresJoueesStr + lettresJouees.get(i).toUpperCase() + " | ";
							}
							labelLettresJouees2.setText(lettresJoueesStr);
							if(index.size() != 0){		
								b.setBackground(Color.decode("0x03da00"));	
								b.setEnabled(false);	
								String motCache = leMot.get(0);
								for(int i = 0; i < motCache.length(); i++){
									motAdevoiler = motAdevoiler.replaceAll(" ", "");
									if (motCache.charAt(i) == strText.charAt(0)){
										motAdevoiler= motAdevoiler.substring(0, i) + strText.charAt(0) + motAdevoiler.substring(i + 1);	
									}
									else if(motCache.charAt(i) == Character.toUpperCase(strText.charAt(0))){
										motAdevoiler= motAdevoiler.substring(0, i) + Character.toUpperCase(strText.charAt(0)) + motAdevoiler.substring(i + 1);	
									}
									else if(motCache.charAt(i) == Character.toLowerCase(strText.charAt(0))){
										motAdevoiler= motAdevoiler.substring(0, i) + Character.toLowerCase(strText.charAt(0)) + motAdevoiler.substring(i + 1);
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
									labelLettresJouees2.setText("");
									drawin.setNbError(0);
									drawin.repaint();
									leMot.clear();
									resetButtons(listeBoutons);
								}
							}	
							else{
								b.setBackground(Color.decode("0xff5555"));
								b.setEnabled(false);
								erreur.set(0, erreur.get(0)+1);
								drawin.setNbError(erreur.get(0));
								drawin.repaint();
								if(erreur.get(0) == 11){
									JOptionPane.showMessageDialog(panel2, "Vous avez perdu !", "InfoBox: ", JOptionPane.WARNING_MESSAGE);
									btnWord.setEnabled(true);
									motAdeviner.setText("");
									labelLettresJouees2.setText("");
									drawin.setNbError(0);
									drawin.repaint();
									leMot.clear();
									resetButtons(listeBoutons);
								}
							}
						}
				}
			});
		}
		int u = 0;
		for(JButton b : second) {
		 
			u++;
			final int y = u;
			b.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					lalettre.add(b.getName());
					int z=y;
					List<Integer> index = new ArrayList<Integer>();

						String strText = secondRow[z-1];
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
							labelLettresJouees2.setText(lettresJoueesStr);
							if(index.size() != 0){	
								b.setBackground(Color.decode("0x55ff55"));
								b.setEnabled(false);
								String motCache = leMot.get(0);
								for(int i = 0; i < motCache.length(); i++){
									motAdevoiler = motAdevoiler.replaceAll(" ", "");
									if (motCache.charAt(i) == strText.charAt(0)){
										motAdevoiler= motAdevoiler.substring(0, i) + strText.charAt(0) + motAdevoiler.substring(i + 1);	
									}
									else if(motCache.charAt(i) == Character.toUpperCase(strText.charAt(0))){
										motAdevoiler= motAdevoiler.substring(0, i) + Character.toUpperCase(strText.charAt(0)) + motAdevoiler.substring(i + 1);	
									}
									else if(motCache.charAt(i) == Character.toLowerCase(strText.charAt(0))){
										motAdevoiler= motAdevoiler.substring(0, i) + Character.toLowerCase(strText.charAt(0)) + motAdevoiler.substring(i + 1);
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
									labelLettresJouees2.setText("");
									drawin.setNbError(0);
									drawin.repaint();
									leMot.clear();
									resetButtons(listeBoutons);
								}
							}	
							else{
								b.setBackground(Color.decode("0xff5555"));
								b.setEnabled(false);
								erreur.set(0, erreur.get(0)+1);
								drawin.setNbError(erreur.get(0));
								drawin.repaint();
								if(erreur.get(0) == 11){
									JOptionPane.showMessageDialog(panel2, "Vous avez perdu !", "InfoBox: ", JOptionPane.WARNING_MESSAGE);
									btnWord.setEnabled(true);
									motAdeviner.setText("");
									labelLettresJouees2.setText("");
									drawin.setNbError(0);
									drawin.repaint();
									leMot.clear();
									resetButtons(listeBoutons);
								}
							}
						}
				}
			});
		}
		int q=0;
		for(JButton b : third) {
			q++;
			final int y = q;
			b.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					lalettre.add(b.getName());
					int z=y;
					List<Integer> index = new ArrayList<Integer>();

						String strText = thirdRow[z-1];
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
							labelLettresJouees2.setText(lettresJoueesStr);
							if(index.size() != 0){	
								b.setBackground(Color.decode("0x55ff55"));
								b.setEnabled(false);
								String motCache = leMot.get(0);
								for(int i = 0; i < motCache.length(); i++){
									motAdevoiler = motAdevoiler.replaceAll(" ", "");
									if (motCache.charAt(i) == strText.charAt(0)){
										motAdevoiler= motAdevoiler.substring(0, i) + strText.charAt(0) + motAdevoiler.substring(i + 1);	
									}
									else if(motCache.charAt(i) == Character.toUpperCase(strText.charAt(0))){
										motAdevoiler= motAdevoiler.substring(0, i) + Character.toUpperCase(strText.charAt(0)) + motAdevoiler.substring(i + 1);	
									}
									else if(motCache.charAt(i) == Character.toLowerCase(strText.charAt(0))){
										motAdevoiler= motAdevoiler.substring(0, i) + Character.toLowerCase(strText.charAt(0)) + motAdevoiler.substring(i + 1);
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
									labelLettresJouees2.setText("");
									drawin.setNbError(0);
									drawin.repaint();
									leMot.clear();
									resetButtons(listeBoutons);
								}
							}	
							else{
								b.setBackground(Color.decode("0xff5555"));
								b.setEnabled(false);
								erreur.set(0, erreur.get(0)+1);
								drawin.setNbError(erreur.get(0));
								drawin.repaint();
								if(erreur.get(0) == 11){
									JOptionPane.showMessageDialog(panel2, "Vous avez perdu !", "InfoBox: ", JOptionPane.WARNING_MESSAGE);
									btnWord.setEnabled(true);
									motAdeviner.setText("");
									labelLettresJouees2.setText("");
									drawin.setNbError(0);
									drawin.repaint();
									leMot.clear();
									resetButtons(listeBoutons);
								}
							}
						}
				}
			});
		}
		
		panel.setLayout(new GridLayout(2,1));
		panel.add(labelTitre);
		temp2.add(btnWord);
		temp2.add(btnExit);
		panel.add(temp2);
		
		panel2.setLayout(new GridLayout(3,1));
		panel2.add(motAdeviner);
		panel2.add(labelLettresJouees);
		panel2.add(labelLettresJouees2);

		panel3.setLayout(new GridLayout(4,1));
		panel3.setBackground(Color.WHITE);
		panel4.add(drawin);

		frame.add(panel, BorderLayout.PAGE_START);
		frame.add(panel2, BorderLayout.CENTER);
		frame.add(panel3, BorderLayout.SOUTH);
		frame.add(panel4, BorderLayout.LINE_START);

		frame.setVisible(true);
    }

	public void resetButtons(List<JButton[]> listKB){
		JButton tab1[] = listKB.get(0);
		JButton tab2[] = listKB.get(1);
		JButton tab3[] = listKB.get(2);
		for(JButton a : tab1){
			a.setEnabled(true);
			a.setBackground(Color.WHITE);
		}
		for(JButton a : tab2){
			a.setEnabled(true);
			a.setBackground(Color.WHITE);
		}
		for(JButton a : tab3){
			a.setEnabled(true);
			a.setBackground(Color.WHITE);
		}
	}
}