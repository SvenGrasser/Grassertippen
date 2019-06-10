package de.svennetz.grasser.tippspiel.filters;

import javax.ws.rs.container.ContainerResponseFilter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.ext.Provider;

@Provider
public class CORSFilter implements ContainerResponseFilter {
   public void filter(ContainerRequestContext req, ContainerResponseContext res)
        throws IOException
   {	   
	  res.getHeaders().add("Access-Control-Allow-Origin", "*");
   }
}