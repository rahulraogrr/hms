package com.hotel.entites;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "A_EMPLOYEES")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String middleName;
    private String lastName;
    private Date dateOfBirth;
    private int eduType;
    private Date hireDate;
    private Date lastDate;
    private int idType;
    private String idNo;
    private String mobile;
    private int gender;
    private long reportsTo;
    private int designation;
    private int status;

    @ManyToOne
    @JoinColumn(name = "emp_dept_id", referencedColumnName = "id")
    private Department department;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "emp_perm_add_id", referencedColumnName = "id")
    private Address permAddress;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "emp_cur_add_id", referencedColumnName = "id")
    private Address curAddress;

    @CreationTimestamp
    private Date createTs;

    @UpdateTimestamp
    private Date updateTs;
}