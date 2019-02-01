package org.singhindustry.services;

import java.util.ArrayList;
import java.util.List;

import org.singhindustry.entities.Daily_basic;
import org.singhindustry.repositories.Daily_basicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Daily_basicService {
	
	@Autowired
	private Daily_basicRepository daily_basicRepository;
	
	public Daily_basicService(Daily_basicRepository daily_basicRepository) {
        this.daily_basicRepository = daily_basicRepository;
    }

    public List<Daily_basic> findAll() {
        List<Daily_basic> daily_basics = new ArrayList<>();
        daily_basics = daily_basicRepository.findAll();
        return daily_basics;
    }

    public Daily_basic findDaily_basic(int id) {
        return daily_basicRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
    	daily_basicRepository.deleteById(id);

    }
    
      public void save(Daily_basic daily_basic) {
    	daily_basicRepository.save(daily_basic);
    }

}
