public class Passport {

    private int birthYear;
    private int issueYear;
    private int expirationYear;
    private Height height;
    private String hairColor;
    private String eyeColor;
    private String passportId;
    private String countryId;

    public Passport() {
        birthYear = -1;
        issueYear = -1;
        expirationYear = -1;
    }

    @Override
    public String toString() {
        return String.format("byr:%s, iyr:%s, eyr:%s, hgt:%s, hcl:%s, ecl:%s, pid:%s, cid:%s, valid:%b",
                birthYear, issueYear, expirationYear, height, hairColor, eyeColor, passportId, countryId, isValid());
    }

    public boolean isValid() {
        return birthYear != -1 && issueYear != -1 && expirationYear != -1 &&
                height != null && hairColor != null && eyeColor != null &&
                passportId != null;
    }

    private int parseYear(String year, int from, int to) {
        try {
            int yearInt = Integer.parseInt(year);
            if (yearInt>= from && yearInt <= to) {
                return  yearInt;
            }
        } catch (Exception ignored) {

        }
        return -1;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = parseYear(birthYear, 1920, 2002);
    }

    public int getIssueYear() {
        return issueYear;
    }

    public void setIssueYear(String issueYear) {
        this.issueYear = parseYear(issueYear, 2010, 2020);
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = parseYear(expirationYear, 2020, 2030);
    }

    public Height getHeight() {
        return height;
    }

    public void setHeight(String height) {
        if (height.matches("[0-9]*(cm|in)")) {
            int splitIndex = height.length() - 2;
            String unit = height.substring(splitIndex);
            int heightInt = Integer.parseInt(height.substring(0, splitIndex));
            if (("cm".equals(unit) && heightInt >= 150 && heightInt <= 193) ||
                    ("in".equals(unit) && heightInt >= 59 && heightInt <= 76)) {
                this.height = new Height(heightInt, unit);
            }
        }
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        if (hairColor.matches("#[a-fA-F0-9]{6}")) {
            this.hairColor = hairColor;
        }
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        if ("amb".equals(eyeColor) || "blu".equals(eyeColor) || "brn".equals(eyeColor) || "gry".equals(eyeColor) ||
                "grn".equals(eyeColor) || "hzl".equals(eyeColor) || "oth".equals(eyeColor)) {
            this.eyeColor = eyeColor;
        }
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        if (passportId.matches("[0-9]{9}")) {
            this.passportId = passportId;
        }
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }
}
