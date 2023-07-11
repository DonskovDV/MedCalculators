package com.MedCalculator.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "Сущность result")
public class ResultDto extends BaseCalcDto {
    private String title;

    public ResultDto(String title) {
        this.title = title;
    }

    private String details;
}
