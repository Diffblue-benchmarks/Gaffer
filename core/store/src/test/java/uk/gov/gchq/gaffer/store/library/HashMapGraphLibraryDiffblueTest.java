package uk.gov.gchq.gaffer.store.library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.exception.OverwritingException;
import uk.gov.gchq.gaffer.commonutil.pair.Pair;

class HashMapGraphLibraryDiffblueTest {
  /**
   * Test {@link HashMapGraphLibrary#_addIds(String, Pair)}.
   *
   * <p>Method under test: {@link HashMapGraphLibrary#_addIds(String, Pair)}
   */
  @Test
  @DisplayName("Test _addIds(String, Pair)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HashMapGraphLibrary._addIds(String, Pair)"})
  void test_addIds() throws OverwritingException {
    // Arrange
    HashMapGraphLibrary hashMapGraphLibrary = new HashMapGraphLibrary();
    Pair<String, String> schemaAndPropsIds = new Pair<>();

    // Act
    hashMapGraphLibrary._addIds("42", schemaAndPropsIds);

    // Assert
    assertEquals(schemaAndPropsIds, hashMapGraphLibrary.get("42"));
  }

  /**
   * Test {@link HashMapGraphLibrary#_addSchema(String, byte[])}.
   *
   * <p>Method under test: {@link HashMapGraphLibrary#_addSchema(String, byte[])}
   */
  @Test
  @DisplayName("Test _addSchema(String, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HashMapGraphLibrary._addSchema(String, byte[])"})
  void test_addSchema() throws UnsupportedEncodingException, OverwritingException {
    // Arrange
    HashMapGraphLibrary hashMapGraphLibrary = new HashMapGraphLibrary();
    byte[] schema = "AXAXAXAX".getBytes("UTF-8");

    // Act
    hashMapGraphLibrary._addSchema("42", schema);

    // Assert
    assertSame(schema, hashMapGraphLibrary._getSchema("42"));
  }
}
