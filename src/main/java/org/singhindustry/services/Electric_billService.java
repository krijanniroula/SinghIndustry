package org.singhindustry.services;

import java.util.ArrayList;
import java.util.List;

import org.singhindustry.entities.Electric_bill;
import org.singhindustry.repositories.Electric_billRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Electric_billService {
	
	@Autowired
	private Electric_billRepository electric_billRepository;
	
	public Electric_billService(Electric_billRepository electric_billRepository) {
        this.electric_billRepository = electric_billRepository;
    }

    public List<Electric_bill> findAll() {
        List<Electric_bill> electric_bills = new ArrayList<>();
        electric_bills = electric_billRepository.findAll();
        return electric_bills;
    }

    public Electric_bill findelectric_bill(int id) {
        return electric_billRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
    	electric_billRepository.deleteById(id);

    }
    
      public void save(Electric_bill electric_bill) {
    	electric_billRepository.save(electric_bill);
    }

}
