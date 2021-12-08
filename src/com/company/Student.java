package com.company;

// Класс студент
public class Student{
    // Поля
    int ID;
    String Name;
    String Surname;

    //Конструктор принимат id, имя и фамилию
    Student(int id, String n, String s)
    {
        ID = id;
        Name = n;
        Surname = s;
    }

    //Перегружаем метод toString в котором прописываем как студент будет преобразовываться в строку
    @Override
    public String toString() {
        return "Student{" +
                "Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                '}';
    }
}
