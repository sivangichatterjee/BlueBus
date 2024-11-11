package com.nrifintech.bms.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author	Debopam
 * @email	debpal07@gmail.com
 * @created	Nov 9, 2021
 */
@MappedSuperclass
public class AbstractBaseEntity implements Serializable{


 //  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)										NOTE: TO BE IMPLEMENTED IN SUBCLASS
  // private Long id;

//    @Version
//    private int version;
    
    @CreationTimestamp
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @UpdateTimestamp
    @Column(updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    
}