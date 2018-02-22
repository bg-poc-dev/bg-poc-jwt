package com.bg.poc.bgpocjwtservice.persist.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "tbl_group")
@Data
public class Group {

    @Id
    @Column(name = "uid")
    private String id;

    private String name;
}
