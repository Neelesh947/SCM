package in.neelesh.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.neelesh.scm.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

	public User findByEmail(String email);
}
