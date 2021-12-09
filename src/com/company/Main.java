package com.company;
import java.util.*;


public class Main {

    public static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {

        // Создаём словарь групп
        HashMap<Integer, Group> group_map = new HashMap<Integer, Group>();
        int current_group_id = -1;

        //Бесконечный цикл
        while (true)
        {
            //Сканер - объект для считывания из консоли срок
            Scanner in = new Scanner(System.in);
            //Берём строку из консоли
            String str = in.nextLine();

            // Если строка просто число
            if (isDigit(str)) {
                //Преобразовываем строку в число
                current_group_id =  Integer.parseInt(str);

                //Если такая группа уже есть
                if (group_map.containsKey(current_group_id)) {
                    //Выводим её
                    group_map.get(current_group_id).toSet();
                    group_map.get(current_group_id).toMap();
                }
                //если нет
                else {
                    //То мы создаём новую группу с номером введённого числа и кладём её в словарь групп
                    group_map.put(current_group_id, new Group(current_group_id));
                    System.out.println("Group Created!");
                }

            }
            // Если после числа есть ещё строки
            else {
                //Отделяем строки
                String[] params = str.split(" ");
                //Если количество параметров не корректное
                if(params.length > 3 || params.length < 1){
                    //выводим ошибку и пропускаем эту итерацию цикла
                    System.out.println("Error!");
                    continue;
                }
                //Если ввели end заканчиваем цикл
                if (str.equals("end")) {
                    in.close();
                    break;
                }

                //Создаём нового студента и кладём словарь и в множество
                group_map.get(current_group_id).students_map.put(Integer.parseInt(params[0]),
                        new Student(Integer.parseInt(params[0]), params[1], params[2]));
                group_map.get(current_group_id).students_set.add(new Student(Integer.parseInt(params[0]), params[1], params[2]));

                //Выводим строку, что студент был создан
                System.out.println("Student " + params[1] + " " + params[2] + " added to group " + params[0]);
            }
        }
    }
}
