package org.sid.customerservice;

import com.google.inject.internal.cglib.core.$Customizer;
import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repoisitories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Customer.class);
        return args -> {
        customerRepository.save(new Customer(null,"mohamed","med@gmail.com"));
        customerRepository.save(new Customer(null,"yassine","yassine@gmail.com"));
        customerRepository.save(new Customer(null,"oualid","oualid@gmail.com"));
        customerRepository.findAll().forEach(customer -> {
            System.out.println(customer.toString());
        });
        };
    }

}
