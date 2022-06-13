package com.empik.entity;

import javax.persistence.*;

@Entity
@Table
public class QueryCount {

    @Id
    @Column(name = "LOGIN")
    private String login;

    @Column(name = "REQUEST_COUNT")
    private long requestCount;

    public QueryCount() {
    }

    public QueryCount(String name, long requestCount) {
        this.login = name;
        this.requestCount = requestCount;
    }

    public QueryCount(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public long getRequestCount() {
        return requestCount;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setRequestCount(long requestCount) {
        this.requestCount = requestCount;
    }
}