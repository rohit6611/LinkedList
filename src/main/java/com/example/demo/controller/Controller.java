package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SystemChannel;
import com.example.demo.repo.SystemChannelRepo;

@RestController
public class Controller {

	@Autowired
	private SystemChannelRepo systemChannelrepo;
	
	@GetMapping(value = "/getChannel")
	public ResponseEntity<List<SystemChannel>> getChannelWithTrafficType(){
		
		List<SystemChannel> list = systemChannelrepo.findAll();
		return new ResponseEntity<List<SystemChannel>>(list,HttpStatus.OK);
		
	}
}
