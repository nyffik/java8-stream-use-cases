package pl.socodeit.streams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class Java8WayTest {
    private Java8Way java8Way;
    @Mock
    private SomeService someService;

    @BeforeEach
    void init() {
        java8Way = new Java8Way(someService, Arrays.asList("first", "second", "third"));
    }

    @Test
    void should_iterate_list() {
        //Given

        //Then
        java8Way.iterateList();

        //When
        verify(someService, times(3)).doSomething(anyString());
    }

    @Test
    void should_upper_case_all_elements() {
        //Given

        //Then
       List<String> upperCases =  java8Way.map();

        //When
        assertThat(upperCases).containsExactly("FIRST", "SECOND", "THIRD");
    }

    @Test
    void should_upper_case_one_filtered_string_first() {
        //Given

        //Then
       String result = java8Way.mapFirstFilteredFound("second");

        //When
        assertThat(result).isEqualTo("SECOND");
    }

    @Test
    void should_upper_case_one_filtered_string_any() {
        //Given

        //Then
       String result = java8Way.mapAnyFilteredFound("second");

        //When
        assertThat(result).isEqualTo("SECOND");
    }

    @Test
    void should_return_default_when_filtered_not_found() {
        //Given

        //Then
        String result = java8Way.mapFirstFilteredFound("fourth");

        //When
        assertThat(result).isEqualTo("DEFAULT");
    }

    @Test
    void should_return_first_element_of_list() {
        //Given

        //Then
        String result = java8Way.firstElement();

        //When
        assertThat(result).isEqualTo("first");
    }

    @Test
    void should_map_with_counter_open_range() {
        //Given

        //Then
        List<String> result = java8Way.mapWithCounterOpenRange();

        //When
        assertThat(result).containsExactly("0","1","2");
    }

    @Test
    void should_map_with_counter_close_range() {
        //Given

        //Then
        List<String> result = java8Way.mapWithCounterCloseRange();

        //When
        assertThat(result).containsExactly("0","1","2","3");
    }

    @Test
    void should_map_to_set() {
        //Given

        //Then
        Set<String> result = java8Way.mapToSet();

        //When
        assertThat(result).containsExactlyInAnyOrder("FIRST", "SECOND", "THIRD");
    }

    @Test
    void should_return_unique_values() {
        //Given

        //Then
        List<String> result = java8Way.mapOnlyUnique();

        //When
        assertThat(result).containsExactlyInAnyOrder("FIRST", "SECOND", "THIRD");
    }

    @Test
    void should_return_map() {
        //Given

        //Then
        Map<String,String> result = java8Way.createMap();

        //When
        assertThat(result).containsKeys("first", "second", "third");
        assertThat(result).containsValues("FIRST", "SECOND", "THIRD");
    }

    @Test
    void should_return_map_with_identity() {
        //Given

        //Then
        Map<String,String> result = java8Way.createMapWithIdentity();

        //When
        assertThat(result).containsKeys("first", "second", "third");
        assertThat(result).containsValues("FIRST", "SECOND", "THIRD");
    } //TODO stworzene innej mapy

}