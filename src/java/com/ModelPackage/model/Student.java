package com.ModelPackage.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author santiago.sanmartin
 */
//POJO
@Entity
@Table // esto sirve para mapear desde esta clase a la DB.

//Es necesario serializarlo para que el EnterpriseJavaBean pueda acceder aquí!!!!
//Va a ser un EntityBean

/*
    NamedQuery:
        JPA tiene un lenguaje parecido a SQL para hacer consultas, llamado
        JPQL, lo que permite usar consultas y además usar encapsulamiento, 
        herencia, etc.
*/
@NamedQueries(@NamedQuery(name="Student.getAll", query= "SELECT e FROM Student e"))

public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /*
     Indica al proveedor de persistencia que ajuste la generación de la DB.
     Hace el mejor esfuerzo para crear la llave primaria a partir de lo que
     esté dicho en persistence.xml
     */
    //@Column para empatar los atributos entre este modelo y la DB.

    @Column
    private int studentId;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private int yearLevel;

    // Constructores y Encapsulamiento.    
    public Student(int studentId, String firstName, String lastName, int yearLevel) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearLevel = yearLevel;
    }
    public Student() {
    }
    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getYearLevel() {
        return yearLevel;
    }
    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

}
