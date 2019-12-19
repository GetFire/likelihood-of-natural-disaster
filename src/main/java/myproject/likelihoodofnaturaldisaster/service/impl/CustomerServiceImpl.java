package myproject.likelihoodofnaturaldisaster.service.impl;

import myproject.likelihoodofnaturaldisaster.dao.CustomerDao;
import myproject.likelihoodofnaturaldisaster.model.CustomerModel;
import myproject.likelihoodofnaturaldisaster.service.CustomerService;
import myproject.likelihoodofnaturaldisaster.service.ForecastService;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;
    private ForecastService forecastService;

    public CustomerServiceImpl(CustomerDao customerDao, ForecastService forecastService) {
        this.customerDao = customerDao;
        this.forecastService = forecastService;
    }

    @Override
    public CustomerModel getCustomerForId(String id) {
        return customerDao.getCustomerById(id);
    }

    @Override
    public boolean saveCustomer(CustomerModel customer) {
        return customerDao.saveCustomer(customer);
    }

    @Override
    public void updateCustomer(CustomerModel customer) {
        customerDao.updateCustomer(customer);
    }

    @Override
    public CustomerModel deleteCustomer(CustomerModel customer) {
        return customerDao.deleteCustomer(customer);
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public ForecastService getForecastService() {
        return forecastService;
    }

    public void setForecastService(ForecastService forecastService) {
        this.forecastService = forecastService;
    }
}

