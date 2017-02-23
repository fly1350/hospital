package com.sgxrmyy.entity;

import com.sgxrmyy.entity.comm.DeptClinicAttrDict;
import com.sgxrmyy.entity.comm.DeptIsAttrDict;
import com.sgxrmyy.entity.comm.DeptOiAttrDict;
import lombok.Data;

import javax.persistence.*;

/**
 * 科室字典实体类
 *
 * @author 袁明 on 2017/2/22.
 */
@Table(name = "dept_dict",schema = "COMM")
@Entity
@Data
public class DeptDict {
    /**
     * 科室代码，使用层次代码，由用户定义
     */
    @Id
    private String deptCode;
    /**
     * 科室的正式名称
     */
    private String deptName;
    /**
     * 科室简称或别名
     */
    private String deptAlias;
    /**
     * 临床科室属性，描述本科室属于临床、辅诊、护理单元、机关、其他，本系统定义，见科室临床属性字典
     */
    @ManyToOne(cascade = {CascadeType.PERSIST},fetch = FetchType.EAGER)
    @JoinColumn(name = "CLINIC_ATTR")
    private DeptClinicAttrDict clinicAttr;
    /**
     * 门诊住院科室标志，描述本科室属于门诊或住院科室，本系统定义，见科室门诊住院属性字典DEPT_OI_ATTR_DICT
     */
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "outp_or_inp")
    private DeptOiAttrDict outpOrInp;
    /**
     * 内外科标志，如果是临床科室，则区分内外科，本系统定义，见科室内外科属性字典DEPT_IS_ATTR_DICT
     */
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "INTERNAL_OR_SERGERY")
    private DeptIsAttrDict internalOrSergery;
    /**
     * 输入码
     */
    private String inputCode;
    /**
     * 摆药累积属性,是否参与摆药累积:0-否 1-是
     */
    private boolean dispensingCumulate;

}
