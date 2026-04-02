package com.controlcandidaturas.mapper;

import com.controlcandidaturas.dto.ApplicationDTO;
import com.controlcandidaturas.model.Application;

import java.util.List;

public class ApplicationMapper {

    public static ApplicationDTO toDTO(Application app) {

        if (app == null) {
            throw new RuntimeException("Aplicacion no encontrada");
        }
        ApplicationDTO dto = new ApplicationDTO();

            dto.setId(app.getId());
            dto.setName(app.getName());
            dto.setEmail(app.getEmail());
            dto.setAffair(app.getAffair());
            dto.setPhone(app.getPhone());
            dto.setCv(app.getCv());
            dto.setStatus(app.getStatus());
            dto.setMsg(app.getMsg());
            dto.setDate(app.getDate());
            return dto;
    }

    public static Application toEntity(ApplicationDTO dto) {
        if (dto == null) {
            return null;
        }
        Application app = new Application();

            app.setId(dto.getId());
            app.setName(dto.getName());
            app.setEmail(dto.getEmail());
            app.setAffair(dto.getAffair());
            app.setPhone(dto.getPhone());
            app.setCv(dto.getCv());
            app.setStatus(dto.getStatus());
            app.setMsg(dto.getMsg());
            app.setDate(dto.getDate());
            return app;
        }
}

