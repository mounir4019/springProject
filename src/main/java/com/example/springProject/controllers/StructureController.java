package com.example.springProject.controllers;

import com.example.springProject.entity.Structure;
import com.example.springProject.service.StructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
public class StructureController {
    @Autowired
    StructureService structureService;
    @GetMapping({"/structures"})
    @CrossOrigin(origins = "*")
    private List<Structure> getAllStructures() {
        return this.structureService.getAllStructures();
    }

    @GetMapping({"/structures/{structureId}"})
    private Structure getStructure(@PathVariable("structureId") int id) {
        return this.structureService.getStructureById(id);
    }
}
