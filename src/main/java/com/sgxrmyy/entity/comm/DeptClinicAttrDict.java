package com.sgxrmyy.entity.comm;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 科室临床属性字典
 * @author 袁明 on 2017/2/22.
 */
@Entity
@Table(name = "DEPT_CLINIC_ATTR_DICT",schema = "COMM")
@Data
public class DeptClinicAttrDict {

    @Id
    private Byte clinicAttrCode;
    private String clinicAttrName;
    private String inputCode;
}
