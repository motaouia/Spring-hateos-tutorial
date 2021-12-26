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
public class ActorModelAssembler extends RepresentationModelAssemblerSupport<ActorEntity, ActorModel> {

	public ActorModelAssembler() {
		super(WebController.class, ActorModel.class);
	}

	@Override
	public ActorModel toModel(ActorEntity entity) {
		ActorModel actorModel = instantiateModel(entity);
		actorModel.add(linkTo(methodOn(WebController.class).getActorById(entity.getId())).withSelfRel());

		actorModel.setId(entity.getId());
		actorModel.setFirstName(entity.getFirstName());
		actorModel.setLastName(entity.getLastName());
		actorModel.setBirthDate(entity.getBirthDate());
		actorModel.setAlbums(toAlbumModel(entity.getAlbums()));
		return actorModel;
	}

	private List<AlbumModel> toAlbumModel(List<AlbumEntity> albums) {
		if (albums.isEmpty())
			return Collections.emptyList();

		return albums.stream()
				.map(album -> AlbumModel.builder().id(album.getId()).title(album.getTitle()).build()
						.add(linkTo(methodOn(WebController.class).getAlbumById(album.getId())).withSelfRel()))
				.collect(Collectors.toList());
	}

}