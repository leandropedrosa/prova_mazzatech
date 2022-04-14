package br.com.mazzatech.portal.util;

import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class FacesContextFactory {

	@Bean
	@Scope("request")
	public FacesContext facesContext() {
		return FacesContext.getCurrentInstance();
	}
	
}
