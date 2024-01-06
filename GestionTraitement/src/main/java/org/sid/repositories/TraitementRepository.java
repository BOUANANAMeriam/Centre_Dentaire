package org.sid.repositories;

import java.util.Set;

import org.sid.entities.Dent;
import org.sid.entities.Traitement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface TraitementRepository extends JpaRepository<Traitement,Long> {
	

	    @Query("SELECT d FROM Dent d JOIN d.traitements t WHERE t.id = :traitementId")
	    Set<Dent> findDentsByTraitementId(@Param("traitementId") Long traitementId);
	
}
