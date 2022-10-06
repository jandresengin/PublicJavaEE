package Project;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class PageCounter {
	
	private Integer pageCounter;
	
	public PageCounter() {
		this.pageCounter = 0;
	}	
	
	
	public void incrementPageCounter() {
		this.pageCounter++;
	}
	
	public Integer getPageCounter() {
		return pageCounter;
	}
	
}
