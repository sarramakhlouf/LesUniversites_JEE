package web;

import java.util.ArrayList;
import java.util.List;
import metier.entities.Universite;

public class UniversiteModele {
	private String motCle;
	List<Universite> universites = new ArrayList<>();

	public String getMotCle() {
		return motCle;
	}

	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}

	public List<Universite> getUniversites() {
		return universites;
	}

	public void setUniversites(List<Universite> universites) {
		this.universites = universites;
	}
}