package dk.kea.paintings.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "artists")
@Entity
public class Artist {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Long id;

  @Column
  @ApiModelProperty(notes = "name of the artist")
  private String name;

  @Column
  private int age;

  @Column
  private String style;

  @Column(length=100)
  private String nationality;

  @Column
  private Date birthDate;

  @Column
  @Enumerated(value = EnumType.STRING)
  private Gender gender;

  @ManyToOne
  @JoinColumn(name = "gallery_id")
  @Nullable
  private Gallery gallery;
}
