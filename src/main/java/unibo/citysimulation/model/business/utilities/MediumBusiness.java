package unibo.citysimulation.model.business.utilities;

import java.util.LinkedList;

import unibo.citysimulation.model.business.impl.Business;
import unibo.citysimulation.model.zone.Zone;

/**
 * Represents a medium-sized business in the city simulation.
 * Inherits from the Business class.
 */
public class MediumBusiness extends Business {

    public MediumBusiness(final Zone zone) {
        super(new BusinessData(
            new LinkedList<>(),
            BusinessConfig.MEDIUM_OPENING_TIME,
            BusinessConfig.MEDIUM_CLOSING_TIME,
            BusinessConfig.MEDIUM_REVENUE,
            BusinessConfig.MAX_EMPLOYEES_MEDIUM_BUSINESS,
            zone.getRandomPosition(),
            BusinessConfig.MEDIUM_MIN_AGE,
            BusinessConfig.MEDIUM_MAX_AGE,
            BusinessConfig.MEDIUM_MAX_TARDINESS,
            zone));
    }
}
