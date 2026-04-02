package com.controlcandidaturas.service;

import com.controlcandidaturas.dto.ApplicationDTO;
import com.controlcandidaturas.mapper.ApplicationMapper;
import com.controlcandidaturas.model.Application;
import com.controlcandidaturas.repository.ApplicationRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ApplicationService {

    private final ApplicationRepository repo;

    public ApplicationService(ApplicationRepository repo) {
        this.repo = repo;

    }

    public List<ApplicationDTO> getAllApllication() {
        return repo.findAll()
                .stream()
                .map(ApplicationMapper::toDTO)
                .toList();
    }
    public ApplicationDTO getApplicationById(Long id) {
        return ApplicationMapper.toDTO(repo.findById(id).orElseThrow(() -> new RuntimeException("Aplicacion no encontrada")));
    }

    @Transactional
    public ApplicationDTO createApplication(ApplicationDTO dto) {
        Application app = ApplicationMapper.toEntity(dto);
        LocalDate date = dto.getDate() == null ? LocalDate.now() : dto.getDate();
        app.setDate(date);
        repo.save(app);
        return ApplicationMapper.toDTO(app);
    }
    public ApplicationDTO updateApplication(Long id, ApplicationDTO dto){
        Application app = repo.findById(id).orElseThrow(() -> new RuntimeException("Aplicacion no encontada"));
        app.setName(dto.getName());
        app.setEmail(dto.getEmail());
        app.setAffair(dto.getAffair());
        app.setPhone(dto.getPhone());
        app.setCv(dto.getCv());
        app.setStatus(dto.getStatus());
        app.setMsg(dto.getMsg());
        app.setDate(dto.getDate());
        app = repo.save(app);
        return ApplicationMapper.toDTO(app);
    }

    public void deleteApplication(Long id) {
        repo.deleteById(id);
    }
}