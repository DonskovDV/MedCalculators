package com.MedCalculator.service.impl;

import com.MedCalculator.dto.HasBledDto;
import com.MedCalculator.dto.ResultDto;
import com.MedCalculator.service.MedicalCalculatorService;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
@Schema(description = "Сервис для Has-Bled")
public class HasBledservice implements MedicalCalculatorService<HasBledDto>{

    public Integer calculate(HasBledDto object) {
        int sum=0;
        if(object.getCheck1() == 1) sum+=1;
        if(object.getCheck2() == 1) sum+=1;
        if(object.getCheck3() == 1) sum+=1;
        if(object.getCheck4() == 1) sum+=1;
        if(object.getCheck5() == 1) sum+=1;
        if(object.getCheck6() == 1) sum+=1;
        if(object.getCheck7() == 1) sum+=1;
        if(object.getCheck8() == 1) sum+=1;
        if(object.getCheck9() == 1) sum+=1;
        return sum;
    }

    @Override
    public ResultDto calculateResult(HasBledDto dto) {
        Integer offset;
        offset = calculate(dto);
        if(offset==null){
            return null;
        }
        return result(offset);
    }

    @Override
    public ResultDto result(Integer scales) {
        if (scales ==null){
            return null;
        }
        ResultDto res = new ResultDto();
        res.setTitle(String.format("%s баллов по шкале HAS-BLED", scales));
        if (scales == 0 ) res.setDetails("Риск кровотечения у пациентов, принимающих варфарин 0.9%." +
                "Назначение антикоагулянтов должно быть рассмотрено." +
                " Пациент имеет относительно низкий риск кровотечения.");
        if (scales == 1 ) res.setDetails("Риск кровотечения у пациентов, принимающих варфарин 3.4%." +
                "Назначение антикоагулянтов должно быть рассмотрено." +
                " Пациент имеет относительно низкий риск кровотечения.");
        if (scales == 2 ) res.setDetails("Риск кровотечения у пациентов, принимающих варфарин 4.1%." +
                "Назначение антикоагулянтов может быть рассмотрено." +
                " Тем не менее, пациент имеет средний риск кровотечения.");
        if (scales == 3 ) res.setDetails("Риск кровотечения у пациентов, принимающих варфарин 5.8%." +
                "Следует рассмотреть альтернативы антикоагулянтной терапии." +
                " Пациент имеет высокий риск кровотечения.");
        if (scales == 4 ) res.setDetails("Риск кровотечения у пациентов, принимающих варфарин 8.9%." +
                "Следует рассмотреть альтернативы антикоагулянтной терапии." +
                " Пациент имеет высокий риск кровотечения.");
        if (scales == 5 ) res.setDetails("Риск кровотечения у пациентов, принимающих варфарин 9.1%." +
                "Следует рассмотреть альтернативы антикоагулянтной терапии." +
                " Пациент имеет высокий риск кровотечения.");
        if (scales > 5 ) res.setDetails("Сумма баллов более 5 является слишком редкой для установления риска." +
                "Следует рассмотреть альтернативы антикоагулянтной терапии." +
                " Пациент имеет высокий риск кровотечения.");
        return res;
    }



}
