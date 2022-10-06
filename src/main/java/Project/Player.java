package Project;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;





@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer playerid;
	@NotNull
	
	@Size(min=4, max=60)
	private String name;
	@NotNull
	
	@Min(18)
	private Integer agePlayer;
	
	
	@NotNull
	@Size(min=5, max=20)

	private String avatarName;
	@NonNull
	@Size(min=10, max=30)
	@Email
	private String email;
}
