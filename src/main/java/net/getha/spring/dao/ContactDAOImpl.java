/*
 * Title        : Spring MVC DAO Implementation
 * Author       : Getha Jagannathan
 * Date Created : 11/1/2015
 * Description  : Spring MVC Database Query execution 
 * Date Modified: 11/22/2015
 * Modified By  : Getha Jagannathan
 */

package net.getha.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import net.getha.spring.model.Contact;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


public class ContactDAOImpl implements ContactDAO 
{
	private JdbcTemplate jdbcTemplate;	
	//Constructor
	public ContactDAOImpl(DataSource dataSource) 
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	//Insert new or Update existing Student Information
	@Override
	public void saveOrUpdate(Contact contact) 
	{
		if (contact.getId() > 0) 
		{
			// update existing record
			String sql = "UPDATE contact SET name=?, email=?, address=?, "
						+ "telephone=? WHERE contact_id=?";
			jdbcTemplate.update(sql, contact.getName(), contact.getEmail(),
					contact.getAddress(), contact.getTelephone(), contact.getId());
		} 
		else 
		{
			// insert new record
			String sql = "INSERT INTO contact (name, email, address, telephone)"
						+ " VALUES (?, ?, ?, ?)";
			jdbcTemplate.update(sql, contact.getName(), contact.getEmail(),
					contact.getAddress(), contact.getTelephone());
		}	
	}
	
	//Delete existing Student record
	@Override
	public void delete(int contactId) 
	{
		String sql = "DELETE FROM contact WHERE contact_id=?";
		jdbcTemplate.update(sql, contactId);
	}
	
	//List all the Student records, returns a list of all the students
	@Override
	public List<Contact> list() 
	{
		String sql = "SELECT * FROM contact";
		List<Contact> listContact = jdbcTemplate.query(sql, new RowMapper<Contact>() {

			@Override
			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				Contact aContact = new Contact();
	
				aContact.setId(rs.getInt("contact_id"));
				aContact.setName(rs.getString("name"));
				aContact.setEmail(rs.getString("email"));
				aContact.setAddress(rs.getString("address"));
				aContact.setTelephone(rs.getString("telephone"));
				
				return aContact;
			}
			
		});
		
		return listContact;
	}

	@Override
	public Contact get(int contactId) 
	{
		String sql = "SELECT * FROM contact WHERE contact_id=" + contactId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Contact>() {
			@Override
			public Contact extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) 
				{
					Contact contact = new Contact();
					contact.setId(rs.getInt("contact_id"));
					contact.setName(rs.getString("name"));
					contact.setEmail(rs.getString("email"));
					contact.setAddress(rs.getString("address"));
					contact.setTelephone(rs.getString("telephone"));
					return contact;
				}		
				return null;
				}		
			});
	}

}
