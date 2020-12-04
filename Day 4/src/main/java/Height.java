public class Height {

    private int height;
    private String unit;

    public Height(int height, String unit) {
        this.height = height;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return height + unit;
    }

    public boolean isValid() {
        return ("cm".equals(unit) && height >= 150 && height <= 193) ||
                ("in".equals(unit) && height >= 59 && height <= 76);
    }
}
