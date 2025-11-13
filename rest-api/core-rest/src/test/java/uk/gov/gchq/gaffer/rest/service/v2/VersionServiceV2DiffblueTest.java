/*
 * Copyright 2025 Crown Copyright
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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;
import org.glassfish.jersey.message.internal.AcceptableMediaType;
import org.glassfish.jersey.message.internal.CommittingOutputStream;
import org.glassfish.jersey.message.internal.OutboundJaxrsResponse;
import org.glassfish.jersey.message.internal.OutboundMessageContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VersionServiceV2DiffblueTest {
  /**
   * Test {@link VersionServiceV2#getGafferVersion()}.
   * <p>
   * Method under test: {@link VersionServiceV2#getGafferVersion()}
   */
  @Test
  @DisplayName("Test getGafferVersion()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Response VersionServiceV2.getGafferVersion()"})
  void testGetGafferVersion() {
    // Arrange and Act
    Response actualGafferVersion = (new VersionServiceV2()).getGafferVersion();

    // Assert
    StatusType statusInfo = actualGafferVersion.getStatusInfo();
    assertTrue(statusInfo instanceof Status);
    assertTrue(actualGafferVersion instanceof OutboundJaxrsResponse);
    assertEquals("2.3.3-SNAPSHOT", actualGafferVersion.getEntity());
    assertNull(actualGafferVersion.getLocation());
    assertNull(actualGafferVersion.getDate());
    assertNull(actualGafferVersion.getLastModified());
    assertNull(actualGafferVersion.getLanguage());
    assertNull(actualGafferVersion.getEntityTag());
    assertNull(actualGafferVersion.getMediaType());
    assertEquals(-1, actualGafferVersion.getLength());
    MultivaluedMap<String, Object> headers = actualGafferVersion.getHeaders();
    assertEquals(1, headers.size());
    MultivaluedMap<String, String> stringHeaders = actualGafferVersion.getStringHeaders();
    assertEquals(1, stringHeaders.size());
    assertEquals(200, actualGafferVersion.getStatus());
    assertEquals(Status.OK, statusInfo);
    assertTrue(headers.containsKey("X-Gaffer-Media-Type"));
    assertTrue(stringHeaders.containsKey("X-Gaffer-Media-Type"));
    assertTrue(actualGafferVersion.getCookies().isEmpty());
    Set<String> allowedMethods = actualGafferVersion.getAllowedMethods();
    assertTrue(allowedMethods.isEmpty());
    assertSame(allowedMethods, actualGafferVersion.getLinks());
    assertSame(headers, actualGafferVersion.getMetadata());
  }

  /**
   * Test new {@link VersionServiceV2} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link VersionServiceV2}
   */
  @Test
  @DisplayName("Test new VersionServiceV2 (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void VersionServiceV2.<init>()"})
  void testNewVersionServiceV2() throws MissingResourceException {
    // Arrange, Act and Assert
    Response gafferVersion = (new VersionServiceV2()).getGafferVersion();
    StatusType statusInfo = gafferVersion.getStatusInfo();
    assertTrue(statusInfo instanceof Status);
    OutboundMessageContext context = ((OutboundJaxrsResponse) gafferVersion).getContext();
    List<MediaType> acceptableMediaTypes = context.getAcceptableMediaTypes();
    assertEquals(1, acceptableMediaTypes.size());
    MediaType getResult = acceptableMediaTypes.get(0);
    assertTrue(getResult instanceof AcceptableMediaType);
    OutputStream entityStream = context.getEntityStream();
    assertTrue(entityStream instanceof CommittingOutputStream);
    assertTrue(gafferVersion instanceof OutboundJaxrsResponse);
    List<Locale> acceptableLanguages = context.getAcceptableLanguages();
    assertEquals(1, acceptableLanguages.size());
    Locale getResult2 = acceptableLanguages.get(0);
    assertEquals("", getResult2.getCountry());
    assertEquals("", getResult2.getDisplayCountry());
    assertEquals("", getResult2.getDisplayScript());
    assertEquals("", getResult2.getDisplayVariant());
    assertEquals("", getResult2.getISO3Country());
    assertEquals("", getResult2.getScript());
    assertEquals("", getResult2.getVariant());
    assertEquals("*", getResult2.getDisplayLanguage());
    assertEquals("*", getResult2.getDisplayName());
    assertEquals("*", getResult2.getLanguage());
    assertEquals("*", getResult.getSubtype());
    assertEquals("*", getResult.getType());
    assertEquals("2.3.3-SNAPSHOT", gafferVersion.getEntity());
    assertEquals("2.3.3-SNAPSHOT", context.getEntity());
    MultivaluedMap<String, String> stringHeaders = gafferVersion.getStringHeaders();
    assertEquals(1, stringHeaders.size());
    List<String> getResult3 = stringHeaders.get("X-Gaffer-Media-Type");
    assertEquals(1, getResult3.size());
    assertEquals("gaffer.v2; format=json", getResult3.get(0));
    MultivaluedMap<String, String> stringHeaders2 = context.getStringHeaders();
    assertEquals(1, stringHeaders2.size());
    List<String> getResult4 = stringHeaders2.get("X-Gaffer-Media-Type");
    assertEquals(1, getResult4.size());
    assertEquals("gaffer.v2; format=json", getResult4.get(0));
    MultivaluedMap<String, Object> headers = gafferVersion.getHeaders();
    assertEquals(1, headers.size());
    List<Object> getResult5 = headers.get("X-Gaffer-Media-Type");
    assertEquals(1, getResult5.size());
    assertEquals("gaffer.v2; format=json", getResult5.get(0));
    assertNull(gafferVersion.getLocation());
    assertNull(context.getLocation());
    assertNull(gafferVersion.getDate());
    assertNull(gafferVersion.getLastModified());
    assertNull(context.getDate());
    assertNull(context.getLastModified());
    assertNull(gafferVersion.getLanguage());
    assertNull(context.getLanguage());
    assertNull(context.getConfiguration());
    assertNull(gafferVersion.getEntityTag());
    assertNull(context.getEntityTag());
    assertNull(gafferVersion.getMediaType());
    assertNull(context.getMediaType());
    assertEquals(-1, gafferVersion.getLength());
    assertEquals(-1, context.getLength());
    assertEquals(-1L, context.getLengthLong());
    assertEquals(0, context.getEntityAnnotations().length);
    assertEquals(1000, ((AcceptableMediaType) getResult).getQuality());
    assertEquals(200, gafferVersion.getStatus());
    assertEquals(Status.OK, statusInfo);
    assertFalse(getResult2.hasExtensions());
    assertFalse(((CommittingOutputStream) entityStream).isClosed());
    assertFalse(((CommittingOutputStream) entityStream).isCommitted());
    assertFalse(context.isCommitted());
    assertTrue(getResult.getParameters().isEmpty());
    Map<String, NewCookie> cookies = gafferVersion.getCookies();
    assertTrue(cookies.isEmpty());
    Set<String> allowedMethods = gafferVersion.getAllowedMethods();
    assertTrue(allowedMethods.isEmpty());
    assertTrue(getResult.isWildcardSubtype());
    assertTrue(getResult.isWildcardType());
    assertTrue(context.hasEntity());
    Class<String> expectedEntityClass = String.class;
    Class<?> entityClass = context.getEntityClass();
    assertEquals(expectedEntityClass, entityClass);
    assertSame(allowedMethods, getResult2.getExtensionKeys());
    assertSame(allowedMethods, getResult2.getUnicodeLocaleAttributes());
    assertSame(allowedMethods, getResult2.getUnicodeLocaleKeys());
    assertSame(allowedMethods, gafferVersion.getLinks());
    assertSame(allowedMethods, context.getAllowedMethods());
    assertSame(allowedMethods, context.getLinks());
    assertSame(cookies, context.getRequestCookies());
    assertSame(cookies, context.getResponseCookies());
    assertSame(entityClass, context.getEntityType());
    assertSame(headers, gafferVersion.getMetadata());
    assertSame(headers, context.getHeaders());
  }
}
