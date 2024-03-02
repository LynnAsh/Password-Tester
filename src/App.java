import java.util.Scanner;

public class App {
    public static int test(char[] arr) {
        char[] lower = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] upper = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char[] numbers = {'0','1','2','3','4','5','6','7','8','9'};
        char[] special = {'~','!','@','#','$','%','^','&','*','(',')','-','=','+','_'};

        int lowerI = 0, upperI = 0, numbersI = 0, specialI = 0;
        for (int i = 0; i < arr.length; i++) {
            if (lowerI == 0) {
                for (int l = 0; l < lower.length; l++) {
                    if (arr[i] == lower[l]) {
                        lowerI = 1;
                    }
                }
            }
            if (upperI == 0) {
                for(int u = 0; u < upper.length; u++) {
                    if (arr[i] == upper[u]) {
                        upperI = 1;
                    }
                }
            }
            if (numbersI == 0) {
                for (int n = 0; n < numbers.length; n++) {
                    if (arr[i] == numbers[n]) {
                        numbersI = 1;
                    }
                }
            }
            if (specialI == 0) {
                for (int s = 0; s < special.length; s++) {
                    if (arr[i] == special[s]) {
                        specialI = 1;
                    }
                }
            }
        }

        int used = lowerI + upperI + numbersI + specialI;
        return used;
    }

    public static void main(String[] args) throws Exception {
        int used = 0;
        String usrIn;
        char[] arr;
        Scanner scnr = new Scanner(System.in);
        while (used < 3) {
            System.out.println("[Enter password to test]: ");
            usrIn = scnr.nextLine();
            arr = usrIn.toCharArray();
    
            boolean length = false;
            if (usrIn.length() >= 8 && usrIn.length() <= 16) {
                length = true;
            }
    
            if (length == true) {
                used = test(arr);

                if (used < 3) {
                    System.out.println("Password must use at least 3 of the 4:\n> Capital letters\n> Lowercase letters\n> Numbers\n> ~,!,@,#,$,%,^,&,*,(,),-,=,+,_");
                } else {
                    System.out.println("-- Password works! --");
                }   

            } else {
                System.out.println("-- Password is too short --");
            }
        }
        scnr.close();
    }
}
