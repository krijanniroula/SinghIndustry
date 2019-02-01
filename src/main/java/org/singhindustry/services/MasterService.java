package org.singhindustry.services;

import java.util.ArrayList;
import java.util.List;

import org.singhindustry.entities.Master;
import org.singhindustry.repositories.MasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MasterService {
	
	@Autowired
	private MasterRepository masterRepository;
	
	public MasterService(MasterRepository masterRepository) {
        this.masterRepository = masterRepository;
    }

    public List<Master> findAll() {
        List<Master> masters = new ArrayList<>();
        masters = masterRepository.findAll();
        return masters;
    }

    public Master findMaster(int id) {
        return masterRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
    	masterRepository.deleteById(id);

    }
    
      public void save(Master master) {
    	masterRepository.save(master);
    }

}
