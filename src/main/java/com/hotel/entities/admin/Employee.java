package com.hotel.entities.admin;

import com.hotel.constants.Gender;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "A_EMPLOYEES")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    private int designation;
    private int status;
    private boolean currAddSameAsPermAdd;
    private int grade;

    /** Self-referencing manager relationship. Null for top-level employees. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reports_to", referencedColumnName = "id")
    private Employee manager;

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