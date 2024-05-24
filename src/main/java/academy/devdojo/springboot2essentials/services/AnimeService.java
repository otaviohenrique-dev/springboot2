package academy.devdojo.springboot2essentials.services;

import academy.devdojo.springboot2essentials.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class AnimeService {
    private List<Anime> animes = List.of(new Anime(1L, "Naruto"), new Anime(2L, "DBZ"), new Anime(3L, "TT444567686867dgdfgdfgdfgdfg67"));
    public List<Anime> listAll (){
        return animes;
    };
    public Anime getById(Long id){
        return  animes.stream()
                .filter(anime -> anime.getId().equals(id))
                .findAny()
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime Not Found"));

    }
}
