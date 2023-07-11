package com.MedCalculator.restController;

import com.MedCalculator.dto.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

@RestController
@RequestMapping("calculator/")
@Log4j2
public class InformationRestController {
    @Tag(name = "Info", description = "Возвращает информацию о калькуляторе в формате json")
    @GetMapping("{name}/info")
    public Info info(@PathVariable("name") String name) {
        log.info("Request to /" + name + "/info");
        Info info = new Info();
        switch (name) {
            case "IMT" -> {
                try {
                    ClassPathResource resource = new ClassPathResource("/templates/infoAboutCalc/infoIMT.html");
                    Scanner scanner = new Scanner(resource.getInputStream());
                    scanner.useDelimiter("\\Z");
                    String text = scanner.next();
                    info.setInfo(text);
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            case "ApacheII" -> {
                try {
                    ClassPathResource resource = new ClassPathResource("/templates/infoAboutCalc/infoApache");
                    Scanner scanner = new Scanner(resource.getInputStream());
                    scanner.useDelimiter("\\Z");
                    String text = scanner.next();
                    info.setInfo(text);
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            case "Has-Bled" -> {
                try {
                    ClassPathResource resource = new ClassPathResource("/templates/infoAboutCalc/infoHas-Bled");
                    Scanner scanner = new Scanner(resource.getInputStream());
                    scanner.useDelimiter("\\Z");
                    String text = scanner.next();
                    info.setInfo(text);
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return info;
    }
}
