package com.oussema.pieces.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.oussema.pieces.entities.Piece;
import com.oussema.pieces.service.PieceService;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class PieceRESTController {
@Autowired
PieceService pieceService;
@RequestMapping(method = RequestMethod.GET)
public List<Piece> getAllPieces() {
return pieceService.getAllPieces();
}

@RequestMapping(value="/{id}",method = RequestMethod.GET)
public Piece getPieceById(@PathVariable("id") Long id) {
return pieceService.getPiece(id);
 }

@RequestMapping(method = RequestMethod.POST)
public Piece createPiece(@RequestBody Piece piece) {
return pieceService.savePiece(piece);
}

@RequestMapping(method = RequestMethod.PUT)
public Piece updatePiece(@RequestBody Piece piece) {
return pieceService.updatePiece(piece);
}
@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
public void deletePiece(@PathVariable("id") Long id)
{
pieceService.deletePieceById(id);
}

@RequestMapping(value="/piecsnat/{idnat}", method = RequestMethod.GET)
public List<Piece> getPiecesByNatId(@PathVariable("idnat") Long idNat) {
    return pieceService.findByNatureIdNat(idNat);
}

}