import java.util.List;
/**
 * 
 * An interface for creating transports.
 */
public interface TransportCreation extends TransportManagement {
    /**
     * Creates a new transport.
     *
     * @param type     the type of the transport
     * @param route    the route of the transport
     * @param capacity the capacity of the transport
     */
    void createTransport(String type, String route, int capacity);

    /**
     * Adds a predefined line between zones.
     *
     * @param originZone      the origin zone of the line
     * @param destinationZone the destination zone of the line
     * @param transports      the list of transports for the predefined line
     */
    void addPredefinedLine(Zone originZone, Zone destinationZone, List<Transport> transports);
     /**
     * Calculates the congestion of a predefined line between zones.
     *
     * @param originZone      the origin zone of the line
     * @param destinationZone the destination zone of the line
     * @return the congestion of the line
     */
    int calculateCongestion(Zone originZone, Zone destinationZone);
}
