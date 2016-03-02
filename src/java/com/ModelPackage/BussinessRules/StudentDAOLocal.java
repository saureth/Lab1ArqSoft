package com.ModelPackage.BussinessRules;

import javax.ejb.Local;
import com.ModelPackage.model.Student;
import java.util.List;

/**
 *
 * @author santiago.sanmartin
 */
@Local//Facade

public interface StudentDAOLocal {
    public void addStudent(Student stud);
    public void editStudent(Student stud);
    public void deleteStudent(Student stud);
    public Student getStudent(int studentId);
    public List<Student> getStudents();

    void businessMethod();
}
