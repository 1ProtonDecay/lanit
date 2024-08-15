package org.lanit;

// импорт класса org.springframework.boot.SpringApplication, который используется для запуска Spring Boot приложений.
// Spring Boot - это фреймворк для создания микросервисов и веб-приложений на основе Spring Framework. 
// Он упрощает процесс разработки, автоматически конфигурируя многие аспекты приложения, такие как управление зависимостями, логирование, профилирование и многое другое.
// Класс SpringApplication используется для запуска Spring Boot приложения. 
// Он предоставляет методы для настройки и запуска приложения, а также для управления жизненным циклом приложения.
import org.springframework.boot.SpringApplication;

// импорти аннотации org.springframework.boot.autoconfigure.SpringBootApplication, 
// которая используется для автоматической конфигурации Spring Boot приложений.
// Аннотация SpringBootApplication указывает компилятору, что данный класс является точкой входа в Spring Boot приложение. 
// Она автоматически включает в себя аннотации @EnableAutoConfiguration, @ComponentScan и @Configuration, 
// что позволяет Spring Boot автоматически конфигурировать различные аспекты приложения, такие как управление зависимостями, логирование, профилирование и многое другое.
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

// определяет класс LanitApplication, который аннотирован с помощью SpringBootApplication. 
// Это указывает компилятору, что данный класс является точкой входа в Spring Boot приложение.
// В методе main класса LanitApplication вызывается статический метод run класса SpringApplication, 
// который используется для запуска Spring Boot приложения. 
// Аргументы args передаются в метод run, что позволяет приложению обрабатывать аргументы командной строки.
public class LanitApplication {

	public static void main(String[] args) {
		SpringApplication.run(LanitApplication.class, args);
	}

}
