package dao;

import java.util.List;

import metier.entities.Universite;

public interface IUniversiteDao {
	public Universite save(Universite uni);
	public List<Universite> universitesParMC(String mc);
	public Universite getUniversite(int id);
	public Universite updateUniversite(Universite p);
	public void deleteUniversite(int id);


}
