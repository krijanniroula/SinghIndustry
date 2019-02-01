package org.singhindustry.repositories;

import org.singhindustry.entities.Cutting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuttingRepository extends JpaRepository<Cutting, Integer>{

}
