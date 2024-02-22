package org.example.entityСlasses;

import java.sql.Date;

public class Project {
    private long id;
    private long client_id;
    private Date start_date;
    private Date finish_date;

    public Project() {
    }

    public Project(Long id, Date start_date, Date finish_date) {
        this.id = id;
        this.start_date = start_date;
        this.finish_date = finish_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClient_id() {
        return client_id;
    }

    public void setClient_id(long client_id) {
        this.client_id = client_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(Date finish_date) {
        this.finish_date = finish_date;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", client_id=" + client_id +
                ", start_date=" + start_date +
                ", finish_date=" + finish_date +
                '}';
    }
}
