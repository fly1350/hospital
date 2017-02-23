package com.sgxrmyy.serive;

import com.sgxrmyy.entity.StaffDict;

import java.util.List;

/**
 * @author 袁明 on 2017/2/13.
 */
public interface StaffService {

    public StaffDict findByUserName(String username);
    public StaffDict findByName(String name);

    List<StaffDict> findAll();
}
