//This one for estimate detail page second table
package com.example.SPSProjectBackend.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class EstimateItemDTO {
    // Getters and Setters
    private String lineType; // Maps to LINE_TYPE (code)
    private String uom;      // Maps to UOM
    private String linedes;  // Maps to LINEDES (description)
    private Float length;    // Maps to LENGTH (quantity/length)
    private Double estCost;  // Maps to EST_COST (standard rate)
    private Double lineCost; // Maps to LINE_COST (cost)
    private BigDecimal demand; // Maps to DEMAND from WIRING_LAND_DETAIL

}