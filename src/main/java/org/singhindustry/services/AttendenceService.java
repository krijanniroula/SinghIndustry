package org.singhindustry.services;

import java.util.ArrayList;
import java.util.List;

import org.singhindustry.entities.Attendence;
import org.singhindustry.repositories.AttendenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendenceService {
	
	@Autowired
	private AttendenceRepository attendenceRepository;
	
	public AttendenceService(AttendenceRepository attendenceRepository) {
        this.attendenceRepository = attendenceRepository;
    }

    public List<Attendence> findAll() {
        List<Attendence> attendences = new ArrayList<>();
        attendences = attendenceRepository.findAll();
        return attendences;
    }

    public Attendence findattendence(int id) {
        return attendenceRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
    	attendenceRepository.deleteById(id);

    }
    
      public void save(Attendence attendence) {
    	attendenceRepository.save(attendence);
    }

}
