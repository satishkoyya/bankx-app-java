import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Customer {

    static String Name;
    static String passWord;
    static StringBuilder id;
    static String mail;
    static String number;
    static String balance;

    Scanner in=new Scanner(System.in);

    Account ac=new Account();


    public static void main(String[] args) throws IOException {
        Scanner	in =new Scanner(System.in);


        Customer c=new Customer();
        //lf.Home();

        //ac.Detials();
        System.out.println("New CUSTOMER? press 1 for SIGNUP");
        System.out.println("Existing CUSTOMER? press 2 for LOGIN");
        int a=in.nextInt();

        switch(a){
            case 1:
                c.CustomerOnBoard();
                break;
            case 2:
                c.Login();
                break;
            default:
                System.out.println("please select a valid option");
                break;


        }

    }









    private void CustomerOnBoard() throws IOException{
        System.out.println("CustomerOnboard page ");
        System.out.println("Enter Name");
        Name=in.nextLine();
        System.out.println("Enter Mail");
        mail=in.nextLine();
        System.out.println("Enter phoneNumber");
        number=in.nextLine();
        System.out.println("Enter Password");
        System.out.println("Password Must contains capital small speical numeric lenght more then 6");
        passWord=in.nextLine();



        Pattern p=Pattern.compile(reg);
        Matcher m=p.matcher(passWord);
        if(m.matches()==true){

        }else{
            System.out.println("please enter valid password");
            CustomerOnBoard();
        }


        String AlphaNumericString = "0123456789";
        StringBuilder sb = new StringBuilder(12);

        for (int i = 0; i < 12; i++) {

            int index  = (int)(AlphaNumericString.length() //62
                    * Math.random());
            sb.append(AlphaNumericString.charAt(index));


        }
        id=sb;
        balance ="500";

        String Path="E:\\Javahurreh/";

        FileOutputStream pos=new FileOutputStream(Path+Name+"LOG"+".txt");
        String s=Name+","+passWord;
        for(int i=0;i<s.length();i++){
            pos.write(s.charAt(i));
        }

        FileOutputStream pos1=new FileOutputStream(Path+Name+".txt");
        String s1=id+","+Name+","+mail+","+number+","+balance;
        for(int i=0;i<s1.length();i++){
            pos1.write(s1.charAt(i));
        }


        System.out.println("Successfully Registered");
        Login();




    }

    void Login() throws FileNotFoundException {
        System.out.println("Login Form");
        System.out.println("Enter Name");
        String Name=in.nextLine();
        System.out.println("Enter Password");
        String passWord=in.nextLine();

        String Path="E:\\Satishhurreh/";

        Scanner in = new Scanner(new File(Path+Name+"LOG"+".txt"));
        while (in.hasNextLine())
        {
            String s1 = in.nextLine();
            String[] sArray = s1.split(",");

            if(sArray[0].equals(Name)&&sArray[1].equals(passWord)
            ){
                System.out.println("Logged In To The Current Account");
                ac.Detials(id,Name,mail,number,balance);

            }else{
                System.out.println("login UnSuccessfull");
                Login();
            }


        }
    }
}




