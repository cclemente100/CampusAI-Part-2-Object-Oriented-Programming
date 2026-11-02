public class AIModel {

    protected String name;
    protected int[] scores;

    public AIModel(String name, int[] scores) {
        this.name = name;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public int[] getScores() {
        return scores;
    }

    public double calculateAverage() {
        int total = 0;

        for (int score : scores) {
            total += score;
        }

        return (double) total / scores.length;
    }

    public String getDescription() {
        return "General-purpose AI assistant";
    }
}