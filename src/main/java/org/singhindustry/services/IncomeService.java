package org.singhindustry.services;

import java.util.ArrayList;
import java.util.List;

import org.singhindustry.entities.Income;
import org.singhindustry.repositories.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncomeService {
	
	@Autowired
	private IncomeRepository incomeRepository;
	
	public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public List<Income> findAll() {
        List<Income> income = new ArrayList<>();
        income = incomeRepository.findAll();
        return income;
    }

    public Income findincome(int id) {
        return incomeRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
    	incomeRepository.deleteById(id);

    }
    
      public void save(Income income) {
    	  incomeRepository.save(income);
    }

}
