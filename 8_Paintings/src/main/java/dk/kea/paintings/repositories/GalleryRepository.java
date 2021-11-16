package dk.kea.paintings.repositories;

import dk.kea.paintings.models.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {
}
