
package com.example.springProject.service;

import com.example.springProject.entity.Enseignant;
import com.example.springProject.entity.Structure;
import com.example.springProject.repository.EnseignantRepository;
import com.example.springProject.repository.StructureRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class EnseignantService {
    @Autowired
    private EnseignantRepository enseignantRepository;
    @Autowired
    private StructureRepository structureRepository;
    public EnseignantService() {
    }
    public List<Enseignant> getAllEnseignants() {
        List<Enseignant> enseignants = new ArrayList();
        enseignants.addAll(this.enseignantRepository.findAll());
        return enseignants;
    }
    public Enseignant getEnseignantById(int id) {
        return this.enseignantRepository.findById(id);
    }

    public void saveOrUpdate(Enseignant enseignant ) {

        this.enseignantRepository.save(enseignant);
    }

    public void delete(int id) {
        this.enseignantRepository.deleteById(id);
    }

    public void update(Enseignant enseignant, int id) {
        this.enseignantRepository.save(enseignant);
    }
    public Enseignant assignStructureToEnseignant(int structureId, int enseignantId){

        Enseignant enseignant = this.enseignantRepository.findById(enseignantId) ;
        System.out.println(enseignant);
        Structure structure = this.structureRepository.findById(structureId);
        System.out.println(enseignant);
        enseignant.setStructure(structure);
        System.out.println(enseignant);
        this.enseignantRepository.save(enseignant);
         return enseignant;
    }
    public Page<Enseignant> getEnseignantPagination(Integer pageNumber, Integer pageSize, String sortProperty) {
        Pageable pageable = null;
        if (null != sortProperty) {
            pageable = PageRequest.of(pageNumber, pageSize, Direction.ASC, new String[]{sortProperty});
        } else {
            pageable = PageRequest.of(pageNumber, pageSize, Direction.ASC, new String[]{"id"});
        }

        return this.enseignantRepository.findAll(pageable);
    }
}

