package com.sgxrmyy.entity.comm;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author 袁明 on 2017/2/22.
 */
@Entity
@Data
public class DeptIsAttrDict {

    @Id
    private Byte isAttrCode;
    private String isAttrName;
    private String inputCode;

}
