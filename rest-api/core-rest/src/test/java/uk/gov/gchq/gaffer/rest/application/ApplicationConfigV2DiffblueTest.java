package uk.gov.gchq.gaffer.rest.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;
import javax.ws.rs.RuntimeType;
import javax.ws.rs.core.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ApplicationConfigV2DiffblueTest {
  /**
   * Test new {@link ApplicationConfigV2} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ApplicationConfigV2}
   */
  @Test
  @DisplayName("Test new ApplicationConfigV2 (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewApplicationConfigV2() {
    // Arrange and Act
    ApplicationConfigV2 actualApplicationConfigV2 = new ApplicationConfigV2();

    // Assert
    assertNull(actualApplicationConfigV2.getApplicationName());
    assertEquals(17, actualApplicationConfigV2.resources.size());
    Set<Object> instances = actualApplicationConfigV2.getInstances();
    assertEquals(2, instances.size());
    assertEquals(RuntimeType.SERVER, actualApplicationConfigV2.getRuntimeType());
    assertTrue(actualApplicationConfigV2.getPropertyNames().isEmpty());
    assertTrue(actualApplicationConfigV2.getProperties().isEmpty());
    assertTrue(actualApplicationConfigV2.getResources().isEmpty());
    Set<Class<?>> expectedClasses = actualApplicationConfigV2.resources;
    assertEquals(expectedClasses, actualApplicationConfigV2.getClasses());
    Application actualApplication = actualApplicationConfigV2.getApplication();
    assertSame(actualApplicationConfigV2, actualApplication);
    assertSame(instances, actualApplicationConfigV2.getSingletons());
  }
}
