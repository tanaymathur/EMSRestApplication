package com.barclays.service;

import com.barclays.dao.EmployeeDao;
import com.barclays.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by knight on 20-12-2016.
 */

@Component
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    public Employee creation(Employee emp){
        employeeDao.createEmployee(emp);
        return findEmployee(emp.getId());
    }


    public Employee findEmployee(Long id){
        return employeeDao.getEmployee(id);
    }

    public List<Employee> findAllEmployees(){ return employeeDao.getAllEmployee();}

    public Employee updateEmployee(Employee emp , Long id){
        employeeDao.updateEmployee(id,emp);
        return findEmployee(id);
    }

    public void deleteEmploye(Long id){
        employeeDao.deleteEmployee(id);
    }
}
