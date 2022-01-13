package com.gonana.demo.service.main.impl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.gonana.demo.model.entity.main.Main;
import com.gonana.demo.service.main.MainService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {

    @PersistenceContext
    EntityManager em;

    @Override
    public Date getSysdate(){
        //Query query = em.createQuery("SELECT DATE_FORMAT(CURRENT_TIMESTAMP, '%Y.%m.%d %H:%i:%s') AS sysdate", Main.class);
        Query query = em.createNativeQuery("SELECT DATE_FORMAT(CURRENT_TIMESTAMP, '%Y.%m.%d %H:%i:%s') AS sysdate", Main.class);
        Main main = (Main)query.getSingleResult();

        return main.getSysdate();
    }

    @Override
    public Main getSysdateOnApi(){
        Query query = em.createNativeQuery("SELECT CURRENT_TIMESTAMP AS sysdate", Main.class);
        Main main = (Main) query.getSingleResult();

       return main;
    }
    
}
