package org.example;

import org.example.entityСlasses.Client;
import org.example.entityСlasses.Project;
import org.example.entityСlasses.Worker;
import org.example.serviceClasses.PopulateDBRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.List;
import java.util.Random;

public class DatabasePopulate {
    public static void populateDatabase(List<Worker> workers, List<Client> clients, List<Project> projects) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement workersRequest = connection.prepareStatement(PopulateDBRequest.addWorkers());
        PreparedStatement clientsRequest = connection.prepareStatement(PopulateDBRequest.addClients());
        PreparedStatement projectsRequest = connection.prepareStatement(PopulateDBRequest.addProjects());
        PreparedStatement projectsWorkersRequest = connection.prepareStatement(PopulateDBRequest.addProjectsWorkers());
        for (Worker elem:workers){
            workersRequest.setLong(1, elem.getId());
            workersRequest.setString(2, elem.getName());
            workersRequest.setDate(3, elem.getBirthday());
            workersRequest.setString(4, elem.getWlevel());
            workersRequest.setInt(5, elem.getSalary());
            workersRequest.addBatch();
        }
        workersRequest.executeBatch();

        for (Client elem:clients){
            clientsRequest.setLong(1, elem.getId());
            clientsRequest.setString(2, elem.getName());
            clientsRequest.addBatch();
        }
        clientsRequest.executeBatch();

        Random random1 = new Random();
        for (Project project : projects) {
            int clientIdIndex = random1.nextInt(clients.size());
            projectsRequest.setLong(1, project.getId());
            projectsRequest.setLong(2, clients.get(clientIdIndex).getId());
            projectsRequest.setDate(3, project.getStart_date());
            projectsRequest.setDate(4, project.getFinish_date());
            projectsRequest.addBatch(); // Add to batch
        }
        projectsRequest.executeBatch();


        Random random2 = new Random();
        for (int i = 1; i < projects.size()+1; i++) {
            int workerIndex = random2.nextInt(workers.size());
            projectsWorkersRequest.setLong(1, i);
            projectsWorkersRequest.setLong(2, workers.get(workerIndex).getId());
            projectsWorkersRequest.addBatch();
        }
        projectsWorkersRequest.executeBatch();
    }
}
