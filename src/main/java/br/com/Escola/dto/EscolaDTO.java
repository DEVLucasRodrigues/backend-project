package br.com.Escola.dto;

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
public class EscolaDTO extends RepresentationModel {
    private int id;
    @NotBlank
    @Size(min = 1, max = 50)
    private String name;


}
