package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

@Service
public class DepartementServiceImpl implements IDepartementService {

	private static final Logger logger = LogManager.getLogger(DepartementServiceImpl.class);

	@Autowired
	DepartementRepository departementRepoistory;

	@Override
	public List<Departement> getAllDepartements() {
		return (List<Departement>) departementRepoistory.findAll();
	}
	
	@Override
	public void deleteAll() {

		departementRepoistory.deleteAll();

	}
	
	@Override
	public Departement ajouterDepartement(Departement departement) {

		try {
			logger.info("Dans la  methode ajouterDepartement()");
			logger.debug("Je vais lancer l'ajout d'un nouveau Departement .");
			departementRepoistory.save(departement);
			logger.debug("Je viens de finir l'ajout .");
			logger.info("Out ajouterDepartement() without errors avec.");
		}
		catch (Exception e)
			{
			logger.error("Erreur dans ajouterDepartement()");
			}
			logger.info("fin methode ajouterDepartement() .");
			return departement ;
	}
	

	@Override
	public void deleteDepartementById(int id){

		departementRepoistory.deleteById(id);
	}
}
