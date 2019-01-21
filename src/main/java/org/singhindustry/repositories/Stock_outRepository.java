package org.singhindustry.repositories;

import org.singhindustry.entities.Stock_out;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Stock_outRepository extends JpaRepository<Stock_out, Integer>{

}
