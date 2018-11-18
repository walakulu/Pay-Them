package com.recruit.paythem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recruit.paythem.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findEmployeesByRecruitmentId(int recrumentId);

}
