package com.blumonpay.BlumonPayTest.controllers;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blumonpay.BlumonPayTest.entities.Terminal;
import com.blumonpay.BlumonPayTest.entities.User;
import com.blumonpay.BlumonPayTest.services.IUsersService;
import com.blumonpay.BlumonPayTest.util.Utilities;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private IUsersService usersService;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/getAll")
	public String getAll(Model model) {
		
		String username = "";
		Object main = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(main instanceof UserDetails) username = ((UserDetails) main).getUsername();
		User user = usersService.findByUsername(username);
		System.out.println(user);
		session.setAttribute("userSession", user);
		
		model.addAttribute("users", usersService.list());
		model.addAttribute("user", new User());
		return "users";
	}
	
	@PostMapping("/save")
	public String save(User user, Model model) {
		System.out.println(user);
		user.setAuthorities("ROLE_USER");
		user.setEnabled('1');
		user.setCreationDate(LocalDate.now());
		usersService.save(user);
		return "redirect:getAll";
	}
	
	@GetMapping("/update/{id}")
	public String updateTerminalPage(@PathVariable("id") Long id, Model model) {
		User user = usersService.findById(id);
		model.addAttribute("userToUpdate" , user);
		return "updateUser";
	}
	
	@PostMapping("/update")
	public String update(User user){
		System.out.println(user);
		usersService.update(user, user.getIdUser());
		return "redirect:getAll";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id){
		usersService.delete(id);
		return "redirect:/users/getAll";
	}
	
}
