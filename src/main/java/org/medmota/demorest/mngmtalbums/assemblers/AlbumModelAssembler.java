package org.medmota.demorest.mngmtalbums.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.medmota.demorest.mngmtalbums.controllers.WebController;
import org.medmota.demorest.mngmtalbums.dtos.ActorModel;
import org.medmota.demorest.mngmtalbums.dtos.AlbumModel;
import org.medmota.demorest.mngmtalbums.entities.ActorEntity;
import org.medmota.demorest.mngmtalbums.entities.AlbumEntity;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class AlbumModelAssembler extends RepresentationModelAssemblerSupport<AlbumEntity, AlbumModel> {

	public AlbumModelAssembler() {
		super(WebController.class, AlbumModel.class);
	}

	@Override
	public AlbumModel toModel(AlbumEntity entity) {
		AlbumModel albumModel = instantiateModel(entity);

		albumModel.add(linkTo(methodOn(WebController.class).getActorById(entity.getId())).withSelfRel());

		albumModel.setId(entity.getId());
		albumModel.setTitle(entity.getTitle());
		albumModel.setDescription(entity.getDescription());
		albumModel.setReleaseDate(entity.getDateRelease());
		albumModel.setActors(toActorModel(entity.getActors()));
		return albumModel;
	}

	private List<ActorModel> toActorModel(List<ActorEntity> actors) {
		if (actors.isEmpty())
			return Collections.emptyList();

		return actors.stream()
				.map(actor -> ActorModel.builder().id(actor.getId()).firstName(actor.getFirstName())
						.lastName(actor.getLastName()).build()
						.add(linkTo(methodOn(WebController.class).getActorById(actor.getId())).withSelfRel()))
				.collect(Collectors.toList());
	}

}
