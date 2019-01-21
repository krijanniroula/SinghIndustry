package org.singhindustry.repositories;

import org.singhindustry.entities.Factory_expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Factory_expensesRepository extends JpaRepository<Factory_expenses, Integer>{

}
