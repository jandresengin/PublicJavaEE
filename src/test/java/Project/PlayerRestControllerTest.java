package Project;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;



@WebMvcTest(PlayerRestController.class)
public class PlayerRestControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PlayerCache mockCache;
	
	@MockBean
	private PlayerRepository mockCache2;
	
	@Test
	public void numberOfPlayersTest() throws Exception {
		
		
				
		
		
		mockMvc.perform(get("/numberOfPlayers"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").value("0"));
		
	}
	
	@Test
	public void findbynameTest() throws Exception {
		
		mockMvc.perform(get("/findbyname?name=Jairo"))
		.andExpect(status().isOk());
		
	}
}
