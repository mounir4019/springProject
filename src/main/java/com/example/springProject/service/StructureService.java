
package com.example.springProject.service;
import com.example.springProject.entity.Structure;
import com.example.springProject.repository.StructureRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StructureService {
    @Autowired
    StructureRepository structureRepository;

    public StructureService() {
    }
    public List<Structure> getAllStructures() {
        List<Structure> structures = new ArrayList();
//        structures.addAll(this.structureRepository.findAll());
        structures.addAll(this.structureRepository.findAllByTypeStructure(0));
        return structures;
    }
    public Structure getStructureById(int id) {
        return this.structureRepository.findById(id);
    }

    public void saveOrUpdate(Structure structure) {
        this.structureRepository.save(structure);
    }

    public void delete(int id) {
        this.structureRepository.deleteById(id);
    }

    public void update(Structure structure, int id) {
        this.structureRepository.save(structure);
    }


}

