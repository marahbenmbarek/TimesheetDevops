package tn.esprit.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.EntrepriseServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EntrepriseTest {
	@Autowired EntrepriseServiceImpl Entreprisee ;
	
	
	public EntrepriseTest(){
		
	}
	
	
	@Test
	public void ajouterEntreprise ()
	{
		Entreprise entreprise = new Entreprise() ;
		entreprise.setName("IPACT");
		entreprise.setRaisonSocial("azerty");
		List<Departement> list = new ArrayList();
		list.add(new Departement(1,"physique"));
	
		//entreprise.setDepartements(list);
		Entreprisee.ajouterEntreprise(entreprise);
	}
	

}
