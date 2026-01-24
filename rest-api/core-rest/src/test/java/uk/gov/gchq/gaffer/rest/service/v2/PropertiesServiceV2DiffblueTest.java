/*
 * Copyright 2026 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.gchq.gaffer.rest.service.v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;
import org.glassfish.jersey.message.internal.OutboundJaxrsResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.Error;

class PropertiesServiceV2DiffblueTest {
  /**
   * Test {@link PropertiesServiceV2#getProperties()}.
   *
   * <p>Method under test: {@link PropertiesServiceV2#getProperties()}
   */
  @Test
  @DisplayName("Test getProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response PropertiesServiceV2.getProperties()"})
  void testGetProperties() {
    // Arrange and Act
    Response actualProperties = new PropertiesServiceV2().getProperties();

    // Assert
    StatusType statusInfo = actualProperties.getStatusInfo();
    assertTrue(statusInfo instanceof Status);
    assertTrue(actualProperties instanceof OutboundJaxrsResponse);
    assertNull(actualProperties.getLocation());
    assertNull(actualProperties.getDate());
    assertNull(actualProperties.getLastModified());
    assertNull(actualProperties.getLanguage());
    assertNull(actualProperties.getEntityTag());
    assertNull(actualProperties.getMediaType());
    assertEquals(-1, actualProperties.getLength());
    MultivaluedMap<String, Object> headers = actualProperties.getHeaders();
    assertEquals(1, headers.size());
    MultivaluedMap<String, String> stringHeaders = actualProperties.getStringHeaders();
    assertEquals(1, stringHeaders.size());
    assertEquals(200, actualProperties.getStatus());
    assertEquals(Status.OK, statusInfo);
    assertTrue(headers.containsKey("X-Gaffer-Media-Type"));
    assertTrue(stringHeaders.containsKey("X-Gaffer-Media-Type"));
    assertTrue(actualProperties.getCookies().isEmpty());
    Set<String> allowedMethods = actualProperties.getAllowedMethods();
    assertTrue(allowedMethods.isEmpty());
    assertEquals(PropertiesServiceV2.CORE_EXPOSED_PROPERTIES, actualProperties.getEntity());
    assertSame(allowedMethods, actualProperties.getLinks());
    assertSame(headers, actualProperties.getMetadata());
  }

  /**
   * Test {@link PropertiesServiceV2#getProperty(String)}.
   *
   * <p>Method under test: {@link PropertiesServiceV2#getProperty(String)}
   */
  @Test
  @DisplayName("Test getProperty(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response PropertiesServiceV2.getProperty(String)"})
  void testGetProperty() {
    // Arrange and Act
    Response actualProperty = new PropertiesServiceV2().getProperty("Property Name");

    // Assert
    StatusType statusInfo = actualProperty.getStatusInfo();
    assertTrue(statusInfo instanceof Status);
    assertTrue(actualProperty instanceof OutboundJaxrsResponse);
    assertTrue(actualProperty.getEntity() instanceof Error);
    assertNull(actualProperty.getLocation());
    assertNull(actualProperty.getDate());
    assertNull(actualProperty.getLastModified());
    assertNull(actualProperty.getLanguage());
    assertNull(actualProperty.getEntityTag());
    assertEquals(-1, actualProperty.getLength());
    MultivaluedMap<String, Object> headers = actualProperty.getHeaders();
    assertEquals(2, headers.size());
    MultivaluedMap<String, String> stringHeaders = actualProperty.getStringHeaders();
    assertEquals(2, stringHeaders.size());
    assertEquals(404, actualProperty.getStatus());
    assertEquals(Status.NOT_FOUND, statusInfo);
    assertTrue(headers.containsKey("Content-Type"));
    assertTrue(headers.containsKey("X-Gaffer-Media-Type"));
    assertTrue(stringHeaders.containsKey("Content-Type"));
    assertTrue(stringHeaders.containsKey("X-Gaffer-Media-Type"));
    assertTrue(actualProperty.getCookies().isEmpty());
    Set<String> allowedMethods = actualProperty.getAllowedMethods();
    assertTrue(allowedMethods.isEmpty());
    assertSame(allowedMethods, actualProperty.getLinks());
    assertSame(headers, actualProperty.getMetadata());
  }
}
