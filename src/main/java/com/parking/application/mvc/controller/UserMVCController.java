package com.parking.application.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.parking.application.dto.PwUserDTO;
import com.parking.application.model.PwUser;
import com.parking.application.service.UserService;

@Controller
@RequestMapping(path = "parkwisely/mvc")
public class UserMVCController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/users")
	public ModelAndView elasticHome(Model model) {
		try {
			model.addAttribute("users", userService.getUsers());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("users");
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/add")
	public ModelAndView addParkUser(@ModelAttribute PwUser user) throws Exception {
		try {
			userService.registerUser(user);
		} catch (Exception e) {
			return new ModelAndView("redirect:/error");
		}
		return new ModelAndView("redirect:/parkwisely/users");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/user/delete")
	public ModelAndView deleteUser(int userId) throws Exception {
		try {
			userService.deleteUser(userId);
		} catch (Exception e) {
			return new ModelAndView("redirect:/error");
		}
		return new ModelAndView("redirect:/parkwisely/users");
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/user/edit")
	public String editEmployee(Model model, int userId) throws Exception {
		try {
			PwUser user = userService.findUserById(userId);
			model.addAttribute("user", user);
		} catch (Exception e) {
			return "error";
		}
		return "edit_user";
}
	
	@RequestMapping(method = RequestMethod.GET, value = "/user/upsert")
	public String editElasticEmployee(Model model, Integer userId) throws Exception {
		PwUserDTO user = null;
		try {
			if (userId == null){
				user = new PwUserDTO();
				model.addAttribute("user", user);
				return "single_user";
			}
			PwUser user1 = userService.findUserById(userId);
			model.addAttribute("user", user1);
		} catch (Exception e) {
			return "error";
		}
		return "single_user";
	}
	
	/*@RequestMapping(method = RequestMethod.POST, value = "/parkwisely/user/search")
	public String getElasticEmployee(Model model, @RequestParam String search) {
		try {
			model.addAttribute("employees", employeeElasticDao.getEmployee(search));
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("employeeSearch", search);
		return "elasticIndex";
} 
*/
}
