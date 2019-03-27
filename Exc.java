import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exc {
    public static void main(String[] args) throws IOException {

        for (int x = 1; x < 5; x = x + 1) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите номер телефона");
            String number = sc.nextLine();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите имя");
            String name = scanner.nextLine();
            String str1 = number + " " + name + "\n";

            try {

                FileWriter writer = new FileWriter("out.txt", true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write(str1);
                bufferedWriter.close();

                FileReader fr = new FileReader("out.txt");
                Scanner scan = new Scanner(fr);

                int i = 1;

                while (scan.hasNextLine()) {

                    System.out.println(i + " : " + scan.nextLine());
                    i++;
                }
                if (str1.contains(scan.nextLine())) {
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        System.out.println("Ошибка, такой контакт уже существует");
                        e.printStackTrace();
                    }
                }
            }
            catch (IOException e) {System.out.println("Ошибка");
                e.printStackTrace();
            }
        }
    }

}