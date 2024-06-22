package in.neelesh.scm.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UserDto {

	  	private String id;
	    private String name;
	    private String email;
	    private String password;
	    private String about;
	    private MultipartFile profilePicFile;
	    private String gender;
	    private String phoneNumber;
	    private boolean enabled = false;
	    private boolean emailVerified = false;
	    private boolean phoneVerified = false;
	    private String providerUserId;
	    private String userRole;
}
