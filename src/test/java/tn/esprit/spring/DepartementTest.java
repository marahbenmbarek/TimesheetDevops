package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;

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
import java.util.Optional;

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
	private DepartementRepository departementRepository;
	
	@Test
	public void testgetAllDeppartments() {

    	logger.info("In testgetAllDeppartments() : ");
    	logger.debug("getting departements is starting .");
		Mockito.when(departementRepository.findAll()).thenReturn(new ArrayList());
		List<Departement> department = departmentService.getAllDepartements();
		Assert.assertEquals(department.isEmpty(), department.isEmpty());
	    long start = System.currentTimeMillis();
	    long elapsedTime = System.currentTimeMillis() - start;
		logger.info("Method execution time: " + elapsedTime + " milliseconds.");
		logger.info("department list is here");
	}

	@Test
	public void testAjoutDepartement() throws ParseException {

    	logger.info("In testAjoutDepartement() : ");
    	logger.debug("adding departement is starting .");
		Entreprise entreprise= new Entreprise(1);
		Departement departement = new Departement("test",entreprise);
		Departement departementAdded = departmentService.ajouterDepartement(departement);
		Assert.assertEquals(departement.getName(),departementAdded.getName());
		long start = System.currentTimeMillis();
		long elapsedTime = System.currentTimeMillis() - start;
		logger.info("Method execution time: " + elapsedTime + " milliseconds.");
		logger.info("AjoutDepartement is here");
	}

	@Test
	public void testDeleteDepartements() throws ParseException {

    	logger.info("In testDeleteDepartements() : ");
    	logger.debug("deleting departements is starting .");
		try {
			departmentService.deleteAll();
			departementRepository.findById(1);
			assertThat(Optional.empty());
			long start = System.currentTimeMillis();
			long elapsedTime = System.currentTimeMillis() - start;
			logger.info("Method execution time: " + elapsedTime + " milliseconds.");
			logger.info("delete departements is here");
		} catch (Exception e) {
			logger.error("somthing went wrong");
		}
	}
	 @Test
	    public void testDeletedepartementById() throws ParseException {
	    	logger.info("In testDeletedepartementById() : ");
	    	logger.debug("deleting departement by Id is starting .");
	        try {
	        	departmentService.deleteDepartementById(1);
	            assertNull(departementRepository.findById(1));
	            long start = System.currentTimeMillis();
	            long elapsedTime = System.currentTimeMillis() - start;
	            logger.info("Method execution time: " + elapsedTime + " milliseconds.");
	            logger.info("get delete By Id  is here");
	        } catch (Exception e) {
	        	 logger.error("departement with id 1 not founded");
	        }
	    }
}
