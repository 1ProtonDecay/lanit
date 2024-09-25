package org.lanit.controllers;

import org.lanit.modelsJson.RequestJson;
import org.lanit.snils.validate.CheckSnils;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class JSONController {
    private final ModelMapper modelMapper;
    private final CheckSnils checkSnils;

    public JSONController(ModelMapper modelMapper, CheckSnils checkSnils) {
        this.modelMapper = modelMapper;
        this.checkSnils = checkSnils;
    }

    @PostMapping("/snils")
    public ResponseEntity<Object> snilsValidate(@RequestBody HashMap request) {
        if (Objects.isNull(request.get("snils")))
            return ResponseEntity.badRequest().body(Map.of("message", "Error: uncorrected json", "request",
                    request));

        RequestJson requestJson = convertJson(request);
        if (checkSnils.validate(requestJson.getSnils()))
            return ResponseEntity.ok(Map.of("message", "success", "snils", requestJson.getSnils()));
        else
            return ResponseEntity.badRequest().body(Map.of("message", "Error: uncorrected snils", "snils",
                    requestJson.getSnils()));
    }

    private RequestJson convertJson(Object requestJson) {
        return this.modelMapper.map(requestJson, RequestJson.class);
    }
}
