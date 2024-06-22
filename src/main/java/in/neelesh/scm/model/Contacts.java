package in.neelesh.scm.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Contacts {

	@Id
	private String id;
	private String name;
	private String email;
	private String phoneNumber;
	private String address;
	private String pictures;
	private String descriptions;
	private boolean favourite=false;
	private String websiteLink;
	private String linkedInLink;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private User user;
	
	@OneToMany(mappedBy = "contacts", fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<SocialLinks> links=new ArrayList<>();
}
