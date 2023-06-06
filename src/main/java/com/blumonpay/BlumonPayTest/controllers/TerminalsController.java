package com.blumonpay.BlumonPayTest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blumonpay.BlumonPayTest.entities.Terminal;
import com.blumonpay.BlumonPayTest.services.ITerminalsService;
import com.blumonpay.BlumonPayTest.util.Utilities;


//@RestController
@Controller
@RequestMapping("/terminals")
public class TerminalsController {
	
	@Autowired
	private ITerminalsService terminalsService;
	
	@GetMapping("/getAll")
	public String getTerminals(Model model){
		List<Terminal> terminals = terminalsService.list();
		model.addAttribute("terminals", terminals);
		model.addAttribute("terminal", new Terminal());
		return "terminals";
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Terminal> getById(@PathVariable("id") Long id){
		Terminal terminal = terminalsService.findById(id);
		return ResponseEntity.ok(terminal);
	}
	
	@PostMapping("/save")
	public String save(@Valid Terminal terminal){
		terminal.setBornDate(Utilities.parseStrToLocalDate(terminal.getBornDateStr()));
		terminalsService.save(terminal);
		return "redirect:getAll";
	}
	
	@GetMapping("/update/{id}")
	public String updateTerminalPage(@PathVariable("id") Long id, Model model) {
		Terminal terminal = terminalsService.findById(id);
		model.addAttribute("terminalToUpdate" , terminal);
		return "updateTerminal";
	}
	
	@PostMapping("/update")
	public String update(@Valid Terminal terminal){
		terminal.setBornDate(Utilities.parseStrToLocalDate(terminal.getBornDateStr()));
		System.out.println(terminal);
		terminalsService.update(terminal, terminal.getIdTerminal());
		return "redirect:getAll";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id){
		terminalsService.delete(id);
		return "redirect:/terminals/getAll";
	}

}
