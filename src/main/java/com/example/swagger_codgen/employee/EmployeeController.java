package com.example.swagger_codgen.employee;
import com.example.swagger_codgen.api.DeleteApi;
import com.example.swagger_codgen.api.EmployeeDetailsApi;
import com.example.swagger_codgen.api.UpdateEmployeedetailsApi;

import com.example.swagger_codgen.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
public class EmployeeController implements EmployeeDetailsApi, UpdateEmployeedetailsApi, DeleteApi {
    EmployeeService employeeService;
    EmployeeController(EmployeeService employeeService)
    {
        this.employeeService=employeeService;
    }


    @Override
    public ResponseEntity<Integer> deleteEmployeeRecord(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<List<Employee>> getEmployeeRecord() {
        return ResponseEntity.status(200).body(employeeService.getEmployeeDetails());
    }

    @Override
    public ResponseEntity<Employee> addEmployeeRecord(@Valid Employee body) {
        return new ResponseEntity(employeeService.insertEmployeeRecord(body), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Employee> updateEmployeeRecords(@Valid Employee body, @NotNull @Valid Integer id) {
        return new ResponseEntity(employeeService.updateEmployeeRecord(body,id),HttpStatus.OK);
    }

}
