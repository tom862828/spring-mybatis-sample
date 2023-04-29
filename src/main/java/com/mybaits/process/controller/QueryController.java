package com.mybaits.process.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mybaits.process.dao.PersonDAO;
import com.mybaits.process.vo.PersonVO;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class QueryController {
	
	@GetMapping(value="/{user}/getPerson", produces = "application/json")
	public ResponseEntity<List<PersonVO>> getPerson(@PathVariable("user") String user) {
		
		PersonVO personVO = new PersonVO();
		PersonDAO personDAO = new PersonDAO();
		List<PersonVO> resultList = new ArrayList<PersonVO>();
		try {
			personVO.setUser_name(user);
			resultList = personDAO.getPerson(personVO);
			
			for(int i=0;i<resultList.size();i++) {
				resultList.get(i).setStatusCode("200");
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(resultList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.debug(e.toString());
			personVO.setStatusCode("400");
			resultList.add(personVO);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultList);
		}
	}
}
