// Program 7: Volume of Earth in km^3 and miles^3
public class Program7EarthVolume {
    public static void main(String[] args) {
        double radiusKm = 6378;
        double volumeKm3 = (4.0 / 3) * Math.PI * Math.pow(radiusKm, 3);
        double radiusMiles = radiusKm * 0.621371;
        double volumeMiles3 = (4.0 / 3) * Math.PI * Math.pow(radiusMiles, 3);
        System.out.println(volumeKm3);
        System.out.println(volumeMiles3);
    }
}
