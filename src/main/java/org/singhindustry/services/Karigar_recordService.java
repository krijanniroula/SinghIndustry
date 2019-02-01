package org.singhindustry.services;

import java.util.ArrayList;
import java.util.List;

import org.singhindustry.entities.Karigar_record;
import org.singhindustry.repositories.Karigar_recordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Karigar_recordService {
	
	@Autowired
	private Karigar_recordRepository karigar_recordRepository;
	
	public Karigar_recordService(Karigar_recordRepository karigar_recordRepository) {
        this.karigar_recordRepository = karigar_recordRepository;
    }

    public List<Karigar_record> findAll() {
        List<Karigar_record> karigars = new ArrayList<>();
        karigars = karigar_recordRepository.findAll();
        return karigars;
    }

    public Karigar_record findKarigar_record(int id) {
        return karigar_recordRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
    	karigar_recordRepository.deleteById(id);

    }
    
      public void save(Karigar_record karigar_record) {
    	karigar_recordRepository.save(karigar_record);
    }

}
