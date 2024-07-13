/**
 * BY BHUWAN UPADHYAYA
 * DATE: 2/16/2024
 * 
 * This program will calculate the BMI(biximent metabolic index) for people of Q-Work people
 * As per the BMI value it will print out the report and recommend them the proper treatment
 * 
 * This program will promts the user regarding their age, weight,....and throw out any immediate error
 * Also will provide oppourtunity to correct those values.
 * 
 */

import java.util.Scanner;

public class BUProjectOne {

    public static void main(String[] args) {
        double biximentMetabolicIndex;  //BMI 
        char gender;                        // gender of the people
        char letter;                        // The user's Y or N decision
        double age;                         // age of Qwork people
        double weight;                      // weight of the people
        double biximentLevel;               // people's  biximent level
        double genderFactor = 0;            // gender factor based on gender
        String recommendedTreatment="";     // required treatment as per BMI value
        String condition = "";              // condition based on BMI

        Scanner keyboard = new Scanner(System.in);
        do {
        // Prompt the citizen for their weight in kilograms
        do {
            System.out.println("Hello Qwork People!!");
            System.out.println("I am your medical officer BHUWAN from IAS.");
            System.out.println("I will require following datas from you.");
            System.out.println("Enter your weight in kilograms :");
            weight = keyboard.nextDouble();

            if (weight <= 27) {
                System.out.println("Error: Weight must be greater than 27 kilograms again.");
            }
        } while (weight <= 27);

        // Prompt the citizen for their age in solar cycles
        do {
            System.out.println("Enter your age in solar cycles :");
            age = keyboard.nextDouble();

            if (age < 17 || age > 97) {
                System.out.println("Error: Age must be between 17 and 97 solar cycles.\nTry again.");
            }
        } while (age < 17 || age > 97);

        // Prompt the citizen for their gender identification
        do {
            System.out.println("Enter your gender (R, S, T):");
            gender = Character.toUpperCase(keyboard.next().charAt(0));

            if (gender != 'R' && gender != 'S' && gender != 'T') {
                System.out.println("Error: Invalid gender input.\nTry again.");
            }
        } while (gender != 'R' && gender != 'S' && gender != 'T');

        // Prompt the citizen for their Biximent level
        do {
            System.out.println("Enter your Biximent level :");
            biximentLevel = keyboard.nextDouble();

            if (biximentLevel < 31) {
                System.out.println("Error: Biximent level must be at least 31.");
            }
        } while (biximentLevel < 31);

        // Calculate gender factor based on gender
        switch (gender) {
            case 'R':
                genderFactor = 8.42;
                break;
            case 'S':
                genderFactor = 4.25;
                break;
            case 'T':
                genderFactor = 6.37;
                break;
            default:
                System.out.println("Error: Invalid gender input.");  // no use of default case at this point
                                                                     // because if gender is wrong it will ask to re-enter
                return; // Exit the program if gender is not valid
        }

        //Method call,  Calculate the Biximent Metabolic Index (BMI) 
        biximentMetabolicIndex = calculateBMI(age, biximentLevel, weight, genderFactor);
        String biximentMetabolicIndex2 =String.format("%.1f", biximentMetabolicIndex); 
        
        if (biximentMetabolicIndex<90){
            recommendedTreatment = "No treatment required";
            condition = "Mild";
            
        }
        else if (biximentMetabolicIndex>=90 && biximentMetabolicIndex<125){
            recommendedTreatment ="Medication treatment";
            condition = "Serious";
            
        }
        else if (biximentMetabolicIndex>=125 && biximentMetabolicIndex<210){
            recommendedTreatment ="Ultraviolet treatment";
            condition = "Acute";
            
        }
        else if (biximentMetabolicIndex>=210 && biximentMetabolicIndex<372){
            recommendedTreatment ="Replacement therapy";
            condition = "Severe";
        }
        else if (biximentMetabolicIndex >=372){
            recommendedTreatment = "Hospitalization";
            condition = "Extreme";
            
        }
        System.out.println();
        System.out.println(
        "For a citizen of gender type " + gender + ", who is " + age + " cycles old and\n" +
        "weighs " + weight + " kilograms with a reported Biximent Level of " + biximentLevel + ",\n" +
        "the Biximent Metabolic Index is " + biximentMetabolicIndex2 + ", their condition is\n" +
        condition + " and " + recommendedTreatment + " is recommended.");
        System.out.println(" ");
        


        if (biximentMetabolicIndex>220){
            System.out.println("Biximent Metabolic Index Report");
            System.out.println("Gender: " + gender);
            System.out.println("Age: " + age + " cycles");
            System.out.println("Weight: " + weight + " kilograms");
            System.out.println("Biximent Level: " + biximentLevel);
            System.out.println("BMI: " + biximentMetabolicIndex2);
            System.out.println("Recommended treatment: " + condition+","+recommendedTreatment);
            System.out.println("Inhabitant is Highly Contagious. ");
            
        }
        else{
            System.out.println("Biximent Metabolic Index Report");
            System.out.println("Gender: " + gender);
            System.out.println("Age: " + age + " cycles");
            System.out.println("Weight: " + weight + " kilograms");
            System.out.println("Biximent Level: " + biximentLevel);
            System.out.println("BMI: " + biximentMetabolicIndex2);
            System.out.println("Recommended treatment: " +condition+","+recommendedTreatment ); 
        }
        System.out.println("Do you want to exit the program (Y/N)?: ");
        keyboard.nextLine();  // consume the newline character
        String answer = keyboard.nextLine();
        letter = answer.charAt(0);

      } while(letter != 'Y' && letter != 'y');
    }
    

    // Method to calculate BMI
    /**
     * 
     * @param age---->age of Qwork people
     * @param biximentLevel-----> people's  biximent level
     * @param weight ------> weight of the people
     * @param genderFactor -----> gender factor based on gender
     * @return ---BMI value
     */
    public static double calculateBMI(double age, double biximentLevel, double weight, double genderFactor) {
        return (2.66 * age) + (biximentLevel * 477) / (weight * genderFactor);
    }
}
