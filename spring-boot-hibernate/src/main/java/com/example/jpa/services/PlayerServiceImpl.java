package com.example.jpa.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.jpa.model.Player;
import com.example.jpa.model.Playerdetails;
import com.example.jpa.model.Team;
import com.example.jpa.repository.PlayerDetailJPARepository;
import com.example.jpa.repository.PlayerJPARepository;
import com.example.jpa.repository.PlayerRepository;
import com.example.jpa.repository.TeamRepository;

@Service
public class PlayerServiceImpl implements PlayerService {
	
//	@Autowired
//	private PlayerRepository playerRepository;
	
	@Autowired
	private PlayerJPARepository playerRepository;
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private PlayerDetailJPARepository playerDetailJPARepository;

	public List<String> getAllTeamPlayers(long teamId) {
		List<String> result = new ArrayList<String>();
		List<Player> players = playerRepository.findByTeamId(teamId);
		for (Player player : players) {
			result.add(player.getName());
		}

		return result;
	}

	public void addPlayer(String name, String position, int number) {
		
		Team barcelona = teamRepository.findById(1L).get();
		
		Player newPlayer = new Player();
		newPlayer.setName(name);
		newPlayer.setPosition(position);
		newPlayer.setNum(number);
		newPlayer.setTeam(barcelona);
		playerRepository.save(newPlayer);
	}
	
	
	public List<Player> getNameLikeAndTeamName(String name, String teamName){
		return playerRepository.getNameLikeAndTeamName(name, teamName);
		
	}
	
	public List<Player> fetchByNameLength(Long length){
	   return playerRepository.fetchByNameLength(length);
	}

	@Override
	public List<Playerdetails> getAllPlayerDetails() {
		List<Playerdetails> playerDetailList = playerDetailJPARepository.findAll();
		return playerDetailList;
	}
	
	
}
