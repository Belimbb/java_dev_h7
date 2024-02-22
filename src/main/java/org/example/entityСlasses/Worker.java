package org.example.entityСlasses;

import java.sql.Date;

public class Worker {
    private Long id;
    private String name;
    private Date birthday;
    private String wlevel;
    private int salary;

    public Worker(String name, Date birthday, String wlevel, int salary) {
        this.name = name;
        this.birthday = birthday;
        this.wlevel = wlevel;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getWlevel() {
        return wlevel;
    }

    public void setWlevel(String wlevel) {
        this.wlevel = wlevel;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", wlevel='" + wlevel + '\'' +
                ", salary=" + salary +
                '}';
    }
}
