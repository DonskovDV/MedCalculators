package com.MedCalculator.restController;

import com.MedCalculator.dto.ResultDto;
import com.MedCalculator.dto.ApacheIIdto;
import com.MedCalculator.service.impl.ApacheIIservice;
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
public class ResultApacheIIRestController {
    private final ApacheIIservice apacheIIservice;
    @Autowired
    protected ResultApacheIIRestController(ApacheIIservice srv) {
        this.apacheIIservice = srv;
    }

    @Qualifier("ApacheIIservice")
    @Tag(name = "resultApacheII", description = "POST запрос для ApacheII в формате json")
    @PostMapping("ApacheII/result")
    public ResponseEntity<ResultDto> result(@NonNull @RequestBody ApacheIIdto apacheIIdto) {
        log.info("Request to /ApacheII/result");
        ResultDto resultDto=apacheIIservice.calculateResult(apacheIIdto);
        if(resultDto==null){
            return ResponseEntity.badRequest().body(new ResultDto("Ошибка расчета ApacheII"));
        }
        return ResponseEntity.ok(resultDto);
    }
}
