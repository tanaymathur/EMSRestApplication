package com.barclays.controller;

import com.barclays.View;
import com.barclays.domain.Employee;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import com.barclays.service.EmployeeService;

import java.util.List;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.OK;

/**
 * Created by knight on 14-12-2016.
 */

@RestController
public class RoutingController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/")
    public String index(){
        return "Hello Employee";
    }


    @JsonView(View.Summary.class)
    @RequestMapping(value="/create",method = RequestMethod.POST)
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        System.out.println("Here"+employee);
        employee = employeeService.creation(employee);
        return new ResponseEntity<Employee>(employee, ACCEPTED);
    }


    @JsonView(View.Summary.class)
    @RequestMapping(value = "/allEmployees",method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> findAll(){
        return  new ResponseEntity< List<Employee>>(employeeService.findAllEmployees(), OK);
    }


    @JsonView(View.Summary.class)
    @RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> search(@PathVariable("id") Long id){
        return new ResponseEntity<Employee>(employeeService.findEmployee(id), OK);
    }

    @JsonView(View.Summary.class)
    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Employee> update(@RequestBody Employee employee , @PathVariable("id") long id ){
        Employee emp = employeeService.updateEmployee(employee,id);
        return new ResponseEntity<Employee>(emp, ACCEPTED);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Employee> delete(@PathVariable("id") Long id){
        employeeService.deleteEmploye(id);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("status","Employee Deleted");
        return new ResponseEntity<Employee>(HttpStatus.OK);
    }
}
