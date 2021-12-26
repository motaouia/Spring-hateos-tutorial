package org.medmota.demorest.mngmtalbums.repositories;

import org.medmota.demorest.mngmtalbums.entities.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<AlbumEntity, Long>{

}
