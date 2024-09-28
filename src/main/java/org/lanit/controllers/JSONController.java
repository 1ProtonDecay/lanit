package org.lanit.controllers;

//Импорт классов под названием RequestJson и CheckSnils.
// Это используется для того, чтобы указать компилятору, где искать этот класс.
// Импортирование таких объектов позволяет использовать их
// без необходимости писать полное квалифицированное имя каждый раз при обращении к ним.
import org.lanit.modelsJson.RequestJson;
import org.lanit.validate.CheckSnils;

// ModelMapper может использоваться для преобразования данных между объектами различных типов.
import org.modelmapper.ModelMapper;

//ResponseEntity является классом из библиотеки Spring Framework, который используется для создания HTTP-ответов.
import org.springframework.http.ResponseEntity;

//Аннотации используются в Java для добавления метаданных к элементам программы, таким как классы, методы, поля и параметры методов.
//@PostMapping используется для определения метода контроллера, который будет обрабатывать POST-запросы.
import org.springframework.web.bind.annotation.PostMapping;

//@RequestBody используется для обозначения параметра метода контроллера, который будет принимать данные из тела HTTP-запроса.
import org.springframework.web.bind.annotation.RequestBody;

//@RestController используется для обозначения класса контроллера, который будет генерировать RESTful API.
import org.springframework.web.bind.annotation.RestController;

//Импорт класса под названием HashMap из пакета java.util.
// Класс HashMap предоставляет реализацию ассоциативного массива,
// где ключи могут быть любыми объектами,а значения могут быть любыми типами.
import java.util.HashMap;

//Импорт интерфейса под названием Map из пакета java.util.
// Интерфейс Map определяет функциональность ассоциативных массивов, где пары ключ-значение хранятся и управляются.
import java.util.Map;

//Импорт класса под названием Objects из пакета java.util.
// Класс Objects содержит статические методы для работы с объектами, такие как сравнение, проверка равенства и т.д.
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