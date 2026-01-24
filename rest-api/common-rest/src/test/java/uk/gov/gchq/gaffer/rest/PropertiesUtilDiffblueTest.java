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

package uk.gov.gchq.gaffer.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PropertiesUtilDiffblueTest {
  /**
   * Test {@link PropertiesUtil#getProperties()}.
   *
   * <p>Method under test: {@link PropertiesUtil#getProperties()}
   */
  @Test
  @DisplayName("Test getProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PropertiesUtil.getProperties()"})
  void testGetProperties() {
    // Arrange and Act
    Map<String, String> actualProperties = PropertiesUtil.getProperties();

    // Assert
    assertEquals(11, actualProperties.size());
    assertEquals("", actualProperties.get(SystemProperty.APP_BANNER_COLOUR));
    assertEquals("", actualProperties.get(SystemProperty.APP_BANNER_DESCRIPTION));
    assertEquals(
        SystemProperty.APP_DESCRIPTION_DEFAULT,
        actualProperties.get(SystemProperty.APP_DESCRIPTION));
    assertEquals(
        SystemProperty.APP_DOCUMENTATION_URL_DEFAULT,
        actualProperties.get(SystemProperty.APP_DOCUMENTATION_URL));
    assertEquals(SystemProperty.APP_TITLE_DEFAULT, actualProperties.get(SystemProperty.APP_TITLE));
    assertEquals(
        SystemProperty.GAFFER_VERSION_DEFAULT, actualProperties.get(SystemProperty.GAFFER_VERSION));
    assertEquals(
        SystemProperty.KORYPHE_VERSION_DEFAULT,
        actualProperties.get(SystemProperty.KORYPHE_VERSION));
    assertEquals(
        SystemProperty.LOGO_IMAGE_URL_DEFAULT,
        actualProperties.get(SystemProperty.FAVICON_LARGE_URL));
    assertEquals(
        SystemProperty.LOGO_IMAGE_URL_DEFAULT,
        actualProperties.get(SystemProperty.FAVICON_SMALL_URL));
    assertEquals(
        SystemProperty.LOGO_IMAGE_URL_DEFAULT, actualProperties.get(SystemProperty.LOGO_IMAGE_URL));
    assertEquals(SystemProperty.LOGO_LINK_DEFAULT, actualProperties.get(SystemProperty.LOGO_LINK));
  }

  /**
   * Test {@link PropertiesUtil#getProperty(String)}.
   *
   * <p>Method under test: {@link PropertiesUtil#getProperty(String)}
   */
  @Test
  @DisplayName("Test getProperty(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PropertiesUtil.getProperty(String)"})
  void testGetProperty() {
    // Arrange, Act and Assert
    assertNull(PropertiesUtil.getProperty("Property Name"));
  }
}
