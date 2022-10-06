package Project;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository

public interface PlayerRepository extends JpaRepository<Player, Integer>{
	
	public Player findByName(String playerName);

}
