package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableOAuth2Sso
public class SecuredController extends WebSecurityConfigurerAdapter {

	@Autowired
	private OAuth2ClientContext clientContext;
	
	@RequestMapping("/")
	public String loadHome() {
		return "home";
	}

	@RequestMapping("/tolldata")
	public String loadTollData(Model model)
	{
		System.out.println("Token ********** "+clientContext.getAccessToken().getValue());
		return "tolls";
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/", "/login**").permitAll()
		.anyRequest().authenticated();
	}
	
	
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
}
