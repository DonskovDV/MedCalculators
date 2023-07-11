package com.MedCalculator.restController;
import com.MedCalculator.dto.ResultDto;
import com.MedCalculator.dto.HasBledDto;
import com.MedCalculator.service.impl.HasBledservice;
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
public class ResultHasBledRestController {
    private final HasBledservice hasBledservice;
    @Autowired
    protected ResultHasBledRestController(HasBledservice srv) {
        this.hasBledservice = srv;
    }

    @Qualifier("HasBledservice")
    @Tag(name = "result-Has-Bled", description = "POST запрос для Has-Bled в формате json")
    @PostMapping("HasBled/result")
    public ResponseEntity<ResultDto> result(@NonNull @RequestBody HasBledDto hasBledDto) {
        log.info("Request to /HasBled/result");
        ResultDto resultDto=hasBledservice.calculateResult(hasBledDto);
        if(resultDto==null){
            return ResponseEntity.badRequest().body(new ResultDto("Ошибка расчета Has-Bled"));
        }
        return ResponseEntity.ok(resultDto);
    }
}
