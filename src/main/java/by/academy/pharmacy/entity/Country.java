package by.academy.pharmacy.entity;

public enum Country {
    /**
     * Contains name and ISO code of Australia.
     */
    AUSTRALIA("Australia", "AU"),
    /**
     * Contains name and ISO code of Austria.
     */
    AUSTRIA("Austria", "AT"),
    /**
     * Contains name and ISO code of Belgium.
     */
    BELGIUM("Belgium", "BE"),
    /**
     * Contains name and ISO code of Canada.
     */
    CANADA("Canada", "CA"),
    /**
     * Contains name and ISO code of Croatia.
     */
    CROATIA("Croatia", "HR"),
    /**
     * Contains name and ISO code of Japan.
     */
    JAPAN("Japan", "JP"),
    /**
     * Contains name and ISO code of the United States.
     */
    UNITED_STATES("United States", "US"),
    /**
     * Contains name and ISO code of Poland.
     */
    POLAND("Poland", "PL"),
    /**
     * Contains name and ISO code of South Korea.
     */
    SOUTH_KOREA("South Korea", "KR"),
    /**
     * Contains name and ISO code of Sweden.
     */
    SWEDEN("Sweden", "SE");

    /**
     * Contains name of the country.
     */
    private final String name;
    /**
     * Contains ISO code of the country.
     */
    private final String code;

    Country(final String newName, final String newCode) {
        name = newName;
        code = newCode;
    }

    /**
     * Gets name of the country.
     *
     * @return string value of name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets ISO code of the country.
     *
     * @return string value of code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Returns Country enum constant with the specified name.
     *
     * @param newCode country code value.
     * @return Country enum constant.
     */
    public static Country valueOfCode(final String newCode) {
        return switch (newCode) {
            case "AU" -> Country.AUSTRALIA;
            case "AT" -> Country.AUSTRIA;
            case "BE" -> Country.BELGIUM;
            case "CA" -> Country.CANADA;
            case "HR" -> Country.CROATIA;
            case "JP" -> Country.JAPAN;
            case "US" -> Country.UNITED_STATES;
            case "PL" -> Country.POLAND;
            case "KR" -> Country.SOUTH_KOREA;
            case "SE" -> Country.SWEDEN;
            default -> null;
        };
    }
}
