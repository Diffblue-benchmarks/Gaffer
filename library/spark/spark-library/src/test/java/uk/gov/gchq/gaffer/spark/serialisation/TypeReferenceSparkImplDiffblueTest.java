package uk.gov.gchq.gaffer.spark.serialisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.spark.serialisation.TypeReferenceSparkImpl.DataSetRow;
import uk.gov.gchq.gaffer.spark.serialisation.TypeReferenceSparkImpl.IterableRowT;
import uk.gov.gchq.gaffer.spark.serialisation.TypeReferenceSparkImpl.JavaRDDElement;
import uk.gov.gchq.gaffer.spark.serialisation.TypeReferenceSparkImpl.RDDElement;

class TypeReferenceSparkImplDiffblueTest {
  /**
   * Test DataSetRow new {@link DataSetRow} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link DataSetRow}
   */
  @Test
  @DisplayName("Test DataSetRow new DataSetRow (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataSetRow.<init>()"})
  void testDataSetRowNewDataSetRow() {
    // Arrange, Act and Assert
    assertEquals(
        "org.apache.spark.sql.Dataset<org.apache.spark.sql.Row>",
        new DataSetRow().getType().getTypeName());
  }

  /**
   * Test IterableRowT new {@link IterableRowT} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link IterableRowT}
   */
  @Test
  @DisplayName("Test IterableRowT new IterableRowT (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IterableRowT.<init>()"})
  void testIterableRowTNewIterableRowT() {
    // Arrange, Act and Assert
    assertEquals(
        "java.lang.Iterable<? extends org.apache.spark.sql.Row>",
        new IterableRowT().getType().getTypeName());
  }

  /**
   * Test JavaRDDElement new {@link JavaRDDElement} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link JavaRDDElement}
   */
  @Test
  @DisplayName("Test JavaRDDElement new JavaRDDElement (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JavaRDDElement.<init>()"})
  void testJavaRDDElementNewJavaRDDElement() {
    // Arrange, Act and Assert
    assertEquals(
        "org.apache.spark.api.java.JavaRDD<uk.gov.gchq.gaffer.data.element.Element>",
        new JavaRDDElement().getType().getTypeName());
  }

  /**
   * Test RDDElement new {@link RDDElement} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link RDDElement}
   */
  @Test
  @DisplayName("Test RDDElement new RDDElement (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RDDElement.<init>()"})
  void testRDDElementNewRDDElement() {
    // Arrange, Act and Assert
    assertEquals(
        "org.apache.spark.rdd.RDD<uk.gov.gchq.gaffer.data.element.Element>",
        new RDDElement().getType().getTypeName());
  }
}
