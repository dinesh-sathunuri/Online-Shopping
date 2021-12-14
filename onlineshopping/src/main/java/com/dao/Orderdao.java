package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.pojo.Order;
@Repository
public class Orderdao {
	 
	@Autowired
    private JdbcTemplate jdbcTemplate;
	 
    
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public int insertintooreder(Order o) throws ClassNotFoundException{
		String query="insert into orderheader(productid,customeruser,quantity,amount,productname,datebuyed,statusofproduct,modifiedby,Createdby,modifieddate) values(?,?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(query, 
		o.getOrderid(),
		o.getUsername(),
		o.getQuatity(),
		o.getAmount(),
		o.getOrdername(),
		o.getDatecreated().toString(),
		o.getStatus(),
		o.getModifiedby(),
		o.getCreatedby(),
		o.getModifieddate()
		);	
	}
	public int insertintoorederdetails(Order o) throws ClassNotFoundException{
		String query="insert into orderDetails(productid,quantity,totalAmount,statusofproduct,username,createdbydate) values(?,?,?,?,?,?)";
		return jdbcTemplate.update(query, 
		o.getProductid(),
		o.getQuatity(),
		o.getAmount(),
		o.getStatus(),
		o.getUsername(),
		o.getDatecreated()
		);	
	}
	public int deleteintooreder(int id) throws ClassNotFoundException
	{
		String query="delete from orderheader where productid=?";
		return jdbcTemplate.update(query,id);
	}
	public void update(String id1,int status,String modifiedby,String modifieddate) throws ClassNotFoundException
	{
		String query="update orderheader set statusofproduct=?,modifiedby=?,modifieddate=? where orderid=?";
		int orderid=Integer.parseInt(id1);
		jdbcTemplate.update(query,status,modifiedby,modifieddate,orderid);
	}
	public List<Order> retrive(String user)
	{
		if(user.substring(0,5).equals("admin"))
		{
			String query="select * from orderDetails order by orderid desc";
			return jdbcTemplate.query(query,new ResultSetExtractor<List<Order>>() {

				public List<Order> extractData(ResultSet rs) throws SQLException, DataAccessException {
					// TODO Auto-generated method stub
					List<Order>order=new ArrayList<Order>();
					while(rs.next())
					{
						Order o=new Order();
						o.setOrderid(rs.getInt(1));
						o.setProductid(rs.getInt(2));
						o.setQuatity(rs.getInt(3));
						o.setAmount(rs.getInt(4));
						o.setStatus(rs.getInt(5));
						o.setUsername(rs.getString(6));
						o.setDatecreated(rs.getString(7));
						order.add(o);
					}
					return order;
				}
				
			});
		}
		else
		{
			String query="select * from orderDetails where username=? order by orderid desc";
			return jdbcTemplate.query(query,new String[]{user},new ResultSetExtractor<List<Order>>() {

				public List<Order> extractData(ResultSet rs) throws SQLException, DataAccessException {
					// TODO Auto-generated method stub
					List<Order>order=new ArrayList<Order>();
					while(rs.next())
					{
						Order o=new Order();
						o.setOrderid(rs.getInt(1));
						o.setProductid(rs.getInt(2));
						o.setQuatity(rs.getInt(3));
						o.setAmount(rs.getInt(4));
						o.setStatus(rs.getInt(5));
						o.setUsername(rs.getString(6));
						o.setDatecreated(rs.getString(7));
						order.add(o);
					}
					return order;
				}
				
			});
		}
	}
	public int update(int id1,int status,String modifiedby,String modifieddate) throws ClassNotFoundException
	{
		String query="update orderheader set statusofproduct=?,modifiedby=?,modifieddate=? where orderid=?";
		//int orderid=Integer.parseInt(id1);
		return jdbcTemplate.update(query,status,modifiedby,modifieddate,id1);
	}
	public int updatestatus(int id,int status)
	{
		String query="update orderDetails set statusofproduct=? where orderid=?";
		return jdbcTemplate.update(query,status,id);
	}
	public Order quantity(int id)
	{
		String query="select quantity from orderDetails where orderid=?";
		
		return jdbcTemplate.query(query,new Integer[] {id},new ResultSetExtractor<Order>(){

			public Order extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				Order pd=new Order();
				while(rs.next())
				pd.setQuatity(rs.getInt(1));
				return pd;
			}
			
			
		});
		
	}
	public Order productid(int id)
	{
		
		String query="select productid from orderDetails where orderid="+id;
		
		return jdbcTemplate.query(query,new ResultSetExtractor<Order>(){

			public Order extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				Order pd=new Order();
				while(rs.next())
				{
				pd.setProductid(rs.getInt(1));
				
				}
				return pd;
			}		
		});
	}

}
