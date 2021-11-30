import java.util.Scanner;

public class Testeos {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String cadena=sc.nextLine();
        String nueva="";
        String nueva2="";
        int c=0;
        for (int i=0; i<cadena.length();i++) {
            while(c<3) {
                nueva=nueva+cadena.charAt(i);
                //System.out.println(nueva);
                c++;
                break;
            }
            while(c>=3) {
                nueva2=nueva2+cadena.charAt(i);
                //System.out.println(nueva2);
                c++;
                break;
            }
            if(c==6) {
                c=0;

            }



        }
        System.out.println(nueva);
        System.out.println(nueva2);
    }
}
