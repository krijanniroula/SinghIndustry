package org.singhindustry.repositories;

import org.singhindustry.entities.Stock_in;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Stock_inRepository extends JpaRepository<Stock_in, Integer>{

}
