package dk.kea.paintings.controllers;

import dk.kea.paintings.models.Painting;
import dk.kea.paintings.repositories.PaintingRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Paintings Controller", description = "REST end points for paintings")
@RestController
public class Paintings {

  @Autowired
  PaintingRepository paintings;

  @GetMapping("/paintings")
  public Iterable<Painting> getPaintings() {
    return paintings.findAll();
  }

  @GetMapping("/paintings/{id}")
  public Painting getOnePainting(@PathVariable Long id) {
    return paintings.findById(id).get();
  }

  @GetMapping("/paintings/timeline")
  public List<Painting> getPaintingByArtistAndYear(@RequestParam String artist, @RequestParam int year) {
    return paintings.findPaintingByArtistAndYear(artist, year);
  }

  @GetMapping("paintings/pricelookup/{price}")
  public List<Painting> getPaintingAboveACertainPrice(@PathVariable double price) {
    return paintings.findPaintingsByPrice(price);
  }

  @PostMapping("/paintings")
  public Painting addPaintingPost(@RequestBody Painting newPainting) {
    newPainting.setId(null);
    return paintings.save(newPainting);
  }

  @PutMapping
  public String updatePainting(@PathVariable Long id, @RequestBody Painting updatedPainting) {
    if (!paintings.existsById(id)) {
      return "No Gallery by id: " + id + " exists, nothing updated";
    }
    updatedPainting.setId(id);
    paintings.save(updatedPainting);
    return "Gallery Updated: " + updatedPainting;
  }

  @PatchMapping("/paintings/{id}")
  public String patchPaintingByID(@PathVariable Long id, @RequestBody Painting paintingToUpdateWith) {
    return paintings.findById(id).map(foundPainting -> {
      if (paintingToUpdateWith.getArtist() != null) foundPainting.setArtist(paintingToUpdateWith.getArtist());
      if (paintingToUpdateWith.getPrice() != 0) foundPainting.setPrice(paintingToUpdateWith.getPrice());
      if (paintingToUpdateWith.getTitle() != null) foundPainting.setTitle(paintingToUpdateWith.getTitle());
      if (paintingToUpdateWith.getGenre() != null) foundPainting.setGenre(paintingToUpdateWith.getGenre());
      if (paintingToUpdateWith.getYear() != 0) foundPainting.setYear(paintingToUpdateWith.getYear());

      paintings.save(foundPainting);
      return "Painting updated";
    }).orElse("Painting not found");
  }

  @DeleteMapping("/paintings/{id}")
  public String deletePainting(@PathVariable Long id) {
    paintings.deleteById(id);
    return "The ArrayListID at "+id+" has been deleted";
  }

}
