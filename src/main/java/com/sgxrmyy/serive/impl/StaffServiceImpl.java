package com.sgxrmyy.serive.impl;

import com.sgxrmyy.entity.StaffDict;
import com.sgxrmyy.repository.StaffRepository;
import com.sgxrmyy.serive.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 袁明 on 2017/2/13.
 */
@Transactional
@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Transactional(readOnly = true)
    @Override
    public StaffDict findByUserName(String username) {
        return staffRepository.findByUserName(username);
    }

    @Transactional(readOnly = true)
    @Override
    public StaffDict findByName(String name) {
        return staffRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public List<StaffDict> findAll() {
        return staffRepository.findAll(new Sort(Sort.Direction.ASC,"userName"));
    }
}
