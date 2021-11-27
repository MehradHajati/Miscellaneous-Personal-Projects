// Mehrad Hajati
// Program to turn Binary numbers into Decimal numbers or Decimal numbers into Binary numbers

import java.util.Scanner;

public class Binary{

    // Method to convert a Binary number to a corresponding Decimal number
    public static int convertBinary(String binary){
        int length = binary.length();
        int decimal = 0;
        for(int i = 0; i < length; i++){
            int bit = Character.getNumericValue(binary.charAt(i));
            decimal += bit * Math.pow(2, length-1-i);
        }
        return decimal;
    }

    // Method to convert a Decimal number to a corresponding Binary number
    public static String convertDecimal(int number){
        String binary = "";
        int bit = 0;
        while(number > 1){
            bit = number % 2;
            binary = bit + binary;
            number = number / 2;
        }
        if(number == 1){
            binary = 1 + binary;
        }
        else{
            binary = 0 + binary;
        }
        return binary;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Type \"Binary\" to convert Binary to Decimal or");
        System.out.println("Type \"Decimal\" to convert Decimal to Binary");
        String answer = sc.next();
        while(!(answer.equals("Binary") || answer.equals("Decimal"))){
            System.out.println("Please try again");
            System.out.println("Type \"Binary\" to convert Binary to Decimal or");
            System.out.println("Type \"Decimal\" to convert Decimal to Binary");
            answer = sc.next();
        } 
        if(answer.equals("Binary")){
            System.out.print("Please enter your binary number: ");
            String binary = sc.next();
            System.out.println("Your Decimal number is: " + convertBinary(binary));
        }
        else{
            System.out.print("Please enter your Decimal number: ");
            int decimal = sc.nextInt();
            System.out.println("Your Binary number is: " + convertDecimal(decimal));
        }  
    }
}