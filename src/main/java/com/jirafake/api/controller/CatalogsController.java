package com.jirafake.api.controller;

import java.util.List;

import com.jirafake.api.dto.PriorityDTO;
import com.jirafake.api.dto.TypeDTO;
import com.jirafake.api.service.CatalogsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/catalogs")
public class CatalogsController {
    
    @Autowired
    private CatalogsService catalogsService;

    @CrossOrigin
    @GetMapping("/types")
    public ResponseEntity<List<TypeDTO>> getTypes() {
        return ResponseEntity.ok(catalogsService.getTypes());
    }

    @CrossOrigin
    @GetMapping("/priorities")
    public ResponseEntity<List<PriorityDTO>> getPriorities() {
        return ResponseEntity.ok(catalogsService.getPriorities());
    }
}
