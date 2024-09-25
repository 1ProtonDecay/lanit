package org.lanit;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//Аннотация @SpringBootApplication: Указывает, что данный класс является основным классом приложения Spring Boot.
// Эта аннотация объединяет аннотации @Configuration, @EnableAutoConfiguration и @ComponentScan,
// что упрощает создание приложений Spring Boot.
@SpringBootApplication
//Основная цель этого кода – запуск и настройка Spring Application. Вот что он делает:
//1. Метод main():
//   - Принимает аргументы командной строки через String args.
//   - Вызывает статический метод SpringApplication.run(), передавая ему класс приложения (SnilsApplication)
//   и массив аргументов. Этот метод запускает Spring Boot приложение.
//2. Аннотация @Bean:
//   - Используется для создания и регистрации компонентов в контейнере Spring IoC.
//   В данном случае создается экземпляр класса ModelMapper.
//   - Метод modelMapper() возвращает новый экземпляр ModelMapper,
//   что позволяет использовать его для преобразования объектов в приложении.
public class SnilsApplication {
	public static void main(String[] args) {
		SpringApplication.run(SnilsApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
