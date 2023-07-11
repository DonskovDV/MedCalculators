package com.MedCalculator.dto;

import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;
@Data
@Schema(description = "Сущность калькулятора ApacheII")
public class ApacheIIdto extends BaseCalcDto {
    private Integer disfunction;
    private Integer renal_failure;
    private Integer age;
    private Double rectal_temp;
    private Integer avg_blood_pressure;
    private Integer heart_rate;
    private Integer breath_rate;
    private Integer serum_sodium; //натрий сыворотки
    private Double serum_potassium; //Калий сыворотки
    private Integer serum_creatinine;
    private Integer hematocrit;
    private Double leuko;
    private Integer glasgow;
    private Integer bicarbonate;
    private Double pH;
    private Integer paO2;
    private Integer a_a_gradient;

    public ApacheIIdto(Integer disfunction, Integer renal_failure, Integer age,
                       Double rectal_temp, Integer avg_blood_pressure, Integer heart_rate,
                       Integer breath_rate, Integer serum_sodium, Double serum_potassium,
                       Integer serum_creatinine, Integer hematocrit, Double leuko, Integer glasgow,
                       Integer  bicarbonate, Double pH, Integer paO2, Integer a_a_gradient){
        this.disfunction=disfunction;
        this.renal_failure=renal_failure;
        this.age=age;
        this.rectal_temp=rectal_temp;
        this.avg_blood_pressure=avg_blood_pressure;
        this.heart_rate=heart_rate;
        this.breath_rate=breath_rate;
        this.serum_sodium=serum_sodium;
        this.serum_potassium=serum_potassium;
        this.serum_creatinine=serum_creatinine;
        this.hematocrit=hematocrit;
        this.leuko=leuko;
        this.glasgow=glasgow;
        this.bicarbonate=bicarbonate;
        this.paO2=paO2;
        this.pH=pH;
        this.a_a_gradient=a_a_gradient;
    }
}
