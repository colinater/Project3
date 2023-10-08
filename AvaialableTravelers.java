public class AvailableTravelers {

    private Traveler[] travelers;
    private int numOfTravelers;

    public AvailableTravelers() {
        travelers = new Traveler[20]; // Creates an array with a default size of 20
        numOfTravelers = 0;
    }

    public AvailableTravelers(int capacity) {
        travelers = new Traveler[capacity]; // Creates an array with a specified capacity
        numOfTravelers = 0;
    }

    public boolean addTraveler(Traveler t) {
        if (numOfTravelers >= travelers.length) {
            return false; // Array is at capacity
        }

        // Check if the traveler is already in the array by comparing IDs
        for (int i = 0; i < numOfTravelers; i++) {
            if (travelers[i].getID() == t.getID()) {
                return false; // Traveler with the same ID is already in the array
            }
        }

        // Add the traveler to the array and increment the count
        travelers[numOfTravelers] = t;
        numOfTravelers++;
        return true; // Traveler successfully added
    }

    public Traveler findTravelerByName(String name) {
        for (int i = 0; i < numOfTravelers; i++) {
            if (travelers[i].getName().equals(name)) {
                return travelers[i]; // Return the traveler with the specified name
            }
        }
        return null; // Traveler not found
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numOfTravelers; i++) {
            sb.append(travelers[i].toString()).append("\n");
        }

        return sb.toString();
    }
}
