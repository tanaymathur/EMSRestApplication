package com.barclays.dao;
import com.barclays.exception.EmployeeNotFoundException;

import com.barclays.domain.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by knight on 20-12-2016.
 */

@Component
public class EmployeeDao {

    private List<Employee> list;
    {
        list = new ArrayList<>();
    }

    public void createEmployee(Employee employee){
        list.add(employee);
    }

    public List<Employee> getAllEmployee(){
        return list;
    }

    public Employee getEmployee(Long id){
        for(Employee emp: list){
            if(emp.getId().equals(id)){
                return emp;
            }
        }
        throw new EmployeeNotFoundException("Employee Not Found");
    }


    public void updateEmployee(Long id , Employee employee){
        Employee emp = getEmployee(id);
        emp.setName(employee.getName());
        emp.setRole(employee.getRole());
    }

    public void deleteEmployee(Long id){
        list.removeIf(li-> li.getId().equals(id));
    }
}
