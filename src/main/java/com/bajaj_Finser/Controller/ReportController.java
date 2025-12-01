package com.bajaj_Finser.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bajaj_Finser.DTO.DepartmentReport;
import com.bajaj_Finser.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    
    @Autowired
    private EmployeeRepository repository;
    
    @GetMapping("/department-average-age")
    public List<DepartmentReport> getDepartmentReport() {
        return repository.getDepartmentAverageAgeReport();
    }
}

