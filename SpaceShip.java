import java.util.Arrays;

import javax.tools.JavaFileManager.Location;

class SpaceShip {
    private String name;
    private Location current;
    private Location destination;
    private int capacity;
    private int numOfTravelers;
    private Traveler[] travelers;
    private int flightHours;

    public SpaceShip() {
        this.name = null;
        this.current = null;
        this.destination = null;
        this.capacity = 20;
        this.numOfTravelers = 0;
        this.travelers = new Traveler[capacity];
        this.flightHours = 0;
    }

    public SpaceShip(String name, Location current, Location destination, int capacity) {
        this.name = name;
        this.current = current;
        this.destination = destination;
        this.capacity = capacity;
        this.numOfTravelers = 0;
        this.travelers = new Traveler[capacity];
        this.flightHours = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrent(Location current) {
        this.current = current;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
        // Resize the travelers array if capacity changes
        travelers = Arrays.copyOf(travelers, capacity);
    }

    public String getName() {
        return name;
    }

    public Location getCurrent() {
        return current;
    }

    public Location getDestination() {
        return destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFlightHours() {
        return flightHours;
    }

    public boolean board(Traveler t) {
        if (!isOnBoard(t) && numOfTravelers < capacity) {
            travelers[numOfTravelers] = t;
            numOfTravelers++;
            return true;
        } else {
            return false;
        }
    }

    public boolean leave(Traveler t) {
        boolean check = false;

        for (int i = 0; i < numOfTravelers; i++) {
            if (t.getID() == travelers[i].getID()) {
                travelers[i] = null;
                // Move the last non-null traveler to the removed position
                travelers[i] = travelers[numOfTravelers - 1];
                travelers[numOfTravelers - 1] = null;
                numOfTravelers--;
                check = true;
            }
        }

        return check;
    }

    public boolean isOnBoard(Traveler t) {
        for (int i = 0; i < numOfTravelers; i++) {
            if (t.getID() == travelers[i].getID()) {
                return true;
            }
        }
        return false;
    }

    public boolean move(Location newLocation) {
        if (current.equals(newLocation)) {
            return false; // Already at the specified location
        } else {
            current = newLocation;
            return true;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Spaceship [name=").append(name).append(", current=").append(current)
                .append(", destination=").append(destination).append(", capacity=").append(capacity)
                .append(", flighthours=").append(flightHours).append("]\n");

        for (int i = 0; i < numOfTravelers; i++) {
            sb.append(travelers[i].toString()).append("\n");
        }

        return sb.toString();
    }
}
