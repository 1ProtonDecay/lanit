// определение пакета org.lanit.modelsJson. 
// Пакеты в Java используются для организации классов и интерфейсов в логические группы. 
// В данном случае, пакет org.lanit.modelsJson содержит классы и интерфейсы, содержит классы и интерфейсы, связанные с моделями JSON.. 
package org.lanit.modelsJson;

// импорт класса com.fasterxml.jackson.annotation.JsonProperty в Java. 
// Этот класс используется для аннотирования свойств объектов при сериализации и десериализации данных с использованием библиотеки Jackson.
import com.fasterxml.jackson.annotation.JsonProperty;

// Класс содержит аннотацию @JsonProperty, которая указывает Jackson, 
// что свойство snils должно быть использовано для сериализации и десериализации JSON-объекта. 
// В классе также есть методы для установки и получения значения свойства snils, 
// а также для установки и получения значения свойства numbers.
public class RequestJson {
	
	// аннотация в Java, которая используется с библиотекой Jackson для сериализации и десериализации объектов в формате JSON. 
	// Аннотация @JsonProperty указывает, что при сериализации объекта в JSON имя поля будет snils, 
	// даже если в самом классе оно имеет другое имя. 
	// Это позволяет контролировать, как поля будут представлены в JSON, что особенно полезно, 
	// когда имена полей в классе и JSON не совпадают.
    @JsonProperty("snils")
	
    // объявление поля класса. В данном случае, snils - это имя поля, которое является строкой (String), 
    // и оно имеет модификатор доступа private, что означает, что это поле может быть доступно только внутри класса, где оно объявлено. 
    private String snils;
	private String numbers = "";
	private int checkSumm;

    // Код представляет собой часть класса RequestJson. Конструктор public RequestJson() является пустым, 
    // что означает, что он не выполняет никаких действий при создании экземпляра класса. 
    // Методы getCheckSumm и getNumbers являются геттерами, которые возвращают значения соответствующих полей класса.
	public RequestJson() {

	}
	//  метод getCheckSumm. Метод возвращает значение переменной checkSumm, которая является атрибутом класса. 
	// Это типичный пример метода доступа к свойству в ООП.
	public int getCheckSumm() {
		return checkSumm;
	}

	// метод getNumbers. Метод возвращает значение переменной numbers, которая является атрибутом класса. 
	public String getNumbers() {
		return numbers;
	}

	// метод setCheckSumm. 
	// Метод принимает строку checkSumm в качестве аргумента и пытается преобразовать подстроку из 12-го по 14-й символ строки, 
	// возвращаемой методом getSnils, в целое число. Затем он присваивает полученное значение переменной this.checkSumm. 
	// Метод также может выбрасывать исключение IndexOutOfBoundsException, если подстрока выходит за пределы исходной строки.
	public void setCheckSumm(String checkSumm) throws IndexOutOfBoundsException {
	    this.checkSumm = Integer.parseInt(getSnils().substring(12, 14));
	}

	// метод setNumbers. 
	// Метод принимает строку numbers в качестве аргумента и пытается создать новую строку this.numbers, 
	// добавляя в нее цифры из строки, возвращаемой методом getSnils. 
	// Циклы используются для проверки каждой позиции в строке getSnils и добавления соответствующих цифр в строку this.numbers.
	public void setNumbers(String numbers) {
		for (int i = 0; i <= getSnils().length() - 3; i++) {

			char symbol = getSnils().charAt(i);
			if (Character.isDigit(symbol)) {
				this.numbers += symbol;
			}
		}
	}

	// метод setSnils. Метод принимает строку snils в качестве аргумента и присваивает её значение переменной this.snils.
	public void setSnils(String snils){
		this.snils = snils;
	}

	// метод getSnils. Метод возвращает значение переменной snils, которая является атрибутом класса. 
	public String getSnils(){
		return snils;
	}
}
