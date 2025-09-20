package uk.gov.gchq.gaffer.store.operation.handler.named.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.cache.exception.CacheOperationException;
import uk.gov.gchq.gaffer.core.exception.GafferRuntimeException;
import uk.gov.gchq.gaffer.data.elementdefinition.view.NamedViewDetail;
import uk.gov.gchq.gaffer.user.User;

class NamedViewCacheDiffblueTest {
  /**
   * Test {@link NamedViewCache#NamedViewCache(String)}.
   *
   * <p>Method under test: {@link NamedViewCache#NamedViewCache(String)}
   */
  @Test
  @DisplayName("Test new NamedViewCache(String)")
  @Tag("MaintainedByDiffblue")
  void testNewNamedViewCache() {
    // Arrange and Act
    NamedViewCache actualNamedViewCache = new NamedViewCache("Suffix Named View Cache Name");

    // Assert
    assertEquals("NamedView_suffix named view cache name", actualNamedViewCache.getCacheName());
    assertEquals("suffix named view cache name", actualNamedViewCache.getSuffixCacheName());
    assertNull(actualNamedViewCache.getCache());
  }

  /**
   * Test {@link NamedViewCache#getCacheNameFrom(String)} with {@code suffixNamedViewCacheName}.
   *
   * <p>Method under test: {@link NamedViewCache#getCacheNameFrom(String)}
   */
  @Test
  @DisplayName("Test getCacheNameFrom(String) with 'suffixNamedViewCacheName'")
  @Tag("MaintainedByDiffblue")
  void testGetCacheNameFromWithSuffixNamedViewCacheName() {
    // Arrange, Act and Assert
    assertEquals(
        "NamedView_suffix named view cache name",
        NamedViewCache.getCacheNameFrom("Suffix Named View Cache Name"));
  }

  /**
   * Test {@link NamedViewCache#getSuffixCacheName()}.
   *
   * <p>Method under test: {@link NamedViewCache#getSuffixCacheName()}
   */
  @Test
  @DisplayName("Test getSuffixCacheName()")
  @Tag("MaintainedByDiffblue")
  void testGetSuffixCacheName() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix named view cache name",
        new NamedViewCache("Suffix Named View Cache Name").getSuffixCacheName());
  }

  /**
   * Test {@link NamedViewCache#addNamedView(NamedViewDetail, boolean, User, String)} with {@code
   * namedViewDetail}, {@code overwrite}, {@code user}, {@code adminAuth}.
   *
   * <p>Method under test: {@link NamedViewCache#addNamedView(NamedViewDetail, boolean, User,
   * String)}
   */
  @Test
  @DisplayName(
      "Test addNamedView(NamedViewDetail, boolean, User, String) with 'namedViewDetail', 'overwrite', 'user', 'adminAuth'")
  @Tag("MaintainedByDiffblue")
  void testAddNamedViewWithNamedViewDetailOverwriteUserAdminAuth() throws CacheOperationException {
    // Arrange
    NamedViewCache namedViewCache = new NamedViewCache("Suffix Named View Cache Name");
    NamedViewDetail namedViewDetail = new NamedViewDetail();

    // Act and Assert
    assertThrows(
        CacheOperationException.class,
        () -> namedViewCache.addNamedView(namedViewDetail, true, new User(), "Admin Auth"));
  }

  /**
   * Test {@link NamedViewCache#addNamedView(NamedViewDetail, boolean, User, String)} with {@code
   * namedViewDetail}, {@code overwrite}, {@code user}, {@code adminAuth}.
   *
   * <p>Method under test: {@link NamedViewCache#addNamedView(NamedViewDetail, boolean, User,
   * String)}
   */
  @Test
  @DisplayName(
      "Test addNamedView(NamedViewDetail, boolean, User, String) with 'namedViewDetail', 'overwrite', 'user', 'adminAuth'")
  @Tag("MaintainedByDiffblue")
  void testAddNamedViewWithNamedViewDetailOverwriteUserAdminAuth2() throws CacheOperationException {
    // Arrange
    NamedViewCache namedViewCache = new NamedViewCache("Suffix Named View Cache Name");
    NamedViewDetail namedViewDetail =
        new NamedViewDetail(
            "NamedView name cannot be null",
            "NamedView name cannot be null",
            "The characteristics of someone or something",
            new HashMap<>());

    // Act and Assert
    assertThrows(
        GafferRuntimeException.class,
        () -> namedViewCache.addNamedView(namedViewDetail, true, new User(), "Admin Auth"));
  }

  /**
   * Test {@link NamedViewCache#addNamedView(NamedViewDetail, boolean)} with {@code
   * namedViewDetail}, {@code overwrite}.
   *
   * <ul>
   *   <li>Then throw {@link CacheOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewCache#addNamedView(NamedViewDetail, boolean)}
   */
  @Test
  @DisplayName(
      "Test addNamedView(NamedViewDetail, boolean) with 'namedViewDetail', 'overwrite'; then throw CacheOperationException")
  @Tag("MaintainedByDiffblue")
  void testAddNamedViewWithNamedViewDetailOverwrite_thenThrowCacheOperationException()
      throws CacheOperationException {
    // Arrange
    NamedViewCache namedViewCache = new NamedViewCache("Suffix Named View Cache Name");

    // Act and Assert
    assertThrows(
        CacheOperationException.class,
        () -> namedViewCache.addNamedView(new NamedViewDetail(), true));
  }

  /**
   * Test {@link NamedViewCache#addNamedView(NamedViewDetail, boolean)} with {@code
   * namedViewDetail}, {@code overwrite}.
   *
   * <ul>
   *   <li>Then throw {@link GafferRuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewCache#addNamedView(NamedViewDetail, boolean)}
   */
  @Test
  @DisplayName(
      "Test addNamedView(NamedViewDetail, boolean) with 'namedViewDetail', 'overwrite'; then throw GafferRuntimeException")
  @Tag("MaintainedByDiffblue")
  void testAddNamedViewWithNamedViewDetailOverwrite_thenThrowGafferRuntimeException()
      throws CacheOperationException {
    // Arrange
    NamedViewCache namedViewCache = new NamedViewCache("Suffix Named View Cache Name");
    NamedViewDetail namedViewDetail =
        new NamedViewDetail(
            "NamedView name cannot be null",
            "NamedView name cannot be null",
            "The characteristics of someone or something",
            new HashMap<>());

    // Act and Assert
    assertThrows(
        GafferRuntimeException.class, () -> namedViewCache.addNamedView(namedViewDetail, true));
  }

  /**
   * Test {@link NamedViewCache#deleteNamedView(String, User, String)} with {@code name}, {@code
   * user}, {@code adminAuth}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewCache#deleteNamedView(String, User, String)}
   */
  @Test
  @DisplayName(
      "Test deleteNamedView(String, User, String) with 'name', 'user', 'adminAuth'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testDeleteNamedViewWithNameUserAdminAuth_thenThrowIllegalArgumentException()
      throws CacheOperationException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedViewCache("Suffix Named View Cache Name")
                .deleteNamedView(null, null, "not empty"));
  }

  /**
   * Test {@link NamedViewCache#deleteNamedView(String, User)} with {@code name}, {@code user}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewCache#deleteNamedView(String, User)}
   */
  @Test
  @DisplayName(
      "Test deleteNamedView(String, User) with 'name', 'user'; when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testDeleteNamedViewWithNameUser_whenNull_thenThrowIllegalArgumentException()
      throws CacheOperationException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new NamedViewCache("Suffix Named View Cache Name").deleteNamedView(null, null));
  }

  /**
   * Test {@link NamedViewCache#getNamedView(String, User, String)} with {@code name}, {@code user},
   * {@code adminAuth}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link CacheOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewCache#getNamedView(String, User, String)}
   */
  @Test
  @DisplayName(
      "Test getNamedView(String, User, String) with 'name', 'user', 'adminAuth'; when 'null'; then throw CacheOperationException")
  @Tag("MaintainedByDiffblue")
  void testGetNamedViewWithNameUserAdminAuth_whenNull_thenThrowCacheOperationException()
      throws CacheOperationException {
    // Arrange
    NamedViewCache namedViewCache = new NamedViewCache("Suffix Named View Cache Name");

    // Act and Assert
    assertThrows(
        CacheOperationException.class,
        () -> namedViewCache.getNamedView(null, new User(), "not empty"));
  }

  /**
   * Test {@link NamedViewCache#getNamedView(String, User)} with {@code name}, {@code user}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link CacheOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewCache#getNamedView(String, User)}
   */
  @Test
  @DisplayName(
      "Test getNamedView(String, User) with 'name', 'user'; when 'null'; then throw CacheOperationException")
  @Tag("MaintainedByDiffblue")
  void testGetNamedViewWithNameUser_whenNull_thenThrowCacheOperationException()
      throws CacheOperationException {
    // Arrange
    NamedViewCache namedViewCache = new NamedViewCache("Suffix Named View Cache Name");

    // Act and Assert
    assertThrows(
        CacheOperationException.class, () -> namedViewCache.getNamedView(null, new User()));
  }

  /**
   * Test {@link NamedViewCache#getFromCache(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewCache#getFromCache(String)}
   */
  @Test
  @DisplayName("Test getFromCache(String); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testGetFromCache_whenNull_thenThrowIllegalArgumentException()
      throws CacheOperationException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new NamedViewCache("Suffix Named View Cache Name").getFromCache(null));
  }
}
