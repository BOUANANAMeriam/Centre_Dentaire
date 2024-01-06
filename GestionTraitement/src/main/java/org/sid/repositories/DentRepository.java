package org.sid.repositories;

import java.util.Set;

import org.sid.entities.Dent;
import org.sid.entities.Traitement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DentRepository extends JpaRepository<Dent,Long> {
	@Query("SELECT d FROM Traitement d JOIN d.dents t WHERE t.id = :dentId")
    Set<Traitement> findTraitemtsByDentId(@Param("dentId") Long dentId);

}
