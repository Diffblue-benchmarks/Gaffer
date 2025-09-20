package uk.gov.gchq.gaffer.sparkaccumulo.operation.rfilereaderrdd;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.Set;
import javassist.Loader;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.ConfigurationWithLogging;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.yarn.conf.YarnConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UtilsDiffblueTest {
  /**
   * Test {@link Utils#serialiseConfiguration(Configuration)}.
   *
   * <ul>
   *   <li>Given {@link Configuration#Configuration()}.
   * </ul>
   *
   * <p>Method under test: {@link Utils#serialiseConfiguration(Configuration)}
   */
  @Test
  @DisplayName("Test serialiseConfiguration(Configuration); given Configuration()")
  @Tag("MaintainedByDiffblue")
  void testSerialiseConfiguration_givenConfiguration() throws IOException {
    // Arrange
    Configuration configuration = new Configuration();
    configuration.addResource(new Configuration());
    configuration.addResource("Name");

    // Act
    byte[] actualSerialiseConfigurationResult = Utils.serialiseConfiguration(configuration);

    // Assert
    assertEquals((byte) -38, actualSerialiseConfigurationResult[140381]);
    assertEquals((byte) -47, actualSerialiseConfigurationResult[140366]);
    assertEquals((byte) -47, actualSerialiseConfigurationResult[140374]);
    assertEquals((byte) -51, actualSerialiseConfigurationResult[140372]);
    assertEquals((byte) -51, actualSerialiseConfigurationResult[140377]);
    assertEquals((byte) -56, actualSerialiseConfigurationResult[140376]);
    assertEquals((byte) -71, actualSerialiseConfigurationResult[140382]);
    assertEquals((byte) -85, actualSerialiseConfigurationResult[140375]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140379]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140385]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140386]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140387]);
    assertEquals(140388, actualSerialiseConfigurationResult.length);
    assertEquals((byte) 17, actualSerialiseConfigurationResult[140383]);
    assertEquals((byte) 18, actualSerialiseConfigurationResult[140384]);
    assertEquals((byte) 1, actualSerialiseConfigurationResult[140378]);
    assertEquals('(', actualSerialiseConfigurationResult[140363]);
    assertEquals(')', actualSerialiseConfigurationResult[140373]);
    assertEquals(',', actualSerialiseConfigurationResult[140371]);
    assertEquals('I', actualSerialiseConfigurationResult[140368]);
    assertEquals('J', actualSerialiseConfigurationResult[140364]);
    assertEquals('K', actualSerialiseConfigurationResult[140370]);
    assertEquals('M', actualSerialiseConfigurationResult[140365]);
    assertEquals('M', actualSerialiseConfigurationResult[140367]);
    assertEquals('M', actualSerialiseConfigurationResult[140369]);
    assertEquals('^', actualSerialiseConfigurationResult[140380]);
  }

  /**
   * Test {@link Utils#serialiseConfiguration(Configuration)}.
   *
   * <ul>
   *   <li>Given {@link Loader#Loader()}.
   *   <li>Then return {@code 82165} element is minus one.
   * </ul>
   *
   * <p>Method under test: {@link Utils#serialiseConfiguration(Configuration)}
   */
  @Test
  @DisplayName(
      "Test serialiseConfiguration(Configuration); given Loader(); then return '82165' element is minus one")
  @Tag("MaintainedByDiffblue")
  void testSerialiseConfiguration_givenLoader_thenReturn82165ElementIsMinusOne()
      throws IOException {
    // Arrange
    Configuration configuration = new Configuration();
    configuration.setClassLoader(new Loader());
    configuration.addResource(new Configuration());
    configuration.addResource("Name");

    // Act
    byte[] actualSerialiseConfigurationResult = Utils.serialiseConfiguration(configuration);

    // Assert
    assertEquals((byte) -1, actualSerialiseConfigurationResult[82164]);
    assertEquals((byte) -1, actualSerialiseConfigurationResult[82165]);
    assertEquals((byte) -1, actualSerialiseConfigurationResult[82166]);
    assertEquals((byte) -1, actualSerialiseConfigurationResult[82167]);
    assertEquals((byte) 4, actualSerialiseConfigurationResult[82159]);
    assertEquals(82168, actualSerialiseConfigurationResult.length);
    assertEquals('-', actualSerialiseConfigurationResult[82150]);
    assertEquals('.', actualSerialiseConfigurationResult[82144]);
    assertEquals('0', actualSerialiseConfigurationResult[82161]);
    assertEquals('0', actualSerialiseConfigurationResult[82162]);
    assertEquals('0', actualSerialiseConfigurationResult[82163]);
    assertEquals('2', actualSerialiseConfigurationResult[82160]);
    assertEquals('a', actualSerialiseConfigurationResult[82157]);
    assertEquals('b', actualSerialiseConfigurationResult[82143]);
    assertEquals('e', actualSerialiseConfigurationResult[82146]);
    assertEquals('e', actualSerialiseConfigurationResult[82154]);
    assertEquals('i', actualSerialiseConfigurationResult[82151]);
    assertEquals('l', actualSerialiseConfigurationResult[82158]);
    assertEquals('n', actualSerialiseConfigurationResult[82152]);
    assertEquals('r', actualSerialiseConfigurationResult[82145]);
    assertEquals('r', actualSerialiseConfigurationResult[82148]);
    assertEquals('r', actualSerialiseConfigurationResult[82155]);
    assertEquals('t', actualSerialiseConfigurationResult[82147]);
    assertEquals('t', actualSerialiseConfigurationResult[82153]);
    assertEquals('v', actualSerialiseConfigurationResult[82156]);
    assertEquals('y', actualSerialiseConfigurationResult[82149]);
  }

  /**
   * Test {@link Utils#serialiseConfiguration(Configuration)}.
   *
   * <ul>
   *   <li>Given {@link Loader#Loader()}.
   *   <li>Then return array of {@code byte} with zero.
   * </ul>
   *
   * <p>Method under test: {@link Utils#serialiseConfiguration(Configuration)}
   */
  @Test
  @DisplayName(
      "Test serialiseConfiguration(Configuration); given Loader(); then return array of byte with zero")
  @Tag("MaintainedByDiffblue")
  void testSerialiseConfiguration_givenLoader_thenReturnArrayOfByteWithZero() throws IOException {
    // Arrange
    Configuration configuration = new Configuration();
    configuration.setClassLoader(new Loader());
    configuration.addResource("Name");

    // Act and Assert
    assertArrayEquals(new byte[] {0}, Utils.serialiseConfiguration(configuration));
  }

  /**
   * Test {@link Utils#serialiseConfiguration(Configuration)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return {@code 140382} element is minus thirty-eight.
   * </ul>
   *
   * <p>Method under test: {@link Utils#serialiseConfiguration(Configuration)}
   */
  @Test
  @DisplayName(
      "Test serialiseConfiguration(Configuration); given 'Name'; then return '140382' element is minus thirty-eight")
  @Tag("MaintainedByDiffblue")
  void testSerialiseConfiguration_givenName_thenReturn140382ElementIsMinusThirtyEight()
      throws IOException {
    // Arrange
    Configuration configuration = new Configuration();
    configuration.addResource("Name");

    // Act
    byte[] actualSerialiseConfigurationResult = Utils.serialiseConfiguration(configuration);

    // Assert
    assertEquals((byte) -38, actualSerialiseConfigurationResult[140381]);
    assertEquals((byte) -47, actualSerialiseConfigurationResult[140366]);
    assertEquals((byte) -47, actualSerialiseConfigurationResult[140374]);
    assertEquals((byte) -51, actualSerialiseConfigurationResult[140372]);
    assertEquals((byte) -51, actualSerialiseConfigurationResult[140377]);
    assertEquals((byte) -56, actualSerialiseConfigurationResult[140376]);
    assertEquals((byte) -71, actualSerialiseConfigurationResult[140382]);
    assertEquals((byte) -85, actualSerialiseConfigurationResult[140375]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140379]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140385]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140386]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140387]);
    assertEquals(140388, actualSerialiseConfigurationResult.length);
    assertEquals((byte) 17, actualSerialiseConfigurationResult[140383]);
    assertEquals((byte) 18, actualSerialiseConfigurationResult[140384]);
    assertEquals((byte) 1, actualSerialiseConfigurationResult[140378]);
    assertEquals('(', actualSerialiseConfigurationResult[140363]);
    assertEquals(')', actualSerialiseConfigurationResult[140373]);
    assertEquals(',', actualSerialiseConfigurationResult[140371]);
    assertEquals('I', actualSerialiseConfigurationResult[140368]);
    assertEquals('J', actualSerialiseConfigurationResult[140364]);
    assertEquals('K', actualSerialiseConfigurationResult[140370]);
    assertEquals('M', actualSerialiseConfigurationResult[140365]);
    assertEquals('M', actualSerialiseConfigurationResult[140367]);
    assertEquals('M', actualSerialiseConfigurationResult[140369]);
    assertEquals('^', actualSerialiseConfigurationResult[140380]);
  }

  /**
   * Test {@link Utils#serialiseConfiguration(Configuration)}.
   *
   * <ul>
   *   <li>Given {@link Path#Path(String)} with {@code Path String}.
   * </ul>
   *
   * <p>Method under test: {@link Utils#serialiseConfiguration(Configuration)}
   */
  @Test
  @DisplayName("Test serialiseConfiguration(Configuration); given Path(String) with 'Path String'")
  @Tag("MaintainedByDiffblue")
  void testSerialiseConfiguration_givenPathWithPathString()
      throws IOException, IllegalArgumentException {
    // Arrange
    Configuration configuration = new Configuration();
    configuration.addResource(new Path("Path String"));
    configuration.addResource("Name");

    // Act
    byte[] actualSerialiseConfigurationResult = Utils.serialiseConfiguration(configuration);

    // Assert
    assertEquals((byte) -38, actualSerialiseConfigurationResult[140381]);
    assertEquals((byte) -47, actualSerialiseConfigurationResult[140366]);
    assertEquals((byte) -47, actualSerialiseConfigurationResult[140374]);
    assertEquals((byte) -51, actualSerialiseConfigurationResult[140372]);
    assertEquals((byte) -51, actualSerialiseConfigurationResult[140377]);
    assertEquals((byte) -56, actualSerialiseConfigurationResult[140376]);
    assertEquals((byte) -71, actualSerialiseConfigurationResult[140382]);
    assertEquals((byte) -85, actualSerialiseConfigurationResult[140375]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140379]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140385]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140386]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140387]);
    assertEquals(140388, actualSerialiseConfigurationResult.length);
    assertEquals((byte) 17, actualSerialiseConfigurationResult[140383]);
    assertEquals((byte) 18, actualSerialiseConfigurationResult[140384]);
    assertEquals((byte) 1, actualSerialiseConfigurationResult[140378]);
    assertEquals('(', actualSerialiseConfigurationResult[140363]);
    assertEquals(')', actualSerialiseConfigurationResult[140373]);
    assertEquals(',', actualSerialiseConfigurationResult[140371]);
    assertEquals('I', actualSerialiseConfigurationResult[140368]);
    assertEquals('J', actualSerialiseConfigurationResult[140364]);
    assertEquals('K', actualSerialiseConfigurationResult[140370]);
    assertEquals('M', actualSerialiseConfigurationResult[140365]);
    assertEquals('M', actualSerialiseConfigurationResult[140367]);
    assertEquals('M', actualSerialiseConfigurationResult[140369]);
    assertEquals('^', actualSerialiseConfigurationResult[140380]);
  }

  /**
   * Test {@link Utils#serialiseConfiguration(Configuration)}.
   *
   * <ul>
   *   <li>Then return third element is minus thirty-seven.
   * </ul>
   *
   * <p>Method under test: {@link Utils#serialiseConfiguration(Configuration)}
   */
  @Test
  @DisplayName(
      "Test serialiseConfiguration(Configuration); then return third element is minus thirty-seven")
  @Tag("MaintainedByDiffblue")
  void testSerialiseConfiguration_thenReturnThirdElementIsMinusThirtySeven() throws IOException {
    // Arrange
    Configuration configuration = new Configuration();
    configuration.setAllowNullValueProperties(true);
    configuration.addResource("Name");

    // Act
    byte[] actualSerialiseConfigurationResult = Utils.serialiseConfiguration(configuration);

    // Assert
    assertEquals((byte) -37, actualSerialiseConfigurationResult[2]);
    assertEquals((byte) -38, actualSerialiseConfigurationResult[174277]);
    assertEquals((byte) -47, actualSerialiseConfigurationResult[174262]);
    assertEquals((byte) -47, actualSerialiseConfigurationResult[174270]);
    assertEquals((byte) -51, actualSerialiseConfigurationResult[174268]);
    assertEquals((byte) -51, actualSerialiseConfigurationResult[174273]);
    assertEquals((byte) -56, actualSerialiseConfigurationResult[174272]);
    assertEquals((byte) -71, actualSerialiseConfigurationResult[174278]);
    assertEquals((byte) -85, actualSerialiseConfigurationResult[174271]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[174275]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[174281]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[174282]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[174283]);
    assertEquals(174284, actualSerialiseConfigurationResult.length);
    assertEquals((byte) 17, actualSerialiseConfigurationResult[174279]);
    assertEquals((byte) 18, actualSerialiseConfigurationResult[174280]);
    assertEquals((byte) 1, actualSerialiseConfigurationResult[174274]);
    assertEquals((byte) 6, actualSerialiseConfigurationResult[1]);
    assertEquals('(', actualSerialiseConfigurationResult[174259]);
    assertEquals(')', actualSerialiseConfigurationResult[174269]);
    assertEquals(',', actualSerialiseConfigurationResult[174267]);
    assertEquals('I', actualSerialiseConfigurationResult[174264]);
    assertEquals('J', actualSerialiseConfigurationResult[174260]);
    assertEquals('K', actualSerialiseConfigurationResult[174266]);
    assertEquals('M', actualSerialiseConfigurationResult[174261]);
    assertEquals('M', actualSerialiseConfigurationResult[174263]);
    assertEquals('M', actualSerialiseConfigurationResult[174265]);
    assertEquals('^', actualSerialiseConfigurationResult[174276]);
  }

  /**
   * Test {@link Utils#serialiseConfiguration(Configuration)}.
   *
   * <ul>
   *   <li>When {@link Configuration#Configuration()}.
   * </ul>
   *
   * <p>Method under test: {@link Utils#serialiseConfiguration(Configuration)}
   */
  @Test
  @DisplayName("Test serialiseConfiguration(Configuration); when Configuration()")
  @Tag("MaintainedByDiffblue")
  void testSerialiseConfiguration_whenConfiguration() throws IOException {
    // Arrange and Act
    byte[] actualSerialiseConfigurationResult = Utils.serialiseConfiguration(new Configuration());

    // Assert
    assertEquals((byte) -38, actualSerialiseConfigurationResult[140381]);
    assertEquals((byte) -47, actualSerialiseConfigurationResult[140366]);
    assertEquals((byte) -47, actualSerialiseConfigurationResult[140374]);
    assertEquals((byte) -51, actualSerialiseConfigurationResult[140372]);
    assertEquals((byte) -51, actualSerialiseConfigurationResult[140377]);
    assertEquals((byte) -56, actualSerialiseConfigurationResult[140376]);
    assertEquals((byte) -71, actualSerialiseConfigurationResult[140382]);
    assertEquals((byte) -85, actualSerialiseConfigurationResult[140375]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140379]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140385]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140386]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140387]);
    assertEquals(140388, actualSerialiseConfigurationResult.length);
    assertEquals((byte) 17, actualSerialiseConfigurationResult[140383]);
    assertEquals((byte) 18, actualSerialiseConfigurationResult[140384]);
    assertEquals((byte) 1, actualSerialiseConfigurationResult[140378]);
    assertEquals('(', actualSerialiseConfigurationResult[140363]);
    assertEquals(')', actualSerialiseConfigurationResult[140373]);
    assertEquals(',', actualSerialiseConfigurationResult[140371]);
    assertEquals('I', actualSerialiseConfigurationResult[140368]);
    assertEquals('J', actualSerialiseConfigurationResult[140364]);
    assertEquals('K', actualSerialiseConfigurationResult[140370]);
    assertEquals('M', actualSerialiseConfigurationResult[140365]);
    assertEquals('M', actualSerialiseConfigurationResult[140367]);
    assertEquals('M', actualSerialiseConfigurationResult[140369]);
    assertEquals('^', actualSerialiseConfigurationResult[140380]);
  }

  /**
   * Test {@link Utils#serialiseConfiguration(Configuration)}.
   *
   * <ul>
   *   <li>When {@link Configuration#Configuration()} RestrictSystemProperties is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Utils#serialiseConfiguration(Configuration)}
   */
  @Test
  @DisplayName(
      "Test serialiseConfiguration(Configuration); when Configuration() RestrictSystemProperties is 'true'")
  @Tag("MaintainedByDiffblue")
  void testSerialiseConfiguration_whenConfigurationRestrictSystemPropertiesIsTrue()
      throws IOException, IllegalArgumentException {
    // Arrange
    Configuration configuration = new Configuration();
    configuration.setRestrictSystemProperties(true);
    configuration.addResource(new Path("Path String"));
    configuration.addResource("Name");

    // Act
    byte[] actualSerialiseConfigurationResult = Utils.serialiseConfiguration(configuration);

    // Assert
    assertEquals((byte) -38, actualSerialiseConfigurationResult[140381]);
    assertEquals((byte) -47, actualSerialiseConfigurationResult[140366]);
    assertEquals((byte) -47, actualSerialiseConfigurationResult[140374]);
    assertEquals((byte) -51, actualSerialiseConfigurationResult[140372]);
    assertEquals((byte) -51, actualSerialiseConfigurationResult[140377]);
    assertEquals((byte) -56, actualSerialiseConfigurationResult[140376]);
    assertEquals((byte) -71, actualSerialiseConfigurationResult[140382]);
    assertEquals((byte) -85, actualSerialiseConfigurationResult[140375]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140379]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140385]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140386]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140387]);
    assertEquals(140388, actualSerialiseConfigurationResult.length);
    assertEquals((byte) 17, actualSerialiseConfigurationResult[140383]);
    assertEquals((byte) 18, actualSerialiseConfigurationResult[140384]);
    assertEquals((byte) 1, actualSerialiseConfigurationResult[140378]);
    assertEquals('(', actualSerialiseConfigurationResult[140363]);
    assertEquals(')', actualSerialiseConfigurationResult[140373]);
    assertEquals(',', actualSerialiseConfigurationResult[140371]);
    assertEquals('I', actualSerialiseConfigurationResult[140368]);
    assertEquals('J', actualSerialiseConfigurationResult[140364]);
    assertEquals('K', actualSerialiseConfigurationResult[140370]);
    assertEquals('M', actualSerialiseConfigurationResult[140365]);
    assertEquals('M', actualSerialiseConfigurationResult[140367]);
    assertEquals('M', actualSerialiseConfigurationResult[140369]);
    assertEquals('^', actualSerialiseConfigurationResult[140380]);
  }

  /**
   * Test {@link Utils#serialiseConfiguration(Configuration)}.
   *
   * <ul>
   *   <li>When {@link ConfigurationWithLogging#ConfigurationWithLogging(Configuration)} with conf
   *       is {@link Configuration#Configuration()}.
   * </ul>
   *
   * <p>Method under test: {@link Utils#serialiseConfiguration(Configuration)}
   */
  @Test
  @DisplayName(
      "Test serialiseConfiguration(Configuration); when ConfigurationWithLogging(Configuration) with conf is Configuration()")
  @Tag("MaintainedByDiffblue")
  void testSerialiseConfiguration_whenConfigurationWithLoggingWithConfIsConfiguration()
      throws IOException {
    // Arrange and Act
    byte[] actualSerialiseConfigurationResult =
        Utils.serialiseConfiguration(new ConfigurationWithLogging(new Configuration()));

    // Assert
    assertEquals((byte) -38, actualSerialiseConfigurationResult[140381]);
    assertEquals((byte) -47, actualSerialiseConfigurationResult[140366]);
    assertEquals((byte) -47, actualSerialiseConfigurationResult[140374]);
    assertEquals((byte) -51, actualSerialiseConfigurationResult[140372]);
    assertEquals((byte) -51, actualSerialiseConfigurationResult[140377]);
    assertEquals((byte) -56, actualSerialiseConfigurationResult[140376]);
    assertEquals((byte) -71, actualSerialiseConfigurationResult[140382]);
    assertEquals((byte) -85, actualSerialiseConfigurationResult[140375]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140379]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140385]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140386]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140387]);
    assertEquals(140388, actualSerialiseConfigurationResult.length);
    assertEquals((byte) 17, actualSerialiseConfigurationResult[140383]);
    assertEquals((byte) 18, actualSerialiseConfigurationResult[140384]);
    assertEquals((byte) 1, actualSerialiseConfigurationResult[140378]);
    assertEquals('(', actualSerialiseConfigurationResult[140363]);
    assertEquals(')', actualSerialiseConfigurationResult[140373]);
    assertEquals(',', actualSerialiseConfigurationResult[140371]);
    assertEquals('I', actualSerialiseConfigurationResult[140368]);
    assertEquals('J', actualSerialiseConfigurationResult[140364]);
    assertEquals('K', actualSerialiseConfigurationResult[140370]);
    assertEquals('M', actualSerialiseConfigurationResult[140365]);
    assertEquals('M', actualSerialiseConfigurationResult[140367]);
    assertEquals('M', actualSerialiseConfigurationResult[140369]);
    assertEquals('^', actualSerialiseConfigurationResult[140380]);
  }

  /**
   * Test {@link Utils#serialiseConfiguration(Configuration)}.
   *
   * <ul>
   *   <li>When {@link YarnConfiguration#YarnConfiguration(Configuration)} with conf is {@link
   *       Configuration#Configuration()}.
   * </ul>
   *
   * <p>Method under test: {@link Utils#serialiseConfiguration(Configuration)}
   */
  @Test
  @DisplayName(
      "Test serialiseConfiguration(Configuration); when YarnConfiguration(Configuration) with conf is Configuration()")
  @Tag("MaintainedByDiffblue")
  void testSerialiseConfiguration_whenYarnConfigurationWithConfIsConfiguration()
      throws IOException {
    // Arrange and Act
    byte[] actualSerialiseConfigurationResult =
        Utils.serialiseConfiguration(new YarnConfiguration(new Configuration()));

    // Assert
    assertEquals((byte) -38, actualSerialiseConfigurationResult[140381]);
    assertEquals((byte) -47, actualSerialiseConfigurationResult[140366]);
    assertEquals((byte) -47, actualSerialiseConfigurationResult[140374]);
    assertEquals((byte) -51, actualSerialiseConfigurationResult[140372]);
    assertEquals((byte) -51, actualSerialiseConfigurationResult[140377]);
    assertEquals((byte) -56, actualSerialiseConfigurationResult[140376]);
    assertEquals((byte) -71, actualSerialiseConfigurationResult[140382]);
    assertEquals((byte) -85, actualSerialiseConfigurationResult[140375]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140379]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140385]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140386]);
    assertEquals((byte) 0, actualSerialiseConfigurationResult[140387]);
    assertEquals(140388, actualSerialiseConfigurationResult.length);
    assertEquals((byte) 17, actualSerialiseConfigurationResult[140383]);
    assertEquals((byte) 18, actualSerialiseConfigurationResult[140384]);
    assertEquals((byte) 1, actualSerialiseConfigurationResult[140378]);
    assertEquals('(', actualSerialiseConfigurationResult[140363]);
    assertEquals(')', actualSerialiseConfigurationResult[140373]);
    assertEquals(',', actualSerialiseConfigurationResult[140371]);
    assertEquals('I', actualSerialiseConfigurationResult[140368]);
    assertEquals('J', actualSerialiseConfigurationResult[140364]);
    assertEquals('K', actualSerialiseConfigurationResult[140370]);
    assertEquals('M', actualSerialiseConfigurationResult[140365]);
    assertEquals('M', actualSerialiseConfigurationResult[140367]);
    assertEquals('M', actualSerialiseConfigurationResult[140369]);
    assertEquals('^', actualSerialiseConfigurationResult[140380]);
  }

  /**
   * Test {@link Utils#deserialiseConfiguration(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link Utils#deserialiseConfiguration(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialiseConfiguration(byte[]); when array of byte with zero and 'X'; then return size is zero")
  @Tag("MaintainedByDiffblue")
  void testDeserialiseConfiguration_whenArrayOfByteWithZeroAndX_thenReturnSizeIsZero()
      throws IOException {
    // Arrange and Act
    Configuration actualDeserialiseConfigurationResult =
        Utils.deserialiseConfiguration(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals(0, actualDeserialiseConfigurationResult.size());
    Set<String> finalParameters = actualDeserialiseConfigurationResult.getFinalParameters();
    assertEquals(2, finalParameters.size());
    assertTrue(finalParameters.contains("mapreduce.job.end-notification.max.attempts"));
    assertTrue(finalParameters.contains("mapreduce.job.end-notification.max.retry.interval"));
  }
}
