/*
 * Title        : Spring MVC DAO 
 * Author       : Getha Jagannathan
 * Date Created : 11/1/2015
 * Description  : Spring MVC Data Access Object - Database Operations. 
 * Date Modified: 11/22/2015
 * Modified By  : Getha Jagannathan
 */

package net.getha.spring.dao;

import java.util.List;


import net.getha.spring.model.Contact;

public interface ContactDAO {
	
	public void saveOrUpdate(Contact contact);
	
	public void delete(int contactId);
	
	public Contact get(int contactId);
	
	public List<Contact> list();
}
