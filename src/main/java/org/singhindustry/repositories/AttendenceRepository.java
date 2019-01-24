package org.singhindustry.repositories;

import org.singhindustry.entities.Attendence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendenceRepository extends JpaRepository<Attendence, Integer>{

}
