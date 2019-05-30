package com.example.jpa.repository;

import java.util.List;

import com.example.jpa.model.Player;

public interface PlayerCustomRepository {

	List<Player> getNameLikeAndTeamName(String name, String teamName);

}
