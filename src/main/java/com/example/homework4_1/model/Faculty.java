package com.example.homework4_1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Faculty {
    private String nameFaculty;
    private String color;

    @Id
    @GeneratedValue
    private long id;
   @JsonIgnore
   @OneToMany(mappedBy = "faculty")
    private Collection<Student> students;


    public String getNameFaculty() {
        return nameFaculty;
    }

    public void setNameFaculty(String name) {
        this.nameFaculty = name;

    }

    public String getColor() {
        return color;

    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return id == faculty.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Faculty{" + "nameFaculty='" + nameFaculty + " " + ", color='" + color;
    }
}
