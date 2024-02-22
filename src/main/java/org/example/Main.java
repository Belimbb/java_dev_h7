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
        workers.add(new Worker(1L, "Aleks", Date.valueOf("1990-01-12"), "Trainee", 500));
        workers.add(new Worker(2L, "Oleg", Date.valueOf("1945-03-1"), "Junior", 800));

        List<Client> clients = new ArrayList<>();
        clients.add(new Client(1L, "Nazar"));
        clients.add(new Client(2L, "Maksim"));

        List<Project> projects = new ArrayList<>();
        projects.add(new Project(1L, Date.valueOf("2000-02-11"), Date.valueOf("2001-03-25")));
        projects.add(new Project(2L, Date.valueOf("2008-04-06"), Date.valueOf("2008-09-14")));

        try {
            DatabasePopulate.populateDatabase(workers, clients, projects);
        } catch (SQLException e) {
            throw new RuntimeException(e + " \nSome problems with populating DB");
        }
    }
}