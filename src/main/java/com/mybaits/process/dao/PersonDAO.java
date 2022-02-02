package com.mybaits.process.dao;

import java.util.List;


import com.mybaits.process.config.ResultFactory;
import com.mybaits.process.vo.PersonVO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class PersonDAO {
	
	public int insertPerson(PersonVO personVO) throws Exception{
		ResultFactory resultFactory = new ResultFactory();
		int result = resultFactory.insertObject("insertPerson", personVO);
		log.debug("result -> " + result);
		return result;
	}
	
	public List<PersonVO> getPerson(PersonVO personVO) throws Exception{
		ResultFactory resultFactory = new ResultFactory();
		@SuppressWarnings("unchecked")
		List<PersonVO> result = (List<PersonVO>) resultFactory.querylist("queryPerson", personVO);
		return result;
	}
	
	public int updatePerson(PersonVO personVO) throws Exception{
		ResultFactory resultFactory = new ResultFactory();
		int result = resultFactory.updateObject("updatePerson", personVO);
		return result;
	}
	
	public int deletePerson(PersonVO personVO) throws Exception{
		ResultFactory resultFactory = new ResultFactory();
		int result = resultFactory.deleteObject("deletePerson", personVO);
		return result;
	}
}
