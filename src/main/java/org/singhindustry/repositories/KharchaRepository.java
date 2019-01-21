package org.singhindustry.repositories;

import org.singhindustry.entities.Kharcha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KharchaRepository extends JpaRepository<Kharcha, Integer>{

}
