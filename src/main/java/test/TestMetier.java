package test;

import java.util.List;

import dao.UniversiteDaoImpl;
import metier.entities.Universite;

public class TestMetier {

	public static void main(String[] args) {
		UniversiteDaoImpl pdao = new UniversiteDaoImpl();
		Universite univer = pdao.save(new Universite("Isie", "Soussa", "Isie@gmail.com", 1200));
		System.out.println(univer);
		List<Universite> unis = pdao.universitesParMC("ip");
		for (Universite uni : unis)
			System.out.println(uni);
	}
}
