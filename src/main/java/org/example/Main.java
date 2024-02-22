package org.example;


import org.example.entityСlasses.Client;
import org.example.entityСlasses.Project;
import org.example.entityСlasses.Worker;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //INIT DATABASE
        try {
            DatabaseInit.initDatabase();
        } catch (SQLException e) {
            throw new RuntimeException(e + " \nSome problems with initialization DB");
        }
        //POPULATE DATABASE
        List<Worker> workers = new ArrayList<>();
        workers.add(new Worker("Aleks", Date.valueOf("1990-01-12"), "Trainee", 500));
        workers.add(new Worker("Oleg", Date.valueOf("1945-03-01"), "Junior", 800));
        workers.add(new Worker("Pasha", Date.valueOf("2004-11-23"), "Middle", 20000));
        workers.add(new Worker("Masha", Date.valueOf("2000-08-14"), "Trainee", 1200));
        workers.add(new Worker("Bogdan", Date.valueOf("1987-03-22"), "Senior", 50000));
        workers.add(new Worker("Vadim", Date.valueOf("1998-07-11"), "Junior", 950));
        workers.add(new Worker("Lida", Date.valueOf("2001-12-03"), "Middle", 30000));
        workers.add(new Worker("Oksana", Date.valueOf("1989-06-21"), "Middle", 30000));
        workers.add(new Worker("Lena", Date.valueOf("1967-05-04"), "Trainee", 750));

        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Nazar"));
        clients.add(new Client("Maksim"));
        clients.add(new Client("Zhenya"));
        clients.add(new Client("Vitalina"));
        clients.add(new Client("Dasha"));
        clients.add(new Client("Natasha"));
        clients.add(new Client("Aleksey"));
        clients.add(new Client("Igor"));
        clients.add(new Client("Kiril"));
        clients.add(new Client("Pavlik"));

        List<Project> projects = new ArrayList<>();
        projects.add(new Project(Date.valueOf("2000-02-11"), Date.valueOf("2001-03-25")));
        projects.add(new Project(Date.valueOf("2008-04-06"), Date.valueOf("2008-09-14")));
        projects.add(new Project(Date.valueOf("1999-12-31"), Date.valueOf("2002-05-23")));
        projects.add(new Project(Date.valueOf("2001-05-28"), Date.valueOf("2010-10-10")));
        projects.add(new Project(Date.valueOf("1985-12-23"), Date.valueOf("1988-01-24")));
        projects.add(new Project(Date.valueOf("2000-09-05"), Date.valueOf("2005-02-23")));
        projects.add(new Project(Date.valueOf("1934-02-12"), Date.valueOf("1940-07-11")));
        projects.add(new Project(Date.valueOf("1963-08-19"), Date.valueOf("1965-06-21")));
        projects.add(new Project(Date.valueOf("2010-12-30"), Date.valueOf("2014-11-22")));
        projects.add(new Project(Date.valueOf("2020-10-03"), Date.valueOf("2020-12-13")));

        try {
            DatabasePopulate.populateDatabase(workers, clients, projects);
        } catch (SQLException e) {
            throw new RuntimeException(e + " \nSome problems with populating DB");
        }

        //
    }
}