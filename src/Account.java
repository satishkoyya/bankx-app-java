import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Account {
    static String Name;

    static String id;
    static String mail;
    static String number;
    static String balance;
    Scanner in=new Scanner(System.in);

    Transcation s=new Transcation();
    Customer j=new Customer();

    public void Detials(StringBuilder id2, String name2, String mail2, String number2, String balance2) throws FileNotFoundException,ArrayIndexOutOfBoundsException{



        System.out.println("ID: "+id2);
        System.out.println("Name: "+name2);
        System.out.println("Mail: "+mail2);
        System.out.println("Number: "+number2);
        System.out.println("Balance: "+balance2);




        System.out.println("view Transcations press 0");
        System.out.println("Login Page press 1");
        int a=in.nextInt();
        if(a==0){
            s.transcationHome();

        }else if(a==1){
            j.Login();
        }else{
            System.out.println("Enter the valid Input");
        }
    }


}

