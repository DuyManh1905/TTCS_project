package com.project.Shop.controller.api;

import com.project.Shop.dto.Material.MaterialDto;
import com.project.Shop.service.MaterialService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaterialRestController {
    private final MaterialService materialService;

    public MaterialRestController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @PostMapping("/api/material")
    public MaterialDto createMaterialApi(@RequestBody MaterialDto materialDto) {
        return materialService.createMaterialApi(materialDto);
    }
}
