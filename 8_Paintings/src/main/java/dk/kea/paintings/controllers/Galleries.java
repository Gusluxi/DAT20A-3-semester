package dk.kea.paintings.controllers;

import dk.kea.paintings.models.Gallery;
import dk.kea.paintings.repositories.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Galleries {

  @Autowired
  GalleryRepository galleries;

  @GetMapping("/galleries")
  public Iterable<Gallery> getArtists() {

    return galleries.findAll();
  }

  @GetMapping("/galleries/{id}")
  public Gallery getGallery(@PathVariable Long id) {
    return galleries.findById(id).get();
  }

  @PostMapping("/galleries")
  public Gallery addGallery(@RequestBody Gallery newGallery) {
    return galleries.save(newGallery);
  }

  @PutMapping("/galleries/{id}")
  public String updateGallery(@PathVariable Long id, @RequestBody Gallery updatedGallery) {

    if (!galleries.existsById(id)) {
      return "No Gallery by id: " + id + " exists, nothing updated";
    }
    updatedGallery.setId(id);
    galleries.save(updatedGallery);
    return "Gallery Updated: "+updatedGallery;

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

  @PatchMapping("/galleries/{id}")
  public String patchArtistById(@PathVariable Long id, @RequestBody Gallery galleryToUpdateWith) {
    return galleries.findById(id).map(foundGallery -> {
      if (galleryToUpdateWith.getOwner() != null) foundGallery.setOwner(galleryToUpdateWith.getOwner());
      if (galleryToUpdateWith.getName() != null) foundGallery.setName(galleryToUpdateWith.getName());
      if (galleryToUpdateWith.getLocation() != null) foundGallery.setLocation(galleryToUpdateWith.getLocation());
      if (galleryToUpdateWith.getSquareFeet() != 0) foundGallery.setSquareFeet(galleryToUpdateWith.getSquareFeet());

      galleries.save(foundGallery);
      return "Gallery updated";
    }).orElse("Gallery not found");
  }

  @DeleteMapping("/galleries/{id}")
  public String deleteArtist(@PathVariable Long id) {
    if (!galleries.existsById(id)) {
      return "Gallery doesn't exists by id:" + id + ", No Gallery Deleted";
    }
    galleries.deleteById(id);
    return "Gallery Deleted";
  }
}
