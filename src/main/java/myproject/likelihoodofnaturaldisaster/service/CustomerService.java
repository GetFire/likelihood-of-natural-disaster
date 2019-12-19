package myproject.likelihoodofnaturaldisaster.service;

import myproject.likelihoodofnaturaldisaster.model.Customer;
import myproject.likelihoodofnaturaldisaster.model.CustomerModel;

public interface CustomerService {

    CustomerModel getCustomerForId(String id);

    boolean saveCustomer(CustomerModel customer);

    void updateCustomer(CustomerModel customer);

    CustomerModel deleteCustomer(CustomerModel customer);
}
