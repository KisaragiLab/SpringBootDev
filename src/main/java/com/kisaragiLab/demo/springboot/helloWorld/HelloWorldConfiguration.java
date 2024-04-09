package com.kisaragiLab.demo.springboot.helloWorld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address) {}
record Address(String firstLine, String city) {}

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Joel";
    }

    @Bean
    public int age() {
        return 28;
    }
    
    @Bean
    @Primary
    public Person person() {
        Person person = new Person("Sam", 32, new Address("FLat 7", "Manchester"));
        return person;
    }

    @Bean
    public Person personMethodCall() {
        Person person = new Person(name(), age(), address());
        return person;
    }

    @Bean
    public Person personParameters(String name, int age, Address address2) {
        Person person = new Person(name, age, address());
        return person;
    }

    @Bean
    public Person personWithQualifier(String name, int age, @Qualifier("address2qualifier") Address address2) {
        Person person = new Person(name, age, address());
        return person;
    }

    @Bean(name = "address2")
    @Primary
    @Qualifier("address2qualifier")
    public Address address() {
        Address address = new Address("Flat 9", "London");
        return address;
    }

}
