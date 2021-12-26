package org.medmota.demorest.mngmtalbums.controllers;

import java.util.List;

import org.medmota.demorest.mngmtalbums.assemblers.ActorModelAssembler;
import org.medmota.demorest.mngmtalbums.assemblers.AlbumModelAssembler;
import org.medmota.demorest.mngmtalbums.dtos.ActorModel;
import org.medmota.demorest.mngmtalbums.dtos.AlbumModel;
import org.medmota.demorest.mngmtalbums.entities.ActorEntity;
import org.medmota.demorest.mngmtalbums.entities.AlbumEntity;
import org.medmota.demorest.mngmtalbums.repositories.ActorRepository;
import org.medmota.demorest.mngmtalbums.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

	@Autowired
	private AlbumRepository albumRepository;

	@Autowired
	private ActorRepository actorRepository;

	@Autowired
	private ActorModelAssembler actorModelAssembler;

	@Autowired
	private AlbumModelAssembler albumModelAssembler;
	
	@GetMapping("/api/actors")
    public ResponseEntity<CollectionModel<ActorModel>> getAllActors() 
    {
        List<ActorEntity> actorEntities = actorRepository.findAll();
        return new ResponseEntity<>(
                actorModelAssembler.toCollectionModel(actorEntities), 
                HttpStatus.OK);
    }

	@GetMapping("/api/actors/{id}")
	public ResponseEntity<ActorModel> getActorById(@PathVariable Long id) {
		return actorRepository.findById(id) 
                .map(actorModelAssembler::toModel) 
                .map(ResponseEntity::ok) 
                .orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/api/albums")
	public ResponseEntity<CollectionModel<AlbumModel>> getAllAlbums() {
		 List<AlbumEntity> albumEntities = albumRepository.findAll();
         
	        return new ResponseEntity<>(
	                albumModelAssembler.toCollectionModel(albumEntities), 
	                HttpStatus.OK);
	}
	

	@GetMapping("/api/albums/{id}")
	public ResponseEntity<AlbumModel> getAlbumById(@PathVariable Long id) {
		 return albumRepository.findById(id) 
	                .map(albumModelAssembler::toModel) 
	                .map(ResponseEntity::ok) 
	                .orElse(ResponseEntity.notFound().build());
	}
}
