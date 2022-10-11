package pack;
//NOT FINISHED
import java.io.*;
import java.util.*;

public class Jeu {
    Competiteur comp;
    Date dateDuJeu;
    int score;

    public Jeu(Competiteur c, Date dateDuJeu, int score){
        this.comp = c;
        this.score = 0;
        this.dateDuJeu = dateDuJeu;
    }
    public static void main(String args[]) throws NumberFormatException, IOException {
        Jeu j = new Jeu(null, null, 0);
        j.jouer();
    }
    public List<Integer> randomNumbers(){
        Random r1 = new Random();
        Random r2 = new Random();
        List<Integer> tab = new ArrayList<Integer>();
        int random1 = r1.nextInt(11);
        int random2 = r2.nextInt(11);
        tab.add(random1);
        tab.add(random2);
        System.out.println("Quel est le résultat de la multiplication de " + random1 + " par " + random2);
        return tab;
    }
    public void resetScore(){
        this.score = 0;
    }
    public void jouer() throws NumberFormatException, IOException{
        int i = 0;
        for (i = 0; i < 5; i++){
            List<Integer> nombres = randomNumbers();
            String solution = Integer.toString(nombres.get(0) * nombres.get(1));
            int x = 3;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            long startTime = System.currentTimeMillis();
            while ((System.currentTimeMillis() - startTime) < x * 1000 && !br.ready()){
                try{
                    String reponse = br.readLine();
                    System.out.println("Vous avez répondu " + reponse);
                    if(reponse == solution){ //marche pas
                        this.score++;
                        System.out.println("Bonne réponse, votre score a augmenté de 1 et est de : " + this.score);
                    }
                    else if(reponse == "STOP"){
                        System.out.println("Votre score est de : " + this.score);
                        break;
                    }
                    else{
                        System.out.println("Mauvaise réponse, votre score est de : " + this.score);
                    }
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
            br.close();
        }
        comp.setScoreTotal(comp.getScoreTotal() + this.score);
        if (comp.getScoreTotal() == 5){
            System.out.println("Félicitations, vous avez gagné le jeu");
        }
    }

}
