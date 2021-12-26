package org.medmota.demorest.mngmtalbums.dtos;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "album")
@Relation(collectionRelation = "albums")
@JsonInclude(Include.NON_NULL)
public class AlbumModel extends RepresentationModel<AlbumModel> {

	private Long id;
	private String title;
	private String description;
	private String releaseDate;
	private List<ActorModel> actors;
}
