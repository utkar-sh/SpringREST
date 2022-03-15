package com.utkarsh.programmingAssignment.repository;

import com.utkarsh.programmingAssignment.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.inject.Singleton;
import java.util.Optional;

@Singleton
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findBySchoolName(String schoolName);

    Optional<Student> deleteById(Long id);
}
