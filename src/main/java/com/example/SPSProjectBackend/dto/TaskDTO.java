package com.example.SPSProjectBackend.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskDTO {
    private String menuCode;
    private String activityCode;
    private String activityName;

    public TaskDTO(String menuCode, String activityCode, String activityName) {
        this.menuCode = menuCode;
        this.activityCode = activityCode;
        this.activityName = activityName;
    }

}