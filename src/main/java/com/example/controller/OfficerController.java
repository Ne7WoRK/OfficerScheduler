package com.example.controller;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

//import com.example.encryption.RSAEncryption;
import com.example.model.*;
import com.example.service.OfficerService;

@Controller
public class OfficerController {

	@Autowired
	private OfficerService officerService;
	
	//private RSAEncryption rsa = new RSAEncryption();
	
	//Get list of all police officers and render them on the page.
	@RequestMapping(value = "/police_officers", method = RequestMethod.GET, produces = MediaType.ALL_VALUE)
	public String getAllOfficers(Model model, Officer officer) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, IOException {

		List<Officer> officers = officerService.findAll();

		model.addAttribute("officers", officers);
		model.addAttribute("officer", officer);

		return "officers";
	}
	
	//Add new officer to the database.
	@RequestMapping(value = "/add_officer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String addOfficer(Officer officer,BindingResult result, Model model,
			@RequestParam(value = "isAvailable", required = true) boolean isAvailable,
			@RequestParam (value = "photo") MultipartFile photo) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, IOException, SerialException, SQLException {
		
		//Sets the officer availability and photo.
		officer.setAvailable(isAvailable);
		officer.setPhoto("data:image/png;image/jpeg;image/bmp;base64," + Base64.getEncoder().encodeToString(photo.getBytes()));
		
		officerService.addOfficer(officer);
		
		return "redirect:/police_officers";
	}
	
	//Delete officer from database.
	@RequestMapping (value = "/delete_officer/{id}", method = RequestMethod.POST)
	public String deleteOfficer(@PathVariable (name = "id") int id) {
		
		officerService.deleteOfficer(id);
		
		return "redirect:/police_officers";
	}
	
}
