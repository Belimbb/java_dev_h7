package org.example;


import org.example.entityСlasses.*;
import org.example.entityСlasses.searchEntities.*;
import org.example.serviceClasses.CreateDBPopulation;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        //INIT DATABASE
        try {
            DatabaseInit.initDatabase();
        } catch (SQLException e) {
            throw new RuntimeException(e + " \nSome problems with initialization DB");
        }
        //POPULATE DATABASE
        CreateDBPopulation createDBPopulation = new CreateDBPopulation();
        List<Worker> workers = createDBPopulation.getWorkers();
        List<Client> clients = createDBPopulation.getClients();
        List<Project> projects = createDBPopulation.getProjects();

        try {
            DatabasePopulate.populateDatabase(workers, clients, projects);
        } catch (SQLException e) {
            throw new RuntimeException(e + " \nSome problems with populating DB");
        }

         */

        //FIND LONGEST PROJECT
        try {
            List<LongestProject> longestProjects = new DatabaseQueryService().findLongestProject();
        } catch (SQLException e) {
            throw new RuntimeException(e + " \nSome problems with find longest project");
        }

        //FIND MAX COUNT CLIENT
        try {
            List<MaxProjectCountClient> maxProjectsClients = new DatabaseQueryService().findMaxProjectsClient();
        } catch (SQLException e) {
            throw new RuntimeException(e + " \nSome problems with find max projects client");
        }

        //FIND MAX SALARY WORKER
        try {
            List<Worker> maxSalaryWorkers = new DatabaseQueryService().findMaxSalaryWorker();
        } catch (SQLException e) {
            throw new RuntimeException(e + " \nSome problems with find max salary worker");
        }

        //FIND YOUNGEST ELDEST WORKER
        try {
            List<YoungestAndEldestWorker> youngestAndEldestWorkers = new DatabaseQueryService().findYoungestAndEldestWorker();
        } catch (SQLException e) {
            throw new RuntimeException(e + " \nSome problems with find youngest and eldest workers");
        }

        //PRINT PROJECTS PRICES
        try {
            List<ProjectPrice> projectsPrices = new DatabaseQueryService().getProjectPrices();
            for (ProjectPrice elem: projectsPrices){
                System.out.println(elem);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e + " \nSome problems with get projects prices");
        }
    }
}