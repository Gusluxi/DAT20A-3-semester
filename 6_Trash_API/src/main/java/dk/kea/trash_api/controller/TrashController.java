package dk.kea.trash_api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class TrashController {

  List<String> deadlySins = Arrays.asList("Lust", "Gluttony", "Greed", "Sloth", "Wrath", "Envy", "Pride");

  @GetMapping("/")
  public String frontpage() {
    return "hi there";
  }

  @GetMapping("/clock")
  public Date clock() {
    return new Date();
  }

  @GetMapping("/sins")
  public String deadlySin() {
    int sinNum = (int) ((Math.random() * 7) + 1)-1;
    return deadlySins.get(sinNum);
  }

}
