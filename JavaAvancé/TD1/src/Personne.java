import java.util.*;
import java.io.*;

public class Personne implements Serializable{
    private String nom;
    private String dateNaissance;
    private String pays;
    private String numSecuSocial;
    private String profession;
    public Personne(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nom : ");
        this.nom = sc.nextLine();
        System.out.println("Date de naissance : ");
        this.dateNaissance = sc.nextLine();
        System.out.println("Pays : ");
        this.pays = sc.nextLine();
        System.out.println("Numéro de sécurité sociale : ");
        this.numSecuSocial = sc.nextLine();
        System.out.println("Profession : ");
        this.profession = sc.nextLine();
        // System.out.println("Personne créée : \n" + "Nom : " + this.nom + "\nDate de naissance : " + this.dateNaissance + "\nPays : " + this.pays + "\nNuméro de sécurité sociale : " + this.numSecuSocial + "\nProfession : " + this.profession);
    }
    public static void main(String args[]){
        int i = 0;
        List<Personne> tab = new ArrayList<Personne>();

        for(i = 0; i < 3; i++){
            Personne p = new Personne();
            tab.add(p);
            System.out.println("Personne crée");
        }

        File fichier = new File("maj - Liste des metiers.txt");
        if(!fichier.exists()){
            Boolean fileCreated = false;
            for(i = 0; i < tab.size(); i++){
                if (tab.get(i).checkIfInFile() == 0){
                    if(fileCreated == false){
                        copierFichier("Liste des metiers.txt", "maj - Liste des metiers.txt");
                        fileCreated = true;
                    }
                    tab.get(i).ecriture();
                }
            }
        }
        else{
            for(i = 0; i < tab.size(); i++){
                if (tab.get(i).checkIfInFile() == 0){
                    tab.get(i).ecriture();
                }
            }
        }
        serializePersonne(tab);
        deserializePersonne();
    }
    public static void copierFichier(String source, String destination){
        try{
            byte buffer[] = new byte[1024];
            int taille = 0;
            FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(destination);
            while((taille = fis.read(buffer)) != -1)
            {
                fos.write(buffer, 0, taille);
            }
            fis.close();
            fos.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
    }
    // Works but not optimal since we're using "ligne.contains" and not the split method
    // public int checkIfInFile(){
    //     try{
    //         BufferedReader br = new BufferedReader(new FileReader("Liste des metiers.txt"));
    //         String ligne;
    //         while((ligne = br.readLine()) != null){
    //             if (ligne.contains(this.profession)){
    //                 System.out.println("La profession " + this.profession + " existe dans le fichier");
    //                 return 1;
    //             }
    //         }
    //         br.close();
    //     }
    //     catch (IOException e){
    //         e.printStackTrace();
    //     }
    //     return 0;
    // }
    public int checkIfInFile(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("Liste des metiers.txt"));
            String ligne;
            while((ligne = br.readLine()) != null){
                for(String s : ligne.split(", "))
                {
                    if (s.equals(this.profession)){
                        System.out.println("La profession " + this.profession + " existe dans le fichier");
                        return 1;
                    }
                }
            }
            br.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return 0;
    }
    public void ecriture(){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("maj - Liste des metiers.txt", true));
            bw.newLine();
            bw.write(this.profession);
            bw.close();
            System.out.println("La profession " + this.profession + " a été ajoutée au fichier");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void getters(){
        System.out.println("Nom : " + this.nom + "\nDate de naissance : " + this.dateNaissance + "\nPays : " + this.pays + "\nNuméro de sécurité sociale : " + this.numSecuSocial + "\nProfession : " + this.profession);
    }
    public static void serializePersonne(List<Personne> listP){
        ObjectOutputStream oos = null;
        try{
            final FileOutputStream fichier = new FileOutputStream("ObjetPersonne.ser");
            oos = new ObjectOutputStream(fichier);
            oos.writeObject(listP);
            oos.flush();
        }
        catch (final IOException e)
        {
            e.printStackTrace();
        }
        finally{
            try{
                if (oos != null){
                    oos.flush();
                    oos.close();
                }
            }
            catch (final IOException ex){
                ex.printStackTrace();
            }
        }
    }
    public static void deserializePersonne(){
        ObjectInputStream ois = null;
        try{
            final FileInputStream fichier = new FileInputStream("ObjetPersonne.ser");
            ois = new ObjectInputStream(fichier);
            List<Personne> listP = (List<Personne>)ois.readObject();
            for (int i = 0; i < listP.size(); i++){
                listP.get(i).getters();
            }
        }
        catch (final IOException e)
        {
            e.printStackTrace();
        } catch (final ClassNotFoundException exe){
            exe.printStackTrace();
        }
        finally{
            try{
                if (ois != null){
                    ois.close();
                }
            }
            catch (final IOException ex){
                ex.printStackTrace();
            }
        }
    }
}
