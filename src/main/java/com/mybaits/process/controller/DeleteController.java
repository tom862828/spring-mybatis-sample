package com.mybaits.process.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybaits.process.dao.PersonDAO;
import com.mybaits.process.vo.PersonVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class DeleteController {
	
	@DeleteMapping(value="/{user}/DeletePerson", produces = "application/json")
	public ResponseEntity<PersonVO> deletePerson(@PathVariable("user") String user) {
		
		PersonVO personVO = new PersonVO();
		PersonDAO personDAO = new PersonDAO();
		try {
			personVO.setUser(user);
			personDAO.deletePerson(personVO);
			personVO.setStatusCode("200");
			return ResponseEntity.status(HttpStatus.OK).body(personVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.debug(e.toString());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(personVO);
		}
	}
}
