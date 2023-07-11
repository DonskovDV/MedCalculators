package com.MedCalculator.service.impl;

import com.MedCalculator.dto.ResultDto;
import com.MedCalculator.dto.IMTDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
@Schema(description = "Сервис для IMT")
public class IMTservice {

    public Double calculate(IMTDto object) {
        double height_m=object.getHeight()/100;
        double value = object.getWeight()/(Math.pow(height_m,2));
        value = Math.round(value * 100);
        value = value/100;
        return value;
    }

    public ResultDto calculateResult(IMTDto dto) {
        Double offset;
        offset=calculate(dto);
        if(offset==null || offset==0){
            return null;
        }
        return result(offset);
    }

    public ResultDto result(Double index) {
        if(index==null){
            return null;
        }

        ResultDto res = new ResultDto();
        res.setTitle(String.format("индекс массы тела - %s",index));
        if (index >= 40) {
            res.setDetails("Ожирение третьей степени (морбидное)");
        }
        else if(index < 40 && index >= 35) {
            res.setDetails("Ожирение второй степени");
        }
        else if(index < 35 && index >= 30) {
            res.setDetails("Ожирение первой степени");
        }
        else if (index < 30 && index >= 25) {
            res.setDetails("Избыточная масса тела (предожирение)");
        }
        else if (index < 25 && index >= 18.5) {
            res.setDetails("Норма");
        }
        else if (index < 18.5 && index >= 16) {
            res.setDetails("Недостаточная (дефицит) масса тела");
        }
        else if (index < 16) {
            res.setDetails("Выраженный дефицит массы тела");
        }
        return res;
    }



}
