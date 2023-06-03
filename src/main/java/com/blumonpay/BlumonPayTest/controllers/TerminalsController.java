package com.blumonpay.BlumonPayTest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blumonpay.BlumonPayTest.entities.Terminal;
import com.blumonpay.BlumonPayTest.services.ITerminalsService;


@RestController
@RequestMapping("/terminals")
public class TerminalsController {
	
	@Autowired
	private ITerminalsService terminalsService;

	@GetMapping("/getAll")
	public ResponseEntity<List<Terminal>> getTerminals(){
		return ResponseEntity.ok(terminalsService.list());
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Terminal> getById(@PathVariable("id") Long id){
		Terminal terminal = terminalsService.findById(id);
		return ResponseEntity.ok(terminal);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Terminal> save(@RequestBody Terminal terminal){
		return ResponseEntity.status(HttpStatus.CREATED).body(terminalsService.save(terminal));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Terminal> update(@PathVariable("id") Long id, @RequestBody Terminal terminal){
		System.out.println(terminal);
		return ResponseEntity.status(HttpStatus.CREATED).body(terminalsService.update(terminal, id));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Terminal> delete(@PathVariable("id") Long id){
		return ResponseEntity.status(HttpStatus.OK).body(terminalsService.delete(id));
	}

}
