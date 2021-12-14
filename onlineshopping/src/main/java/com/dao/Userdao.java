package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.config.Config;
import com.pojo.User;
@Repository
public class Userdao {
	@Autowired
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
    this.jdbcTemplate = jdbcTemplate;  
}
    public int validate(User login) {
	    String sql = "select * from details where username='" + login.getUser()+"'";
	    final User users=new User();
	    jdbcTemplate.query(sql, new RowCallbackHandler(){

			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
					users.setUser(rs.getString(5));//null
			}
	    });
	    if(users.getUser()==null)
	    	return 0;
	    else
	    	return 1;
	    
	    }
    
	public int register(User user) {
		  String sql = "insert into details values(?,?,?,?,?,MD5(?))";

		    return jdbcTemplate.update(sql,
		    		user.getFn(),
		    		user.getSn(),
		    		user.getEmail(), 
		    		user.getPhone(),
		    		user.getUser(), 
		    		user.getPass());
		    }
	
	 public int validateUser(User login) {
		    String sql = "select * from details where username='" + login.getUser() + "' and password=MD5('" + login.getPass()
		    + "')";
		    final User users=new User();
		    jdbcTemplate.query(sql, new RowCallbackHandler(){

				public void processRow(ResultSet rs) throws SQLException {
					// TODO Auto-generated method stub
				
						users.setUser(rs.getString(5));
					
				}
		    });
		    if(users.getUser()==null)
		    	return 0;
		    else
		    	return 1;
		    
		    }
	 
		
}
