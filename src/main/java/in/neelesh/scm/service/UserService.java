package in.neelesh.scm.service;


import in.neelesh.scm.dto.UserDto;
import in.neelesh.scm.model.User;

public interface UserService {

	User createUser(UserDto userDto) throws Exception;
}
