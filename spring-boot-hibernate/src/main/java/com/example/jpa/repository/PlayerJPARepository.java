package com.example.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.jpa.model.Player;

@Repository
public interface PlayerJPARepository extends JpaRepository<Player, Long>, PlayerCustomRepository{
	
	List<Player> findByTeamId(long teamId);
	@Query()
	List<Player> fetchByNameLength(@Param("length") Long length);
	

}
