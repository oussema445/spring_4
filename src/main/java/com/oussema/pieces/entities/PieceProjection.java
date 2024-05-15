package com.oussema.pieces.entities;

import org.springframework.data.rest.core.config.Projection;
@Projection(name = "nomPiec", types = { Piece.class })
public interface PieceProjection {
public String getNomPiece();
}
