import java.util.ArrayList;
import java.util.List;

public class Agent {
    public String nom;
    public String prenom;
    public String occupation;
    public String password;
    public ArrayList materiel;


    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getPassword() {
        return password;
    }

    public List getMateriel() {
        return materiel;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMateriel(List materiel) {
        this.materiel = (ArrayList) materiel;
    }
}
