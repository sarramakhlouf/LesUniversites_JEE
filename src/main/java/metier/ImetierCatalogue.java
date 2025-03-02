package metier;

import java.util.List;

public interface ImetierCatalogue {
	public List<Universite> getUniversitesParMotCle(String mc);
	public void addUniversite(Universite uni);

}
