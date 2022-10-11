import java.util.*;
import java.io.*;

public class Pendu {
    public static void main(String[] args) throws Exception {
        Pendu p = new Pendu();
        System.out.println(p.recupRandomListe());

    }
    public void ecritureListe(){
        try{
            Scanner sc = new Scanner(System.in);
            BufferedWriter bw = new BufferedWriter(new FileWriter("liste.txt", false));
            System.out.println("Entrez les mots 1 par 1 :\n");
            for(int i = 0; i<10; i++){
                String a = sc.nextLine();
                bw.write(a);
                bw.newLine();
            }
            sc.close();
            bw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public String recupRandomListe(){
        File fichier = new File("liste.txt");
        List<String> l = new ArrayList<String>();
        if(!fichier.exists()){
            // Boolean fileCreated = false;
            ecritureListe();
        }
        try{
            BufferedReader br = new BufferedReader(new FileReader("liste.txt"));
            String ligne;
            while((ligne = br.readLine()) != null){
                l.add(ligne);   
            }
            br.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        Random r1 = new Random();
        int randomNumber = r1.nextInt(10);
        String randomWord = l.get(randomNumber);
        return randomWord;
    }
}
