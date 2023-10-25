

package com.example.springProject.controllers;

import com.example.springProject.entity.Enseignant;
import com.example.springProject.entity.Structure;
import com.example.springProject.entity.User;
import com.example.springProject.sendEmail.EmailDetails;
import com.example.springProject.sendEmail.EmailService;
import com.example.springProject.service.EnseignantService;
import com.example.springProject.service.StructureService;
import java.util.List;

import com.example.springProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;
@Controller
@RestController 
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:8080")

public class EnseignantController {
    @Autowired
    EnseignantService enseignantService;
    @Autowired
    StructureService structureService;
    @Autowired
    UserService userService  ;

    @Autowired private EmailService emailService;
    public EnseignantController() {
    }

    @GetMapping(
            path = {"/accueil"}
    )
    public String accueil() {
        return "welcome to my first MMM spring boot app";
    }

    @GetMapping({"/enseignants"})
    private List<Enseignant> getAllEnseignants() {
        return this.enseignantService.getAllEnseignants();
    }
 
    @GetMapping({"/enseignants/{enseignantId}"})
    private Enseignant getEnseignant(@PathVariable("enseignantId") int id) {
        return this.enseignantService.getEnseignantById(id);
    }
  @GetMapping({"/enseignantIu/{idUniq}"})
    private Enseignant getEnseignantIu(@PathVariable("idUniq") String idUniq) {
       User user= userService.getUserByIdUniq(  idUniq );
        return this.enseignantService.getEnseignantByUser(user);

    }

    @DeleteMapping({"/enseignants/{id}"})
    @CrossOrigin(origins = "*")
    private Enseignant deleteEnseignant(@PathVariable("id")  int id) {
        Enseignant enseignant=this.enseignantService.getEnseignantById(id);
        this.enseignantService.delete(id);
        return   enseignant ;
    }

    @PostMapping({"/enseignants/{strId}"})
    @CrossOrigin(origins = "*")
    private Enseignant saveEnseignant(@RequestBody Enseignant enseignant, @PathVariable  int  strId) {

        enseignant.setStructure(this.structureService.getStructureById(strId));
        this.enseignantService.saveOrUpdate(enseignant);
        // EmailDetails emailDetails = new EmailDetails();
        // emailDetails.setRecipient("mounir4019@gmail.com");
        // emailDetails.setMsgBody(" hello spring boot emai");
        // emailDetails.setSubject("spring boot email");
        // emailDetails.setAttachment("d:/mounirTabarka.JPG");

       // String status  = emailService.sendMailWithAttachment(emailDetails);
        return enseignant;
    }

    @PutMapping({"/enseignants/{strId}"})
    @CrossOrigin(origins = "*")
    private Enseignant updateEnseignant(@RequestBody Enseignant enseignant, @PathVariable int  strId) {
        enseignant.setStructure(this.structureService.getStructureById(strId));
        this.enseignantService.saveOrUpdate(enseignant);
        return enseignant;
    }
//    @PutMapping("/{structureId}/enseignants/{enseignantId}")
//    public Enseignant assignStructureToEnseignant(
//            @PathVariable int  structureId,
//            @PathVariable int enseignantId
//    ){
//        return enseignantService.assignStructureToEnseignant(structureId, enseignantId);
//    }
    @RequestMapping(
            value = {"/enseignants/pagingation/{pageNumber}/{pageSize}/{sortProperty}"},
            method = {RequestMethod.GET}
    )
    public Page<Enseignant> employeePagination(@PathVariable Integer pageNumber, @PathVariable Integer pageSize, @PathVariable String sortProperty) {

        return this.enseignantService.getEnseignantPagination(pageNumber, pageSize, sortProperty);
    }
}
