public abstract class Passenger extends Traveler {

    private double cost;
    private SeatCategory seat;
    private int rewardsPoints;

    // Constants for the cost of different seat classes
    private static final double FIRST_CLASS_COST = 1499.00;
    private static final double BUSINESS_CLASS_COST = 998.00;
    private static final double COACH_CLASS_COST = 449.00;

    public Passenger() {
        super(); // Call the superclass constructor
        this.cost = 0.0; // Default cost
        this.seat = SeatCategory.NOSEAT; // Default seat category
        this.rewardsPoints = 0; // Default rewards points
    }

    public Passenger(String name, Location location, SeatCategory seat) {
        super(name, location); // Call the superclass constructor
        this.seat = seat;
        calculateCost(); // Calculate cost based on seat category
        this.rewardsPoints = 0; // Default rewards points
    }

    // Accessor and mutator methods for cost
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    // Accessor and mutator methods for seat
    public SeatCategory getSeat() {
        return seat;
    }

    public void setSeat(SeatCategory seat) {
        this.seat = seat;
        calculateCost(); // Recalculate cost when the seat is set
    }

    // Accessor and mutator methods for rewardsPoints
    public int getRewardsPoints() {
        return rewardsPoints;
    }

    public void setRewardsPoints(int rewardsPoints) {
        this.rewardsPoints = rewardsPoints;
    }

    // Upgrade passenger based on rewards points
    public void upgradeAndResetPoints(SpaceShip s) {
        if (rewardsPoints >= 10000) {
            if (seat != SeatCategory.FIRST) {
                seat = SeatCategory.FIRST;
            } else {
                cost *= 0.8; // 20% discount for first class passengers
            }
            rewardsPoints = 0; // Reset rewards points
            rewardsPoints += s.getFlightHours() * 100; // Add rewards points based on flight hours
        }
    }

    // Override toString method for customized representation
    @Override
    public String toString() {
        return String.format("Passenger [name=%s, id=%d, current=%s, seat=%s, cost = $%.2f, rewardsPoints=%d]",
                getName(), getID(), getCurrent(), seat, cost, rewardsPoints);
    }

    // Override move method as required
    @Override
    public void move(SpaceShip s) {
        // Implement passenger's move behavior here
    }

	@Override
	public void move(SpaceShip s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(SpaceShip s) {
		// TODO Auto-generated method stub
		
	}
}
