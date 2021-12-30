package com.atos.dawg.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atos.dawg.model.DawgModel;
import com.atos.dawg.service.DawgService;


//@CrossOrigin(origins = "http://localhost:8080")
//@CrossOrigin(origins = "http://127.0.0.1:4200")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class DawgController {

		@Autowired
		//DawgRepository dawgRepository;
		DawgService dawgService;

		@GetMapping("/getDawg")
		public ResponseEntity<List<DawgModel>> getAllDawg(@RequestParam(required = false) String title) {
			try {
				List<DawgModel> tutorials = new ArrayList<DawgModel>();
				tutorials=dawgService.getAllDawg();
				return new ResponseEntity<>(tutorials, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		@GetMapping("/getDawgById/{id}")
		public ResponseEntity<DawgModel> getDawgById(@PathVariable("id") long id) {
			
			Optional<DawgModel> dawgModelData = dawgService.getDawgById(id);
			if (dawgModelData.isPresent()) {
				return new ResponseEntity<>(dawgModelData.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		}

		//@CrossOrigin(origins = "http://localhost:8080")
		@PostMapping(value="/createDawg")
		public ResponseEntity<DawgModel> createDawg(@RequestBody DawgModel dawgModelValue) {
			try {
				DawgModel dawgModel = dawgService.createDawg(dawgModelValue);
				return new ResponseEntity<>(dawgModel, HttpStatus.CREATED);
			} catch (Exception e) {				
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		@PutMapping(value="/updateDawg/{id}")
		public ResponseEntity<DawgModel> updateDawg(@PathVariable("id") long id,@RequestBody DawgModel dawgModelValue) {
			DawgModel dawgModelData = dawgService.updateDawg(id,dawgModelValue);//.findById(id);
			if (dawgModelData!=null ) {
				return new ResponseEntity<>(dawgModelData, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}

		@DeleteMapping("/deleteDawgById/{id}")
		public ResponseEntity<HttpStatus> deleteDawg(@PathVariable("id") long id) {
			//try {
				boolean bVal=dawgService.deleteDawg(id);
				if(bVal) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			//} catch (Exception e) {
				}else {
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			//}
		}

		@DeleteMapping("/deleteDawg")
		public ResponseEntity<HttpStatus> deleteAllDawg() {
			try {
				boolean bVal=dawgService.deleteAllDawg();
				if(bVal) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			//} catch (Exception e) {
				}else {
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}

			}finally {
				
			}
		}

		/*@GetMapping("/tutorials/published")
		public ResponseEntity<List<DawgModel>> findByDawg() {
			try {
				/*List<DawgModel> tutorials = dawgRepository.findByPublished(true);

				if (tutorials.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(tutorials, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}*/

	}

