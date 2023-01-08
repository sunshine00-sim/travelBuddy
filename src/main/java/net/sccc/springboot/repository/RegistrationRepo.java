package net.sccc.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import net.sccc.springboot.model.UserRegistration;

public interface RegistrationRepo extends JpaRepository<UserRegistration, Long> {
	//List<UserRegistration> findByuser_name(String user_name);
	 @Query("Select u from UserRegistration u WHERE u.email_id=:email_id AND u.password=:password")
	UserRegistration findBy(String email_id, String password);
}
