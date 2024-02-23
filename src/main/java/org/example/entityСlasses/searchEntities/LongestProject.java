package org.example.entityСlasses.searchEntities;

public class LongestProject {
    private long id;
    private int max;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "id=" + id +
                ", max=" + max +
                '}';
    }
}
