package com.MedCalculator.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Schema(description = "Сущность калькулятора Has-Bled")
@Data
public class HasBledDto extends BaseCalcDto {
    private  Integer check1;
    private  Integer check2;
    private  Integer check3;
    private  Integer check4;
    private  Integer check5;
    private  Integer check6;
    private  Integer check7;
    private  Integer check8;
    private  Integer check9;

    public HasBledDto (Integer check1, Integer check2, Integer check3, Integer check4, Integer check5,
                       Integer check6,Integer check7, Integer check8, Integer check9){
        this.check1=check1;
        this.check2=check2;
        this.check3=check3;
        this.check4=check4;
        this.check5=check5;
        this.check6=check6;
        this.check7=check7;
        this.check8=check8;
        this.check9=check9;
    }
}
