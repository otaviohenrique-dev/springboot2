package academy.devdojo.springboot2essentials.controller;
import academy.devdojo.springboot2essentials.domain.Anime;
import academy.devdojo.springboot2essentials.services.AnimeService;
import academy.devdojo.springboot2essentials.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {
    private final AnimeService animeService;
    @GetMapping
    public ResponseEntity<List<Anime>> list (){
        log.info(LocalDateTime.now());
        return ResponseEntity.ok(animeService.listAll());
        /*A classse ResponseEntity serve para retorna informações adcionais a mais na reuquição, acima ele faz com que retorne o status 200*/
        //return new ResponseEntity<>(animeService.listAll(), HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> getById (@PathVariable Long id){
        return ResponseEntity.ok(animeService.getById(id));
    }
    @PostMapping
    public ResponseEntity<Anime> save(@RequestBody Anime anime){
        return new ResponseEntity<>(animeService.save(anime), HttpStatus.CREATED);
    }
    @DeleteMapping(path = "/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Long  id){
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    public ResponseEntity<Anime> replace(@RequestBody Anime anime){
        animeService.replace(anime);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
