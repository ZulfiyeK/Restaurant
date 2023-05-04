package selectstudent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SelectStudentLambda {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Lutfen ogrenci sayisini giriniz");
        int numStd = input.nextInt();

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < numStd; i++) {
            System.out.println("isim: ");
            String name = input.next();
            System.out.println("cinsiyet: ");
            String gender = input.next().toUpperCase().trim().substring(0, 1);
            System.out.println("boy: ");
            double height = input.nextDouble();
            System.out.println("kilo: ");
            double weight = input.nextDouble();

            Student student = new Student(name, gender, height, weight);
            students.add(student);

        }//for i
        long time = System.nanoTime();
        List <Student> selectedStudent = Stream.concat( students.
                                stream().
                                filter(t-> t.getGender().equals("K") && t.getHeight()>1.50  && t.getWeight()>50 && t.getWeight()<70),

                        students.
                                stream().
                                filter(t-> t.getGender().equals("E") && t.getHeight()>1.60  && t.getWeight()>70 && t.getWeight()<90)).
                collect(Collectors.toList());

        if(selectedStudent.isEmpty()){
            System.out.println("Malesef kurs gereksinimlerini karşılayan öğrenci bulunamadı.");

        }else {
            System.out.println(" =================== Kursa Secilen Ogrenciler =================");
            selectedStudent.forEach(t-> System.out.println("isim : "+ t.getName()+
                    ", cinsiyet: "+ t.getGender() +
                    ", boy: " + t.getHeight() +
                    ", kilo: "+ t.getWeight()));
        }
        long time1 = System.nanoTime();
        long lambda = time1-time;
        System.out.println("lambda = " + lambda/1000);//lambda = 2602300

    }
}
