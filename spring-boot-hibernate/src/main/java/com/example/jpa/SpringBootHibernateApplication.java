package com.example.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpa.model.Employee;
import com.example.jpa.model.EmployeeIdentity;
import com.example.jpa.model.Player;
import com.example.jpa.model.Playerdetails;
import com.example.jpa.repository.EmployeeRepository;
import com.example.jpa.services.PlayerService;



@SpringBootApplication
public class SpringBootHibernateApplication implements CommandLineRunner{

//	@Autowired
//	EmployeeRepository employeeRepository;
	
	@Autowired
	PlayerService playerService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// to clean up the table we need
		//employeeRepository.deleteAllInBatch();
		
		//Employee emp = new Employee(new EmployeeIdentity("E1", "C1"), "thiyagu", "thiyagu@yhh.com", "5353535353");
		//employeeRepository.save(emp);
		
		//finding employee by composite key.
		//employeeRepository.findById(new EmployeeIdentity("E1", "C1"));
		
		
		//playerService.addPlayer("Lionel Messi", "Forward", 10);
		List<String> players = playerService.getAllTeamPlayers(1);
		for(String player : players)
		{
			System.out.println("Introducing player => " + player);
		}
		List<Player> playerList = playerService.getNameLikeAndTeamName("Li", "B");
		for (Player player : playerList) {
			System.out.println("Player name =>" +player.getName());
			System.out.println("player id =>"+player.getId());
		}
		
		List<Player> playerList2 = playerService.fetchByNameLength(12L);
		for (Player player : playerList2) {
			System.out.println("Player name =>" +player.getName());
			System.out.println("player id =>"+player.getId());
		}
		
		List<Playerdetails> playerDetailList = playerService.getAllPlayerDetails();
		for (Playerdetails playerdetails : playerDetailList) {
			System.out.println("player name "+playerdetails.getFirstName() );
			System.out.println("player country "+playerdetails.getCountry());
			
		}
	}
}
