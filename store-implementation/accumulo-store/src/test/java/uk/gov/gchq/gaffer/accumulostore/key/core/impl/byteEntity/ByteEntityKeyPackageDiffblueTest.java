package uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.CoreKeyBloomFunctor;
import uk.gov.gchq.gaffer.store.schema.Schema;

class ByteEntityKeyPackageDiffblueTest {
  /**
   * Test {@link ByteEntityKeyPackage#ByteEntityKeyPackage()}.
   *
   * <p>Method under test: {@link ByteEntityKeyPackage#ByteEntityKeyPackage()}
   */
  @Test
  @DisplayName("Test new ByteEntityKeyPackage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ByteEntityKeyPackage.<init>()"})
  void testNewByteEntityKeyPackage() {
    // Arrange and Act
    ByteEntityKeyPackage actualByteEntityKeyPackage = new ByteEntityKeyPackage();

    // Assert
    assertTrue(actualByteEntityKeyPackage.getKeyFunctor() instanceof CoreKeyBloomFunctor);
    assertTrue(
        actualByteEntityKeyPackage.getIteratorFactory()
            instanceof ByteEntityIteratorSettingsFactory);
    assertNull(actualByteEntityKeyPackage.getKeyConverter());
    assertNull(actualByteEntityKeyPackage.getRangeFactory());
  }

  /**
   * Test {@link ByteEntityKeyPackage#ByteEntityKeyPackage(Schema)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityKeyPackage#ByteEntityKeyPackage(Schema)}
   */
  @Test
  @DisplayName("Test new ByteEntityKeyPackage(Schema); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ByteEntityKeyPackage.<init>(Schema)"})
  void testNewByteEntityKeyPackage_whenNull() {
    // Arrange and Act
    ByteEntityKeyPackage actualByteEntityKeyPackage = new ByteEntityKeyPackage(null);

    // Assert
    assertTrue(actualByteEntityKeyPackage.getKeyFunctor() instanceof CoreKeyBloomFunctor);
    assertTrue(
        actualByteEntityKeyPackage.getKeyConverter() instanceof ByteEntityAccumuloElementConverter);
    assertTrue(
        actualByteEntityKeyPackage.getIteratorFactory()
            instanceof ByteEntityIteratorSettingsFactory);
    assertTrue(actualByteEntityKeyPackage.getRangeFactory() instanceof ByteEntityRangeFactory);
  }

  /**
   * Test {@link ByteEntityKeyPackage#ByteEntityKeyPackage(Schema)}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityKeyPackage#ByteEntityKeyPackage(Schema)}
   */
  @Test
  @DisplayName("Test new ByteEntityKeyPackage(Schema); when Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ByteEntityKeyPackage.<init>(Schema)"})
  void testNewByteEntityKeyPackage_whenSchema() {
    // Arrange and Act
    ByteEntityKeyPackage actualByteEntityKeyPackage = new ByteEntityKeyPackage(new Schema());

    // Assert
    assertTrue(actualByteEntityKeyPackage.getKeyFunctor() instanceof CoreKeyBloomFunctor);
    assertTrue(
        actualByteEntityKeyPackage.getKeyConverter() instanceof ByteEntityAccumuloElementConverter);
    assertTrue(
        actualByteEntityKeyPackage.getIteratorFactory()
            instanceof ByteEntityIteratorSettingsFactory);
    assertTrue(actualByteEntityKeyPackage.getRangeFactory() instanceof ByteEntityRangeFactory);
  }

  /**
   * Test {@link ByteEntityKeyPackage#setSchema(Schema)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityKeyPackage#setSchema(Schema)}
   */
  @Test
  @DisplayName("Test setSchema(Schema); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ByteEntityKeyPackage.setSchema(Schema)"})
  void testSetSchema_whenNull() {
    // Arrange
    ByteEntityKeyPackage byteEntityKeyPackage = new ByteEntityKeyPackage();

    // Act
    byteEntityKeyPackage.setSchema(null);

    // Assert
    assertTrue(
        byteEntityKeyPackage.getKeyConverter() instanceof ByteEntityAccumuloElementConverter);
    assertTrue(byteEntityKeyPackage.getRangeFactory() instanceof ByteEntityRangeFactory);
  }

  /**
   * Test {@link ByteEntityKeyPackage#setSchema(Schema)}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link ByteEntityKeyPackage#setSchema(Schema)}
   */
  @Test
  @DisplayName("Test setSchema(Schema); when Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ByteEntityKeyPackage.setSchema(Schema)"})
  void testSetSchema_whenSchema() {
    // Arrange
    ByteEntityKeyPackage byteEntityKeyPackage = new ByteEntityKeyPackage();

    // Act
    byteEntityKeyPackage.setSchema(new Schema());

    // Assert
    assertTrue(
        byteEntityKeyPackage.getKeyConverter() instanceof ByteEntityAccumuloElementConverter);
    assertTrue(byteEntityKeyPackage.getRangeFactory() instanceof ByteEntityRangeFactory);
  }
}
