package org.example;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
@Entity //hibernat will treat this student class as an entity// use to change the details of the table
@Cacheable
@org.hibernate.annotations.Cache(usage= CacheConcurrencyStrategy.READ_ONLY)
@Table(name="student1")
public class Student{
    public Student() {
        super();
    }

    public Student(String city,String studentName,int id) {
        super();
        this.city = city;
        this.id=id;
        this.studentName=studentName;
    }
    //making id as a primary key is done by using @Id annotation
    @Id // ude to mark column as id (primary Key)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Certificate certi;

    public Certificate getCerti() {
        return certi;
    }

    public void setCerti(Certificate certi) {
        this.certi = certi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String studentName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
