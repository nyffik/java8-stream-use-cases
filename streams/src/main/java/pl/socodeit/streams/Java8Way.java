package pl.socodeit.streams;

import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
class Java8Way {

    private final SomeService someService;
    private final List<String> strings;

    void iterateList() {

        strings.forEach(someService::doSomething);
    }

    List<String> map() {
        return strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    Set<String> mapToSet() {
        return strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
    }

    List<String> mapToLinkedList() {
        return strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    String mapFirstFilteredFound(String filter) {
        return strings.stream()
                .filter(s -> s.equals(filter))
                .map(String::toUpperCase)
                .findFirst()
                .orElse("DEFAULT");
    }

    String mapAnyFilteredFound(String filter) {
        return strings.stream()
                .filter(s -> s.equals(filter))
                .map(String::toUpperCase)
                .findAny()
                .orElse("DEFAULT");
    }

    String firstElement() {
        return strings.stream().findFirst().get();
    }

    List<String> mapWithCounterOpenRange() {
        return IntStream.range(0, strings.size())
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());
    }

    List<String> mapWithCounterCloseRange() {
        return IntStream.rangeClosed(0, strings.size())
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());
    }

    List<String> mapOnlyUnique() {
        List<String> stringsWithDuplicates = Arrays.asList("first", "second", "third", "second");

        return stringsWithDuplicates.stream()
                .distinct()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    Map<String, String> createMap() {
        return strings.stream()
                .collect(Collectors.toMap(s -> s, String::toUpperCase));
    }

    Map<String, String> createMapWithIdentity() {
        return strings.stream()
                .collect(Collectors.toMap(Function.identity(), String::toUpperCase));
    }

    Map<String, String> createLinkedHashMap() {
        return strings.stream()
                .collect(Collectors.toMap(s -> s, String::toUpperCase, (key1, key2) -> key1, LinkedHashMap::new));
    }

    Map<String, String> createLinkedHashMapOtherWay() {
        return strings.stream()
                .collect(
                        LinkedHashMap::new,
                        (map, s) -> map.put(s, s.toUpperCase()),
                        Map::putAll);
    }

    List<String> createSortedDescList() {
        return strings.stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .collect(Collectors.toList());
    }

    String min() {
        return strings.stream()
                .min(Comparator.comparing(String::length).reversed())
                .get();
    }

    Map<Integer, List<String>> group() {
        return strings.stream()
                .collect(Collectors.groupingBy(String::length));
    }

    String joinStream() {
        return strings.stream().collect(Collectors.joining(","));
    }

    String join() {
        return String.join(",", strings);
    }

    List<String> flat() {
        List<List<String>> listOfList = Arrays.asList(Arrays.asList("first", "second"), Arrays.asList("third", "fourth"));

        return listOfList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    Integer sum() {
        return strings.stream().map(String::length).collect(Collectors.summingInt(Integer::intValue));
    }

    Integer sumByReduce() {
        return strings.stream().map(String::length).reduce(0, (a, b) -> a + b);
    }
}
