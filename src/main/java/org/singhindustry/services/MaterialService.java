package org.singhindustry.services;

import java.util.ArrayList;
import java.util.List;

import org.singhindustry.entities.Material;
import org.singhindustry.repositories.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialService {
	
	@Autowired
	private MaterialRepository materialRepository;
	
	public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    public List<Material> findAll() {
        List<Material> materials = new ArrayList<>();
        materials = materialRepository.findAll();
        return materials;
    }

    public Material findMaterial(int id) {
        return materialRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
    	materialRepository.deleteById(id);

    }
    
      public void save(Material material) {
    	materialRepository.save(material);
    }

}
