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

class ApplicationConfigV1DiffblueTest {
  /**
   * Test new {@link ApplicationConfigV1} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ApplicationConfigV1}
   */
  @Test
  @DisplayName("Test new ApplicationConfigV1 (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewApplicationConfigV1() {
    // Arrange and Act
    ApplicationConfigV1 actualApplicationConfigV1 = new ApplicationConfigV1();

    // Assert
    assertNull(actualApplicationConfigV1.getApplicationName());
    Set<Object> instances = actualApplicationConfigV1.getInstances();
    assertEquals(1, instances.size());
    assertEquals(15, actualApplicationConfigV1.resources.size());
    assertEquals(RuntimeType.SERVER, actualApplicationConfigV1.getRuntimeType());
    assertTrue(actualApplicationConfigV1.getPropertyNames().isEmpty());
    assertTrue(actualApplicationConfigV1.getProperties().isEmpty());
    assertTrue(actualApplicationConfigV1.getResources().isEmpty());
    Set<Class<?>> expectedClasses = actualApplicationConfigV1.resources;
    assertEquals(expectedClasses, actualApplicationConfigV1.getClasses());
    Application actualApplication = actualApplicationConfigV1.getApplication();
    assertSame(actualApplicationConfigV1, actualApplication);
    assertSame(instances, actualApplicationConfigV1.getSingletons());
  }
}
