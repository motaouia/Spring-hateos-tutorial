package org.medmota.demorest.mngmtalbums.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "albums")
@Entity
@Table(name = "ACTORS")
public class ActorEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String birthDate;

	@ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
      name = "actor_album", 
      joinColumns = @JoinColumn(name = "actor_id"), 
      inverseJoinColumns = @JoinColumn(name = "album_id"))
	private List<AlbumEntity> albums;

}
