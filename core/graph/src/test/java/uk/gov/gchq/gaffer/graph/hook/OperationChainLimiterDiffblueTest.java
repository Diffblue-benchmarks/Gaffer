package uk.gov.gchq.gaffer.graph.hook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.exception.UnauthorisedException;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.export.graph.ExportToOtherAuthorisedGraph;
import uk.gov.gchq.gaffer.store.Context;

class OperationChainLimiterDiffblueTest {
  /**
   * Test {@link OperationChainLimiter#OperationChainLimiter(String)}.
   *
   * <p>Method under test: {@link OperationChainLimiter#OperationChainLimiter(String)}
   */
  @Test
  @DisplayName("Test new OperationChainLimiter(String)")
  @Tag("MaintainedByDiffblue")
  void testNewOperationChainLimiter() {
    // Arrange and Act
    OperationChainLimiter actualOperationChainLimiter =
        new OperationChainLimiter("Cache Service Name Suffix");

    // Assert
    assertEquals(
        "cache service name suffix",
        actualOperationChainLimiter.getSuffixNamedOperationCacheName());
    assertTrue(actualOperationChainLimiter.getAuthScores().isEmpty());
    assertTrue(actualOperationChainLimiter.getOpScores().isEmpty());
    assertTrue(actualOperationChainLimiter.getOpScoresAsStrings().isEmpty());
    assertTrue(actualOperationChainLimiter.getScoreResolvers().isEmpty());
  }

  /**
   * Test {@link OperationChainLimiter#OperationChainLimiter(String)}.
   *
   * <ul>
   *   <li>Then return SuffixNamedOperationCacheName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChainLimiter#OperationChainLimiter(String)}
   */
  @Test
  @DisplayName(
      "Test new OperationChainLimiter(String); then return SuffixNamedOperationCacheName is 'null'")
  @Tag("MaintainedByDiffblue")
  void testNewOperationChainLimiter_thenReturnSuffixNamedOperationCacheNameIsNull() {
    // Arrange and Act
    OperationChainLimiter actualOperationChainLimiter = new OperationChainLimiter(null);

    // Assert
    assertNull(actualOperationChainLimiter.getSuffixNamedOperationCacheName());
    assertTrue(actualOperationChainLimiter.getAuthScores().isEmpty());
    assertTrue(actualOperationChainLimiter.getOpScores().isEmpty());
    assertTrue(actualOperationChainLimiter.getOpScoresAsStrings().isEmpty());
    assertTrue(actualOperationChainLimiter.getScoreResolvers().isEmpty());
  }

  /**
   * Test {@link OperationChainLimiter#getSuffixNamedOperationCacheName()}.
   *
   * <p>Method under test: {@link OperationChainLimiter#getSuffixNamedOperationCacheName()}
   */
  @Test
  @DisplayName("Test getSuffixNamedOperationCacheName()")
  @Tag("MaintainedByDiffblue")
  void testGetSuffixNamedOperationCacheName() {
    // Arrange, Act and Assert
    assertEquals(
        "cache service name suffix",
        new OperationChainLimiter("Cache Service Name Suffix").getSuffixNamedOperationCacheName());
  }

  /**
   * Test {@link OperationChainLimiter#preExecute(OperationChain, Context)}.
   *
   * <p>Method under test: {@link OperationChainLimiter#preExecute(OperationChain, Context)}
   */
  @Test
  @DisplayName("Test preExecute(OperationChain, Context)")
  @Tag("MaintainedByDiffblue")
  void testPreExecute() {
    // Arrange
    OperationChainLimiter operationChainLimiter =
        new OperationChainLimiter("Cache Service Name Suffix");
    OperationChain<?> opChain = OperationChain.wrap(new ExportToOtherAuthorisedGraph());

    // Act and Assert
    assertThrows(
        UnauthorisedException.class,
        () -> operationChainLimiter.preExecute(opChain, new Context()));
  }

  /**
   * Test {@link OperationChainLimiter#postExecute(Object, OperationChain, Context)}.
   *
   * <p>Method under test: {@link OperationChainLimiter#postExecute(Object, OperationChain,
   * Context)}
   */
  @Test
  @DisplayName("Test postExecute(Object, OperationChain, Context)")
  @Tag("MaintainedByDiffblue")
  void testPostExecute() {
    // Arrange
    OperationChainLimiter operationChainLimiter =
        new OperationChainLimiter("Cache Service Name Suffix");
    OperationChain<?> opChain = OperationChain.wrap(new ExportToOtherAuthorisedGraph());

    // Act and Assert
    assertEquals("Result", operationChainLimiter.postExecute("Result", opChain, new Context()));
  }

  /**
   * Test {@link OperationChainLimiter#onFailure(Object, OperationChain, Context, Exception)}.
   *
   * <p>Method under test: {@link OperationChainLimiter#onFailure(Object, OperationChain, Context,
   * Exception)}
   */
  @Test
  @DisplayName("Test onFailure(Object, OperationChain, Context, Exception)")
  @Tag("MaintainedByDiffblue")
  void testOnFailure() {
    // Arrange
    OperationChainLimiter operationChainLimiter =
        new OperationChainLimiter("Cache Service Name Suffix");
    OperationChain<?> opChain = OperationChain.wrap(new ExportToOtherAuthorisedGraph());
    Context context = new Context();

    // Act and Assert
    assertEquals(
        "Result", operationChainLimiter.onFailure("Result", opChain, context, new Exception()));
  }

  /**
   * Test {@link OperationChainLimiter#getOpScores()}.
   *
   * <p>Method under test: {@link OperationChainLimiter#getOpScores()}
   */
  @Test
  @DisplayName("Test getOpScores()")
  @Tag("MaintainedByDiffblue")
  void testGetOpScores() {
    // Arrange, Act and Assert
    assertTrue(new OperationChainLimiter("Cache Service Name Suffix").getOpScores().isEmpty());
  }

  /**
   * Test {@link OperationChainLimiter#setOpScores(Map)}.
   *
   * <p>Method under test: {@link OperationChainLimiter#setOpScores(Map)}
   */
  @Test
  @DisplayName("Test setOpScores(Map)")
  @Tag("MaintainedByDiffblue")
  void testSetOpScores() {
    // Arrange
    OperationChainLimiter operationChainLimiter =
        new OperationChainLimiter("Cache Service Name Suffix");

    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();
    Class<Operation> forNameResult = Operation.class;
    opScores.put(forNameResult, 1);

    // Act
    operationChainLimiter.setOpScores(opScores);

    // Assert
    Map<String, Integer> opScoresAsStrings = operationChainLimiter.getOpScoresAsStrings();
    assertEquals(1, opScoresAsStrings.size());
    assertEquals(1, opScoresAsStrings.get("uk.gov.gchq.gaffer.operation.Operation").intValue());
    assertEquals(opScores, operationChainLimiter.getOpScores());
  }

  /**
   * Test {@link OperationChainLimiter#setOpScores(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChainLimiter#setOpScores(Map)}
   */
  @Test
  @DisplayName("Test setOpScores(Map); when HashMap()")
  @Tag("MaintainedByDiffblue")
  void testSetOpScores_whenHashMap() {
    // Arrange
    OperationChainLimiter operationChainLimiter =
        new OperationChainLimiter("Cache Service Name Suffix");

    // Act
    operationChainLimiter.setOpScores(new HashMap<>());

    // Assert that nothing has changed
    assertTrue(operationChainLimiter.getOpScores().isEmpty());
    assertTrue(operationChainLimiter.getOpScoresAsStrings().isEmpty());
  }

  /**
   * Test {@link OperationChainLimiter#setOpScores(Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChainLimiter#setOpScores(Map)}
   */
  @Test
  @DisplayName("Test setOpScores(Map); when 'null'")
  @Tag("MaintainedByDiffblue")
  void testSetOpScores_whenNull() {
    // Arrange
    OperationChainLimiter operationChainLimiter =
        new OperationChainLimiter("Cache Service Name Suffix");

    // Act
    operationChainLimiter.setOpScores(null);

    // Assert that nothing has changed
    assertTrue(operationChainLimiter.getOpScores().isEmpty());
    assertTrue(operationChainLimiter.getOpScoresAsStrings().isEmpty());
  }

  /**
   * Test {@link OperationChainLimiter#getOpScoresAsStrings()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OperationChainLimiter#getOpScoresAsStrings()}
   */
  @Test
  @DisplayName("Test getOpScoresAsStrings(); then return Empty")
  @Tag("MaintainedByDiffblue")
  void testGetOpScoresAsStrings_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new OperationChainLimiter("Cache Service Name Suffix").getOpScoresAsStrings().isEmpty());
  }

  /**
   * Test {@link OperationChainLimiter#getOpScoresAsStrings()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link OperationChainLimiter#getOpScoresAsStrings()}
   */
  @Test
  @DisplayName("Test getOpScoresAsStrings(); then return size is one")
  @Tag("MaintainedByDiffblue")
  void testGetOpScoresAsStrings_thenReturnSizeIsOne() {
    // Arrange
    HashMap<Class<? extends Operation>, Integer> opScores = new HashMap<>();
    Class<Operation> forNameResult = Operation.class;
    opScores.put(forNameResult, 1);

    OperationChainLimiter operationChainLimiter =
        new OperationChainLimiter("Cache Service Name Suffix");
    operationChainLimiter.setOpScores(opScores);

    // Act
    Map<String, Integer> actualOpScoresAsStrings = operationChainLimiter.getOpScoresAsStrings();

    // Assert
    assertEquals(1, actualOpScoresAsStrings.size());
    assertEquals(
        1, actualOpScoresAsStrings.get("uk.gov.gchq.gaffer.operation.Operation").intValue());
  }

  /**
   * Test {@link OperationChainLimiter#getAuthScores()}.
   *
   * <p>Method under test: {@link OperationChainLimiter#getAuthScores()}
   */
  @Test
  @DisplayName("Test getAuthScores()")
  @Tag("MaintainedByDiffblue")
  void testGetAuthScores() {
    // Arrange, Act and Assert
    assertTrue(new OperationChainLimiter("Cache Service Name Suffix").getAuthScores().isEmpty());
  }

  /**
   * Test {@link OperationChainLimiter#getScoreResolvers()}.
   *
   * <p>Method under test: {@link OperationChainLimiter#getScoreResolvers()}
   */
  @Test
  @DisplayName("Test getScoreResolvers()")
  @Tag("MaintainedByDiffblue")
  void testGetScoreResolvers() {
    // Arrange, Act and Assert
    assertTrue(
        new OperationChainLimiter("Cache Service Name Suffix").getScoreResolvers().isEmpty());
  }
}
