import javax.tools.DocumentationTool.Location;

public abstract class Traveler {

    public static int nextIDNum = 0;

    private String name;
    private int id;
    private Location current;

    public Traveler() {
        this.name = null;
        this.current = null;
        this.id = nextIDNum;
    }

    public Traveler(String name, Location location) {
        this.name = name;
        this.current = location;
        this.id = nextIDNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(Location location) {
        this.current = location;
    }

    public String getName() {
        return this.name;
    }

    public int getID() {
        return this.id;
    }

    public Location getCurrent() {
        return this.current;
    }

    // Abstract toString method to be implemented by subclasses
    public abstract String toString();

    // Abstract move method to be implemented by subclasses
    public abstract void move(SpaceShip s);
}
