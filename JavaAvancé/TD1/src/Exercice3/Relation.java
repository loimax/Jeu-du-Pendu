package Exercice3;
//NOT FINISHED
public class Relation {
    private Personne personne1;
    private Personne personne2;
    private String typeRelation;
    public Relation(Personne personne1, Personne personne2, String typeRelation){
        this.personne1 = personne1;
        this.personne2 = personne2;
        this.typeRelation = typeRelation;
    }
    public Personne getPersonne1(){
        return this.personne1;
    }
    public Personne getPersonne2(){
        return this.personne2;
    }
    public String getTypeRelation(){
        return this.typeRelation;
    }
    public void setPersonne1(Personne personne1){
        this.personne1 = personne1;
    }
    public void setPersonne2(Personne personne2){
        this.personne2 = personne2;
    }
    public void setTypeRelation(String typeRelation){
        this.typeRelation = typeRelation;
    }
}