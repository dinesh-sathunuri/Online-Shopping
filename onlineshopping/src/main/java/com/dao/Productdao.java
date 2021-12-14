package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.config.Config;
import com.pojo.Product;

@Repository
public class Productdao {
	
	@Autowired
     private JdbcTemplate jdbcTemplate;
//    public Productdao(DataSource dataSource) {
//        jdbcTemplate = new JdbcTemplate(dataSource);
//    }
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public List<Product> retrive()
	{
		String query="select * from product";
		return jdbcTemplate.query(query,new ResultSetExtractor<List<Product>>()
	{

		public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {
			// TODO Auto-generated method stub
			String name,link;
			int id,amount,quantity;
			List<Product>product=new ArrayList<Product>();
			while(rs.next())
			{
				Product pd=new Product();
				name=rs.getString(2);
				id=rs.getInt(1);
				amount=rs.getInt(3);
				link=rs.getString(4);
				quantity=rs.getInt(5);
				pd.setId(id);
				pd.setName(name);
				pd.setAmount(amount);
				pd.setLink(link);
				pd.setQuantity(quantity);
				product.add(pd);
			}
			return product;
		}
			
	});
		
	}
	public int change(int id,int quantity)
	{
		String query="update product set quantity=? where id=?";
		return jdbcTemplate.update(query,quantity,id);
	}
	public int add(Product p)
	{
		String query="insert into product(name,amount,link,quantity) values(?,?,?,?)";
		return jdbcTemplate.update(query,p.getName(),p.getAmount(),p.getLink(),p.getQuantity());
	}
	public Product quantity(int id)
	{
		String query="select quantity from product where id=?";
		
		return jdbcTemplate.query(query,new Integer[] {id},new ResultSetExtractor<Product>(){

			public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				Product pd=new Product();
				while(rs.next())
				{
				
				pd.setQuantity(rs.getInt(1));
				
				}
				return pd;
			}
			
			
		});
	}

}
