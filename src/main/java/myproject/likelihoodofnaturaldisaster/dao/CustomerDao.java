package myproject.likelihoodofnaturaldisaster.dao;

import myproject.likelihoodofnaturaldisaster.model.CustomerModel;

public interface CustomerDao {
    CustomerModel getCustomerById(String id);

    boolean saveCustomer(CustomerModel customer);

    void updateCustomer(CustomerModel customer);

    CustomerModel deleteCustomer(CustomerModel customer);
}
