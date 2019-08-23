package com.gwg.xml.dtd.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class MyEntityResolver implements EntityResolver{
	
	protected static final Log LOG = LogFactory.getLog(MyEntityResolver.class);

	/**
	 * 返回一个与xsd相关的输入流InputStream
	 * 如果返回null,会使用jdk默认的方式来读取XML Schema
	 */
	public InputSource resolveEntity(String publicId, String systemId)
			throws SAXException, IOException {
		LOG.info("****publicId:"+publicId+", ****systemId:"+systemId);
		if (LOG.isTraceEnabled()) {
			LOG.trace("Trying to resolve XML entity with public id [" + publicId +
					"] and system id [" + systemId + "]");
		}

		if (systemId != null) {
			//uri absolute path resource
			String resourceLocation = systemId;
			if (resourceLocation != null) {
				try {
					URI uri = new URI(resourceLocation);
					//URI to File
					File file = new File(uri);
					InputStream inputStream = new FileInputStream(file);
					InputSource source = new InputSource(inputStream);
					source.setPublicId(publicId);
					source.setSystemId(systemId);
					if (LOG.isDebugEnabled()) {
						LOG.debug("Found XML schema [" + systemId + "] in classpath: " + resourceLocation);
					}
					return source;
				}
				catch (FileNotFoundException ex) {
					if (LOG.isDebugEnabled()) {
						LOG.debug("Couldn't find XML schema [" + systemId + "]: " + resourceLocation, ex);
					}
				} catch (URISyntaxException e) {
					if (LOG.isDebugEnabled()) {
						LOG.debug("URISyntaxException ", e);
					}
				}
			}
		}
		return null;
	}

}
