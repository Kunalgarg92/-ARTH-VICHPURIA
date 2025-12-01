package com.bajaj_Finser.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bajaj_Finser.DTO.DepartmentReport;
import com.bajaj_Finser.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    @Query(value = """
        SELECT 
            d.department_name as departmentName,
            AVG(DATEDIFF(CURDATE(), e.dob) / 365.25) as averageAge,
            GROUP_CONCAT(
                CONCAT(e.first_name, ' ', e.last_name) 
                ORDER BY e.emp_id 
                SEPARATOR ', '
                LIMIT 10
            ) as employeeList
        FROM department d
        JOIN employee e ON d.department_id = e.department
        JOIN payments p ON e.emp_id = p.emp_id
        WHERE p.amount > 70000
        GROUP BY d.department_id, d.department_name
        ORDER BY d.department_id DESC
        """, nativeQuery = true)
    List<DepartmentReport> getDepartmentAverageAgeReport();
}

