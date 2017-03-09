							/**	Day4 **/
							=============
							
Spring cloud security
Docker

OAuth 2.0 - autherisation protocol [to extend the support to mobile devices]
Openconnect - protocol used to exchange tokens
	
	Role of security in MS
		-User Authentication /Autherization
		-Single Sign-On
		-Data Security
		-Interoperability
		
JWT - Json Web Tokens
How spring supports OAuth 2.0
	- Code annotations
	- Token storage solutions
	
Annotate the controller with @EnableOAuth2Sso
	security:
  oauth2:
    client:
      clientId: bd1c0a783ccdd1c9b9e4
      clientSecret: 1a9030fbca47a5b2c28e92f19050bb77824b5ad1
      accessTokenUri: https://github.com/login/oauth/access_token
      userAuthorizationUri: https://github.com/login/oauth/authorize
      clientAuthenticationScheme: form
    resource:
      userInfoUri: https://api.github.com/user
      preferTokenInfo: false
	  
WebSecurityConfigurerAdapter
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/", "/login**").permitAll()
		.anyRequest().authenticated();
	}
	
	@EnableResourceServer
	
	
	
	//Docker
	
	C:\Users\Administrator\AppData\Roaming\Microsoft\Windows\Start Menu\Programs\Docker
	
	Package Once Deploy Anywhere(PODA)
	Write Once Run Anywhere(WORA)
	
	Main things in Docker
		-Client
			-docker build
			-docker pull
			-docker run
		-Docker Host
			-docker daemon
			-container
			-Ubuntu
			-Oracle DB
		-Docker Registry
			-Ubuntu OS
			-Oracle DB
			-MongoDB
			
			
	build microservice jar 
	run docker file in docker cli client
	
	build -t secureduims:1.0 .
	
	docker login --username paloorazeez --password az525523
	docker build -t secureduims:1.0 .
	docker tag secureduims:1.0 paloorazeez/secureduims:1.0
	docker push paloorazeez/secureduims:1.0
	docker run --net host  -p 8090:8090 paloorazeez/secureduims:1.0
	
	
	