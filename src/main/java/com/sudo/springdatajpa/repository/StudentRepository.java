package com.sudo.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudo.springdatajpa.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
