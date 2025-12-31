package com.example.SPSProjectBackend.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginBranchInfoDTO {
    private String deptId;
    private String deptType;
    private String deptTypeName;
    private String menuCode;
    private String menuName;
    private String activityCode;
    private String activityName;

    public LoginBranchInfoDTO(String deptId, String deptType, String deptTypeName, String menuCode, String menuName, String activityCode, String activityName) {
        this.deptId = deptId;
        this.deptType = deptType;
        this.deptTypeName = deptTypeName;
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.activityCode = activityCode;
        this.activityName = activityName;
    }

}
