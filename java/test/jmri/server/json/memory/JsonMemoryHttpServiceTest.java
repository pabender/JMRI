// SPDX-License-Identifier: GPL-2.0 WITH Classpath-exception-2.0
package jmri.server.json.memory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import jmri.InstanceManager;
import jmri.JmriException;
import jmri.Memory;
import jmri.MemoryManager;
import jmri.server.json.JSON;
import jmri.server.json.JsonException;
import jmri.server.json.JsonNamedBeanHttpServiceTestBase;
import jmri.server.json.JsonRequest;

import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender
 * @author Randall Wood
 */
public class JsonMemoryHttpServiceTest extends JsonNamedBeanHttpServiceTestBase<Memory, JsonMemoryHttpService> {

    @Test
    @Override
    public void testDoGet() throws JmriException, JsonException {
        MemoryManager manager = InstanceManager.getDefault(MemoryManager.class);
        Memory memory1 = manager.provideMemory("IM1"); // no value
        JsonNode result;
        result = service.doGet(JsonMemory.MEMORY, "IM1", service.getObjectMapper().createObjectNode(), new JsonRequest(locale, JSON.V5, JSON.GET, 42));
        validate(result);
        assertEquals(JsonMemory.MEMORY, result.path(JSON.TYPE).asText());
        assertEquals("IM1", result.path(JSON.DATA).path(JSON.NAME).asText());
        // JSON node has the text "null" if memory is null
        assertEquals("null", result.path(JSON.DATA).path(JSON.VALUE).asText());
        memory1.setValue("throw");
        result = service.doGet(JsonMemory.MEMORY, "IM1", service.getObjectMapper().createObjectNode(), new JsonRequest(locale, JSON.V5, JSON.GET, 42));
        validate(result);
        assertEquals("throw", result.path(JSON.DATA).path(JSON.VALUE).asText());
        memory1.setValue("close");
        result = service.doGet(JsonMemory.MEMORY, "IM1", service.getObjectMapper().createObjectNode(), new JsonRequest(locale, JSON.V5, JSON.GET, 42));
        validate(result);
        assertEquals("close", result.path(JSON.DATA).path(JSON.VALUE).asText());
    }

    @Test
    public void testDoPost() throws JmriException, JsonException {
        MemoryManager manager = InstanceManager.getDefault(MemoryManager.class);
        Memory memory1 = manager.provideMemory("IM1");
        JsonNode result;
        JsonNode message;
        // set off
        message = mapper.createObjectNode().put(JSON.NAME, "IM1").put(JSON.VALUE, "close");
        result = service.doPost(JsonMemory.MEMORY, "IM1", message, new JsonRequest(locale, JSON.V5, JSON.GET, 42));
        assertEquals("close", memory1.getValue());
        validate(result);
        assertEquals("close", result.path(JSON.DATA).path(JSON.VALUE).asText());
        // set on
        message = mapper.createObjectNode().put(JSON.NAME, "IM1").put(JSON.VALUE, "throw");
        result = service.doPost(JsonMemory.MEMORY, "IM1", message, new JsonRequest(locale, JSON.V5, JSON.GET, 42));
        assertEquals("throw", memory1.getValue());
        validate(result);
        assertEquals("throw", result.path(JSON.DATA).path(JSON.VALUE).asText());
        // set null
        message = mapper.createObjectNode().put(JSON.NAME, "IM1").putNull(JSON.VALUE);
        result = service.doPost(JsonMemory.MEMORY, "IM1", message, new JsonRequest(locale, JSON.V5, JSON.GET, 42));
        assertNull(memory1.getValue());
        assertEquals("null", result.path(JSON.DATA).path(JSON.VALUE).asText());
    }

    @Test
    public void testDoPut() throws JsonException {
        MemoryManager manager = InstanceManager.getDefault(MemoryManager.class);
        JsonNode message;
        // add a memory
        assertNull(manager.getMemory("IM1"));
        message = mapper.createObjectNode().put(JSON.NAME, "IM1").put(JSON.VALUE, "close");
        service.doPut(JsonMemory.MEMORY, "IM1", message, new JsonRequest(locale, JSON.V5, JSON.GET, 42));
        assertNotNull(manager.getMemory("IM1"));
    }

    @Test
    public void testDoGetList() throws JsonException {
        MemoryManager manager = InstanceManager.getDefault(MemoryManager.class);
        JsonNode result;
        result = service.doGetList(JsonMemory.MEMORY, NullNode.getInstance(), new JsonRequest(locale, JSON.V5, JSON.GET, 0));
        validate(result);
        assertEquals(0, result.size());
        manager.provideMemory("IM1");
        manager.provideMemory("IM2");
        result = service.doGetList(JsonMemory.MEMORY, NullNode.getInstance(), new JsonRequest(locale, JSON.V5, JSON.GET, 0));
        validate(result);
        assertEquals(2, result.size());
    }

    @BeforeEach
    @Override
    public void setUp() throws Exception {
        super.setUp();
        service = new JsonMemoryHttpService(mapper);
    }

    @AfterEach
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

}
