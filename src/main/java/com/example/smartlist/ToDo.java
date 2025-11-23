package com.example.smartlist;

import java.time.LocalDate;

public class ToDo {
    private String title;
    private String description;
    private String dueDate;
    private String category;
    private String priority;

    //
    public ToDo(String title, String description, LocalDate date, String category, String priority){
        this.title = title;
        this.description = description;
        this.dueDate = (date != null) ? date.toString() : "";
        this.category = category;
        this.priority = priority;
    }

    public String getTitle(){ return title; }
    public String getDescription() { return description; }
    public String getDueDate() { return dueDate;}
    public String getCategory() { return category; }
    public String getPriority() { return priority; }

}
