public class Player {
    private String name;
    private Integer bornYear;
    private Boolean agree;

    public Player(Boolean agree, String name, Integer bornYear) {
        this.agree = agree;
        this.name = name;
        this.bornYear = bornYear;
    }

    public static Player createPlayer(Boolean agree, String name, Integer born) {
        if (isValidBornYear(born) && isValidName(name) && agree) {
            return new Player(agree, name, born);
        }
        return null;
    }

    public void setName(String name) {
        if (isValidName(name)) {
            this.name = name;
        }
    }

    public void setBornYear(Integer bornYear) {
        if (isValidBornYear(bornYear)) {
            this.bornYear = bornYear;
        }
    }

    public String getName() {
        return name;
    }

    public Integer getBornYear() {
        return bornYear;
    }

    public Boolean getAgree() {
        return agree;
    }

    private static boolean isValidName(String name) {
        return name != null && name.matches("^[a-zA-Z0-9 ]+$");
    }

    private static boolean isValidBornYear(Integer bornYear) {
        if (bornYear == null) {
            return false;
        }
        int currentYear = java.time.LocalDate.now().getYear();
        if ((currentYear - bornYear) < 18) {
            return false;
        }
        return true;


    }
}