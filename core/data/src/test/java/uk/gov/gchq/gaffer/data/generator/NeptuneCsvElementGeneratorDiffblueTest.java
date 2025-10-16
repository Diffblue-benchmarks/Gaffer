package uk.gov.gchq.gaffer.data.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.LinkedHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NeptuneCsvElementGeneratorDiffblueTest {
  /**
   * Test {@link NeptuneCsvElementGenerator#getFields()}.
   *
   * <p>Method under test: {@link NeptuneCsvElementGenerator#getFields()}
   */
  @Test
  @DisplayName("Test getFields()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LinkedHashMap NeptuneCsvElementGenerator.getFields()"})
  void testGetFields() {
    // Arrange
    NeptuneCsvElementGenerator neptuneCsvElementGenerator = new NeptuneCsvElementGenerator();

    // Act
    LinkedHashMap<String, String> actualFields = neptuneCsvElementGenerator.getFields();

    // Assert
    assertEquals(neptuneCsvElementGenerator.fields, actualFields);
  }

  /**
   * Test new {@link NeptuneCsvElementGenerator} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * NeptuneCsvElementGenerator}
   */
  @Test
  @DisplayName("Test new NeptuneCsvElementGenerator (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NeptuneCsvElementGenerator.<init>()"})
  void testNewNeptuneCsvElementGenerator() {
    // Arrange and Act
    NeptuneCsvElementGenerator actualNeptuneCsvElementGenerator = new NeptuneCsvElementGenerator();

    // Assert
    assertEquals("", actualNeptuneCsvElementGenerator.getNullString());
    LinkedHashMap<String, String> stringStringMap = actualNeptuneCsvElementGenerator.fields;
    assertEquals(5, stringStringMap.size());
    assertEquals(":END_ID", stringStringMap.get("DESTINATION"));
    assertEquals(":ID", stringStringMap.get("VERTEX"));
    assertEquals(":LABEL", stringStringMap.get("ENTITY_GROUP"));
    assertEquals(":START_ID", stringStringMap.get("SOURCE"));
    assertEquals(":TYPE", stringStringMap.get("EDGE_GROUP"));
    assertEquals(',', actualNeptuneCsvElementGenerator.getDelimiter());
    assertEquals(1, actualNeptuneCsvElementGenerator.getFirstRow());
    assertFalse(actualNeptuneCsvElementGenerator.getTrim());
    LinkedHashMap<String, String> expectedFields = actualNeptuneCsvElementGenerator.fields;
    assertEquals(expectedFields, actualNeptuneCsvElementGenerator.getFields());
  }
}
