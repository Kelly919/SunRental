package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.CustomerRepository;

@Service
public class CustomerService implements ICustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }


    @Override
    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        return repository.save(customer);
    }


    public Customer findByEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }

//
//    public Customer (String email, String password) {
//        Customer customer = repository.findByEmailAndPassword(email, password);
//        if (customer != null && customer.getPassword().equals(password)) {
//            return customer;
//        }
//        throw new IllegalArgumentException("Invalid email or password");
//    }
}
