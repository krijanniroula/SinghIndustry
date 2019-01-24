package org.singhindustry.services;

import java.util.ArrayList;
import java.util.List;

import org.singhindustry.entities.Sales;
import org.singhindustry.repositories.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesService {
	
	@Autowired
	private SalesRepository salesRepository;
	
	public SalesService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    public List<Sales> findAll() {
        List<Sales> saless = new ArrayList<>();
        saless = salesRepository.findAll();
        return saless;
    }

    public Sales findsales(int id) {
        return salesRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
    	salesRepository.deleteById(id);

    }
    
      public void save(Sales sales) {
    	salesRepository.save(sales);
    }

}
