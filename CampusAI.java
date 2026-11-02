public class CampusAI {

    public static void main(String[] args) {

        // Original performance matrix
        int[][] scores = {
            {92, 88, 91, 90, 90},
            {89, 90, 88, 89, 90},
            {91, 89, 90, 91, 89},
            {87, 88, 89, 88, 89},
            {90, 91, 88, 89, 89}
        };

        String[] categories = {
            "Accuracy",
            "Speed",
            "Reliability",
            "Ease of Use",
            "Overall"
        };

        String[] names = {
            "ChatGPT",
            "Gemini",
            "Claude",
            "Copilot",
            "Perplexity"
        };

        // Create AIModel objects using polymorphism
        AIModel[] assistants = {
            new CreativeAI("ChatGPT", scores[0]),
            new ResearchAI("Gemini", scores[1]),
            new AIModel("Claude", scores[2]),
            new CodingAI("Copilot", scores[3]),
            new ResearchAI("Perplexity", scores[4])
        };

        System.out.println("=== CAMPUSAI OBJECT-ORIENTED REPORT ===");

        // Display original performance matrix
        displayMatrix(names, categories, scores);

        // Display category averages
        displayCategoryAverages(categories, scores);

        // Display AI profiles
        System.out.println("\nAI MODEL PROFILES\n");
        displayAIProfiles(assistants);

        // Display search results
        searchAI(names, "Claude");

        // Display final leaderboard
        displayLeaderboard(assistants);
    }

    // Display original performance matrix
    public static void displayMatrix(
            String[] names,
            String[] categories,
            int[][] scores) {

        System.out.println("\n=== PERFORMANCE MATRIX ===");

        System.out.printf("%-12s", "AI Model");

        for (String category : categories) {
            System.out.printf("%-15s", category);
        }

        System.out.println();

        for (int i = 0; i < scores.length; i++) {

            System.out.printf("%-12s", names[i]);

            for (int score : scores[i]) {
                System.out.printf("%-15d", score);
            }

            System.out.println();
        }
    }

    // Calculate and display category averages
    public static void displayCategoryAverages(
            String[] categories,
            int[][] scores) {

        System.out.println("\n=== CATEGORY AVERAGES ===");

        for (int j = 0; j < categories.length; j++) {

            int total = 0;

            for (int i = 0; i < scores.length; i++) {
                total += scores[i][j];
            }

            double average = (double) total / scores.length;

            System.out.printf(
                "%s: %.2f%n",
                categories[j],
                average
            );
        }
    }

    // Display AI profiles using polymorphism
    public static void displayAIProfiles(AIModel[] assistants) {

        for (AIModel ai : assistants) {

            System.out.println(ai.getName());

            System.out.println(
                "Type: " + ai.getDescription()
            );

            System.out.printf(
                "Average: %.2f%n%n",
                ai.calculateAverage()
            );
        }
    }

    // Search for an AI assistant
    public static void searchAI(String[] names, String searchName) {

        System.out.println("=== SEARCH RESULTS ===");

        boolean found = false;

        for (String name : names) {

            if (name.equalsIgnoreCase(searchName)) {

                System.out.println("Found: " + name);

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("AI assistant not found.");
        }
    }

    // Selection sort leaderboard
    public static void displayLeaderboard(AIModel[] assistants) {

        // Create a copy so the original array remains unchanged
        AIModel[] sorted = new AIModel[assistants.length];

        for (int i = 0; i < assistants.length; i++) {
            sorted[i] = assistants[i];
        }

        // Selection sort
        for (int i = 0; i < sorted.length - 1; i++) {

            int maxIndex = i;

            for (int j = i + 1; j < sorted.length; j++) {

                if (sorted[j].calculateAverage()
                        > sorted[maxIndex].calculateAverage()) {

                    maxIndex = j;
                }
            }

            AIModel temp = sorted[i];

            sorted[i] = sorted[maxIndex];

            sorted[maxIndex] = temp;
        }

        // Display leaderboard
        System.out.println("\n=== FINAL LEADERBOARD ===\n");

        for (int i = 0; i < sorted.length; i++) {

            System.out.printf(
                "%d. %-12s %.2f   %s%n",
                i + 1,
                sorted[i].getName(),
                sorted[i].calculateAverage(),
                sorted[i].getDescription()
            );
        }
    }
}