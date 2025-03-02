package metier;

public class Universite {
	private Long idUni;
	private String nomUni;
	private String adresseUni;
	private String email;
	private double nbEtudiants;
	public Universite(String nomUni, String adresseUni, String email, double nbEtudiants) {
		super();
		this.nomUni = nomUni;
		this.adresseUni = adresseUni;
		this.email = email;
		this.nbEtudiants = nbEtudiants;
	}
	public Long getIdUni() {
		return idUni;
	}
	public void setIdUni(Long idUni) {
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