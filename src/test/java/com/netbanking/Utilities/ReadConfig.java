package com.netbanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()   {
		
		File src = new File("./Configuration/config.properties");
	
		try {
			FileInputStream fis= new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getApplicationURL() {
		String url= pro.getProperty("baseURL");
		return url;
	}
	public String getUsername() {
		String username= pro.getProperty("username");
		return username;
	}
	public String getPassword() {
		String password= pro.getProperty("password");
		return password;
	}
	public String getChromepath() {
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	public String getIEPath() {
		String iepath=pro.getProperty("iepath");
		return iepath;
	}
	public String getfirefoxpath() {
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}
}
