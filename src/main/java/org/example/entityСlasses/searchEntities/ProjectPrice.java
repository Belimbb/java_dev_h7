package org.example.entityСlasses.searchEntities;

public class ProjectPrice {
    private Long project_id;
    private int price;

    public Long getProject_id() {
        return project_id;
    }

    public void setProject_id(Long project_id) {
        this.project_id = project_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProjectPrice{" +
                "project_id=" + project_id +
                ", price=" + price +
                '}';
    }
}
