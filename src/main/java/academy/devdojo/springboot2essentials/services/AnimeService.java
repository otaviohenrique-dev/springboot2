package academy.devdojo.springboot2essentials.services;

import academy.devdojo.springboot2essentials.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AnimeService {
    private static List<Anime> animes;
    static {
        animes = new ArrayList<>(List.of(new Anime(1L, "Naruto"), new Anime(2L, "DBZ"), new Anime(3L, "TT444567686867dgdfgdfgdfgdfg67")));
    }
    public List<Anime> listAll (){
        return animes;
    };
    public Anime getById(Long id){
        return  animes.stream()
                .filter(anime -> anime.getId().equals(id))
                .findAny()
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime Not Found"));

    }

    public Anime save(Anime anime) {
        anime.setId(ThreadLocalRandom.current().nextLong(3, 1000));
        animes.add(anime);
        return anime;
    }

    public void delete(Long id) {
        animes.remove(getById(id));
    }

    public void replace(Anime anime) {
        delete(anime.getId());
        save(anime);

    }
}
