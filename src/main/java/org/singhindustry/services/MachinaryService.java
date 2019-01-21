package org.singhindustry.services;

import java.util.ArrayList;
import java.util.List;

import org.singhindustry.entities.Machinary;
import org.singhindustry.repositories.MachinaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MachinaryService {
	
	@Autowired
	private MachinaryRepository machinaryRepository;
	
	public MachinaryService(MachinaryRepository machinaryRepository) {
        this.machinaryRepository = machinaryRepository;
    }

    public List<Machinary> findAll() {
        List<Machinary> machinary = new ArrayList<>();
        machinary = machinaryRepository.findAll();
        return machinary;
    }

    public Machinary findMachinary(int id) {
        return machinaryRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
    	machinaryRepository.deleteById(id);

    }
    
      public void save(Machinary machinary) {
    	  machinaryRepository.save(machinary);
    }

}
