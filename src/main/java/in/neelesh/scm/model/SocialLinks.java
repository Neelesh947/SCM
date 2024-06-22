package in.neelesh.scm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SocialLinks {

	@Id
	private String id;
	private String link;
	private String title;
	
	@ManyToOne
	private Contacts contacts;
}
