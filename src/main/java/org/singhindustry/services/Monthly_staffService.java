package org.singhindustry.services;

import java.util.ArrayList;
import java.util.List;

import org.singhindustry.entities.Monthly_staff;
import org.singhindustry.repositories.Monthly_staffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Monthly_staffService {
	
	@Autowired
	private Monthly_staffRepository monthly_staffRepository;
	
	public Monthly_staffService(Monthly_staffRepository monthly_staffRepository) {
        this.monthly_staffRepository = monthly_staffRepository;
    }

    public List<Monthly_staff> findAll() {
        List<Monthly_staff> monthly_staffs = new ArrayList<>();
        monthly_staffs = monthly_staffRepository.findAll();
        return monthly_staffs;
    }

    public Monthly_staff findmonthly_staff(int id) {
        return monthly_staffRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
    	monthly_staffRepository.deleteById(id);

    }
    
      public void save(Monthly_staff monthly_staff) {
    	monthly_staffRepository.save(monthly_staff);
    }

}
