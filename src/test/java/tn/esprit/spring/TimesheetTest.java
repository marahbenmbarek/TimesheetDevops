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
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.TimesheetRepository;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.TimesheetServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TimesheetTest {

	public TimesheetTest() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
    private TimesheetRepository timesheetRepository;
    @Autowired
    private TimesheetServiceImpl timesheetService;
    private final static Logger l = LogManager.getLogger(TimesheetTest.class);
    
    @Test
    public void ajouterMissionTest() {
       Mission mission = new Mission();
       mission.setName("missionMarah");
       mission.setDescription("MissionImposible");
     timesheetService.ajouterMission(mission);
        
        long start = System.currentTimeMillis();
        long elapsedTime = System.currentTimeMillis() - start;
        l.info("Method execution time: " + elapsedTime + " milliseconds.");
        l.info("Mission est ajoutée");
    }
}


