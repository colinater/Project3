import javax.tools.DocumentationTool.Location;

public class Crew extends Traveler {
    private String position;
    private double payRate;
    private int flightHours;

    public Crew() {
        super();
        this.position = "Crewman";
        this.payRate = 0.0;
        this.flightHours = 0;
    }

    public Crew(String name, Location location, String position, double payRate) {
        super(name, location);
        this.position = position;
        this.payRate = payRate;
        this.flightHours = 0;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public int getFlightHours() {
        return flightHours;
    }

    public void setFlightHours(int flightHours) {
        this.flightHours = flightHours;
    }

    @Override
    public void move(SpaceShip s) {
        // Adds the flight hours of the SpaceShip s to the accumulated flight hours
        this.flightHours += s.getFlightHours();
    }

    @Override
    public String toString() {
        return "Crew [name=" + getName() + ", id=" + getID() + ", current=" + getCurrent() +
               ", position=" + position + ", pay = $" + payRate + ", flight hours = " + flightHours + "]";
    }
}
