package pl.dawidkaszuba.homeBudget.model;

import java.util.Date;

public class LoggedUser {

    private String userName;
    private Long id;
    private String token;
    private Date expirationDate;

    public LoggedUser(String userName, Long id, String token, Date expirationDate) {
        this.userName = userName;
        this.id = id;
        this.token = token;
        this.expirationDate = expirationDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
