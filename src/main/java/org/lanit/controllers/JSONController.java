// определение пакета org.lanit.controllers. 
// Пакеты в Java используются для организации классов и интерфейсов в логические группы. 
// В данном случае, пакет org.lanit.controllers содержит классы и интерфейсы, связанные с контроллерами в приложении. 
// Контроллеры в контексте веб-приложений отвечают за обработку HTTP-запросов и ответов.
package org.lanit.controllers;

// импортирует класс com.fasterxml.jackson.databind.ObjectMapper из библиотеки Jackson, 
// которая используется для сериализации и десериализации объектов в формате JSON.
import com.fasterxml.jackson.databind.ObjectMapper;

// импортирует класс RequestJson из пакета org.lanit.modelsJson, 
// который, является частью библиотеки или проекта, связанного с обработкой данных в формате JSON.
import org.lanit.modelsJson.RequestJson;

// импортирует класс CheckSnils из пакета org.lanit.validate, 
// который является частью библиотеки или проекта, связанного с валидацией данных, включая проверку правильности серии и номера СНИЛС.
import org.lanit.validate.CheckSnils;

// импортирует класс ResponseEntity из пакета org.springframework, который является частью фреймворка Spring. 
// Этот класс используется для представления HTTP-ответа, содержащего тело ответа и заголовки.
import org.springframework.http.ResponseEntity;

// импортирует аннотацию Controller из пакета org.springframework.stereotype. 
// Аннотация @Controller используется в Spring Framework для обозначения класса как контроллера, 
// то есть компонента, который обрабатывает HTTP-запросы и возвращает ответы.
import org.springframework.stereotype.Controller;

// импортирует аннотацию @PostMapping из пакета org.springframework.web.bind.annotation. 
// Аннотация @PostMapping используется в Spring MVC для определения метода контроллера, который будет обрабатывать POST-запросы к определенному URL.
import org.springframework.web.bind.annotation.PostMapping;

// импортирует аннотацию @RequestBody из пакета org.springframework.web.bind.annotation. 
// Аннотация @RequestBody используется в Spring MVC для обозначения параметра метода контроллера, который должен быть заполнен данными из тела HTTP-запроса.
import org.springframework.web.bind.annotation.RequestBody;

// импортирует исключение IOException из пакета java.io. 
// Исключение IOException используется для обработки ошибок ввода/вывода, таких как проблемы с файлами, сетью или устройствами.
import java.io.IOException;

@Controller
public class JSONController {

    //  код реализует контроллер для обработки HTTP-запросов с использованием библиотеки Spring MVC. 
    // Конкретно этот метод обрабатывает POST-запрос к URL /snils и принимает тело запроса в формате JSON. 
    // Он проверяет корректность введенного номера СНИЛС и возвращает соответствующий ответ в зависимости от результата проверки.
    @PostMapping(value = "/snils")
    public Object addTicker(@RequestBody String requestBodyData) throws IOException {

        // кода пытается создать экземпляр класса ObjectMapper, который используется для сериализации и десериализации объектов в формате JSON. 
        // Затем он пытается прочитать данные из requestBodyData и преобразовать их в объект типа RequestJson.
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            RequestJson requestJson = objectMapper.readValue(requestBodyData, RequestJson.class);

            // код проверяет правильность номера СНИЛС. 
            // Код сначала пытается получить номер СНИЛС из входных данных, затем создает экземпляр класса CheckSnils, который выполняет проверку номера СНИЛС. 
            // Если номер СНИЛС неверный, код возвращает HTTP-ответ с кодом ошибки 400 и сообщением об ошибке. 
            // Если номер СНИЛС корректен, код возвращает HTTP-ответ с кодом успеха 200 и сообщением о том, что проверка прошла успешно.
            try {
                String snils = requestJson.getSnils();

                CheckSnils checkSnils = new CheckSnils();
                try {
                    checkSnils.checkSnils(requestJson.getNumbers(), requestJson.getCheckSumm());
                    if (!checkSnils.getIsValid()) {
                        return ResponseEntity.status(400).header("content-type", "application/json").body("{" +
                                "  \"message\": \"Error: uncorrected snils\"," +
                                "  \"snils\": \"" + requestJson.getSnils() + "\"" +
                                "}");
                    } else {
                        return ResponseEntity.ok().header("Content-Type", "application/json").body(String.format("{\"message\":\"success\", \"snils\" : \"%s\"}", requestJson.getSnils()));
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    return ResponseEntity.status(400).header("content-type", "application/json").body("{" +
                            "  \"message\": \"Error: uncorrected snils\"," +
                            "  \"snils\": \"" + requestJson.getSnils() + "\"" +
                            "}");
                }
        //  блок кода на Java, который используется для обработки исключений. 
        // Блок catch следует за ключевым словом try и содержит код, который выполняется, когда происходит исключение. 
        // В данном случае, если возникает любое исключение, оно будет обработано блоком catch, 
        // и переменная e будет содержать информацию об этом исключении.
            } catch (Exception e) {
                System.out.println(e);

                return ResponseEntity.status(400).header("content-type", "application/json").body("{" +
                        "  \"message\": \"Error: uncorrected snils\"," +
                        "  \"snils\": \"" + requestJson.getSnils() + "\"" +
                        "}");
            }
        } catch (Exception e) {
            System.out.println(e);
            String replacedSnils = requestBodyData.replace("\r\n ", "");
            replacedSnils = replacedSnils.replace("\r\n", "");

            return ResponseEntity.status(400).header("content-type", "application/json").body("{" +
                    "  \"message\": \"Error: uncorrected json\"," +
                    "  \"request\": " +  replacedSnils  +
                    "}");
        }


    }
}