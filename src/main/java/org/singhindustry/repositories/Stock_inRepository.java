package org.singhindustry.repositories;

import org.singhindustry.entities.Stock_in;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Stock_inRepository extends JpaRepository<Stock_in, Integer>{
	
	@Query("select si from Stock_in si where si.product = :product")
	Stock_in findByProduct(@Param("product") String product);

}
