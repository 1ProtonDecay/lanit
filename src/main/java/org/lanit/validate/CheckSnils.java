// определение пакета org.lanit.validate. 
// Пакеты в Java используются для организации классов и интерфейсов в логические группы. 
// В данном случае, пакет org.lanit.validate содержит классы и интерфейсы, связанные с валидацией. 
// Контроллеры в контексте веб-приложений отвечают за обработку HTTP-запросов и ответов.
package org.lanit.validate;

// класс CheckSnils в Java. Класс содержит два поля: private boolean isValid; и private int checkSumm;
// Первое поле isValid используется для хранения информации о том, является ли введенный номер СНИЛС действительным. Второе поле checkSumm хранит контрольную сумму номера СНИЛС.
// Класс также содержит методы для получения и установки значения поля isValid: public boolean getIsValid() и public void setValid(boolean valid).
// Метод checkSnils(String numbers, int checkSumm) используется для проверки введенного номера СНИЛС на корректность. 
// Он принимает два параметра: строку numbers, содержащую сам номер СНИЛС, и целое число checkSumm, 
// которое должно быть контрольной суммой этого номера. Метод вычисляет контрольную сумму введенного номера и сравнивает ее с предоставленной контрольной суммой. 
// Если они совпадают, поле isValid устанавливается в true, иначе - в false.
public class CheckSnils {
    private boolean isValid;

    public boolean getIsValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public void checkSnils(String numbers, int checkSumm)  {
        int temp = 0;
        int summ = 0;

        for (int i = 0; i < numbers.length(); i++) {

            char symbol = numbers.charAt(i);
            temp = numbers.length()  - i;
            summ += Character.getNumericValue(symbol) * (temp);

        }

        if (summ % 101 == checkSumm) {
            setValid(true);
        } else setValid(false);

    }
}
