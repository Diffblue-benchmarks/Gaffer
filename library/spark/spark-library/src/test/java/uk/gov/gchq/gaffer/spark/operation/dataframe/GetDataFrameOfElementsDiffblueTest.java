package uk.gov.gchq.gaffer.spark.operation.dataframe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.spark.operation.dataframe.GetDataFrameOfElements.Builder;
import uk.gov.gchq.gaffer.spark.operation.dataframe.converter.property.Converter;
import uk.gov.gchq.gaffer.spark.operation.dataframe.converter.property.impl.FreqMapConverter;
import uk.gov.gchq.gaffer.spark.serialisation.TypeReferenceSparkImpl;
import uk.gov.gchq.gaffer.spark.serialisation.TypeReferenceSparkImpl.DataSetRow;

class GetDataFrameOfElementsDiffblueTest {
  /**
   * Test Builder {@link Builder#converters(List)}.
   *
   * <ul>
   *   <li>Then return _getOp Converters is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#converters(List)}
   */
  @Test
  @DisplayName("Test Builder converters(List); then return _getOp Converters is ArrayList()")
  @Tag("MaintainedByDiffblue")
  void testBuilderConverters_thenReturn_getOpConvertersIsArrayList() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Converter> converters = new ArrayList<>();
    converters.add(new FreqMapConverter());

    // Act and Assert
    assertSame(converters, builder.converters(converters)._getOp().getConverters());
  }

  /**
   * Test Builder {@link Builder#converters(List)}.
   *
   * <ul>
   *   <li>Then return _getOp Converters is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#converters(List)}
   */
  @Test
  @DisplayName("Test Builder converters(List); then return _getOp Converters is ArrayList()")
  @Tag("MaintainedByDiffblue")
  void testBuilderConverters_thenReturn_getOpConvertersIsArrayList2() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Converter> converters = new ArrayList<>();
    converters.add(new FreqMapConverter());
    converters.add(new FreqMapConverter());

    // Act and Assert
    assertSame(converters, builder.converters(converters)._getOp().getConverters());
  }

  /**
   * Test Builder {@link Builder#converters(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#converters(List)}
   */
  @Test
  @DisplayName(
      "Test Builder converters(List); when ArrayList(); then return Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderConverters_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualConvertersResult = builder.converters(new ArrayList<>());

    // Assert
    assertSame(builder, actualConvertersResult);
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    GetDataFrameOfElements _getOpResult = actualBuilder._getOp();
    TypeReference<Dataset<Row>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof DataSetRow);
    Type outputType = _getOpResult.getOutputType();
    assertEquals(
        "org.apache.spark.sql.Dataset<org.apache.spark.sql.Row>", outputType.getTypeName());
    assertNull(_getOpResult.getConverters());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getDirectedType());
    assertNull(_getOpResult.getView());
    Class<Dataset> expectedOutputClass = Dataset.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    GetDataFrameOfElements actualGetDataFrameOfElements = actualBuilder.build();
    assertSame(_getOpResult, actualGetDataFrameOfElements);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GetDataFrameOfElements#GetDataFrameOfElements()}
   *   <li>{@link GetDataFrameOfElements#setConverters(List)}
   *   <li>{@link GetDataFrameOfElements#setDirectedType(DirectedType)}
   *   <li>{@link GetDataFrameOfElements#setOptions(Map)}
   *   <li>{@link GetDataFrameOfElements#setView(View)}
   *   <li>{@link GetDataFrameOfElements#getConverters()}
   *   <li>{@link GetDataFrameOfElements#getDirectedType()}
   *   <li>{@link GetDataFrameOfElements#getOptions()}
   *   <li>{@link GetDataFrameOfElements#getView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    GetDataFrameOfElements actualGetDataFrameOfElements = new GetDataFrameOfElements();
    ArrayList<Converter> converters = new ArrayList<>();
    actualGetDataFrameOfElements.setConverters(converters);
    actualGetDataFrameOfElements.setDirectedType(DirectedType.EITHER);
    HashMap<String, String> options = new HashMap<>();
    actualGetDataFrameOfElements.setOptions(options);
    View view = new View();
    actualGetDataFrameOfElements.setView(view);
    List<Converter> actualConverters = actualGetDataFrameOfElements.getConverters();
    DirectedType actualDirectedType = actualGetDataFrameOfElements.getDirectedType();
    Map<String, String> actualOptions = actualGetDataFrameOfElements.getOptions();
    View actualView = actualGetDataFrameOfElements.getView();

    // Assert
    assertEquals(DirectedType.EITHER, actualDirectedType);
    assertTrue(actualConverters.isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertSame(converters, actualConverters);
    assertSame(options, actualOptions);
    assertSame(view, actualView);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GetDataFrameOfElements#GetDataFrameOfElements(List)}
   *   <li>{@link GetDataFrameOfElements#setConverters(List)}
   *   <li>{@link GetDataFrameOfElements#setDirectedType(DirectedType)}
   *   <li>{@link GetDataFrameOfElements#setOptions(Map)}
   *   <li>{@link GetDataFrameOfElements#setView(View)}
   *   <li>{@link GetDataFrameOfElements#getConverters()}
   *   <li>{@link GetDataFrameOfElements#getDirectedType()}
   *   <li>{@link GetDataFrameOfElements#getOptions()}
   *   <li>{@link GetDataFrameOfElements#getView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when ArrayList()")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters_whenArrayList() {
    // Arrange and Act
    GetDataFrameOfElements actualGetDataFrameOfElements =
        new GetDataFrameOfElements(new ArrayList<>());
    ArrayList<Converter> converters = new ArrayList<>();
    actualGetDataFrameOfElements.setConverters(converters);
    actualGetDataFrameOfElements.setDirectedType(DirectedType.EITHER);
    HashMap<String, String> options = new HashMap<>();
    actualGetDataFrameOfElements.setOptions(options);
    View view = new View();
    actualGetDataFrameOfElements.setView(view);
    List<Converter> actualConverters = actualGetDataFrameOfElements.getConverters();
    DirectedType actualDirectedType = actualGetDataFrameOfElements.getDirectedType();
    Map<String, String> actualOptions = actualGetDataFrameOfElements.getOptions();
    View actualView = actualGetDataFrameOfElements.getView();

    // Assert
    assertEquals(DirectedType.EITHER, actualDirectedType);
    assertTrue(actualConverters.isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertSame(converters, actualConverters);
    assertSame(options, actualOptions);
    assertSame(view, actualView);
  }

  /**
   * Test {@link GetDataFrameOfElements#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link GetDataFrameOfElements#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Dataset<Row>> actualOutputTypeReference =
        new GetDataFrameOfElements().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof DataSetRow);
    assertEquals(
        "org.apache.spark.sql.Dataset<org.apache.spark.sql.Row>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link GetDataFrameOfElements#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetDataFrameOfElements#GetDataFrameOfElements()}.
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetDataFrameOfElements#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given GetDataFrameOfElements(); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenGetDataFrameOfElements_thenReturnOptionsIsNull() {
    // Arrange and Act
    GetDataFrameOfElements actualShallowCloneResult = new GetDataFrameOfElements().shallowClone();

    // Assert
    TypeReference<Dataset<Row>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof DataSetRow);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "org.apache.spark.sql.Dataset<org.apache.spark.sql.Row>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getConverters());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getDirectedType());
    assertNull(actualShallowCloneResult.getView());
    Class<Dataset> expectedOutputClass = Dataset.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetDataFrameOfElements#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetDataFrameOfElements#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_thenReturnOptionsEmpty() {
    // Arrange
    GetDataFrameOfElements getDataFrameOfElements = new GetDataFrameOfElements();
    getDataFrameOfElements.setOptions(new HashMap<>());

    // Act
    GetDataFrameOfElements actualShallowCloneResult = getDataFrameOfElements.shallowClone();

    // Assert
    TypeReference<Dataset<Row>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof DataSetRow);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "org.apache.spark.sql.Dataset<org.apache.spark.sql.Row>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getConverters());
    assertNull(actualShallowCloneResult.getDirectedType());
    assertNull(actualShallowCloneResult.getView());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Dataset> expectedOutputClass = Dataset.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }
}
