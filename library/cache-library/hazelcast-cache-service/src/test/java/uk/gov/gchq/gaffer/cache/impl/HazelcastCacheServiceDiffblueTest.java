package uk.gov.gchq.gaffer.cache.impl;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Properties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HazelcastCacheServiceDiffblueTest {
  /**
   * Test {@link HazelcastCacheService#initialise(Properties)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link Properties#Properties()} {@code 42} is {@code 42}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link HazelcastCacheService#initialise(Properties)}
   */
  @Test
  @DisplayName(
      "Test initialise(Properties); given '42'; when Properties() '42' is '42'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testInitialise_given42_whenProperties42Is42_thenThrowIllegalArgumentException() {
    // Arrange
    HazelcastCacheService hazelcastCacheService = new HazelcastCacheService();

    Properties properties = new Properties();
    properties.put("42", "42");
    properties.put("gaffer.cache.config.file", "42");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> hazelcastCacheService.initialise(properties));
  }

  /**
   * Test {@link HazelcastCacheService#initialise(Properties)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link Properties#Properties()} {@code gaffer.cache.config.file} is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link HazelcastCacheService#initialise(Properties)}
   */
  @Test
  @DisplayName(
      "Test initialise(Properties); given 'foo'; when Properties() 'gaffer.cache.config.file' is 'foo'")
  @Tag("MaintainedByDiffblue")
  void testInitialise_givenFoo_whenPropertiesGafferCacheConfigFileIsFoo() {
    // Arrange
    HazelcastCacheService hazelcastCacheService = new HazelcastCacheService();

    Properties properties = new Properties();
    properties.put("gaffer.cache.config.file", "foo");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> hazelcastCacheService.initialise(properties));
  }

  /**
   * Test {@link HazelcastCacheService#initialise(Properties)}.
   *
   * <ul>
   *   <li>When {@link Properties#Properties()} {@code gaffer.cache.config.file} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link HazelcastCacheService#initialise(Properties)}
   */
  @Test
  @DisplayName("Test initialise(Properties); when Properties() 'gaffer.cache.config.file' is '42'")
  @Tag("MaintainedByDiffblue")
  void testInitialise_whenPropertiesGafferCacheConfigFileIs42() {
    // Arrange
    HazelcastCacheService hazelcastCacheService = new HazelcastCacheService();

    Properties properties = new Properties();
    properties.put("gaffer.cache.config.file", "42");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> hazelcastCacheService.initialise(properties));
  }

  /**
   * Test {@link HazelcastCacheService#getCache(String)}.
   *
   * <p>Method under test: {@link HazelcastCacheService#getCache(String)}
   */
  @Test
  @DisplayName("Test getCache(String)")
  @Tag("MaintainedByDiffblue")
  void testGetCache() {
    // Arrange, Act and Assert
    assertNull(new HazelcastCacheService().getCache("Cache Name"));
  }
}
