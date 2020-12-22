package com.programming.exam.model;

import javax.persistence.*;

@Entity
public class Student {
    private long id;
    private String name;
    private String email;
    private Supervisor supervisorBySupervisorId;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 70)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 60)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (email != null ? !email.equals(student.email) : student.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "supervisor_id", referencedColumnName = "id", nullable = false)
    public Supervisor getSupervisorBySupervisorId() {
        return supervisorBySupervisorId;
    }

    public void setSupervisorBySupervisorId(Supervisor supervisorBySupervisorId) {
        this.supervisorBySupervisorId = supervisorBySupervisorId;
    }
}
