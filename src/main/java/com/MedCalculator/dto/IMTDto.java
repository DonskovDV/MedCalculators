package com.MedCalculator.dto;

import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;
@Data
@Schema(description = "Сущность калькулятора IMT")
public class IMTDto extends BaseCalcDto {
    private  Double weight;
    private  Double height;

    public IMTDto (Double weight, Double height)
    {
        this.weight=weight;
        this.height=height;
    }
}
