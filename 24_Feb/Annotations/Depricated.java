class LegacyAPI {
    @Deprecated
    void oldFeature() {
        System.out.println("Old feature is being used");
    }

    void newFeature() {
        System.out.println("New feature is available");
    }
}

public class Depricated {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();
        api.newFeature();
    }
}
