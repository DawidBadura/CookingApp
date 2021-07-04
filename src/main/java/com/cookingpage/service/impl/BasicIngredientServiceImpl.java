package com.cookingpage.service.impl;

import com.cookingpage.commands.IngredientCommand;
import com.cookingpage.domain.BasicIngredient;
import com.cookingpage.repository.BasicIngredientRepository;
import com.cookingpage.service.BasicIngredientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class BasicIngredientServiceImpl implements BasicIngredientService {
    @Autowired
    BasicIngredientRepository basicIngredientRepository;

    @Override
    public BasicIngredient saveIngredientCommand(BasicIngredient command) {
        return basicIngredientRepository.save(command);
    }

    @Override
    public List<BasicIngredient> findAll() { return basicIngredientRepository.findAll(); }

    @Override
    public void deleteById(Long idToDelete) {
       basicIngredientRepository.deleteById(idToDelete);
    }
}
