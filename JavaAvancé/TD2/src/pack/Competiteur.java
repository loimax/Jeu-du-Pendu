package pack;
//NOT FINISHED
public class Competiteur {
    String nom;
    String prenom;
    int age;
    int scoreTotal;
    public Competiteur(String nom, String prenom, int age){
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.scoreTotal = 0;
    }
    public String getNom(){
        return this.nom;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public int getAge(){
        return this.age;
    }
    public int getScoreTotal(){
        return this.scoreTotal;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setScoreTotal(int score){
        this.scoreTotal = score;
    }
    public void ajouterScore(int score){
        this.scoreTotal += score;
    }
}

