package ua.goit.java.module_8;

import java.io.Serializable;

public class Task implements Serializable {
    private int id;
    private String name;
    private String category;
    private boolean isCompleted;

    public Task() {
    }

    public Task(String name, String category, boolean isCompleted) {
        this.name = name;
        this.category = category;
        this.isCompleted = isCompleted;
    }

    public Task(int id, String name, String category, boolean isCompleted) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.isCompleted = isCompleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
