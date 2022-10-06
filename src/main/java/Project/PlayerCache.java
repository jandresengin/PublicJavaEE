package Project;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerCache {
	
	
	private List<Player> players;
	
	public PlayerCache() {
		players = new ArrayList<>();
	}
	
	public List<Player> listPlayers() {
		return this.players;
	}
	
	public void addPlayer(Player toAdd) {
		this.players.add(toAdd);
	}
	
	public Player findByName(String toFind) {
		return this.players.stream()
				.filter(u -> u.getName().equals(toFind))
				.findAny()
				.orElse(null);
	}

}
