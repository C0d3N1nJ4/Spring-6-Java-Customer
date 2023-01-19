# Customer
This Spring demo project uses the following spring modules :
1. Data JPA
2. Web
3. H2
4. Actuator
5. Security

This project aims to implement a simple Spring project that exposes an API with various operations to interact with Customer information stored in H2.

# Actuator 
The following endpoints are available :

https://localhost:8080/actuator

# Security
Spring Security’s InMemoryUserDetailsManager implements UserDetailsService to provide support for username/password based authentication that is stored in memory. InMemoryUserDetailsManager provides management of UserDetails by implementing the UserDetailsManager interface. UserDetails-based authentication is used by Spring Security when it is configured to accept a username and password for authentication.

For more information : [https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/in-memory.html](https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/in-memory.html)


