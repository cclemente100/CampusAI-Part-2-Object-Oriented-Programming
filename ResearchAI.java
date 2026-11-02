public class ResearchAI extends AIModel {

    public ResearchAI(String name, int[] scores) {
        super(name, scores);
    }

    @Override
    public String getDescription() {
        return "Research-focused AI assistant";
    }
}