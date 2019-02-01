package org.singhindustry.services;

import java.util.ArrayList;
import java.util.List;

import org.singhindustry.entities.Karigar;
import org.singhindustry.repositories.KarigarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KarigarService {
	
	@Autowired
	private KarigarRepository karigarRepository;
	
	public KarigarService(KarigarRepository karigarRepository) {
        this.karigarRepository = karigarRepository;
    }

    public List<Karigar> findAll() {
        List<Karigar> karigars = new ArrayList<>();
        karigars = karigarRepository.findAll();
        return karigars;
    }

    public Karigar findKarigar(int id) {
        return karigarRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
    	karigarRepository.deleteById(id);

    }
    
      public void save(Karigar karigar) {
    	karigarRepository.save(karigar);
    }

}
