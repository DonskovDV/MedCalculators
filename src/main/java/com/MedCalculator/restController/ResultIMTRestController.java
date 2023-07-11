package com.MedCalculator.restController;

import com.MedCalculator.dto.ResultDto;
import com.MedCalculator.dto.IMTDto;
import com.MedCalculator.service.impl.IMTservice;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calculator/")
@Log4j2
public class ResultIMTRestController {

    private final IMTservice imtService;
    @Autowired
    protected ResultIMTRestController(IMTservice srv) {
        this.imtService = srv;
    }

    @Qualifier("IMTService")
    @Tag(name = "resultIMT", description = "POST запрос для IMT в формате json")
    @PostMapping("IMT/result")
    public ResponseEntity<ResultDto> result(@NonNull @RequestBody IMTDto imtdto) {
        log.info("Request to /IMT/result");
        ResultDto resultDto=imtService.calculateResult(imtdto);
        if(resultDto==null){
            return ResponseEntity.badRequest().body(new ResultDto("Ошибка расчета IMT"));
        }
        return ResponseEntity.ok(resultDto);
    }
}
