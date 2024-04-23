public class calculateDistance {
    private double lat1;
    private double lon1;
    private double lat2;
    private double lon2;

    // constructor
    public calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        this.lat1 = lat1;
        this.lon1 = lon1;
        this.lat2 = lat2;
        this.lon2 = lon2;
    }

    // math is from the following website:
    // https://community.esri.com/t5/coordinate-reference-systems-blog/distance-on-a-sphere-the-haversine-formula/ba-p/902128#:~:text=All%20of%20these%20can%20be,longitude%20of%20the%20two%20points
    public double getDistance() {
        final int R = 6371; // Radius of the Earth in kilometers

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c;
        return distance;
    }

    public String getTime() {
        double dist = getDistance();
        double hours = (dist / 22.97); //kmh for average forest fire spread
        // source: https://wfca.com/wildfire-articles/how-fast-do-wildfires-spread/#:~:text=Wildfires%20spread%20at%20an%20average%20of%2014.27%20miles,such%20as%20weather%20conditions%2C%20fuel%20type%2C%20and%20terrain.
        int mins =  (int) Math.floor(hours * 60);
        if (mins / 60 >= 1) {
            int hoursT = (int) Math.floor(mins / 60);
            int minsT = (mins % 60) * 60;
            return "According to average fire spread data, you have approximately " + hoursT + " hour(s) and " +
                    minsT + " minutes.";
        }
        return "According to average fire spread data, you have approximately " + mins + " minutes.";
    }
}
