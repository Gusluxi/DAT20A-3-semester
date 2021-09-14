package dk.kea.trash_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class PokemonController {

  List<String> pokes = Arrays.asList("Mr. Mime", "Pikachu", "Alakazam", "Machamp");

  @GetMapping("/pokemon/go")
  public boolean isGo() {
    return false;
  }

  @GetMapping("/pokemon")
  public List<String> allPokemons() {
    return pokes;
  }


}
