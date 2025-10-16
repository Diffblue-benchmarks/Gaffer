package uk.gov.gchq.gaffer.accumulostore.data.element;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityAccumuloElementConverter;
import uk.gov.gchq.gaffer.data.element.Properties;
import uk.gov.gchq.gaffer.store.schema.Schema;

class AccumuloElementValueLoaderDiffblueTest {
  /**
   * Test {@link AccumuloElementValueLoader#getProperty(String, Properties)}.
   *
   * <p>Method under test: {@link AccumuloElementValueLoader#getProperty(String, Properties)}
   */
  @Test
  @DisplayName("Test getProperty(String, Properties)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object AccumuloElementValueLoader.getProperty(String, Properties)"})
  void testGetProperty() {
    // Arrange
    Key key = new Key();
    Value value = new Value();
    ByteEntityAccumuloElementConverter elementConverter =
        new ByteEntityAccumuloElementConverter(new Schema());

    AccumuloEntityValueLoader accumuloEntityValueLoader =
        new AccumuloEntityValueLoader("Group", key, value, elementConverter, new Schema());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> accumuloEntityValueLoader.getProperty("Name", new Properties()));
  }
}
