package Project;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PlayerCacheTest {
	private PlayerCache toTest;
	// Player 1
	
	Player player1 = new Player(1, "Jairo", 32, "Rinty", "Rinty@gmail.com");
	// Player 2
	Player player2= new Player(2, "Andres", 23, "Chivas", "Chivas2001@hotmail.com");
	// Player 3
	Player player3= new Player(3, "Andy", 28, "Shaya", "Shaya@hotmail.ca");
	// Player 3
	Player player4= new Player(4, "Rodolfo", 48, "Buffalo", "Rodolfo1978@hotmail.com");
	@BeforeEach
	public void setup() {
		toTest = new PlayerCache();
		toTest.addPlayer(player1);
		toTest.addPlayer(player2);
		toTest.addPlayer(player3);
		toTest.addPlayer(player4);
	}
	@Test
	void findByNameTest() {
		Player result = toTest.findByName("Andy");
		Assertions.assertEquals(player3, result);
	}
	@Test
	void listPlayersTest() {
		List<Player> result = toTest.listPlayers();
		Assertions.assertEquals(result.size(),4);
		Assertions.assertEquals(result.get(0),player1);
		Assertions.assertEquals(result.get(1),player2);
		Assertions.assertEquals(result.get(2),player3);
		Assertions.assertEquals(result.get(3),player4);
	}
}
