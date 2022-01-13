package com.gonana.demo.model.entity.main;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Main {

    @Id
    @Column(name = "SYSDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sysdate;

    public Main(){}

    @Builder
    public Main(Date sysdate){
        this.sysdate = sysdate;
    }
}
