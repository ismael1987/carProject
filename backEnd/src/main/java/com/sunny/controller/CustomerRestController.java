package com.sunny.controller;

import com.sunny.exceptions.CustomerNotFoundException;
import com.sunny.model.Customer;
import com.sunny.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;
import java.util.List;

/**
 * Created by Sunny on 8/11/2019.
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class CustomerRestController {

    @Autowired
    CustomerRepository customerRepository;

    /**GET**/ //read all
    @RequestMapping(value="/customers", method = RequestMethod.GET)
    public List getAllLocations()
    {
        return (List)customerRepository.findAll();
    }

    /**GET**/ //read one
    @GetMapping ("/v1/customer/{id}")
    Customer one (@PathVariable Long id) {
        return customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException(id));
    }

    /**POST**/ //create
    @PostMapping("/v1/customer")
    Customer  newCustomer(@RequestBody Customer newCustomer) {
        return customerRepository.save(newCustomer);
    }


    /**PUT**/ //update
    @PutMapping("/v1/customer/{id}")
    Customer newCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {

        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setCustomer_id(newCustomer.getCustomer_id());
                    customer.setUsername(newCustomer.getUsername());
                    customer.setAge(newCustomer.getAge());
                    customer.setDriver_license(newCustomer.getDriver_license());
                    customer.setFirst_name(newCustomer.getFirst_name());
                    customer.setLast_name(newCustomer.getFirst_name());
                    customer.setPwd(newCustomer.getPwd());
                    customer.setRole(newCustomer.getRole());
                    return customerRepository.save(customer);
                })
                .orElseGet(() -> {
                    newCustomer.setCustomer_id(id);
                    return customerRepository.save(newCustomer);
                });
        }

    /**DELETE**/
    @DeleteMapping("/customer/{id}")
    void deleteCustomer(@PathVariable Long id) {
        customerRepository.deleteById(id);
    }

    @GetMapping("/login")
    public @ResponseBody String login() {
        return "test";
    }


}





