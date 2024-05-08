package unibo.citysimulation.model.transport;

<<<<<<< HEAD

=======
>>>>>>> branch_develop
/**
 * Represents a transport line within the city simulation.
 * Each transport line has a name, capacity, and duration.
 * It also maintains the number of people in line and can calculate the congestion.
 */
<<<<<<< HEAD
public class TransportLine {
    private int capacity;
    private String name;
    private int personInLine=0;
    private int duration;

    public TransportLine(String name,int capacity,int duration) {
        this.name = name;
        this.capacity=capacity;
        this.duration=duration;
    }

    // Getter and setter methods for other fields, if needed
    public String getName() {
        return name;
    }
    public double getCongestion(){
        return (double)(personInLine*100/capacity);
    }
    public int getDuration(){
        return duration;
    }
}
=======
public interface TransportLine {
    /**
     * Returns the name of the transport line.
     *
     * @return the name of the transport line
     */
    String getName();

    /**
     * Returns the congestion of the transport line as a percentage of the capacity.
     *
     * @return the congestion of the transport line
     */
    double getCongestion();

    /**
     * Returns the duration of the transport line.
     *
     * @return the duration of the transport line
     */
    int getDuration();
}
>>>>>>> branch_develop
