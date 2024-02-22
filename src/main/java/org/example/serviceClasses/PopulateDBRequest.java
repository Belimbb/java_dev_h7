package org.example.serviceClasses;

public class PopulateDBRequest {
    public static String addWorkers(){
        return "insert into public.worker (name, birthday, wLevel, salary) values (?, ?, ?, ?);";
    }
    public static String addClients(){
        return "insert into client (name) values (?);";
    }
    public static String addProjects(){
        return "insert into project (client_id, start_date, finish_date) values (?, ?, ?);";
    }
    public static String addProjectsWorkers(){
        return "insert into project_worker values (?, ?);";
    }
}
