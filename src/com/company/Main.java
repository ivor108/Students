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
                current_group_id =  Integer.parseInt(str);
                if (group_map.containsKey(current_group_id)) {
                    group_map.get(current_group_id).toSet();
                    group_map.get(current_group_id).toMap();
                }
                else {
                    group_map.put(current_group_id, new Group(current_group_id));
                    System.out.println("Group Created!");
                }

            }
            else {
                String[] params = str.split(" ");
                if(params.length > 3 || params.length < 1){
                    System.out.println("Error!");
                    continue;
                }
                
                if (str.equals("end")) {
                    in.close();
                    break;
                }
                
                group_map.get(current_group_id).students_map.put(Integer.parseInt(params[0]),
                        new Student(Integer.parseInt(params[0]), params[1], params[2]));
                group_map.get(current_group_id).students_set.add(new Student(Integer.parseInt(params[0]), params[1], params[2]));

                System.out.println("Student " + params[1] + " " + params[2] + " added to group " + params[0]);
            }
        }
    }
}
