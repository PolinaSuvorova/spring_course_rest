package com.polina.spring.rest.service;

import com.polina.spring.rest.dao.EmployeeDAO;
import com.polina.spring.rest.entity.Employee;
import com.polina.spring.rest.exception.NoSuchEmployeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    //Доверяем открытие и закрытие транзакции Spring через аннотацию @Transactional
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        int id = employee.getId();
        if (id != 0) {
            getEmployee(employee.getId());
        }
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        Employee employee = getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with id = " + id);
        }
        return employee;
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        getEmployee(id);
        employeeDAO.deleteEmployee(id);
    }
}
