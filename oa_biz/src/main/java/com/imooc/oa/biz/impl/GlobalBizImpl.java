package com.imooc.oa.biz.impl;

import com.imooc.oa.biz.GlobalBiz;
import com.imooc.oa.dao.EmployeeDao;
import com.imooc.oa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("globalBiz")
public class GlobalBizImpl implements GlobalBiz {
    @Autowired
    private EmployeeDao employeeDao;
    @Override
    public Employee login(String sn, String password) {
        Employee employee=employeeDao.select(sn);
        if(employee!=null&&employee.getPassword().equals(password))
            return employee;
        return null;
    }

    @Override
    public void changePassword(Employee employee) {
        System.out.println("changePassword");
        employeeDao.update(employee);
    }
}
