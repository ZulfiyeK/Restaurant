package selectstudent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectStudent {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Lutfen ogrenci sayisini giriniz");
        int numStd = input.nextInt();

        List<Student> students = new ArrayList<>();// birden fazla data var ve ogrenci isimlerini burada tutacagim
        // ve daha hizli oldugu icin list yerine arrayList tercih ederim.

        for (int i = 0; i < numStd; i++) {
            System.out.println("isim: ");
            String name = input.next();
            System.out.println("cinsiyet: ");
            String gender = input.next().toUpperCase().trim().substring(0, 1);// buyuk kucuk yanlis girerse, bosluklu girerse , ilk harf olsun digeri haric
            System.out.println("boy: ");
            double height = input.nextDouble();
            System.out.println("kilo: ");
            double weight = input.nextDouble();

            Student student = new Student(name, gender, height, weight);//student isminde bir obje olusturdu.
            students.add(student);// ogrenci'yi ogrenciler'in icine ekledik.

        }//for i
        long time1 = System.nanoTime();

        List<Student> selectedStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getGender().equals("K") && student.getHeight() > 1.50 && student.getWeight() > 50 && student.getWeight() < 70) {
                selectedStudents.add(student);
            } else if (student.getGender().equals("E") && student.getHeight() > 1.60 && student.getWeight() > 70 && student.getWeight() < 90) {
                selectedStudents.add(student);
            }
        }//for each
        System.out.println(" =================== Kursa Secilen Ogrenciler =================");

        if (selectedStudents.size() == 0) {
            System.out.println("Malesef kurs gereksinimlerini karşılayan öğrenci bulunamadı.");
        } else {
            for (Student student : selectedStudents) {
            }

            long time2 = System.nanoTime();
            long java = time2 - time1;
            System.out.println("java = " + java/1000);//java = 209800


        }
    }
}
