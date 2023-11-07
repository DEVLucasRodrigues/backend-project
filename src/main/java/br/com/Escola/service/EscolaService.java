package br.com.Escola.service;

import br.com.Escola.dto.EscolaDTO;
import br.com.Escola.mapper.CustomModelMapper;
import br.com.Escola.model.EscolaModel;
import br.com.Escola.repositories.EscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

@Service
public class EscolaService {
    @Autowired
    private EscolaRepository repository;

    public EscolaDTO create(EscolaDTO dto){
        EscolaModel model = CustomModelMapper.parseObject(dto, EscolaModel.class);
        return CustomModelMapper.parseObject(repository.save(model), EscolaDTO.class);
    }

    public EscolaDTO findById(int id){
        EscolaModel model = repository.findById(id).orElseThrow(
                ()-> new br.com.Escola.exception.ResourceNotFoundException(null));
        return CustomModelMapper.parseObject(model, EscolaDTO.class);
    }

    public Page<EscolaDTO> findAll(Pageable pageable){
        var page = repository.findAll(pageable);
        return page.map(p -> CustomModelMapper.parseObject(p, EscolaDTO.class));
    }

    public EscolaDTO update(EscolaDTO dto){
        EscolaModel model = repository.findById(dto.getId()).orElseThrow(
                () -> new br.com.Escola.exception.ResourceNotFoundException(null));
        model = CustomModelMapper.parseObject(dto, EscolaModel.class);
        return CustomModelMapper.parseObject(repository.save(model), EscolaDTO.class);
    }

    public void delete(EscolaDTO dto){
        EscolaModel model = repository.findById(dto.getId()).orElseThrow(
                () -> new br.com.Escola.exception.ResourceNotFoundException(null)
        );
        repository.delete(model);
    }

    public Page<EscolaDTO> findByName(String name, Pageable pageable){
        var page = repository.findByNameStartsWithIgnoreCase(name, pageable);
        return page.map(p -> CustomModelMapper.parseObject(p, EscolaDTO.class));
    }
}
