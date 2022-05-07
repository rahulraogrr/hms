package com.hotel.entites;

import com.hotel.constants.Gender;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "A_EMPLOYEES")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_generator")
    @SequenceGenerator(name = "emp_generator", sequenceName = "EMP_SEQUENCE")
    private long id;

    private String firstName;
    private String middleName;
    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    private int eduType;

    @Temporal(TemporalType.DATE)
    private Date hireDate;

    @Temporal(TemporalType.DATE)
    private Date lastDate;

    private int idType;
    private String idNo;
    private String mobile;
    private Gender gender;
    private long reportsTo;
    private int designation;
    private int status;
    private boolean currAddSameAsPermAdd;

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