package br.com.Escola.service;

import br.com.Escola.dto.ProfessorDTO;
import br.com.Escola.mapper.CustomModelMapper;
import br.com.Escola.model.ProfessorModel;
import br.com.Escola.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository repository;

    public ProfessorDTO create(ProfessorDTO dto){
        ProfessorModel model = CustomModelMapper.parseObject(dto, ProfessorModel.class);
        return CustomModelMapper.parseObject(repository.save(model), ProfessorDTO.class);
    }

    public ProfessorDTO findById(int id){
        ProfessorModel model = repository.findById(id).orElseThrow(
                ()-> new br.com.Escola.exception.ResourceNotFoundException(null));
        return CustomModelMapper.parseObject(model, ProfessorDTO.class);
    }

    public Page<ProfessorDTO> findAll(Pageable pageable){
        var page = repository.findAll(pageable);
        return page.map(p -> CustomModelMapper.parseObject(p, ProfessorDTO.class));
    }

    public ProfessorDTO update(ProfessorDTO dto){
        ProfessorModel model = repository.findById(dto.getId()).orElseThrow(
                () -> new br.com.Escola.exception.ResourceNotFoundException(null));
        model = CustomModelMapper.parseObject(dto, ProfessorModel.class);
        return CustomModelMapper.parseObject(repository.save(model), ProfessorDTO.class);
    }

    public void delete(ProfessorDTO dto){
        ProfessorModel model = repository.findById(dto.getId()).orElseThrow(
                () -> new br.com.Escola.exception.ResourceNotFoundException(null)
        );
        repository.delete(model);
    }

    public Page<ProfessorDTO> findByName(String name, Pageable pageable){
        var page = repository.findByNameStartsWithIgnoreCase(name, pageable);
        return page.map(p -> CustomModelMapper.parseObject(p, ProfessorDTO.class));
    }
}