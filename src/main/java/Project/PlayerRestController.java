package Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class PlayerRestController {


	@SuppressWarnings("unused")
	@Autowired
	private PlayerCache playerCache;
	
	@Autowired
	private PageCounter pageCounter;
	
	@Autowired
	private PlayerRepository playerDb;
	
	@Operation(summary = "This is to get the data of a player from the name stored in db")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
			description = "Fetched a player from Db",
			content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "404",
			description = "Not available",
			content= @Content)
			
	})
	
	@GetMapping("/findbyname") //mywebsite.com/findbyname?name=joe bob
	public Player findByName(@RequestParam String name) {
		
		return playerDb.findByName(name);
	}
	@Operation(summary = "This is to get the number of player registered from the stored in db")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
			description = "Fetched a number of player in Db",
			content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "404",
			description = "Not available",
			content= @Content)
			
	})
	@GetMapping("/numberOfPlayers")
	public Long numberOfPlayers() {
		return playerDb.count();
	}
	@Operation(summary = "This method returns the number of times the user requests any of the 3 web pages, since the last server restart.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
			description = "Gets the number of visits made by the user",
			content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "404",
			description = "Not available",
			content= @Content)
			
	})
	@GetMapping("/currentcount") //Counter hits on web page.
	public Integer numberPageCounter() {
		return pageCounter.getPageCounter();
	}
}
