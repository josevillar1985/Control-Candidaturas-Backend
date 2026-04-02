package com.controlcandidaturas.controller;

import com.controlcandidaturas.dto.ApplicationDTO;
import com.controlcandidaturas.service.ApplicationService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/applications")
@CrossOrigin
public class ApplicationController {

    private final ApplicationService service;

    public ApplicationController(ApplicationService service) {
        this.service = service;
    }

    @GetMapping
    public List<ApplicationDTO> getAllApllication() {
        return service.getAllApllication();
    }

    @GetMapping("/{id}")
    public ApplicationDTO getApplicationById(@PathVariable Long id) {
        return service.getApplicationById(id);
    }

    @PostMapping
    public ApplicationDTO createApplication(@RequestBody ApplicationDTO dto) {
        System.out.println(dto);

        return service.createApplication(dto);
    }

    @PutMapping("/{id}")
    public ApplicationDTO updateApplication(@PathVariable Long id, @RequestBody ApplicationDTO dto) {
        return service.updateApplication(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable Long id) {
        service.deleteApplication(id);
    }

}
