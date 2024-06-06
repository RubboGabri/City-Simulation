package unibo.citysimulation.model.transport.impl;


import unibo.citysimulation.model.transport.api.TransportFactory;
import unibo.citysimulation.model.transport.api.TransportLine;
import unibo.citysimulation.model.zone.Zone;
import unibo.citysimulation.utilities.Pair;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collections;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

/**
 * Factory for creating TransportLine objects.
 * This factory creates a list of TransportLine objects based on a list of Zone
 * objects.
 */
public final class TransportFactoryImpl implements TransportFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransportFactoryImpl.class);
    /**
     * Create a list of TransportLine objects based on a list of Zone objects.
     * 
     * @param zones List of Zone objects.
     * @return List of TransportLine objects.
     */
    @Override
    public List<TransportLine> createTransportsFromFile(final List<Zone> zones) {
        final List<TransportLine> lines = new ArrayList<>();
        final Gson gson = new Gson();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                    new FileInputStream("src/main/resources/unibo/citysimulation/data/TransportInfo.json"),
                        StandardCharsets.UTF_8))) {
            final JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);
            for (final JsonElement jsonElement : jsonArray) {
                final JsonObject jsonObject = jsonElement.getAsJsonObject();

                lines.add(
                    new TransportLineImpl(
                        jsonObject.get("name").getAsString(),
                        jsonObject.get("capacity").getAsInt(),
                        jsonObject.get("duration").getAsInt(),
                        new Pair<Zone, Zone>(
                            zones.get(jsonObject.get("zone").getAsJsonObject().get("a").getAsInt()),
                            zones.get(jsonObject.get("zone").getAsJsonObject().get("b").getAsInt())
                        )
                    )
                );
            }

        } catch (FileNotFoundException e) {
            LOGGER.error("File not found: ", e);
        } catch (JsonParseException e) {
            LOGGER.error("Error parsing JSON: ", e);
        } catch (IOException e) {
            LOGGER.error("Error reading file: ", e);
        }

        return lines.isEmpty() ? Collections.emptyList() : lines;
    }
}
