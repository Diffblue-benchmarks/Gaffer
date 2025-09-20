package uk.gov.gchq.gaffer.data.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.LinkedHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NeptuneCsvGeneratorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NeptuneCsvGenerator#getFields()}
   *   <li>{@link NeptuneCsvGenerator#getIncludeDefaultFields()}
   *   <li>{@link NeptuneCsvGenerator#getIncludeSchemaProperties()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange
    NeptuneCsvGenerator neptuneCsvGenerator = new NeptuneCsvGenerator();

    // Act
    LinkedHashMap<String, String> actualFields = neptuneCsvGenerator.getFields();
    boolean actualIncludeDefaultFields = neptuneCsvGenerator.getIncludeDefaultFields();

    // Assert
    assertEquals(5, actualFields.size());
    assertEquals(":END_ID", actualFields.get("DESTINATION"));
    assertEquals(":ID", actualFields.get("VERTEX"));
    assertEquals(":LABEL", actualFields.get("ENTITY_GROUP"));
    assertEquals(":START_ID", actualFields.get("SOURCE"));
    assertEquals(":TYPE", actualFields.get("EDGE_GROUP"));
    assertTrue(actualIncludeDefaultFields);
    assertTrue(neptuneCsvGenerator.getIncludeSchemaProperties());
  }

  /**
   * Test {@link NeptuneCsvGenerator#getDefaultFields()}.
   *
   * <p>Method under test: {@link NeptuneCsvGenerator#getDefaultFields()}
   */
  @Test
  @DisplayName("Test getDefaultFields()")
  @Tag("MaintainedByDiffblue")
  void testGetDefaultFields() {
    // Arrange and Act
    LinkedHashMap<String, String> actualDefaultFields =
        new NeptuneCsvGenerator().getDefaultFields();

    // Assert
    assertEquals(5, actualDefaultFields.size());
    assertEquals(":END_ID", actualDefaultFields.get("DESTINATION"));
    assertEquals(":ID", actualDefaultFields.get("VERTEX"));
    assertEquals(":LABEL", actualDefaultFields.get("ENTITY_GROUP"));
    assertEquals(":START_ID", actualDefaultFields.get("SOURCE"));
    assertEquals(":TYPE", actualDefaultFields.get("EDGE_GROUP"));
  }

  /**
   * Test new {@link NeptuneCsvGenerator} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link NeptuneCsvGenerator}
   */
  @Test
  @DisplayName("Test new NeptuneCsvGenerator (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewNeptuneCsvGenerator() {
    // Arrange and Act
    NeptuneCsvGenerator actualNeptuneCsvGenerator = new NeptuneCsvGenerator();

    // Assert
    assertEquals(" ", actualNeptuneCsvGenerator.getCommaReplacement());
    LinkedHashMap<String, String> defaultFields = actualNeptuneCsvGenerator.getDefaultFields();
    assertEquals(5, defaultFields.size());
    assertEquals(":END_ID", defaultFields.get("DESTINATION"));
    assertEquals(":ID", defaultFields.get("VERTEX"));
    assertEquals(":ID,:LABEL,:TYPE,:START_ID,:END_ID", actualNeptuneCsvGenerator.getHeader());
    assertEquals(":LABEL", defaultFields.get("ENTITY_GROUP"));
    assertEquals(":START_ID", defaultFields.get("SOURCE"));
    assertEquals(":TYPE", defaultFields.get("EDGE_GROUP"));
    assertFalse(actualNeptuneCsvGenerator.isQuoted());
    assertTrue(actualNeptuneCsvGenerator.getConstants().isEmpty());
    assertTrue(actualNeptuneCsvGenerator.getIncludeDefaultFields());
    assertTrue(actualNeptuneCsvGenerator.getIncludeSchemaProperties());
    assertEquals(defaultFields, actualNeptuneCsvGenerator.getFields());
  }
}
