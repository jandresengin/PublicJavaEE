package Project;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;



@WebMvcTest(PlayerController.class)
public class PlayerControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PlayerCache mockCache;
	
	@MockBean
	private PlayerRepository mockCache2;
	
	
	@Test
	public void createNewPlayer() throws Exception {

		this.mockMvc.perform(get("/create"))
		//.andDo(print());
		.andExpect(status().isOk())
		.andExpect(view().name("playerform"))
		.andExpect(model().attribute("player", new Player()));
	}
	
	@Test
	public void createPostNewPlayer() throws Exception {
		mockMvc.perform(post("/create")
				.param("playerid", "5")
				.param("name", "James Bond")
				.param("agePlayer", "33")
				.param("avatarName", "Legolas")
				.param("email", "007Bond@gmail.com"))
		//.andDo(print());
		.andExpect(status().isOk())
		.andExpect(view().name("saved"));
		
		
		
		mockMvc.perform(post("/create")
				.param("playerid", "6")
				.param("name", "Clark Kent")
				.param("agePlayer", "29")
				.param("avatarName", "Wolverine")
				.param("email", "Xmen2010@gmail.com"))
		//.andDo(print());
		.andExpect(status().isOk())
		.andExpect(view().name("saved"));
		
		
		
		Mockito.verify(mockCache).addPlayer(Mockito.eq(new Player(6, "Clark Kent", 29, "Wolverine",  "Xmen2010@gmail.com")));// local variable only for tests, because the normal behavior is to have the variables empty
	}
	
	@Test
	public void createPostInvalidDataPlayer() throws Exception {
		
		
		
		mockMvc.perform(post("/create")
				.param("playerid", "5")
				.param("name", "James Bond")
				.param("agePlayer", "11")
				.param("avatarName", "Legolas")
				.param("email", "007Bond@gmail.com"))
		//.andDo(print());
		.andExpect(status().isOk())
		.andExpect(view().name("playerform"))
		.andExpect(model().attribute("player", new Player(5, "James Bond", 11, "Legolas",  "007Bond@gmail.com"))); // age must be greater than 18.
		
		
		
		
		
		
		//checks that never saved the user
		Mockito.verifyNoInteractions(mockCache);
		
		
		
		mockMvc.perform(post("/create")
				.param("playerid", "5")
				.param("name", "Ja")
				.param("agePlayer", "21")
				.param("avatarName", "Legolas")
				.param("email", "007Bond@gmail.com"))
		//.andDo(print());
		.andExpect(status().isOk())
		.andExpect(view().name("playerform"))
		.andExpect(model().attribute("player", new Player(5, "Ja", 21, "Legolas",  "007Bond@gmail.com"))); // name length must be greater than 4 characters.
		
		//checks that never saved the user
		Mockito.verifyNoInteractions(mockCache);
		
		mockMvc.perform(post("/create")
				.param("playerid", "5")
				.param("name", "James Bond")
				.param("agePlayer", "21")
				.param("avatarName", "Leg")
				.param("email", "007Bond@gmail.com"))
		//.andDo(print());
		.andExpect(status().isOk())
		.andExpect(view().name("playerform"))
		.andExpect(model().attribute("player", new Player(5, "James Bond", 21, "Leg",  "007Bond@gmail.com"))); // Avatar name length must be greater than 5 characters.
		
		//checks that never saved the user
		Mockito.verifyNoInteractions(mockCache);
		
		mockMvc.perform(post("/create")
				.param("playerid", "5")
				.param("name", "James Bond")
				.param("agePlayer", "21")
				.param("avatarName", "Legolas")
				.param("email", "0@g.co"))
		//.andDo(print());
		.andExpect(status().isOk())
		.andExpect(view().name("playerform"))
		.andExpect(model().attribute("player", new Player(5, "James Bond", 21, "Legolas",  "0@g.co"))); // Email length must be greater than 10 characters.
		
		//checks that never saved the user
		Mockito.verifyNoInteractions(mockCache);
	}
	
	
	
	@Test
	public void listAllPlayersTest() throws Exception {
		
		// expected
		List<Player> expectedList = new ArrayList<Player>(); 
		
		//////
		
		mockMvc.perform(get("/allplayers"))
		.andExpect(status().isOk())
		.andExpect(view().name("listplayers"))
		.andExpect(model().attribute("players", expectedList));//Player data is stored in DB
		
	}

}
