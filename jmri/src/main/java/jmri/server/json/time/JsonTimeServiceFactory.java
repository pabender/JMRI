// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.server.json.time;

import com.fasterxml.jackson.databind.ObjectMapper;

import jmri.server.json.JSON;
import jmri.server.json.JsonConnection;
import jmri.spi.JsonServiceFactory;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Randall Wood
 */
@ServiceProvider(service = JsonServiceFactory.class)
public class JsonTimeServiceFactory implements JsonServiceFactory<JsonTimeHttpService, JsonTimeSocketService> {

    @Override
    public String[] getTypes(String version) {
        return new String[]{JSON.TIME};
    }

    @Override
    public JsonTimeSocketService getSocketService(JsonConnection connection, String version) {
        return new JsonTimeSocketService(connection);
    }

    @Override
    public JsonTimeHttpService getHttpService(ObjectMapper mapper, String version) {
        return new JsonTimeHttpService(mapper);
    }

}
