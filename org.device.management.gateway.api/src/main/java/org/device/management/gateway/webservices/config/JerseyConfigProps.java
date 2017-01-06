package org.device.management.gateway.webservices.config;

import java.util.Dictionary;

import javax.servlet.ServletException;

import org.osgi.service.http.NamespaceException;

public interface JerseyConfigProps {
	
	public Dictionary<String, String> getJerseyConfigProviderPackagesProps();
	
	/**
	 * List of packages separated by semicolon
	 * e.g(org.test;org.test2;org.test3)
	 * @throws NamespaceException 
	 * @throws ServletException 
	 * 
	 * @pa
	 * */
	public void putProps(String webServicePackages) throws ServletException, NamespaceException;

}
