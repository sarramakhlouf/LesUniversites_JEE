package metier.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "universites")
public class Universite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "ID_UNI")
    private int idUni; 

    @Column(name = "NOM_UNI")
    private String nomUni;

    @Column(name = "ADRESSE_UNI")
    private String adresseUni;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "NB_ETUDIANTS")
    private double nbEtudiants;

    // Constructeurs
    public Universite() {
    }

    public Universite(String nom_Uni, String adresse_Uni, String email, double nb_Etudiants) {
        this.nomUni = nom_Uni;
        this.adresseUni = adresse_Uni;
        this.email = email;
        this.nbEtudiants = nb_Etudiants;
    }


    // Getters et Setters
    public int getIdUni() {
        return idUni;
    }

    public void setIdUni(int idUni) {
        this.idUni = idUni;
    }

    public String getNomUni() {
        return nomUni;
    }

    public void setNomUni(String nomUni) {
        this.nomUni = nomUni;
    }

    public String getAdresseUni() {
        return adresseUni;
    }

    public void setAdresseUni(String adresseUni) {
        this.adresseUni = adresseUni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getNbEtudiants() {
        return nbEtudiants;
    }

    public void setNbEtudiants(double nbEtudiants) {
        this.nbEtudiants = nbEtudiants;
    }
}
