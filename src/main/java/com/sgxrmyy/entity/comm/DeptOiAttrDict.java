package com.sgxrmyy.entity.comm;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author 袁明 on 2017/2/22.
 */
@Entity
@Data
public class DeptOiAttrDict {

    @Id
    private Byte oiAttrCode;
    private String oiAttrName;
    private String inputCode;

}
