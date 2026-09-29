package com.vineela.studentcoursemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vineela.studentcoursemanagement.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}