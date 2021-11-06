package tn.esprit.spring;


import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.EntrepriseServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeTest {
	
	public EmployeTest() {
		super();
	
	}


	    @Autowired
	    private EmployeServiceImpl employeService;

	    @Autowired
	    EntrepriseServiceImpl entrepriseService;
    private final  Logger l = LogManager.getLogger(EmployeTest.class);
    
    @Test
    public void ajoutEmploye() {
        Employe employe = new Employe();
        employe.setNom("hadhri");
        employe.setPrenom("hazem");
        employe.setEmail("hazem.hadhri@esprit.tn");
        employe.setPassword("hazem123");
        employe.setRole(Role.CHEF_DEPARTEMENT);
        employe.setActif(true);
        employeService.addOrUpdateEmploye(employe);
        
        l.info("l'employé est ajouté");
    }
    @Test
    public void getNombreEmploye() {
        int nombre = employeService.getNombreEmployeJPQL();
        
        l.info(nombre);
    }
    @Test
    public void ajouterContrat() {
        Date date = new Date();
        Contrat contrat = new Contrat(date, "CDI", 20000);
    employeService.ajouterContrat(contrat);
     
        l.info(" le contrat est bien ajouté");
    }

    @Test
    public void affecterContratAEmploye() {
    	Employe employe = new Employe("hazem", "hadhri", "hazem@esprit.tn", true, Role.CHEF_DEPARTEMENT);
        Date date = new Date();
        Contrat contrat = new Contrat(date, "CDD", 1000);
        employeService.ajouterEmploye(employe);
        employeService.ajouterContrat(contrat);
        employeService.affecterContratAEmploye(contrat.getReference(), employe.getId());
    }

    @Test
    public void affecterEmployeADepartement() {
    	Employe employe = new Employe("hazemm", "hadhrii", "hazemm@esprit.tn", true, Role.CHEF_DEPARTEMENT);
        employeService.ajouterEmploye(employe);
        Departement departement = new Departement("testing");
        entrepriseService.ajouterDepartement(departement);
        employeService.affecterEmployeADepartement(employe.getId(), departement.getId());
    }

    @Test
    public void getSalaireByEmployeIdJPQL() {
    	Employe employe = new Employe("h", "b", "h@esprit.tn", true, Role.CHEF_DEPARTEMENT);
        employeService.ajouterEmploye(employe);
        Date date = new Date();
        Contrat contrat = new Contrat(date, "CDD", 1000);
        employeService.ajouterContrat(contrat);
        employeService.affecterContratAEmploye(contrat.getReference(), employe.getId());
    
        float salaire = employeService.getSalaireByEmployeIdJPQL(employe.getId());
        l.info(" le salaire %d",salaire);
        
    }

    @Test
    public void desaffecterEmployeDuDepartement() {
    	Employe employe = new Employe("hh", "had", "jh@esprit.tn", true, Role.CHEF_DEPARTEMENT);
        employeService.ajouterEmploye(employe);
        Entreprise entreprise = new Entreprise("premiére entreprise", "raison");
        Departement departement = new Departement("Geo");
        departement.setEntreprise(entreprise);
        entrepriseService.ajouterEntreprise(entreprise);
        entrepriseService.ajouterDepartement(departement);
        employeService.desaffecterEmployeDuDepartement(employe.getId(), departement.getId());
    }

    @Test
    @Order(8)
    public void deleteContrat() {
        Date date = new Date();
        Contrat contrat = new Contrat(date, "CDD", 1000);
        employeService.ajouterContrat(contrat);
        
        employeService.deleteContratById(contrat.getReference());
       
        l.info("Le contrat est supprimé");
    }

    @Test
    public void deleteEmploye() {
    	Employe employe = new Employe("ha", "hi", "hah@esprit.tn", true, Role.CHEF_DEPARTEMENT);
        employeService.ajouterEmploye(employe);
     
        employeService.deleteEmployeById(employe.getId());
       
        l.info("L'employé est supprimé");
    }

    @Test
    public void deleteAllContrat() {
        employeService.deleteAllContratJPQL();
      
        l.info("tous les contrats sont supprimés");
    }

  
}
