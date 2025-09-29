import java.util.Scanner;
import java.util.Random;

public class HealthKiosk {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the self-service kiosk!");

        System.out.print("Enter service code (P/L/T/C): ");
        char serviceCode = input.next().charAt(0);
        serviceCode = Character.toUpperCase(serviceCode);

        double metricValue = 0;

        switch (serviceCode) {
            case 'P':
                System.out.println("Go to: Pharmacy Desk");
                break;

            case 'L':
                System.out.println("Go to: Lab Desk");
                break;

            case 'T':
                System.out.println("Go to: Triage Desk");

                System.out.print("Enter health metric (1=BMI, 2=Dosage, 3=Trig): ");
                int metricChoice = input.nextInt();

                switch (metricChoice) {
                    case 1:
                        System.out.print("Enter weight in kg: ");
                        double weight = input.nextDouble();
                        System.out.print("Enter height in m: ");
                        double height = input.nextDouble();

                        double bmi = weight / (height * height);
                        double roundedBmi = Math.round(bmi * 10) / 10.0;
                        System.out.println("BMI: " + roundedBmi);

                        if (roundedBmi < 18.5) {
                            System.out.println("Category: Underweight");
                        } else if (roundedBmi >= 18.5 && roundedBmi <= 24.9) {
                            System.out.println("Category: Normal");
                        } else if (roundedBmi >= 25.0 && roundedBmi <= 29.9) {
                            System.out.println("Category: Overweight");
                        } else {
                            System.out.println("Category: Obese");
                        }
                        metricValue = Math.round(roundedBmi);
                        break;

                    case 2:
                        System.out.print("Enter required dosage in mg: ");
                        double dosage = input.nextDouble();
                        int tablets = (int) Math.ceil(dosage / 250.0);
                        System.out.println("Tablets needed: " + tablets);
                        metricValue = tablets;
                        break;

                    case 3:
                        System.out.print("Enter angle in degrees: ");
                        double angle = input.nextDouble();
                        double radians = Math.toRadians(angle);
                        double trigVal = Math.sin(radians) * 100;
                        metricValue = Math.round(trigVal);
                        System.out.println("Trig metric: " + metricValue);
                        break;

                    default:
                        System.out.println("Invalid health metric option.");
                }
                break;

            case 'C':
                System.out.println("Go to: Counseling Desk");
                break;

            default:
                System.out.println("Invalid service code");
        }

        Random rand = new Random();
        String shortId = "";
        String displayCode = "";

        char randomChar = (char) ('A' + rand.nextInt(26));
        int[] nums = new int[4];
        StringBuilder sb = new StringBuilder();
        sb.append(randomChar);
        for (int i = 0; i < 4; i++) {
            nums[i] = rand.nextInt(7) + 3;
            sb.append(nums[i]);
        }
        shortId = sb.toString();
        if (shortId.length() != 5) {
            System.out.println("Invalid length");
        } else if (!Character.isLetter(shortId.charAt(0))) {
            System.out.println("Invalid: first char must be a letter");
        } else if (!(Character.isDigit(shortId.charAt(1)) && Character.isDigit(shortId.charAt(2)) && Character.isDigit(shortId.charAt(3)) && Character.isDigit(shortId.charAt(4)))) {
            System.out.println("Invalid: last 4 must be digits");
        } else {
            System.out.println("ID IS VALID");
        }

        System.out.print("Enter your first name: ");
        String name = input.next();
        char base = Character.toUpperCase(name.charAt(0));
        char shifted = (char) ('A' + (base - 'A' + 2) % 26);
        String lastTwo = shortId.substring(shortId.length() - 2);
        displayCode = shifted + lastTwo + "-" + (int) metricValue;
        System.out.println("Display Code: " + displayCode);

        switch (serviceCode) {
            case 'P':
                System.out.println("Summary: PHARMACY | ID=" + shortId + " | Code=" + displayCode);
                break;
            case 'L':
                System.out.println("Summary: LAB | ID=" + shortId + " | Code=" + displayCode);
                break;
            case 'T':
                System.out.println("Summary: TRIAGE | ID=" + shortId + " | BMI=" + metricValue + " | Code=" + displayCode);
                break;
            case 'C':
                System.out.println("Summary: COUNSELING | ID=" + shortId + " | Code=" + displayCode);
                break;
        }

        
    }
}



