package org.example;

public class Uchenie {

    private final String surname;
    private final int year;
    private final String pol;
    public Fieldofscience fieldofscience;

    public enum Fieldofscience{ // Публичное перечисление Fieldofscience, хранящее возможные значения сферы науки
        MATH, BIOLOGY, CHEMISTRY  // Математика, биология, химия
    }

    public String getSurname() {  // Публичный метод для возврата значения свойства surname
        return surname;
    }

    public String getPol() { // Публичный метод для возврата значения свойства pol
        return pol;
    }

    public int getYear() { // Публичный метод для возврата значения свойства year
        return year;
    }
    public Fieldofscience getFieldofscience() {
        return fieldofscience;
    }

    public Uchenie(String surname, int year, String pol, Fieldofscience fieldofscience) {
        // Конструктор класса Uchenie, который принимает четыре параметра: фамилию, год рождения,
        // пол нового учёного и его сферу науки, а затем инициализирует свойства класса заданными значениями

        this.surname = surname;
        this.year = year;
        this.pol = pol;
        this.fieldofscience = fieldofscience;
    }
}