package org.medmota.demorest.mngmtalbums.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ALBUMS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlbumEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private String dateRelease;
	
	@ManyToMany(mappedBy = "albums", fetch = FetchType.EAGER)
	private List<ActorEntity> actors;
	

}
