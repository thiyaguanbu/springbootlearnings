package com.example.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.example.jpa.model.Player;

public class PlayerCustomRepositoryImpl implements PlayerCustomRepository{
	
	/**
	 * Expresses a dependency on a container-managed EntityManager and its associated persistence context
	 */
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Player> getNameLikeAndTeamName(String name, String teamName) {
		Query query = entityManager.createNativeQuery("SELECT p.* FROM PLAYER p, TEAM t WHERE p.team_id = t.id AND p.name Like ? AND t.name Like ? ",Player.class);
		query.setParameter(1, name+"%");
		query.setParameter(2, teamName+"%");
		List<Player> playerList  = query.getResultList();
		if(playerList.size()>0)
			return playerList;
		
		
		return null;
	}

}
