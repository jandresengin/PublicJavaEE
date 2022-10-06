package Project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




@Configuration
public class PlayerCacheConfig {

	@Bean
	public PlayerCache getPlayerCache() {
		return new PlayerCache();
	}
	
	@Bean
	public PageCounter getPageCounter() {
		return new PageCounter();
	}
	
	
}
