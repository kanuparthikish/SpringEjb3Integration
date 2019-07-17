package com.kishore.ejb3;

import javax.ejb.Remote;

@Remote
public interface HelloBeanRemote {
	
	public String getHelloMessage();

}
