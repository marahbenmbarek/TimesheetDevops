package tn.esprit.spring;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
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
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;

import tn.esprit.spring.entities.TimesheetPK;
import tn.esprit.spring.services.IDepartementService;

import tn.esprit.spring.services.TimesheetServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TimesheetTest {

	public TimesheetTest() {
		super();
	}
	
    @Autowired
    private TimesheetServiceImpl timesheetService;
    @Autowired
	private IDepartementService departmentService;

    private final static Logger logger = LogManager.getLogger(TimesheetTest.class);
    
    @Test
    public void testAjouterMission() {
    	logger.info("Creation d'une mission");
		logger.debug("ajout mission a commencé .");
       Mission mission = new Mission();
       mission.setName("missionMarah");
       mission.setDescription("MissionImposible");
     timesheetService.ajouterMission(mission);
     assertEquals("missionMarah", mission.getName());
        
        long start = System.currentTimeMillis();
        long elapsedTime = System.currentTimeMillis() - start;
        logger.info("Method execution time: " + elapsedTime + " milliseconds.");
        logger.info("Mission est ajoutée");
    }
    
    @Test
    public void testAffecterMissionADepartement() {
    	logger.info("Creation d'une mission");
		logger.debug("ajout mission a commencé .");
    	 Mission mission = new Mission();
         mission.setName("missionMarah");
         mission.setDescription("MissionImposible");
       timesheetService.ajouterMission(mission);
       logger.info("Creation d'une entreprise");
		logger.debug("ajout entreprise a commencé .");
       Entreprise entreprise= new Entreprise(1);
		Departement departement = new Departement("test",entreprise);
		Departement departementAdded = departmentService.ajouterDepartement(departement);
		
		 timesheetService.affecterMissionADepartement(mission.getId(), departementAdded.getId());
		 
		 
		 long start = System.currentTimeMillis();
	        long elapsedTime = System.currentTimeMillis() - start;
	        logger.info("Method execution time: " + elapsedTime + " milliseconds.");
	        logger.info("Mission affecté a departement");
    	
    }
    
    @Test
	public void testAjouterTimesheet() throws ParseException{
    	
		logger.info("Creation d'une Timesheet");
		logger.debug("ajout timesheet a commencé .");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	Date dateDebut = dateFormat.parse("2020-10-30");
    	Date dateFin = dateFormat.parse("2020-10-30");
		TimesheetPK timesheetPK = new TimesheetPK();
		timesheetPK.setDateDebut(dateDebut);
		timesheetPK.setDateFin(dateFin);
		timesheetPK.setIdEmploye(1);
		timesheetPK.setIdMission(1);
		 
     timesheetService.ajouterTimesheet(1, 1, dateDebut , dateFin);  
     long start = System.currentTimeMillis();
     long elapsedTime = System.currentTimeMillis() - start;
     logger.info("Method execution time: " + elapsedTime + " milliseconds.");
     logger.info("Timesheet est ajoutée");
	
	}	
	
	@Test 
	public void testfindAllMissionByEmployeJPQL(){
		logger.info("dans testfindAllMissionByEmployeJPQL ");
		logger.debug("findAllMissionByEmployeJPQL a commencé .");
		List<Mission> missions = timesheetService.findAllMissionByEmployeJPQL(1);
		assertTrue(missions.size()<10);
		 long start = System.currentTimeMillis();
	     long elapsedTime = System.currentTimeMillis() - start;
	     logger.info("Method execution time: " + elapsedTime + " milliseconds.");
	     logger.info("Timesheet est ajoutée");
	}
	
	@Test
	public void testgetAllEmployeByMission(){
		logger.info("dans testgetAllEmployeByMission ");
		logger.debug("testgetAllEmployeByMission a commencé .");
		List<Employe> employees = timesheetService.getAllEmployeByMission(1);
		assertTrue(employees.size()<10);
		long start = System.currentTimeMillis();
	     long elapsedTime = System.currentTimeMillis() - start;
	     logger.info("Method execution time: " + elapsedTime + " milliseconds.");
	     logger.info("Timesheet est ajoutée");
		
	}
    
}


