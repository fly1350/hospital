package com.sgxrmyy.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 员工字典实体类
 * @author 袁明 on 2017/2/13.
 */
@Entity
@Table(name = "STAFF_DICT",schema = "COMM")
@Data
public class StaffDict {

    @Id
    private String id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 姓名
     */
    private String name;
    /**
     * 员工号
     */
    private String empNo;
    private String password;
    /**
     * 职称
     */
    private String title;
    /**
     * 工种
     */
    private String job;
    /**
     * 科室
     */
    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "dept_code")
    private DeptDict dept;
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createDate;
    private String inputCode;
    private Integer status;
}
