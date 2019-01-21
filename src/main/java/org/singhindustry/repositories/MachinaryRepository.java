package org.singhindustry.repositories;

import org.singhindustry.entities.Machinary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachinaryRepository extends JpaRepository<Machinary, Integer>{

}
