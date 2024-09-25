//Библиотека для валидации данных
package org.lanit.validate;

//Директива импорта org.springframework.stereotype.Component.
// Эта директива используется в контексте фреймворка Spring Framework и указывает, что данный класс является компонентом приложения.
// Компоненты могут использоваться для инверсии управления (IoC) и для поддержки механизма Dependency Injection (DI).
// В результате класс, помеченный аннотацией @Component, становится доступным через механизм IoC контейнера Spring.
import org.springframework.stereotype.Component;

//Директива импорта в коде на Java, которая включает пакет java.util.List.
// Этот пакет содержит классы и интерфейсы, связанные с коллекциями данных, включая интерфейс List,
// который представляет собой упорядоченную коллекцию элементов, где каждый элемент имеет уникальный индекс.
// Использование этого пакета позволяет работать с различными структурами данных, такими как списки, множества, очереди и т.д.
import java.util.List;

@Component
public class CheckSnils {
    public boolean validate(String s) {
        String[] snils = s.split(" ");
        snils[0] = snils[0].replaceAll("-", "");

        int sum = 0;
        for (int i = 0;i < snils[0].length(); i++)
            sum += (snils[0].charAt(i) - '0') * (9 - i);
        sum = sum % 101;

        if (sum == 100 || sum == 0)
            return snils[1].equals("00");

        int num = Integer.parseInt(snils[1]);
        return sum == num;
    }
}
