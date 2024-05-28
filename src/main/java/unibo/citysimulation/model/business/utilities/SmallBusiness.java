package unibo.citysimulation.model.business.utilities;

import unibo.citysimulation.model.business.impl.Business;
import unibo.citysimulation.model.zone.Zone;

/**
 * Represents a small business in the city simulation.
 * Inherits from the Business class.
 */
public class SmallBusiness extends Business {

    /**
     * Constructs a SmallBusiness object.
     * Initializes the opening time, closing time, revenue, maximum number of employees,
     * maximum age, minimum age, and maximum tardiness based on the configuration values
     * defined in the BusinessConfig class.
     *
     * @param zone the zone where the small business is located
     */
    public SmallBusiness(final Zone zone) {
        super(zone);
        setOpLocalTime(BusinessConfig.SMALL_OPENING_TIME);
        setClLocalTime(BusinessConfig.SMALL_CLOSING_TIME);
        setRevenue(BusinessConfig.SMALL_REVENUE);
        setMaxEmployees(BusinessConfig.MAX_EMPLOYEES_SMALL_BUSINESS);
        setMaxAge(BusinessConfig.SMALL_MAX_AGE);
        setMinAge(BusinessConfig.SMALL_MIN_AGE);
        setMaxTardiness(BusinessConfig.SMALL_MAX_TARDINESS);
    }
}