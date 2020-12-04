public class Height {

    private int height;
    private String unit;

    public Height(String input) {
        int splitIndex = input.length() - 3;
        this.unit = input.substring(splitIndex);
        this.height = Integer.parseInt(input.substring(0, splitIndex));
    }
}
