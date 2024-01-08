package com.selenuix.runicarena.services;

import com.selenuix.runicarena.entities.Type;
import com.selenuix.runicarena.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;

    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    public Type getTypeById(Integer id) {
        Optional<Type> optionalType = typeRepository.findById(id);
        return optionalType.orElse(null);
    }

    public Type createType(Type type) {
        return typeRepository.save(type);
    }

    public boolean deleteType(Integer id) {
        Optional<Type> optionalType = typeRepository.findById(id);

        if (optionalType.isPresent()) {
            typeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
