package com.javatechie.keycloak;

import com.javatechie.keycloak.entity.Employee;
import com.javatechie.keycloak.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import java.util.List;

@SpringBootApplication
@RestController
//@RequestMapping("/employees")
public class SpringBootKeycloakExampleApplication {

    @Autowired 
    private EmployeeService service;
    
    @RestController
    public class MyRestController {
        @RequestMapping("/")
        public ModelAndView welcome() {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("index.html");
            return modelAndView;
        }  
    }




 
    //this method can be accessed by user whose role is admin

    @RolesAllowed("admin")
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/admin")
    public ModelAndView welcomeAdmin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin.html");
        return modelAndView;
    }  

    
    //this method can be accessed by user whose role is user
    @GetMapping("/user")
    @RolesAllowed("user")
    public ModelAndView welcomeUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user.html");
        return modelAndView;
    }  

  
    

  
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootKeycloakExampleApplication.class, args);
    }

}
