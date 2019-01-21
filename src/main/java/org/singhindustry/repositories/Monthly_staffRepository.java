package org.singhindustry.repositories;

import org.singhindustry.entities.Monthly_staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Monthly_staffRepository extends JpaRepository<Monthly_staff, Integer>{

}
