package com.bway.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.springdemo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
