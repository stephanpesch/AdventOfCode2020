import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ferry {

    private int eastWestCoordinate;
    private int northSouthCoordinate;
    private int angle;

    public Ferry() {
        reset();
    }

    @Override
    public String toString() {
        return "Ferry{" +
                "eastWestCoordinate=" + eastWestCoordinate +
                ", northSouthCoordinate=" + northSouthCoordinate +
                ", angle=" + angle +
                '}';
    }

    public void reset() {
        this.eastWestCoordinate = 0;
        this.northSouthCoordinate = 0;
        this.angle = 0;
    }

    public void moveByInstructionsFromFile(String file) {
        try (Scanner scanner = new Scanner(Paths.get(file))) {
            while (scanner.hasNext()) {
                followInstruction(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void followInstruction(String instruction) {
        char action = instruction.charAt(0);
        int value = Integer.parseInt(instruction.substring(1));

        switch (action) {
            case 'N':
                moveNorthBy(value);
                break;
            case 'S':
                moveNorthBy(-value);
                break;
            case 'E':
                moveEastBy(value);
                break;
            case 'W':
                moveEastBy(-value);
                break;
            case 'L':
                rotateRightBy(-value);
                break;
            case 'R':
                rotateRightBy(value);
                break;
            case 'F':
                moveForward(value);
                break;
        }
    }

    private void moveEastBy(int moveBy) {
        eastWestCoordinate += moveBy;
    }

    private void moveNorthBy(int moveBy) {
        northSouthCoordinate += moveBy;
    }

    private void moveForward(int moveBy) {
        switch (angle) {
            case 0:
                moveEastBy(moveBy);
                break;
            case 90:
            case -270:
                moveNorthBy(-moveBy);
                break;
            case 180:
            case -180:
                moveEastBy(-moveBy);
                break;
            case 270:
            case -90:
                moveNorthBy(moveBy);
                break;
        }
    }

    private void rotateRightBy(int angle) {
        this.angle = (this.angle + angle) % 360;
    }

    public int manhattanDistanceFromStartingPosition() {
        return Math.abs(eastWestCoordinate) + Math.abs(northSouthCoordinate);
    }
}
