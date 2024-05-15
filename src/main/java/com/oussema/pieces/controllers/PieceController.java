package com.oussema.pieces.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oussema.pieces.entities.Nature;
import com.oussema.pieces.entities.Piece;
import com.oussema.pieces.service.PieceService;

import jakarta.validation.Valid;

@Controller
public class PieceController {
	@Autowired
	PieceService pieceService;
	
	
		   @RequestMapping("/ListePieces")
			public String listeProduits(ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
										@RequestParam (name="size", defaultValue = "2") int size)
			{
			Page<Piece> piecs = pieceService.getAllPiecesParPage(page, size);
				modelMap.addAttribute("pieces", piecs);
		         modelMap.addAttribute("pages", new int[piecs.getTotalPages()]);	
				modelMap.addAttribute("currentPage", page);			
				return "listePieces";	
			}

		   @RequestMapping("/showCreate")
		   public String showCreate(ModelMap modelMap)
		   {
		   modelMap.addAttribute("piece", new Piece());
		   List<Nature> nats = pieceService.getAllNatures();
		   modelMap.addAttribute("mode", "new");
			  modelMap.addAttribute("natures", nats);

		   return "formPiece";
		   }
		   
			

		   @RequestMapping("/savePiece")
		   public String savePiece(@Valid Piece piece,
		   BindingResult bindingResult,@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
		   {
			   int currentPage;
			   boolean isNew = false;
		   if (bindingResult.hasErrors()) return "formPiece";
		   if (piece.getIdPiece()==null) //ajout
			   isNew=true;
			   pieceService.savePiece(piece);
			   if (isNew) //ajout
			   {
			   Page<Piece> piecs = pieceService.getAllPiecesParPage(page, size);
			   currentPage = piecs.getTotalPages()-1;
			   }
			   else 
			   currentPage=page;
			   return ("redirect:/ListePieces?page="+currentPage+"&size="+size);
			   }
		   

	  @RequestMapping("/supprimerPiece")
		public String supprimerPiece(@RequestParam("id") Long id,
				ModelMap modelMap,
				@RequestParam (name="page",defaultValue = "0") int page,
				@RequestParam (name="size", defaultValue = "2") int size)
		{

			pieceService.deletePieceById(id);
			Page<Piece> piecs = pieceService.getAllPiecesParPage(page, size);
			modelMap.addAttribute("pieces", piecs);		
			modelMap.addAttribute("pages", new int[piecs.getTotalPages()]);	
			modelMap.addAttribute("currentPage", page);	
			modelMap.addAttribute("size", size);	
			return "listePieces";	
		}


	  @RequestMapping("/modifierPiece")
	  public String editerProduit(@RequestParam("id") Long id,ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
				@RequestParam (name="size", defaultValue = "2") int size)
	 {
	  Piece p= pieceService.getPiece(id);
	   List<Nature> nats = pieceService.getAllNatures();
	  modelMap.addAttribute("piece", p);
	  modelMap.addAttribute("natures", nats);
	  modelMap.addAttribute("mode", "edit");
	  modelMap.addAttribute("page", page);
	  modelMap.addAttribute("size", size);


	  return "formPiece";
	  }
	  
	

	@RequestMapping("/updatePiece")
	public String updatePiece(@ModelAttribute("piece") Piece piece, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		piece.setDateCreation(dateCreation);

		pieceService.updatePiece(piece);
		List<Piece> piecs = pieceService.getAllPieces();
		modelMap.addAttribute("pieces", piecs);
		return "listePieces";
	}
	
	@GetMapping(value = "/")
	public String welcome() {
	return "index";
	}
	
}
