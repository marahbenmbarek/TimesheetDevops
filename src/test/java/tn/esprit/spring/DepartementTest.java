package tn.esprit.spring;

import java.text.ParseException;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.services.IDepartementService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DepartementTest {
	
	  private final static Logger logger = LogManager.getLogger(DepartementTest.class);
	  public DepartementTest() {
		super();
		// TODO Auto-generated constructor stub
	}
	  
	@Autowired
	private IDepartementService departmentService;

	@Mock
	private DepartementRepository departementRepo;
	
	@Test
	public void getAllDeppartments() {
		Mockito.when(departementRepo.findAll()).thenReturn(new ArrayList());
		List<Departement> department = departmentService.getAllDepartements();
		Assert.assertEquals(department.isEmpty(), department.isEmpty());
	    long start = System.currentTimeMillis();
	    long elapsedTime = System.currentTimeMillis() - start;
		logger.info("Method execution time: " + elapsedTime + " milliseconds.");
		logger.info("department list is here");
	}

	@Test
	public void testAjoutDepartement() throws ParseException {
		Entreprise entreprise= new Entreprise(2);
		Departement departement = new Departement("test",entreprise);
		Departement departementAdded = departmentService.ajouterDepartement(departement);
		Assert.assertEquals(departement.getName(),departementAdded.getName());
		long start = System.currentTimeMillis();
		long elapsedTime = System.currentTimeMillis() - start;
		logger.info("Method execution time: " + elapsedTime + " milliseconds.");
		logger.info("AjoutDepartement list is here");
	}

	@Test
	public void deleteContrat() throws ParseException {
		try {
			departmentService.deleteAll();
			long start = System.currentTimeMillis();
			long elapsedTime = System.currentTimeMillis() - start;
			logger.info("Method execution time: " + elapsedTime + " milliseconds.");
			logger.info("delete contrat list is here");
		} catch (Exception e) {
			System.out.println("contrat with reference 2 not founded");
		}
	}

}
