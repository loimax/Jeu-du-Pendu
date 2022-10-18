package td3;
import java.util.*;
import java.io.*;

public class backend {
    String path = "JavaAvancé/src/td3/liste.txt";
    public void ecritureListe(){
        try{
            Scanner sc = new Scanner(System.in);
            BufferedWriter bw = new BufferedWriter(new FileWriter(path, false));
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
    public String recupRandomWord(){
        File fichier = new File(path);
        List<String> l = new ArrayList<String>();
        if(!fichier.exists()){
            // Boolean fileCreated = false;
            ecritureListe();
        }
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
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
    public List<Integer> checkCharInWord(String mot, String lettre){
        List<Integer> l = new ArrayList<Integer>();
        for(int i = 0; i<mot.length(); i++){
            String a = mot.substring(i, i + 1);
            if(lettre.equals(a) || lettre.equals(a.toUpperCase())){
                l.add(i);
            }        
        }
        return l;
    }
}
