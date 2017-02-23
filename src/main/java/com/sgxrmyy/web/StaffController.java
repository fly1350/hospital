package com.sgxrmyy.web;

import com.sgxrmyy.entity.StaffDict;
import com.sgxrmyy.serive.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 袁明 on 2017/2/22.
 */
@RestController
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping("list")
    public List<StaffDict> list(){
        return staffService.findAll();
    }
}
