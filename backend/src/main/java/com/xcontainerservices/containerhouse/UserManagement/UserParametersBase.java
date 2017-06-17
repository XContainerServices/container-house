package com.xcontainerservices.containerhouse.UserManagement;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "UserDetails" )
public class UserParametersBase {

    @Id
    private int uid;
    private String username;
    private String password;
    private boolean isAdmin;

    public void setUid(int uid) {
        this.uid = uid;

    }
    
    public int getUid() {
        return this.uid;

    }
    
    public void setUsername(String username) {
        this.username = username;

    }
    
    public String getUsername() {
        return this.username;

    }
    
    public void setPassword(String password) {
        this.password = password;

    }
    
    public String getPassword() {
        return this.password;

    }
    
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;

    }
    
    public boolean getIsAdmin() {
        return isAdmin;

    }
}
