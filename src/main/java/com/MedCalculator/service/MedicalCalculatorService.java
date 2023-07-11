package com.MedCalculator.service;

import com.MedCalculator.dto.BaseCalcDto;
import com.MedCalculator.dto.ResultDto;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Интерфейс сервисов")
public interface MedicalCalculatorService<T extends BaseCalcDto> {

    public ResultDto result(Integer scales);

    public Integer calculate(T object);

    public ResultDto calculateResult(T dto);
}