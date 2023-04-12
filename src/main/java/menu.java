import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class menu {
    public static void main(String[] args) throws IOException {
        boolean flag = true;
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);

        while (flag) {
            System.out.println("\nMenu:");
            System.out.println("0. EXIT");
            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Show Data");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(br.readLine());

            switch (choice) {
                case 0:
                    flag = false;
                    break;

                case 1:
                    Config.insertData();
                    break;

                case 2:
                    Config.updateData();
                    break;

                case 3:
                    Config.deleteData();
                    break;

                case 4:
                    Config.showData();
                    break;

                default:
                    System.out.println("Enter valid option");
                    break;

            }
        }
    }

    }

