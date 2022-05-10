package com.vTigerGenericlib;

import com.github.javafaker.Company;
import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

public class Testdata {
	/**
	 * @author akarsh
	 * @return
	 */

	public String getLastname() {
		Faker faker = new Faker();
		String lastname = faker.name().lastName();
		return lastname;
	}

	/**
	 * @author akarsh
	 * @return

	 */

	public String getCompanyname() {
		Faker faker = new Faker();
		String companyname = faker.company().name();
		return companyname ;

	}
	
	/**
	 * @author akarsh
	 * @return
	 */
	
	public String getPhonenumber( ) {
		Faker faker = new Faker() ;
		String number = faker.phoneNumber().cellPhone();
		
		return number;
	
/**	public void getTitle(){
		Faker faker = new Faker();
		return faker.
	**/	
		
		
		
	}




}


