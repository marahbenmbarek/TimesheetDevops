package tn.esprit.spring;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.services.EmployeServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeTest {
	
	public EmployeTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
    private EmployeRepository employeRepository;
    @Autowired
    private EmployeServiceImpl employeService;
    private final static Logger l = LogManager.getLogger(EmployeTest.class);
    
    @Test
    public void ajoutEmploye() {
        Employe employe = new Employe();
        employe.setNom("ahmed");
        employe.setPrenom("labes");
        employe.setEmail("ahmed@esprit.tn");
        employe.setRole(Role.CHEF_DEPARTEMENT);
        employe.setActif(true);
        System.out.println(employe.getPrenom());
        employeService.addOrUpdateEmploye(employe);
        List<Departement> list = new ArrayList<>() ;
        //  employeService.ajouterEmploye(employe);
        long start = System.currentTimeMillis();
        long elapsedTime = System.currentTimeMillis() - start;
        l.info("Method execution time: " + elapsedTime + " milliseconds.");
        l.info("l'employé est ajouté");
    }
}
