package com.example.jpa.services;

import java.util.List;

import com.example.jpa.model.Player;
import com.example.jpa.model.Playerdetails;

public interface PlayerService {
	
	public List<String> getAllTeamPlayers(long teamId);
	public void addPlayer(String name, String position, int number);
	public List<Player> getNameLikeAndTeamName(String name, String teamName);
	public List<Player> fetchByNameLength(Long length);
	public List<Playerdetails> getAllPlayerDetails();
}
