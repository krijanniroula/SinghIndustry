package org.singhindustry.services;

import java.util.ArrayList;
import java.util.List;

import org.singhindustry.entities.Cutting;
import org.singhindustry.repositories.CuttingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuttingService {
	
	@Autowired
	private CuttingRepository cuttingRepository;
	
	public CuttingService(CuttingRepository cuttingRepository) {
        this.cuttingRepository = cuttingRepository;
    }

    public List<Cutting> findAll() {
        List<Cutting> karigars = new ArrayList<>();
        karigars = cuttingRepository.findAll();
        return karigars;
    }

    public Cutting findcutting(int id) {
        return cuttingRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
    	cuttingRepository.deleteById(id);

    }
    
      public void save(Cutting cutting) {
    	cuttingRepository.save(cutting);
    }

}
