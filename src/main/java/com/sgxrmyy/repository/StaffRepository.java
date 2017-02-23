package com.sgxrmyy.repository;

import com.sgxrmyy.entity.StaffDict;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 袁明 on 2017/2/13.
 */
public interface StaffRepository extends JpaRepository<StaffDict,String> {

    StaffDict findByName(String name);

    StaffDict findByUserName(String userName);

}
