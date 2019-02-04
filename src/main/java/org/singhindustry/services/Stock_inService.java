package org.singhindustry.services;

import java.util.ArrayList;
import java.util.List;

import org.singhindustry.entities.Stock_in;
import org.singhindustry.repositories.Stock_inRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Stock_inService {
	
	@Autowired
	private Stock_inRepository stock_inRepository;
	
	public Stock_inService(Stock_inRepository stock_inRepository) {
        this.stock_inRepository = stock_inRepository;
    }

    public List<Stock_in> findAll() {
        List<Stock_in> stock_ins = new ArrayList<>();
        stock_ins = stock_inRepository.findAll();
        return stock_ins;
    }

    public Stock_in findstock_in(int id) {
        return stock_inRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
    	stock_inRepository.deleteById(id);

    }
    
      public void save(Stock_in stock_in) {
    	stock_inRepository.save(stock_in);
    }
      
      public Stock_in findByProduct(String product) {
    	  return stock_inRepository.findByProduct(product);
      }

}
