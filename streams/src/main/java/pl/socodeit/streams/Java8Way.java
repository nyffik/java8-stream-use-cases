package pl.socodeit.streams;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
}
