package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Departement;


public interface IDepartementService {

	public List<Departement> getAllDepartements();
	public void deleteAll();
	public Departement ajouterDepartement(Departement dpt);
}
