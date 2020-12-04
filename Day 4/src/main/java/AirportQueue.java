import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AirportQueue {

    private List<Passport> passports;

    public AirportQueue() {
        this.passports = new ArrayList<>();
    }

    public void add(Passport passport) {
        passports.add(passport);
    }

    public long countValid() {
        return passports.stream().filter(Passport::isValid).count();
    }

    public void printAll() {
        passports.forEach(System.out::println);
    }

    public static AirportQueue getFromFile(String file) {
        AirportQueue queue = new AirportQueue();
        String input;
        try {
            input = Files.readString(Paths.get(file));
        } catch (IOException e) {
            e.printStackTrace();
            input = "";
        }

        String[] splitInput = input.split("\\s\\s");
        for (String s : splitInput) {
            queue.add(parsePort(s.split("\\s")));
        }

        return queue;
    }

    private static Passport parsePort(String[] input) {
        Passport passport = new Passport();
        for (String s : input) {
            String[] splitS = s.split(":");
            String category = splitS[0];

            // System.out.println(Arrays.toString(splitS));

            switch (category) {
                case "ecl":
                    passport.setEyeColor(splitS[1]);
                    break;
                case "pid":
                    passport.setPassportId(splitS[1]);
                    break;
                case "eyr":
                    passport.setExpirationYear(splitS[1]);
                    break;
                case "hcl":
                    passport.setHairColor(splitS[1]);
                    break;
                case "byr":
                    passport.setBirthYear(splitS[1]);
                    break;
                case "iyr":
                    passport.setIssueYear(splitS[1]);
                    break;
                case "cid":
                    passport.setCountryId(splitS[1]);
                    break;
                case "hgt":
                    passport.setHeight(splitS[1]);
                    break;
            }
        }
        return passport;
    }
}
