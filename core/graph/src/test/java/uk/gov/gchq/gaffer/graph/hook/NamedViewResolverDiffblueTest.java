package uk.gov.gchq.gaffer.graph.hook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.export.graph.ExportToOtherAuthorisedGraph;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.operation.handler.named.cache.NamedViewCache;

class NamedViewResolverDiffblueTest {
  /**
   * Test {@link NamedViewResolver#NamedViewResolver(NamedViewCache)}.
   *
   * <p>Method under test: {@link NamedViewResolver#NamedViewResolver(NamedViewCache)}
   */
  @Test
  @DisplayName("Test new NamedViewResolver(NamedViewCache)")
  @Tag("MaintainedByDiffblue")
  void testNewNamedViewResolver() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix named view cache name",
        new NamedViewResolver(new NamedViewCache("Suffix Named View Cache Name"))
            .getSuffixCacheName());
  }

  /**
   * Test {@link NamedViewResolver#NamedViewResolver(String)}.
   *
   * <p>Method under test: {@link NamedViewResolver#NamedViewResolver(String)}
   */
  @Test
  @DisplayName("Test new NamedViewResolver(String)")
  @Tag("MaintainedByDiffblue")
  void testNewNamedViewResolver2() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix named view cache name",
        new NamedViewResolver("Suffix Named View Cache Name").getSuffixCacheName());
  }

  /**
   * Test {@link NamedViewResolver#getSuffixCacheName()}.
   *
   * <ul>
   *   <li>Then return {@code suffix named view cache name}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewResolver#getSuffixCacheName()}
   */
  @Test
  @DisplayName("Test getSuffixCacheName(); then return 'suffix named view cache name'")
  @Tag("MaintainedByDiffblue")
  void testGetSuffixCacheName_thenReturnSuffixNamedViewCacheName() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix named view cache name",
        new NamedViewResolver("Suffix Named View Cache Name").getSuffixCacheName());
  }

  /**
   * Test {@link NamedViewResolver#postExecute(Object, OperationChain, Context)}.
   *
   * <p>Method under test: {@link NamedViewResolver#postExecute(Object, OperationChain, Context)}
   */
  @Test
  @DisplayName("Test postExecute(Object, OperationChain, Context)")
  @Tag("MaintainedByDiffblue")
  void testPostExecute() {
    // Arrange
    NamedViewResolver namedViewResolver = new NamedViewResolver("Suffix Named View Cache Name");
    OperationChain<?> opChain = OperationChain.wrap(new ExportToOtherAuthorisedGraph());

    // Act and Assert
    assertEquals("Result", namedViewResolver.postExecute("Result", opChain, new Context()));
  }

  /**
   * Test {@link NamedViewResolver#onFailure(Object, OperationChain, Context, Exception)}.
   *
   * <p>Method under test: {@link NamedViewResolver#onFailure(Object, OperationChain, Context,
   * Exception)}
   */
  @Test
  @DisplayName("Test onFailure(Object, OperationChain, Context, Exception)")
  @Tag("MaintainedByDiffblue")
  void testOnFailure() {
    // Arrange
    NamedViewResolver namedViewResolver = new NamedViewResolver("Suffix Named View Cache Name");
    OperationChain<?> opChain = OperationChain.wrap(new ExportToOtherAuthorisedGraph());
    Context context = new Context();

    // Act and Assert
    assertEquals(
        "Result", namedViewResolver.onFailure("Result", opChain, context, new Exception()));
  }
}
