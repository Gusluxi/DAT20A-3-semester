package dk.kea.paintings.repositories;

import dk.kea.paintings.models.Gallery;
import dk.kea.paintings.models.Painting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaintingRepository extends JpaRepository<Painting, Long> {
  List<Painting> findPaintingByArtistAndYear(String artistName, int artistYear);

  @Query(value = "SELECT * FROM paintings WHERE price > ?1", nativeQuery = true)
      List<Painting> findPaintingsByPrice(Double price);
}
