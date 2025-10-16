package uk.gov.gchq.gaffer.hdfs.operation.mapper.generator;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AvroMapperGeneratorDiffblueTest {
  /**
   * Test {@link AvroMapperGenerator#AvroMapperGenerator()}.
   *
   * <p>Method under test: {@link AvroMapperGenerator#AvroMapperGenerator()}
   */
  @Test
  @DisplayName("Test new AvroMapperGenerator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AvroMapperGenerator.<init>()"})
  void testNewAvroMapperGenerator() {
    // Arrange and Act
    AvroMapperGenerator<Object> actualAvroMapperGenerator = new AvroMapperGenerator<>();

    // Assert
    assertNull(actualAvroMapperGenerator.getElementGenerator());
  }
}
