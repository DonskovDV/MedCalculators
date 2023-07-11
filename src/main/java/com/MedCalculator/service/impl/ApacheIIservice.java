package com.MedCalculator.service.impl;

import com.MedCalculator.dto.ApacheIIdto;
import com.MedCalculator.dto.ResultDto;
import com.MedCalculator.service.MedicalCalculatorService;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
@Schema(description = "Сервис для Apache")
public class ApacheIIservice implements MedicalCalculatorService<ApacheIIdto> {

    public Integer calculate(ApacheIIdto object) {
        int sum=0;

        switch (object.getDisfunction()) {
            case 1 -> sum += 0;
            case 2 -> sum += 5;
            case 3 -> sum += 2;
            case 4 -> sum += 5;
        }

        if (object.getAge() >= 45 && object.getAge() <= 54) sum += 2;
        else if (object.getAge() >= 55 && object.getAge() <= 64) sum += 3;
        else if (object.getAge() >= 55 && object.getAge() <= 74) sum += 5;
        else if (object.getAge() > 74) sum += 6;

        if (object.getRectal_temp() > 40.9) sum += 4;
        else if (object.getRectal_temp() >= 39 && object.getRectal_temp() <= 40.9) sum += 3;
        else if (object.getRectal_temp() >= 38.5 && object.getRectal_temp() <= 38.9) sum += 1;
        else if (object.getRectal_temp() >= 36 && object.getRectal_temp() <= 38.4) sum += 0;
        else if (object.getRectal_temp() >= 34 && object.getRectal_temp() <= 35.9) sum += 1;
        else if (object.getRectal_temp() >= 32 && object.getRectal_temp() <= 33.9) sum += 2;
        else if (object.getRectal_temp() >= 30 && object.getRectal_temp() <= 31.9) sum += 3;
        else if (object.getRectal_temp() < 30) sum += 4;

        if (object.getAvg_blood_pressure() > 159) sum +=4;
        else if (object.getAvg_blood_pressure() >= 130 && object.getAvg_blood_pressure() <= 159) sum +=3;
        else if (object.getAvg_blood_pressure() >= 110 && object.getAvg_blood_pressure() <= 129) sum +=2;
        else if (object.getAvg_blood_pressure() >= 70 && object.getAvg_blood_pressure() <= 109) sum +=0;
        else if (object.getAvg_blood_pressure() >= 50 && object.getAvg_blood_pressure() <= 69) sum +=2;
        else if (object.getAvg_blood_pressure() < 50) sum +=4;

        if  (object.getHeart_rate() > 179) sum +=4;
        else if (object.getHeart_rate() >=140 && object.getHeart_rate() <= 179) sum +=3;
        else if (object.getHeart_rate() >=110 && object.getHeart_rate() <= 139) sum +=2;
        else if (object.getHeart_rate() >=70 && object.getHeart_rate() <= 109) sum +=0;
        else if (object.getHeart_rate() >=55 && object.getHeart_rate() <= 69) sum +=2;
        else if (object.getHeart_rate() >=40 && object.getHeart_rate() <= 54) sum +=3;
        else if (object.getHeart_rate() < 40) sum +=4;

        if (object.getBreath_rate() > 49) sum+=4;
        else if (object.getBreath_rate() >= 35 && object.getBreath_rate() <= 49) sum+=3;
        else if (object.getBreath_rate() >= 25 && object.getBreath_rate() <= 34) sum+=1;
        else if (object.getBreath_rate() >= 12 && object.getBreath_rate() <= 24) sum+=0;
        else if (object.getBreath_rate() >= 10 && object.getBreath_rate() <= 11) sum+=1;
        else if (object.getBreath_rate() >= 6 && object.getBreath_rate() <= 9) sum+=2;
        else if (object.getBreath_rate() < 6) sum+=4;

        if (object.getSerum_sodium() > 179) sum+=4;
        else if (object.getSerum_sodium() >= 160 && object.getSerum_sodium() <= 179) sum+=3;
        else if (object.getSerum_sodium() >= 155 && object.getSerum_sodium() <= 159) sum+=2;
        else if (object.getSerum_sodium() >= 150 && object.getSerum_sodium() <= 154) sum+=1;
        else if (object.getSerum_sodium() >= 130 && object.getSerum_sodium() <= 149) sum+=0;
        else if (object.getSerum_sodium() >= 120 && object.getSerum_sodium() <= 129) sum+=2;
        else if (object.getSerum_sodium() >= 111 && object.getSerum_sodium() <= 119) sum+=3;
        else if (object.getSerum_sodium() < 111) sum+=4;

        if (object.getSerum_potassium() > 6.9) sum+= 4;
        else if (object.getSerum_potassium() >=6 && object.getSerum_potassium() <= 6.9) sum +=3;
        else if (object.getSerum_potassium() >=5.5 && object.getSerum_potassium() <= 5.9) sum +=1;
        else if (object.getSerum_potassium() >=3.5 && object.getSerum_potassium() <= 5.4) sum +=0;
        else if (object.getSerum_potassium() >=3 && object.getSerum_potassium() <= 3.4) sum +=1;
        else if (object.getSerum_potassium() >=2.5 && object.getSerum_potassium() <= 2.9) sum +=2;
        else if (object.getSerum_potassium() < 2.5) sum +=4;

        if (object.getSerum_creatinine() > 300.56 && object.getRenal_failure() == 2 ) sum +=8;
        else if (object.getSerum_creatinine() >= 176.8 && object.getRenal_failure() == 2 && object.getSerum_creatinine() <= 300.56 ) sum +=6;
        else if (object.getSerum_creatinine() > 300.56 && object.getRenal_failure() == 1 ) sum +=4;
        else if (object.getSerum_creatinine() >= 132.6 && object.getRenal_failure() == 2 && object.getSerum_creatinine() <= 176.7 ) sum +=4;
        else if (object.getSerum_creatinine() >= 176.8 && object.getRenal_failure() == 1 && object.getSerum_creatinine() <= 300.56 ) sum +=3;
        else if (object.getSerum_creatinine() >= 132.6 && object.getRenal_failure() == 1 && object.getSerum_creatinine() <= 176.7 ) sum +=2;
        else if (object.getSerum_creatinine() >= 53.04 && object.getSerum_creatinine() <= 132.5 ) sum +=0;
        else if (object.getSerum_creatinine() < 53.04) sum +=2;

        if (object.getHematocrit() > 59.9) sum += 4;
        else if (object.getHematocrit() >= 50 && object.getHematocrit() <= 59.9) sum += 2;
        else if (object.getHematocrit() >= 46 && object.getHematocrit() <= 49.9) sum += 1;
        else if (object.getHematocrit() >= 30 && object.getHematocrit() <= 45.9) sum += 0;
        else if (object.getHematocrit() >= 20 && object.getHematocrit() <= 29.9) sum += 2;
        else if (object.getHematocrit() < 20) sum += 4;

        if (object.getLeuko() > 39.9) sum+=4;
        else if (object.getLeuko() >= 20 && object.getLeuko() <= 39.9) sum+= 2;
        else if (object.getLeuko() >= 15 && object.getLeuko() <= 19.9) sum+= 1;
        else if (object.getLeuko() >= 3 && object.getLeuko() <= 14.9) sum+= 0;
        else if (object.getLeuko() >= 1 && object.getLeuko() <= 2.9) sum+= 2;
        else if (object.getLeuko() < 1) sum+= 4;

        for (int i = 3; i <=15; i++)
        {
            if(object.getGlasgow() == i)
            {
                sum += 15-i;
            }
        }

        if (object.getBicarbonate()!=null) {
            if (object.getBicarbonate() < 15) sum += 4;
            else if (object.getBicarbonate() >= 15 && object.getBicarbonate() < 18) sum += 3;
            else if (object.getBicarbonate() >= 18 && object.getBicarbonate() < 22) sum += 2;
            else if (object.getBicarbonate() >= 22 && object.getBicarbonate() < 32) sum += 0;
            else if (object.getBicarbonate() >= 32 && object.getBicarbonate() < 41) sum += 1;
            else if (object.getBicarbonate() >= 41 && object.getBicarbonate() < 52) sum += 3;
            else if (object.getBicarbonate() >= 52) sum += 4;
        }
        if (object.getPH()!=null) {
            if (object.getPH() < 7.15) sum += 4;
            else if (object.getPH() >= 7.15 && object.getPH() <= 7.24) sum += 3;
            else if (object.getPH() >= 7.25 && object.getPH() <= 7.32) sum += 2;
            else if (object.getPH() >= 7.33 && object.getPH() <= 7.49) sum += 0;
            else if (object.getPH() >= 7.50 && object.getPH() <= 7.59) sum += 1;
            else if (object.getPH() >= 7.60 && object.getPH() <= 7.69) sum += 3;
            else if (object.getPH() > 7.69) sum += 4;
        }
        if(object.getA_a_gradient() != null) {
            if (object.getA_a_gradient() < 200) sum += 0;
            else if (object.getA_a_gradient() >= 200 && object.getA_a_gradient() <= 349) sum += 2;
            else if (object.getA_a_gradient() >= 350 && object.getA_a_gradient() <= 499) sum += 3;
            else if (object.getA_a_gradient() > 499) sum += 4;
        }

        if (object.getPaO2() != null) {
            if (object.getPaO2() < 55) sum += 4;
            else if (object.getPaO2() >= 55 && object.getPaO2() <= 60) sum += 3;
            else if (object.getPaO2() >= 61 && object.getPaO2() <= 70) sum += 1;
            else if (object.getPaO2() > 70) sum += 0;
        }
        return sum;
    }

    @Override
    public ResultDto calculateResult(ApacheIIdto dto) {
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
        res.setTitle(String.format("%s баллов по шкале GRACE", scales));
        if (scales >= 0 && scales <= 4) res.setDetails("Летальность 4%");
        else if (scales >= 5 && scales <= 9) res.setDetails("Летальность 8%");
        else if (scales >= 10 && scales <= 14) res.setDetails("Летальность 15%");
        else if (scales >= 15 && scales <= 19) res.setDetails("Летальность 25%");
        else if (scales >= 20 && scales <= 24) res.setDetails("Летальность 40%");
        else if (scales >= 25 && scales <= 29) res.setDetails("Летальность 55%");
        else if (scales >= 30 && scales <= 34) res.setDetails("Летальность 75%");
        else if (scales > 34) res.setDetails("Летальность 8%");
        return res;
    }


}
