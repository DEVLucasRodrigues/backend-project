package br.com.Escola.dto;

import br.com.Escola.model.EscolaModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProfessorDTO extends RepresentationModel {
    private int id;
    @NotBlank
    @Size(min = 1, max = 50)
    private String name;
    private EscolaModel escolaModel;
}
