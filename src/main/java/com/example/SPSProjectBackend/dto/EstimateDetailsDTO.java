package com.example.SPSProjectBackend.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class EstimateDetailsDTO {
    // Getters and Setters
    private Double secdeposit;
    private Double cebcost;
    private Double rebateCost;
    private Double vatcost;
    private Double nbtcost;
    private Double sctcost;
    private Double toconpay;
    private BigDecimal demand;

}