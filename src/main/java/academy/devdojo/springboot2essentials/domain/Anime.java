package academy.devdojo.springboot2essentials.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data //Gera hashcodes, getters e setters e etc.
@AllArgsConstructor // Gerar construtores
public class Anime {
    private Long id;
    private String name;
}
