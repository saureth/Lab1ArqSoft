/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ModelPackage.BussinessRules;

import com.ModelPackage.model.Student;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author santiago.sanmartin
 */
@Stateless
public class StudentDAO implements StudentDAOLocal{
    @PersistenceContext(unitName = "Lab1ArqSoftPU")
    private EntityManager em;
    
    @Override
    public void addStudent(Student stud) {
        em.persist(stud);
    }

    @Override
    public void editStudent(Student stud) {
        em.merge(stud);
    }

    @Override
    public void deleteStudent(Student stud) {
        em.remove(stud);
    }

    @Override
    public Student getStudent(int studentId) {
        return em.find(Student.class,studentId);
    }

    @Override
    public List<Student> getStudents() {
        return em.createQuery("Student.getAll").getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void businessMethod() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void persist(Object object) {
        em.persist(object);
    }
}