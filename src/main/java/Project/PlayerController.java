package Project;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;





@Controller
public class PlayerController {
	
	
	@Autowired
	private PlayerCache playerCache;
	
	@Autowired
	private PlayerRepository playerDb;
	
	@Autowired
	private PageCounter pageCounter;
	
	@GetMapping("/create")
	public String playerForm(Model model) {
		pageCounter.incrementPageCounter();
		model.addAttribute("player", new Player());
		return "playerform";
	}
	
	@PostMapping("/create")
	public String createPlayer(@Valid Player toSave, BindingResult bindingResult) {
		pageCounter.incrementPageCounter();
		if(bindingResult.hasErrors()) {
			return "playerform";
		} else {
			playerDb.save(toSave);
			playerCache.addPlayer(toSave); // local variable only for tests, because the normal behavior is to have the variables empty
			return "saved";
		}
	}
	
	@GetMapping("/allplayers")
	public String listAllPlayers(Model model) {
		pageCounter.incrementPageCounter();
		model.addAttribute("players", playerDb.findAll());
		return "listplayers";
	}

}
