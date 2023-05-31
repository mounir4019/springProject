
package com.example.springProject.service;

import com.example.springProject.entity.Structure;
import com.example.springProject.repository.StructureRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class StructureService {
    @Autowired
    StructureRepository structureRepository;

    public StructureService() {
    }
    public List<Structure> getAllStructures() {
        List<Structure> structures = new ArrayList();
        structures.addAll(this.structureRepository.findAll());
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

    public Page<Structure> getStructurePagination(Integer pageNumber, Integer pageSize, String sortProperty) {
        Pageable pageable = null;
        if (null != sortProperty) {
            pageable = PageRequest.of(pageNumber, pageSize, Direction.ASC, new String[]{sortProperty});
        } else {
            pageable = PageRequest.of(pageNumber, pageSize, Direction.ASC, new String[]{"id"});
        }

        return this.structureRepository.findAll(pageable);
    }
}

