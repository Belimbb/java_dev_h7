package org.example;

import org.example.entityСlasses.Worker;
import org.example.entityСlasses.searchEntities.LongestProject;
import org.example.entityСlasses.searchEntities.MaxProjectCountClient;
import org.example.entityСlasses.searchEntities.ProjectPrice;
import org.example.entityСlasses.searchEntities.YoungestAndEldestWorker;
import org.example.serviceClasses.FileService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public List<LongestProject> findLongestProject() throws SQLException {
        String filePath = "src/main/resources/sql/find_longest_project.sql";
        ResultSet resultSet = getResultSet(filePath);

        List<LongestProject> result = new ArrayList<>();
        while (resultSet.next()){
            LongestProject longestProject = new LongestProject();
            longestProject.setId(resultSet.getLong("id"));
            longestProject.setMax(resultSet.getInt("max"));

            result.add(longestProject);
        }

        return result;
    }
    public List<MaxProjectCountClient> findMaxProjectsClient() throws SQLException {
        String filePath = "src/main/resources/sql/find_max_projects_client.sql";
        ResultSet resultSet = getResultSet(filePath);

        List<MaxProjectCountClient> result = new ArrayList<>();
        while (resultSet.next()){
            MaxProjectCountClient mxpcc = new MaxProjectCountClient();

            mxpcc.setId(resultSet.getLong("id"));
            mxpcc.setClient_id(resultSet.getLong("client_id"));
            mxpcc.setStart_date(resultSet.getDate("start_date"));
            mxpcc.setFinish_date(resultSet.getDate("finish_date"));
            mxpcc.setFreq(resultSet.getInt("freq"));

            result.add(mxpcc);
        }
        return result;
    }

    public List<Worker> findMaxSalaryWorker() throws SQLException {
        String filePath = "src/main/resources/sql/find_max_salary_worker.sql";
        ResultSet resultSet = getResultSet(filePath);

        List<Worker> result = new ArrayList<>();
        while (resultSet.next()){
            Worker worker = new Worker();

            worker.setId(resultSet.getLong("id"));
            worker.setName(resultSet.getString("name"));
            worker.setBirthday(resultSet.getDate("birthday"));
            worker.setWlevel(resultSet.getString("wlevel"));
            worker.setSalary(resultSet.getInt("salary"));

            result.add(worker);
        }
        return result;
    }

    public List<YoungestAndEldestWorker> findYoungestAndEldestWorker() throws SQLException {
        String filePath = "src/main/resources/sql/find_youngest_eldest_workers.sql";
        ResultSet resultSet = getResultSet(filePath);

        List<YoungestAndEldestWorker> result = new ArrayList<>();
        while (resultSet.next()){
            YoungestAndEldestWorker worker = new YoungestAndEldestWorker();

            worker.setName(resultSet.getString("name"));
            worker.setBirthday(resultSet.getDate("birthday"));
            worker.setType(resultSet.getString("type"));

            result.add(worker);
        }
        return result;
    }

    public List<ProjectPrice> getProjectPrices() throws SQLException {
        String filePath = "src/main/resources/sql/print_project_prices.sql";
        ResultSet resultSet = getResultSet(filePath);

        List<ProjectPrice> result = new ArrayList<>();
        while (resultSet.next()){
            ProjectPrice projectPrice = new ProjectPrice();

            projectPrice.setProject_id(resultSet.getLong("project_id"));
            projectPrice.setPrice(resultSet.getInt("price"));

            result.add(projectPrice);
        }
        return result;
    }

    private ResultSet getResultSet(String filePath) throws SQLException {
        String dbRequest = FileService.getFileContent(filePath);

        Connection connection = Database.getConnection();
        PreparedStatement queryStatement  = connection.prepareStatement(dbRequest);

        return queryStatement.executeQuery();
    }
}
