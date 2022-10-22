package git.w1shm4st3r.beautyplanner.model.enums;

public enum CosmeticDestination {
    FACE("Face"), BODY("Body"), HAIR("Hair"), MAKEUP("Make-up");

    private String destination;

    CosmeticDestination(String value) {
        this.destination = value;
    }

    public String getDestination() {
        return destination;
    }

//    public static CosmeticDestination of(String value) {
//        return Stream.of(CosmeticDestination.values())
//                .filter(cd -> cd.getDestination().equals(value))
//                .findFirst()
//                .orElseThrow(IllegalArgumentException::new);
//    }
}
