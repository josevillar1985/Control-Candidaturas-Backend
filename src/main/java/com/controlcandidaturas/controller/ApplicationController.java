package com.controlcandidaturas.controller;

import com.controlcandidaturas.dto.ApplicationDTO;
import com.controlcandidaturas.service.ApplicationService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public ApplicationDTO createApplication(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam String affair,
            @RequestParam String msg,
            @RequestParam String status,
            @RequestParam String date,
            @RequestParam("cv") MultipartFile cv
    ) {

        ApplicationDTO dto = new ApplicationDTO();

        dto.setName(name);
        dto.setEmail(email);
        dto.setPhone(phone);
        dto.setAffair(affair);
        dto.setMsg(msg);
        dto.setStatus(status);
        dto.setDate(LocalDate.parse(date.substring(0, 10)));

        String fileName = cv.getOriginalFilename();
        dto.setCv(fileName);

        System.out.println("Archivo recibido: " + fileName);

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
