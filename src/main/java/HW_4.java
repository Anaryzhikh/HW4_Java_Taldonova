import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class HW_4 {
        // Ввод с консоли: ФИО, возраст, пол
        static Scanner iScanner = new Scanner(System.in);
        static ArrayList<String> names = new ArrayList<String>();
        static ArrayList<Integer> ages = new ArrayList<Integer>();
        static ArrayList<Boolean> genders = new ArrayList<Boolean>();

        public static void main(String[] args) {
            ArrayList<String> list_fname = new ArrayList<>();
            ArrayList<String> list_lname = new ArrayList<>();
            ArrayList<String> list_tname = new ArrayList<>();
            ArrayList<Integer> list_age = new ArrayList<>();
            ArrayList<Boolean> list_gender = new ArrayList<>();
            List<Integer> linkedList = new LinkedList<>() ;

            boolean flag = true;
            while (flag) {
                Scanner scanner = new Scanner(System.in);
                Scanner scanner_age = new Scanner(System.in);
                Scanner scanner_gender = new Scanner(System.in);

                System.out.println("Enter your FIO: ");
                String fio = scanner.nextLine();
                System.out.println("Enter your age: ");
                Integer age = scanner_age.nextInt();
                list_age.add(age);

                String[] fio1 = fio.split(" ");
                if (fio1.length == 3) {
                    list_fname.add(fio1[1]);
                    list_lname.add(fio1[0]);
                    list_tname.add(fio1[2]);
                } else if (fio1.length == 2) {
                    list_lname.add(fio1[0]);
                    list_fname.add(fio1[1]);
                    list_tname.add("");
                } else {
                    list_lname.add(fio1[0]);
                    list_fname.add("");
                    list_tname.add("");
                }

                System.out.println("Enter your gender: ");
                String gender = scanner_gender.nextLine();
                if (gender.contains("M")){
                    list_gender.add(true);
                }
                else {
                    list_gender.add(false);
                }
                linkedList.add(list_age.size()-1);
                System.out.println("Do u want enter next one? Y/N");
                Scanner scanner1 = new Scanner(System.in);
                String yn = scanner1.nextLine();
                if (yn.toUpperCase().equals("N")) {
                    flag = false;
                }
            }

            int cnt = list_age.size()-1; // индекс последнего
            while (cnt > -1){
                int max_age = list_age.get(linkedList.get(cnt));
                int index = cnt;
                for (int i = 0; i < cnt; i++) {
                    if (max_age < list_age.get(linkedList.get(i))){
                        max_age = list_age.get(linkedList.get(i));
                        index = i;
                    }
                }
                int tmp = linkedList.get(cnt);
                linkedList.set(cnt, linkedList.get(index));
                linkedList.set(index, tmp);
                cnt--;
            }
            linkedList.forEach(i ->
                    System.out.println(list_lname.get(i) + " " + list_fname.get(i) + " " + list_tname.get(i) + " " + list_age.get(i) + " " + list_gender.get(i)));
        }
}
