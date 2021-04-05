package com.jirafake.api.service;

import java.util.List;
import java.util.stream.Collectors;

import com.jirafake.api.dto.PriorityDTO;
import com.jirafake.api.dto.TypeDTO;
import com.jirafake.api.repository.PriorityRepository;
import com.jirafake.api.repository.TypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogsService {
    
    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private PriorityRepository priorityRepository;

    public List<TypeDTO> getTypes() {
        return typeRepository.findAll().stream().map(TypeDTO::new).collect(Collectors.toList());
    }

    public List<PriorityDTO> getPriorities() {
        return priorityRepository.findAll().stream().map(PriorityDTO::new).collect(Collectors.toList());
    }

}
