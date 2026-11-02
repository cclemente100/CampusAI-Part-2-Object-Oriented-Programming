public class CreativeAI extends AIModel {

    public CreativeAI(String name, int[] scores) {
        super(name, scores);
    }

    @Override
    public String getDescription() {
        return "Creative AI assistant";
    }
}