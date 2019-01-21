package org.singhindustry.services;

import java.util.ArrayList;
import java.util.List;

import org.singhindustry.entities.Stock_out;
import org.singhindustry.repositories.Stock_outRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Stock_outService {
	
	@Autowired
	private Stock_outRepository stock_outRepository;
	
	public Stock_outService(Stock_outRepository stock_outRepository) {
        this.stock_outRepository = stock_outRepository;
    }

    public List<Stock_out> findAll() {
        List<Stock_out> stock_outs = new ArrayList<>();
        stock_outs = stock_outRepository.findAll();
        return stock_outs;
    }

    public Stock_out findstock_out(int id) {
        return stock_outRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
    	stock_outRepository.deleteById(id);

    }
    
      public void save(Stock_out stock_out) {
    	stock_outRepository.save(stock_out);
    }

}
