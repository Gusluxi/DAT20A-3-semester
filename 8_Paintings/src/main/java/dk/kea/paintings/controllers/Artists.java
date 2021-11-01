package dk.kea.paintings.controllers;

import dk.kea.paintings.models.Artist;
import dk.kea.paintings.models.Painting;
import dk.kea.paintings.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Artists {

  @Autowired
  ArtistRepository artists;

  @GetMapping("/artists")
  public Iterable<Artist> getArtists() {

    return artists.findAll();
  }

  @GetMapping("/artists/{id}")
  public Artist getArtist(@PathVariable Long id) {
    return artists.findById(id).get();
  }

  @PostMapping("/artists")
  public Artist addArtist(@RequestBody Artist newArtist) {
    return artists.save(newArtist);
  }

  @PostMapping("/artists/gallery/{artistId}/{galleryId}")
  public Artist addGalleryToArtist(@PathVariable long galleryId, @PathVariable long artistId) {


    return null;
  }

  @PutMapping("/artists/{id}")
  public Artist updateArtist(@PathVariable Long id, @RequestBody Artist updatedArtist) {

    if (!artists.existsById(id)) {
      System.out.println("No Artist by id: " + id + " exists, nothing updated");
      return null;
    }
    updatedArtist.setId(id);
    return artists.save(updatedArtist);

    /* Uden If statement og længere
      return artists.findById(id).map(foundArtist -> {
        foundArtist.setName(updatedArtist.getName());
        foundArtist.setAge(updatedArtist.getAge());
        foundArtist.setBirthDate(updatedArtist.getBirthDate());
        foundArtist.setGender(updatedArtist.getGender());
        foundArtist.setNationality(updatedArtist.getNationality());
        foundArtist.setStyle(updatedArtist.getStyle());
        return artists.save(foundArtist);
      }).get();
    */

  }

  @PatchMapping("/artists/{id}")
  public String patchArtistById(@PathVariable Long id, @RequestBody Artist artistToUpdateWith) {
    return artists.findById(id).map(foundArtist -> {
      if (artistToUpdateWith.getName() != null) foundArtist.setName(artistToUpdateWith.getName());
      if (artistToUpdateWith.getAge() != 0) foundArtist.setAge(artistToUpdateWith.getAge());
      if (artistToUpdateWith.getNationality() != null) foundArtist.setNationality(artistToUpdateWith.getNationality());
      if (artistToUpdateWith.getStyle() != null) foundArtist.setStyle(artistToUpdateWith.getStyle());
      if (artistToUpdateWith.getBirthDate() != null) foundArtist.setBirthDate(artistToUpdateWith.getBirthDate());
      if (artistToUpdateWith.getGender() != null) foundArtist.setGender(artistToUpdateWith.getGender());

      artists.save(foundArtist);
      return "Artist updated";
    }).orElse("Artist not found");
  }

  @DeleteMapping("/artists/{id}")
  public void deleteArtist(@PathVariable Long id) {
    artists.deleteById(id);
  }

}
