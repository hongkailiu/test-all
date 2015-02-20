package com.hongkailiu.test.app.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



/**
 * ref.
 * http://1358440610-qq-com.iteye.com/blog/1826816
 * 
 * @author Liu
 *
 */
@Repository("personDAOSJTImpl")
public class PersonDAOSJTImpl implements PersonDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Person findById(int id) {
		return (Person) jdbcTemplate.queryForObject("select * from Person where id = ?", new Object[]{id}, new BeanPropertyRowMapper(Person.class));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Person> list() {
		return (List<Person>) jdbcTemplate.query("select * from Person", new BeanPropertyRowMapper(Person.class));
	}

	@Override
	public int save(Person person) {
		return jdbcTemplate.update("insert into Person (name,country) values(?,?)",   
                new Object[]{person.getName(),person.getCountry()});  
		
	}

	@Override
	public int deleteById(int id) {
		return jdbcTemplate.update(  
                "delete from Person where id = ?",   
                new Object[]{id},   
                new int[]{java.sql.Types.INTEGER}); 
		
	}
	
}
