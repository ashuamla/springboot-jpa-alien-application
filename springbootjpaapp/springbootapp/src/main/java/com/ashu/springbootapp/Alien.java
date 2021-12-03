package com.ashu.springbootapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {
    @Id
    private int aid;
    private String aname;
    public int getAid() {
        return aid;
    }
    public void setAid(int aid) {
        this.aid = aid;
    }
    public String getAname() {
        return aname;
    }
    public void setAname(String aname) {
        this.aname = aname;
    }
    @Override
    public String toString() {
        return "Alient [aid=" + aid + ", aname=" + aname + "]";
    }
    
    
}
