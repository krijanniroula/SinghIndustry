package org.singhindustry.services;

import java.util.ArrayList;
import java.util.List;

import org.singhindustry.entities.Kharcha;
import org.singhindustry.repositories.KharchaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KharchaService {
	
	@Autowired
	private KharchaRepository kharchaRepository;
	
	public KharchaService(KharchaRepository kharchaRepository) {
        this.kharchaRepository = kharchaRepository;
    }

    public List<Kharcha> findAll() {
        List<Kharcha> kharchas = new ArrayList<>();
        kharchas = kharchaRepository.findAll();
        return kharchas;
    }

    public Kharcha findkharcha(int id) {
        return kharchaRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
    	kharchaRepository.deleteById(id);

    }
    
      public void save(Kharcha kharcha) {
    	kharchaRepository.save(kharcha);
    }

}
