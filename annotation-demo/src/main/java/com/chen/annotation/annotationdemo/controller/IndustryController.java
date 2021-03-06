package com.chen.annotation.annotationdemo.controller;

import com.chen.annotation.anno.PermissionDependency;
import com.chen.annotation.anno.PermissionModule;
import com.chen.annotation.anno.PermissionRequest;
import com.chen.annotation.annotationdemo.entity.Company;

import java.util.List;

@PermissionModule(id = "industry", name = "industry模块")
public class IndustryController {
    @PermissionRequest(PermissionRequest.Permission.Read)
    public List<Company> getCompanys() {
      return null;
    }

    @PermissionRequest(PermissionRequest.Permission.Read)
    public Company getCompanyById() {
        return new Company(1, "company1", "test");
    }

    @PermissionRequest(PermissionRequest.Permission.Update)
    public Company updateCompanyById() {
        return new Company(1, "company1", "test");
    }
}
