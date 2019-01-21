package org.singhindustry.repositories;

import java.util.List;

import org.singhindustry.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	List<User> findByNameLike(String name);
}
