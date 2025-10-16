package uk.gov.gchq.gaffer.bitmap.serialisation.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import com.fasterxml.jackson.core.util.JsonParserSequence;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.Impl;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.util.AccessPattern;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RoaringBitmapJsonDeserialiserDiffblueTest {
  /**
   * Test {@link RoaringBitmapJsonDeserialiser#deserialize(JsonParser, DeserializationContext)} with
   * {@code jsonParser}, {@code deserializationContext}.
   *
   * <ul>
   *   <li>Given {@code END_OBJECT}.
   * </ul>
   *
   * <p>Method under test: {@link RoaringBitmapJsonDeserialiser#deserialize(JsonParser,
   * DeserializationContext)}
   */
  @Test
  @DisplayName(
      "Test deserialize(JsonParser, DeserializationContext) with 'jsonParser', 'deserializationContext'; given 'END_OBJECT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.roaringbitmap.RoaringBitmap RoaringBitmapJsonDeserialiser.deserialize(JsonParser, DeserializationContext)"
  })
  void testDeserializeWithJsonParserDeserializationContext_givenEndObject() throws IOException {
    // Arrange
    RoaringBitmapJsonDeserialiser roaringBitmapJsonDeserialiser =
        new RoaringBitmapJsonDeserialiser();

    JsonParserSequence jsonParser = mock(JsonParserSequence.class);
    doNothing().when(jsonParser).clearCurrentToken();
    JacksonFeatureSet<StreamReadCapability> fromBitmaskResult = JacksonFeatureSet.fromBitmask(1);
    when(jsonParser.getReadCapabilities()).thenReturn(fromBitmaskResult);
    when(jsonParser.currentToken()).thenReturn(JsonToken.END_OBJECT);
    when(jsonParser.getCodec()).thenReturn(JsonMapper.builder().findAndAddModules().build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            roaringBitmapJsonDeserialiser.deserialize(
                jsonParser,
                new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()))));
    verify(jsonParser).clearCurrentToken();
    verify(jsonParser, atLeast(1)).currentToken();
    verify(jsonParser).getCodec();
    verify(jsonParser).getReadCapabilities();
  }

  /**
   * Test {@link RoaringBitmapJsonDeserialiser#deserialize(JsonParser, DeserializationContext)} with
   * {@code jsonParser}, {@code deserializationContext}.
   *
   * <ul>
   *   <li>Then calls {@link JsonParserSequence#currentTokenId()}.
   * </ul>
   *
   * <p>Method under test: {@link RoaringBitmapJsonDeserialiser#deserialize(JsonParser,
   * DeserializationContext)}
   */
  @Test
  @DisplayName(
      "Test deserialize(JsonParser, DeserializationContext) with 'jsonParser', 'deserializationContext'; then calls currentTokenId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.roaringbitmap.RoaringBitmap RoaringBitmapJsonDeserialiser.deserialize(JsonParser, DeserializationContext)"
  })
  void testDeserializeWithJsonParserDeserializationContext_thenCallsCurrentTokenId()
      throws IOException {
    // Arrange
    RoaringBitmapJsonDeserialiser roaringBitmapJsonDeserialiser =
        new RoaringBitmapJsonDeserialiser();

    JsonParserSequence d = mock(JsonParserSequence.class);
    doNothing().when(d).clearCurrentToken();
    JacksonFeatureSet<StreamReadCapability> fromBitmaskResult = JacksonFeatureSet.fromBitmask(1);
    when(d.getReadCapabilities()).thenReturn(fromBitmaskResult);
    when(d.currentTokenId()).thenReturn(1);
    when(d.currentToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.nextToken()).thenReturn(JsonToken.NOT_AVAILABLE);
    when(d.getCodec()).thenReturn(JsonMapper.builder().findAndAddModules().build());
    JsonParserDelegate jsonParser = new JsonParserDelegate(d);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            roaringBitmapJsonDeserialiser.deserialize(
                jsonParser,
                new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()))));
    verify(d).clearCurrentToken();
    verify(d, atLeast(1)).currentToken();
    verify(d).currentTokenId();
    verify(d).getCodec();
    verify(d).getReadCapabilities();
    verify(d).nextToken();
  }

  /**
   * Test new {@link RoaringBitmapJsonDeserialiser} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * RoaringBitmapJsonDeserialiser}
   */
  @Test
  @DisplayName("Test new RoaringBitmapJsonDeserialiser (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RoaringBitmapJsonDeserialiser.<init>()"})
  void testNewRoaringBitmapJsonDeserialiser() {
    // Arrange and Act
    RoaringBitmapJsonDeserialiser actualRoaringBitmapJsonDeserialiser =
        new RoaringBitmapJsonDeserialiser();

    // Assert
    assertNull(actualRoaringBitmapJsonDeserialiser.getDelegatee());
    assertNull(actualRoaringBitmapJsonDeserialiser.getObjectIdReader());
    assertNull(actualRoaringBitmapJsonDeserialiser.getEmptyValue());
    assertNull(actualRoaringBitmapJsonDeserialiser.getKnownPropertyNames());
    assertNull(actualRoaringBitmapJsonDeserialiser.getNullValue());
    assertEquals(
        AccessPattern.CONSTANT, actualRoaringBitmapJsonDeserialiser.getNullAccessPattern());
    assertEquals(
        AccessPattern.DYNAMIC, actualRoaringBitmapJsonDeserialiser.getEmptyAccessPattern());
    assertFalse(actualRoaringBitmapJsonDeserialiser.isCachable());
  }
}
