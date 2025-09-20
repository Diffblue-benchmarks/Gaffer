package uk.gov.gchq.gaffer.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  void testGetProperty() {
    // Arrange, Act and Assert
    assertNull(PropertiesUtil.getProperty("Property Name"));
  }
}
