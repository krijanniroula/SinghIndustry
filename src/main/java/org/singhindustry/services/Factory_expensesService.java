package org.singhindustry.services;

import java.util.ArrayList;
import java.util.List;

import org.singhindustry.entities.Factory_expenses;
import org.singhindustry.repositories.Factory_expensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Factory_expensesService {
	
	@Autowired
	private Factory_expensesRepository factory_expensesRepository;
	
	public Factory_expensesService(Factory_expensesRepository factory_expensesRepository) {
        this.factory_expensesRepository = factory_expensesRepository;
    }

    public List<Factory_expenses> findAll() {
        List<Factory_expenses> factory_expenses = new ArrayList<>();
        factory_expenses = factory_expensesRepository.findAll();
        return factory_expenses;
    }

    public Factory_expenses findfactory_expenses(int id) {
        return factory_expensesRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
    	factory_expensesRepository.deleteById(id);

    }
    
      public void save(Factory_expenses factory_expenses) {
    	  factory_expensesRepository.save(factory_expenses);
    }

}
