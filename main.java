import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiseasePrediction {
    public static void main(String[] args) {
        String[][] dataset = DiseaseData.dataset;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter symptoms (separated by ,): ");
        String input = scanner.nextLine();
        String[] symptoms = input.split(", ");

        int likely = 0;
        List<Integer> predict = new ArrayList<>();

        for (int i = 0; i < dataset.size(); i++) {
            String[] diseases = dataset.get(i);
            for (String symptom : symptoms) {
                for (String diseaseSymptom : diseases) {
                    if (symptom.equals(diseaseSymptom)) {
                        likely++;
                        break;
                    }
                }
            }
            predict.add(likely);
            likely = 0;
        }

        for (int a = symptoms.length; a > 0; a--) {
            if (predict.contains(a)) {
                int index = predict.indexOf(a);
                System.out.println("You might be having: " + dataset[index][0]);
                break;
            }
        }
    }
}

