package org.singhindustry.repositories;

import org.singhindustry.entities.Karigar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KarigarRepository extends JpaRepository<Karigar, Integer>{

}
