package com.oussema.pieces.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.oussema.pieces.entities.Nature;
import com.oussema.pieces.entities.Piece;
@RepositoryRestResource(path = "rest")
public interface PieceRepository extends JpaRepository<Piece, Long> {

	
	List<Piece> findByNomPiece(String nom);
	 List<Piece> findByNomPieceContains(String nom); 
	
	 
	 @Query("select p from Piece p where p.nomPiece like %:nom and p.prixPiece > :prix")
	 List<Piece> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	 
	 @Query("select p from Piece p where p.nature = ?1")
	 List<Piece> findByNature (Nature nature);
	 
	 
	 List<Piece> findByNatureIdNat(Long id);
	 
	  List<Piece> findByOrderByNomPieceAsc();


	  @Query("select p from Piece p order by p.nomPiece ASC, p.prixPiece DESC")
	  List<Piece> trierPiecesNomsPrix ();

}
