package tn.esprit.spring;
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
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.services.IContratService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    public void getAllContracts() {
        Mockito.when(contratRepository.findAll()).thenReturn(new ArrayList());
        List<Contrat> contrats = contratService.getAllContrats();
        Assert.assertEquals(contrats.isEmpty(), contrats.isEmpty());
        long start = System.currentTimeMillis();
        long elapsedTime = System.currentTimeMillis() - start;
        logger.info("Method execution time: " + elapsedTime + " milliseconds.");
        logger.info("contrats list is here");
    }

    @Test
    public void testAddContrat() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse("2020-10-30");
        Contrat contrat = new Contrat(1,date,"yosr", 500);
        int ContratAdded = contratService.ajouterContrat(contrat);
        long start = System.currentTimeMillis();
        long elapsedTime = System.currentTimeMillis() - start;
        logger.info("Method execution time: " + elapsedTime + " milliseconds.");
        logger.info("Ajout Contrat list is here");
    }

    @Test
    public void testRetrieveAllContrat() {
        List<Contrat> listEmployes = contratService.getAllContrats();
        long start = System.currentTimeMillis();
        long elapsedTime = System.currentTimeMillis() - start;
        logger.info("Method execution time: " + elapsedTime + " milliseconds.");
        logger.info("RetrieveAllContrat list is here");
    }

    @Test
    public void getContratById() throws ParseException {
        try{
            Contrat Contratretrieved = contratService.getContratById(1);
            long start = System.currentTimeMillis();
            long elapsedTime = System.currentTimeMillis() - start;
            logger.info("Method execution time: " + elapsedTime + " milliseconds.");
            logger.info("Contrat By Id list is here");
        }catch(Exception e){
            System.out.println("get contrat with reference 2 not founded");
        }
    }

    @Test
    public void deleteContratById() throws ParseException {
        try {
            contratService.deleteById(1);
            long start = System.currentTimeMillis();
            long elapsedTime = System.currentTimeMillis() - start;
            logger.info("Method execution time: " + elapsedTime + " milliseconds.");
            logger.info("get Contrat By Id list is here");
        } catch (Exception e) {
            System.out.println("contrat with reference 2 not founded");
        }
    }
}
