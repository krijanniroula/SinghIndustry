package org.singhindustry.services;

import java.util.ArrayList;
import java.util.List;

import org.singhindustry.entities.Rent;
import org.singhindustry.repositories.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentService {
	
	@Autowired
	private RentRepository rentRepository;
	
	public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    public List<Rent> findAll() {
        List<Rent> rents = new ArrayList<>();
        rents = rentRepository.findAll();
        return rents;
    }

    public Rent findrent(int id) {
        return rentRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
    	rentRepository.deleteById(id);

    }
    
      public void save(Rent rent) {
    	rentRepository.save(rent);
    }

}
