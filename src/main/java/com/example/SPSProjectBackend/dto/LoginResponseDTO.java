package com.example.SPSProjectBackend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class LoginResponseDTO {
    private String userLevel;
    private List<LoginBranchInfoDTO> branchInfoList;
    private String deptId;
    private String message;

    public LoginResponseDTO(String userLevel, List<LoginBranchInfoDTO> branchInfoList, String deptId, String message) {
        this.userLevel = userLevel;
        this.branchInfoList = branchInfoList;
        this.deptId = deptId;
        this.message = message;
    }

}
