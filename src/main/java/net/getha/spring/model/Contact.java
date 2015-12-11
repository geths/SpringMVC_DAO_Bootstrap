/*
 * Title        : Spring MVC Model
 * Author       : Getha Jagannathan
 * Date Created : 11/1/2015
 * Description  : Spring MVC variables and corresponding setter and getter methods 
 * Date Modified: 11/22/2015
 * Modified By  : Getha Jagannathan
 */

package net.getha.spring.model;

public class Contact {
	private int id;
	private String name;
	private String email;
	private String address;
	private String telephone;
    private String country;
	
    //Constructor
    public Contact() 
	{
	}
    public String getCountry() 
	{
		return country;
	}
	public void setCountry(String country) 
	{
		this.country = country;
	}		
	public Contact(String name, String email, String address, String telephone) 
	{
		this.name = name;
		this.email = email;
		this.address = address;
		this.telephone = telephone;
		this.country = "a";
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getTelephone() 
	{
		return telephone;
	}

	public void setTelephone(String telephone) 
	{
		this.telephone = telephone;
	}

}
