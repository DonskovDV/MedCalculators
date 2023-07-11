package com.MedCalculator.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "Сущность info")
public class Info extends BaseCalcDto {
    String info;
}
