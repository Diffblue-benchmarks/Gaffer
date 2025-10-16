package uk.gov.gchq.gaffer.hdfs.operation.mapper.generator;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.generator.JsonToElementGenerator;

class JsonMapperGeneratorDiffblueTest {
  /**
   * Test new {@link JsonMapperGenerator} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link JsonMapperGenerator}
   */
  @Test
  @DisplayName("Test new JsonMapperGenerator (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonMapperGenerator.<init>()"})
  void testNewJsonMapperGenerator() {
    // Arrange, Act and Assert
    assertTrue(new JsonMapperGenerator().getElementGenerator() instanceof JsonToElementGenerator);
  }
}
