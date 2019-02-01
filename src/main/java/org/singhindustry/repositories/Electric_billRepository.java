package org.singhindustry.repositories;

import org.singhindustry.entities.Electric_bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Electric_billRepository extends JpaRepository<Electric_bill, Integer>{

}
