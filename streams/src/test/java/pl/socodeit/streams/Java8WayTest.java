package pl.socodeit.streams;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

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
        List<String> upperCases = java8Way.map();

        //When
        assertThat(upperCases).isInstanceOf(ArrayList.class).containsExactly("FIRST", "SECOND", "THIRD");
    }

    @Test
    void should_return_arrayList() {
        //Given

        //Then
        List<String> upperCases = java8Way.map();

        //When
        assertThat(upperCases).isInstanceOf(ArrayList.class);
    }

    @Test
    void should_return_linkedList() {
        //Given

        //Then
        List<String> upperCases = java8Way.mapToLinkedList();

        //When
        assertThat(upperCases).isInstanceOf(LinkedList.class);
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
        assertThat(result).containsExactly("0", "1", "2");
    }

    @Test
    void should_map_with_counter_close_range() {
        //Given

        //Then
        List<String> result = java8Way.mapWithCounterCloseRange();

        //When
        assertThat(result).containsExactly("0", "1", "2", "3");
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
        Map<String, String> result = java8Way.createMap();

        //When
        assertThat(result).containsKeys("first", "second", "third");
        assertThat(result).containsValues("FIRST", "SECOND", "THIRD");
    }

    @Test
    void should_return_map_with_identity() {
        //Given

        //Then
        Map<String, String> result = java8Way.createMapWithIdentity();

        //When
        assertThat(result).containsKeys("first", "second", "third");
        assertThat(result).containsValues("FIRST", "SECOND", "THIRD");
    }

    @Test
    void should_return_hashMap() {
        //Given

        //Then
        Map<String, String> result = java8Way.createMapWithIdentity();

        //When
        assertThat(result).isInstanceOf(HashMap.class);
    }

    @Test
    void should_return_linkedHashMap() {
        //Given

        //Then
        Map<String, String> result = java8Way.createLinkedHashMap();

        //When
        assertThat(result).isInstanceOf(LinkedHashMap.class);
    }

    @Test
    void should_group_by_length() {
        //Given

        //Then
        Map<Integer, List<String>> result = java8Way.group();

        //When
        assertThat(result).hasSize(2)
                .containsEntry(6, Lists.list("second"))
                .containsEntry(5, Lists.list("first", "third"));
    }

    @Test
    void should_return_linkedHashMap_other_way() {
        //Given

        //Then
        Map<String, String> result = java8Way.createLinkedHashMapOtherWay();

        //When
        assertThat(result).isInstanceOf(LinkedHashMap.class);
    }

    @Test
    void should_return_sorted_desc_list() {
        //Given

        //Then
        List<String> result = java8Way.createSortedDescList();

        //When
        assertThat(result).containsExactly("second", "first", "third");
    }

    @Test
    void should_return_min() {
        //Given

        //Then
        String result = java8Way.min();

        //When
        assertThat(result).isEqualTo("second");
    }

    @Test
    void should_join_list() {
        //Given

        //Then
        String result = java8Way.join();

        //When
        assertThat(result).isEqualTo("first,second,third");
    }

    @Test
    void should_joinStream_list() {
        //Given

        //Then
        String result = java8Way.joinStream();

        //When
        assertThat(result).isEqualTo("first,second,third");
    }

    @Test
    void should_flat() {
        //Given

        //Then
        List<String> result = java8Way.flat();

        //When
        assertThat(result).containsExactly("first", "second", "third", "fourth");
    }

    @Test
    void should_sum_string_length() {
        //Given

        //Then
        Integer result = java8Way.sum();

        //When
        assertThat(result).isEqualTo(16);
    }

    @Test
    void should_sum_by_reduce_string_length() {
        //Given

        //Then
        Integer result = java8Way.sumByReduce();

        //When
        assertThat(result).isEqualTo(16);
    }

}