public class CodingAI extends AIModel {

    public CodingAI(String name, int[] scores) {
        super(name, scores);
    }

    @Override
    public String getDescription() {
        return "Programming-focused AI assistant";
    }
}