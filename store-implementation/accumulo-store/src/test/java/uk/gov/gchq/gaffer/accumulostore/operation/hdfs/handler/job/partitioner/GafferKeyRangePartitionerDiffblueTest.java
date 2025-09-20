package uk.gov.gchq.gaffer.accumulostore.operation.hdfs.handler.job.partitioner;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.hadoop.conf.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GafferKeyRangePartitionerDiffblueTest {
  /**
   * Test {@link GafferKeyRangePartitioner#getConf()}.
   *
   * <p>Method under test: {@link GafferKeyRangePartitioner#getConf()}
   */
  @Test
  @DisplayName("Test getConf()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Configuration GafferKeyRangePartitioner.getConf()"})
  void testGetConf() {
    // Arrange, Act and Assert
    assertNull(new GafferKeyRangePartitioner().getConf());
  }

  /**
   * Test {@link GafferKeyRangePartitioner#setConf(Configuration)}.
   *
   * <p>Method under test: {@link GafferKeyRangePartitioner#setConf(Configuration)}
   */
  @Test
  @DisplayName("Test setConf(Configuration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferKeyRangePartitioner.setConf(Configuration)"})
  void testSetConf() {
    // Arrange
    GafferKeyRangePartitioner gafferKeyRangePartitioner = new GafferKeyRangePartitioner();
    Configuration conf = new Configuration();

    // Act
    gafferKeyRangePartitioner.setConf(conf);

    // Assert
    assertSame(conf, gafferKeyRangePartitioner.getConf());
  }

  /**
   * Test new {@link GafferKeyRangePartitioner} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link GafferKeyRangePartitioner}
   */
  @Test
  @DisplayName("Test new GafferKeyRangePartitioner (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferKeyRangePartitioner.<init>()"})
  void testNewGafferKeyRangePartitioner() {
    // Arrange, Act and Assert
    assertNull(new GafferKeyRangePartitioner().getConf());
  }
}
