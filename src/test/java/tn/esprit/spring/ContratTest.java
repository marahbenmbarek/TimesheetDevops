package tn.esprit.spring;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.services.IContratService;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ContratTest {

    private final static Logger logger = LogManager.getLogger(DepartementTest.class);

    public ContratTest() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Autowired
    private IContratService contratService;
    @Mock
    private ContratRepository contratRepository;

    
    @Test
    public void testAddContrat() throws ParseException {
    	logger.info("In testAddContrat() : ");
    	logger.debug("adding contract is starting .");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse("2020-10-30");
        Contrat contrat = new Contrat(1,date,"hazem", 500);
        int ContratAdded = contratService.ajouterContrat(contrat);
        assertEquals(contrat.getReference(), ContratAdded);
        long start = System.currentTimeMillis();
        long elapsedTime = System.currentTimeMillis() - start;
        logger.info("Method execution time: " + elapsedTime + " milliseconds.");
        logger.info("Ajout Contrat list is here");
    }

    @Test
    public void testRetrieveAllContrat() {
    	logger.info("In testRetrieveAllContrat() : ");
    	logger.debug("getting all contracts is starting .");
        List<Contrat> listEmployes = contratService.getAllContrats();
        assertEquals(false, listEmployes.isEmpty());
        long start = System.currentTimeMillis();
        long elapsedTime = System.currentTimeMillis() - start;
        logger.info("Method execution time: " + elapsedTime + " milliseconds.");
        logger.info("RetrieveAllContrat list is here");
    }

    @Test
    public void testGetContratById() throws ParseException {
    	logger.info("In testGetContratById() : ");
    	logger.debug("getting contract by Id is starting .");
        try{
            Contrat contratretrieved = contratService.getContratById(1);
            assertNotNull(contratretrieved);
            long start = System.currentTimeMillis();
            long elapsedTime = System.currentTimeMillis() - start;
            logger.info("Method execution time: " + elapsedTime + " milliseconds.");
            logger.info("Contrat By Id list is here");
        }catch(Exception e){
            logger.error("somthing went wrong or this contrat don't exist");;
        }
    }

    @Test
    public void testDeleteContratById() throws ParseException {
    	logger.info("In testDeleteContratById() : ");
    	logger.debug("deleting contract by Id is starting .");
        try {
       	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse("2020-10-30");
            Contrat contrat = new Contrat(date,"hazem", 500);
            int ContratAdded = contratService.ajouterContrat(contrat);
            contratService.deleteById(ContratAdded);
            assertNull(contratRepository.findById(ContratAdded));
            long start = System.currentTimeMillis();
            long elapsedTime = System.currentTimeMillis() - start;
            logger.info("Method execution time: " + elapsedTime + " milliseconds.");
            logger.info("get Contrat By Id list is here");
        } catch (Exception e) {
        	 logger.error("contrat with reference 1 not founded");
        }
    }
}
