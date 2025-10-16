package uk.gov.gchq.gaffer.hdfs.operation.mapper.generator;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TextMapperGeneratorDiffblueTest {
  /**
   * Test {@link TextMapperGenerator#TextMapperGenerator()}.
   *
   * <p>Method under test: {@link TextMapperGenerator#TextMapperGenerator()}
   */
  @Test
  @DisplayName("Test new TextMapperGenerator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextMapperGenerator.<init>()"})
  void testNewTextMapperGenerator() {
    // Arrange, Act and Assert
    assertNull(new TextMapperGenerator().getElementGenerator());
  }
}
