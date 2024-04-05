package com.example.demo.springboot.cdiContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

// @Component
@Named
class BusinessService    {
    
    private DataService dataService;

    // @Autowired
    @Inject
    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

    @Named
    public DataService getDataService() {
        System.out.println("Setter Injection");
        return dataService;
    }
    
}

@Component
class DataService {

}

@Configuration
@ComponentScan
public class cdiContextLauncher {
    
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(cdiContextLauncher.class)) {
            System.out.println(context.getBean(BusinessService.class).getDataService());
        }
	}

}
