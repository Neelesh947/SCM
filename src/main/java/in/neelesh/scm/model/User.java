package in.neelesh.scm.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import in.neelesh.scm.enums.Providers;
import in.neelesh.scm.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	private String id;
	private String name;
	private String email;
	private String password;
	private String about;
	
	@Lob
	@Column(columnDefinition = "longblob")
	private byte[] profilePic;
	private String gender;
	private String phoneNumber;
	
	private UserRole userRole;
	
	private boolean enabled=false;
	private boolean emailVerified=false;
	private boolean phoneVerified=false;
	
	//SELF, GOOGLE, GITHUB, FACEOOK,TWITTER, LINKEDIN
	private Providers provide=Providers.SELF;
	private String providerUserId;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Contacts> contact=new ArrayList<>();
}
