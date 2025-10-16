package uk.gov.gchq.gaffer.sparkaccumulo.operation.rfilereaderrdd;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;
import org.apache.spark.SparkContext;
import org.apache.spark.SparkException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RFileReaderRDDDiffblueTest {
  /**
   * Test {@link RFileReaderRDD#RFileReaderRDD(SparkContext, String, String, String, String, String,
   * Set, byte[])}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link RFileReaderRDD#RFileReaderRDD(SparkContext, String, String,
   * String, String, String, Set, byte[])}
   */
  @Test
  @DisplayName(
      "Test new RFileReaderRDD(SparkContext, String, String, String, String, String, Set, byte[]); given '42'; when HashSet() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RFileReaderRDD.<init>(SparkContext, String, String, String, String, String, Set, byte[])"
  })
  void testNewRFileReaderRDD_given42_whenHashSetAdd42() throws UnsupportedEncodingException {
    // Arrange
    HashSet<String> auths = new HashSet<>();
    auths.add("42");
    auths.add("foo");

    // Act and Assert
    assertThrows(
        SparkException.class,
        () ->
            new RFileReaderRDD(
                null,
                "Instance Name",
                "Zookeepers",
                "User",
                "iloveyou",
                "Table Name",
                auths,
                "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link RFileReaderRDD#RFileReaderRDD(SparkContext, String, String, String, String, String,
   * Set, byte[])}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link RFileReaderRDD#RFileReaderRDD(SparkContext, String, String,
   * String, String, String, Set, byte[])}
   */
  @Test
  @DisplayName(
      "Test new RFileReaderRDD(SparkContext, String, String, String, String, String, Set, byte[]); given 'foo'; when HashSet() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RFileReaderRDD.<init>(SparkContext, String, String, String, String, String, Set, byte[])"
  })
  void testNewRFileReaderRDD_givenFoo_whenHashSetAddFoo() throws UnsupportedEncodingException {
    // Arrange
    HashSet<String> auths = new HashSet<>();
    auths.add("foo");

    // Act and Assert
    assertThrows(
        SparkException.class,
        () ->
            new RFileReaderRDD(
                null,
                "Instance Name",
                "Zookeepers",
                "User",
                "iloveyou",
                "Table Name",
                auths,
                "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link RFileReaderRDD#RFileReaderRDD(SparkContext, String, String, String, String, String,
   * Set, byte[])}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link RFileReaderRDD#RFileReaderRDD(SparkContext, String, String,
   * String, String, String, Set, byte[])}
   */
  @Test
  @DisplayName(
      "Test new RFileReaderRDD(SparkContext, String, String, String, String, String, Set, byte[]); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RFileReaderRDD.<init>(SparkContext, String, String, String, String, String, Set, byte[])"
  })
  void testNewRFileReaderRDD_whenHashSet() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        SparkException.class,
        () ->
            new RFileReaderRDD(
                null,
                "Instance Name",
                "Zookeepers",
                "User",
                "iloveyou",
                "Table Name",
                new HashSet<>(),
                "AXAXAXAX".getBytes("UTF-8")));
  }
}
