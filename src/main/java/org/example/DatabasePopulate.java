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
            workersRequest.setString(1, elem.getName());
            workersRequest.setDate(2, elem.getBirthday());
            workersRequest.setString(3, elem.getWlevel());
            workersRequest.setInt(4, elem.getSalary());
            workersRequest.addBatch();
        }
        workersRequest.executeBatch();

        for (Client elem:clients){
            clientsRequest.setString(1, elem.getName());
            clientsRequest.addBatch();
        }
        clientsRequest.executeBatch();

        Random random1 = new Random();
        for (Project project : projects) {
            long clientId = random1.nextInt(clients.size())+1;
            projectsRequest.setLong(1, clientId);
            projectsRequest.setDate(2, project.getStart_date());
            projectsRequest.setDate(3, project.getFinish_date());
            projectsRequest.addBatch(); // Add to batch
        }
        projectsRequest.executeBatch();


        Random random2 = new Random();
        for (int i = 1; i < projects.size()+1; i++) {
            long workerId= random2.nextInt(workers.size())+1;
            projectsWorkersRequest.setLong(1, i);
            projectsWorkersRequest.setLong(2, workerId);
            projectsWorkersRequest.addBatch();
        }
        projectsWorkersRequest.executeBatch();
    }
}
