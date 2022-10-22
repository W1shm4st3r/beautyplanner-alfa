package git.w1shm4st3r.beautyplanner.model.enums;

public enum CosmeticType {
    SHAMPOO("Shampoo"),
    CREAM("Cream"),
    EYECREAM("Eye cream"),
    PEELING("Peeling"),
    MASK("Mask"),
    SERUM("Serum"),
    CONDITIONER("Conditioner"),
    TONIC("Tonic"),
    CLEANER("Cleaner");

    private String type;

    CosmeticType(String cosmeticType) {
        this.type = cosmeticType;
    }

    public String getType() {
        return type;
    }

}
