package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

//Класс группа
public class Group{
    //Поля. ID группы, множество студентов, словарь студентов (ключ номер студента значение студент)
    int group_id;
    //Множетсво (HashSet) студентов. Множетсво (HashSet) - набор уникальных объектов который хранится не упорядочено
    HashSet<Student> students_set = new HashSet<Student>();
    //Словарь (HashMap) студентов. Словарь (HashMap) - нобор пар ключ значение. Значение можно получить по ключу.
    //Приставка Hash означает что объекты хранятся с помощью хещирования (как хеш таблица)
    HashMap<Integer, Student> students_map = new HashMap<Integer, Student>();

    // Констркктор
    Group(int id)
    {
        group_id = id;
    }

    // Вывод на экран множество студентов
    public void toSet(){
        //Создаём итератор. Это объект который есть у множества (Set). Он проходит по множеству
        Iterator<Student> setIterator = students_set.iterator();

        //Цикл. Когда у итератора есть следующий объект
        while(setIterator.hasNext()){
            //Выводить следующий и он становится текущим
            System.out.println(setIterator.next());
        }
    }

    // Вывод на экран всего словаря студентов
    public void toMap(){
        //Итератор. Преобразовываем словарь в множество пар и берём у множества итератор
        Iterator<Map.Entry<Integer, Student>> mapIterator = students_map.entrySet().iterator();

        //Выводим по той же схеме
        while(mapIterator.hasNext()){
            System.out.println(mapIterator.next());
        }
    }
}
