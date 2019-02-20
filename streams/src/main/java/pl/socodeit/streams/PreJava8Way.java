package pl.socodeit.streams;

import lombok.RequiredArgsConstructor;

import java.util.*;

@RequiredArgsConstructor
class PreJava8Way {

    private final SomeService someService;
    private final List<String> strings;

    void iterateList() {
        for (String string : strings) {
            someService.doSomething(string);
        }
    }

    List<String> mapToUpperCase() {
        List<String> upperCases = new ArrayList<>();

        for (String string : strings) {
            upperCases.add(string.toUpperCase());
        }
        return upperCases;
    }


     Set<String> mapToSet() {
        Set<String> upperCases = new HashSet<>();

        for (String string : strings) {
            upperCases.add(string.toUpperCase());
        }
        return upperCases;
    }

     String mapFirstFilteredFound(String filter) {
        for (String string : strings) {
            if (string.equals(filter)) {
                return string.toUpperCase();
            }
        }
        return "DEFAULT";
    }

     String firstElement() {
        return strings.get(0);
    }

     List<String> mapWithCounterOpenRange() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            result.add(String.valueOf(i));
        }
        return result;
    }

     List<String> mapWithCounterCloseRange() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= strings.size(); i++) {
            result.add(String.valueOf(i));
        }
        return result;
    }

    List<String> mapOnlyUnique() {
        List<String> stringsWithDuplicates = Arrays.asList("first", "second", "third", "second");
        List<String> upperCasesWithoutDuplicates = new ArrayList<>();

        for (String string : stringsWithDuplicates) {
            if (!upperCasesWithoutDuplicates.contains(string.toUpperCase())) {
                upperCasesWithoutDuplicates.add(string.toUpperCase());
            }
        }
        return upperCasesWithoutDuplicates;
    }


    Map<String, String> createMap() {
        Map<String, String> result = new HashMap<>();
        for (String string : strings) {
            result.put(string, string.toUpperCase());
        }
        return result;
    }
}
