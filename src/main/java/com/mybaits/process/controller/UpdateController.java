package com.mybaits.process.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybaits.process.dao.PersonDAO;
import com.mybaits.process.vo.PersonVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class UpdateController {

	@PutMapping(value="/{user}/{password}/UpdatePerson", produces = "application/json")
	public ResponseEntity<PersonVO> updatePerson(@PathVariable("user") String user,@PathVariable("password") String password) {
		
		PersonVO personVO = new PersonVO();
		PersonDAO personDAO = new PersonDAO();
		try {
			personVO.setUser_name(user);
			personVO.setPassword(password);
			personVO.setStatusCode("200");
			personDAO.updatePerson(personVO);
			return ResponseEntity.status(HttpStatus.OK).body(personVO);
		}catch (Exception e) {
			// TODO: handle exception
			log.debug(e.toString());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(personVO);
		}
	}
}
