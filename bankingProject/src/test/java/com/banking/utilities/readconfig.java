package com.banking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readconfig {
	Properties pro;

	public readconfig() {
		File src = new File("/home/htadmin/git/repository_Kiran/bankingProject/configuration/congif.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is a :" + e.getMessage());
		}

	}

	public String getUrl() {
		String urlString = pro.getProperty("baseurl");
		return urlString;
	}

	public String getUsername() {
		String usernameString = pro.getProperty("username");
		return usernameString;
	}

	public String getPassword() {
		String passwordString = pro.getProperty("password");
		return passwordString;

	}
}
