public class Passport {

    private String birthYear;
    private String issueYear;
    private String expirationYear;
    private String height;
    private String hairColor;
    private String eyeColor;
    private String passportId;
    private String countryId;

    public Passport() {
        birthYear = null;
        issueYear = null;
        expirationYear = null;
        height = null;
        hairColor = null;
        eyeColor = null;
        passportId = null;
        countryId = null;
    }

    @Override
    public String toString() {
        return String.format("byr:%s, iyr:%s, eyr:%s, hgt:%S, hcl:%s, ecl:%s, pid:%s, cid:%s, valid:%b",
                birthYear, issueYear, expirationYear, height, hairColor, eyeColor, passportId, countryId, isValid());
    }

    public boolean isValid() {
        return birthYear != null && issueYear != null && expirationYear != null &&
                height != null && hairColor != null && eyeColor != null &&
                passportId != null;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getIssueYear() {
        return issueYear;
    }

    public void setIssueYear(String issueYear) {
        this.issueYear = issueYear;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }
}
