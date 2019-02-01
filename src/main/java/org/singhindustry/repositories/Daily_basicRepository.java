package org.singhindustry.repositories;

import org.singhindustry.entities.Daily_basic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Daily_basicRepository extends JpaRepository<Daily_basic, Integer>{

}
