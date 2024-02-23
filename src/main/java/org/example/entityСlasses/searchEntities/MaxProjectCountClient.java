package org.example.entityСlasses.searchEntities;

import java.sql.Date;

public class MaxProjectCountClient {
    private Long id;
    private Long client_id;
    private Date start_date;
    private Date finish_date;
    private int freq;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
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

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    @Override
    public String toString() {
        return "MaxProjectCountClient{" +
                "id=" + id +
                ", client_id=" + client_id +
                ", start_date=" + start_date +
                ", finish_date=" + finish_date +
                ", freq=" + freq +
                '}';
    }
}
