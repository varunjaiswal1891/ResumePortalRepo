package io.javabrains.resumeportal.models;

import javax.persistence.*;

@Entity
@Table
public class UserProfile {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int theme;
    private String userName;
    private String summary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTheme() {
        return theme;
    }

    public void setTheme(int theme) {
        this.theme = theme;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
