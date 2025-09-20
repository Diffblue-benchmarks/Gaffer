package uk.gov.gchq.gaffer.rest.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ExampleDomainObjectDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExampleDomainObject#ExampleDomainObject()}
   *   <li>{@link ExampleDomainObject#setIds(Object[])}
   *   <li>{@link ExampleDomainObject#setType(String)}
   *   <li>{@link ExampleDomainObject#getIds()}
   *   <li>{@link ExampleDomainObject#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    ExampleDomainObject actualExampleDomainObject = new ExampleDomainObject();
    Object[] ids = new Object[] {"Ids"};
    actualExampleDomainObject.setIds(ids);
    actualExampleDomainObject.setType("Type");
    Object[] actualIds = actualExampleDomainObject.getIds();

    // Assert
    assertEquals("Ids", actualIds[0]);
    assertEquals("Type", actualExampleDomainObject.getType());
    assertEquals(1, actualIds.length);
    assertSame(ids, actualIds);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Type}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExampleDomainObject#ExampleDomainObject(String, Object[])}
   *   <li>{@link ExampleDomainObject#setIds(Object[])}
   *   <li>{@link ExampleDomainObject#setType(String)}
   *   <li>{@link ExampleDomainObject#getIds()}
   *   <li>{@link ExampleDomainObject#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Type'")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters_whenType() {
    // Arrange and Act
    ExampleDomainObject actualExampleDomainObject = new ExampleDomainObject("Type", "Ids");
    Object[] ids = new Object[] {"Ids"};
    actualExampleDomainObject.setIds(ids);
    actualExampleDomainObject.setType("Type");
    Object[] actualIds = actualExampleDomainObject.getIds();

    // Assert
    assertEquals("Ids", actualIds[0]);
    assertEquals("Type", actualExampleDomainObject.getType());
    assertEquals(1, actualIds.length);
    assertSame(ids, actualIds);
  }
}
