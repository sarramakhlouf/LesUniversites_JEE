package dao;

import java.util.List;

import metier.Universite;

public interface IUniversiteDao {
	public Universite save(Universite uni);
	public List<Universite> universitesParMC(String mc);
	public Universite getUniversite(Long id);
	public Universite updateUniversite(Universite p);
	public void deleteUniversite(Long id);


}
