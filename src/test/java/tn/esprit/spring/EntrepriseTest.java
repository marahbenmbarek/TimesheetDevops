package tn.esprit.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;





import tn.esprit.spring.entities.Departement;

import tn.esprit.spring.entities.Entreprise;

import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

import tn.esprit.spring.services.EntrepriseServiceImpl;
import tn.esprit.spring.services.IDepartementService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EntrepriseTest {
	  

	Logger logger = LoggerFactory.getLogger(EntrepriseTest.class);
	
	
	
	@Autowired 
	EntrepriseServiceImpl entrepriseeService ;
	
	@Autowired
	IDepartementService idepartement;
	
	@Autowired
	DepartementRepository idepartementrepo;
	
	@Autowired
	EntrepriseRepository ent;
	
	
	
	@Test
	public void ajouterEntreprise ()
	{
		Entreprise entreprise = new Entreprise() ;
		entreprise.setName("IPACT");
		entreprise.setRaisonSocial("azerty");
		List<Departement> list = new ArrayList<>();
		list.add(new Departement(1,"physique"));
	
	
		entrepriseeService.ajouterEntreprise(entreprise);
	}

	@Test
	public void testAjouterDepartement(){
		
		
		
		 Departement departement = new Departement();
	
		 
		    departement.setName("physique");
		    departement.setId(1);
	    
		    idepartement.ajouterDepartement(departement);

	       
	       logger.info("l'employé est ajouté");
		}
	

	@Test
	public void  testDeleteDepartementById(){
		Departement department = new Departement("dev");
		int d = entrepriseeService.ajouterDepartement(department);
		entrepriseeService.deleteDepartementById(d);
		idepartementrepo.findById(d);
		
		logger.info("success!! " );
		
		
	}
	
	@Test
	public void testgetEntrepriseById(){
		
		Entreprise entre =new Entreprise("lait", "bbbbbb") ;
	int	id=entrepriseeService.ajouterEntreprise(entre);
		
		
		logger.info("l objet n est pas null " );
		entrepriseeService.getEntrepriseById(id);
		
	
		logger.info("done!!" );
	}
	
	
	
	
	

}
