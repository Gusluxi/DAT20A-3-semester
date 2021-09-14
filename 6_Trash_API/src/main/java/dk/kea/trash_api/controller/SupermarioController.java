package dk.kea.trash_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupermarioController {

  @GetMapping("supermario/characters")
  public String getCharacter() {
    return "Yoshi";
  }

}
