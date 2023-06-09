package com.hi.app.service;

import com.hi.app.domain.EmpDTO;
import com.hi.app.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpReadService {

    @Autowired
    private EmpMapper mapper;

    public EmpDTO readEmp(int empno){
        return mapper.selectByEmpno(empno);
    }

}
