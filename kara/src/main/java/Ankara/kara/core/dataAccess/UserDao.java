package Ankara.kara.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import Ankara.kara.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	User findByEmail(String e_mail);
}
