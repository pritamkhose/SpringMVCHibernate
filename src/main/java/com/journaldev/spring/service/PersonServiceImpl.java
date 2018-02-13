package com.journaldev.spring.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.PersonDAO;
import com.journaldev.spring.model.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	private PersonDAO personDAO;

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	@Override
	@Transactional
	public void addPerson(Person p) {
		//String s = GentateDocketno(p);
		//p.setDocketno(s);
		this.personDAO.addPerson(p);
	}

	@Override
	@Transactional
	public void updatePerson(Person p) {
		this.personDAO.updatePerson(p);
	}

	@Override
	@Transactional
	public List<Person> listPersons() {
		return this.personDAO.listPersons();
	}

	@Override
	@Transactional
	public Person getPersonById(int id) {
		return this.personDAO.getPersonById(id);
	}

	@Override
	@Transactional
	public void removePerson(int id) {
		this.personDAO.removePerson(id);
	}
	
	private String GentateDocketno(Person p) {
		// TODO Auto-generated method stub
		String s ;
		try{
				int Min = 101;
				int Max = 909;
				int no = (int) (Min + (Math.random() * (Max - Min)));
				
			    s = p.getCountry().toString().substring(0,4).replaceAll("", "")
						+ p.getName().toString().substring(0,4).replaceAll(" ", "")
						//+ hm.get("model_no").toString().substring(0,3).replaceAll(" ", "")
						;	
				Date date = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
				
				s = s.toUpperCase()+dateFormat.format(date)+no;

		} catch(Exception e){
			s = null;
		}
				return s;
	}


}
