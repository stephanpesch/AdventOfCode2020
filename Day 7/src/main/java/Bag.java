import java.util.Objects;

public class Bag {

    private String texture;
    private String color;

    public Bag(String texture, String color) {
        this.texture = texture;
        this.color = color;
    }

    @Override
    public String toString() {
        return texture + " " + color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(texture, color);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Bag)) {
            return false;
        }

        Bag bag = (Bag) obj;

        return bag.texture.equals(this.texture) && bag.color.equals(this.color);
    }
}
