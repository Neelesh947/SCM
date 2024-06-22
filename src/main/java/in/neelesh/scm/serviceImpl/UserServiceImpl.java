package in.neelesh.scm.serviceImpl;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import in.neelesh.scm.dto.UserDto;
import in.neelesh.scm.enums.UserRole;
import in.neelesh.scm.model.User;
import in.neelesh.scm.repository.UserRepository;
import in.neelesh.scm.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	public User createUser(UserDto userDto) throws IOException,Exception{
		User existingUser=this.userRepository.findByEmail(userDto.getEmail());
		if(existingUser!=null)
		{
			throw new Exception("USER_ALREADY_EXIST"); 
		}
		else {
			User user = new User();
            String uuid = UUID.randomUUID().toString();
            user.setId(uuid);
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            user.setAbout(userDto.getAbout());
            user.setGender(userDto.getGender());
            user.setPhoneNumber(userDto.getPhoneNumber());
            if(user.getUserRole()==null)
			{
				user.setUserRole(UserRole.USER);
			}
            user.setEnabled(userDto.isEnabled());
            user.setEmailVerified(userDto.isEmailVerified());
            user.setPhoneVerified(userDto.isPhoneVerified());
            user.setProviderUserId(userDto.getProviderUserId());

            MultipartFile profilePicFile = userDto.getProfilePicFile();
            if (profilePicFile != null && !profilePicFile.isEmpty()) {
                user.setProfilePic(profilePicFile.getBytes());
            }
			
			existingUser=this.userRepository.save(user);
		}
		return this.userRepository.save(existingUser);
	}

}
