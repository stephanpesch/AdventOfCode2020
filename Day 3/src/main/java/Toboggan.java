public class Toboggan {

    private int right;
    private int down;
    private int movementRight;
    private int movementDown;

    public Toboggan(int movementRight, int movementDown) {
        right = 0;
        down = 0;
        this.movementRight = movementRight;
        this.movementDown = movementDown;
    }

    public void move(int right, int down) {
        this.right += right;
        this.down += down;
    }

    public void move() {
        move(movementRight, movementDown);
    }

    public int getRight() {
        return right;
    }

    public int getDown() {
        return down;
    }
}
