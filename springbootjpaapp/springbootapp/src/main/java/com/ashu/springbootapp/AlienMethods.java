package com.ashu.springbootapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlienMethods extends JpaRepository<Alien, Integer>{

    <List> Alien findByAname(String aname);

    @Query("from Alien where aid>?1 order by aname")
    <List> Alien findByAidGreaterThan(int aid);
    
}
