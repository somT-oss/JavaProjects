import java.util.Scanner;

public class TempConv {
    public static void main(String[] args) {
        String converter = converter();
        System.out.println(converter);
    }
 
    public static String converter() {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Note that all default temperature entry will be in Celcius.");
        System.out.println("Available options: Farenheit to Celsius, Celsius to Farenheit, Kelvin to Farenheit, Kelvin to Celsius");


        System.out.println("What temperature conversion do you intend on doing? ");
        String userInput = scanner.nextLine();

        System.out.println("Enter number: ");
        int userInputNumber = scanner.nextInt();


        switch (userInput) {
            case "Farenheit to Celsius":
                int resultFarenheit = (9/5 * userInputNumber) + 32;
                return userInputNumber + " degree Farenheit is " + resultFarenheit + " degree Celsius";
            
            case "Celsius to Farenheit":
                int resultCelsius = (5/9 * userInputNumber) - 32;
                return userInputNumber + " degree celsius is " + resultCelsius + " degree Frenheit";

            case "Kelvin to Farenheit":
                int resultKelvinFarenheit = ( userInputNumber + 273 );
                return userInputNumber + " degree kelvin is " + ((9/5 * resultKelvinFarenheit) + 32) + " degree Farenheit";

            case "Celsius to Kelvin":
                int resultCelsiusKelvin = userInputNumber + 273;
                return userInputNumber + " degree celsius is " + resultCelsiusKelvin + " degree kelvin"; 
            
            default:
                return "Option not valid";
        }
    }
}