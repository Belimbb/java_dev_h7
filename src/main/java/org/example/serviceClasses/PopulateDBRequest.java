package org.example.serviceClasses;

public class PopulateDBRequest {
    public static String addWorkers(){
        return "insert into public.worker values (?, ?, ?, ?, ?);";
    }
    public static String addClients(){
        return "insert into client values (?, ?);";
    }
    public static String addProjects(){
        return "insert into project values (?, ?, ?, ?);";
    }
    public static String addProjectsWorkers(){
        return "insert into project_worker values (?, ?);";
    }
}
