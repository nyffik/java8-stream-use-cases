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

    List<String> map() {
        List<String> upperCases = new ArrayList<>();

        for (String string : strings) {
            upperCases.add(string.toUpperCase());
        }
        return upperCases;
    }

    List<String> mapToLinkedList() {
        List<String> upperCases = new LinkedList<>();

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

    Map<String, String> createLinkedHashMap() {
        Map<String, String> result = new LinkedHashMap<>();
        for (String string : strings) {
            result.put(string, string.toUpperCase());
        }
        return result;
    }

    Map<Integer, List<String>> group() {
        Map<Integer, List<String>> result = new HashMap<>();
        for (String string : strings) {
            if (result.containsKey(string.length())) {
                result.get(string.length()).add(string);
            } else {
                List<String> elements = new ArrayList<>();
                elements.add(string);
                result.put(string.length(), elements);
            }
        }
        return result;
    }

    List<String> createSortedDescList() {
        List<String> copy = new ArrayList(strings);
        copy.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        return copy;
    }

    String min() {
        List<String> copy = new ArrayList(strings);
        copy.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        return copy.get(0);
    }

    String join() {
        StringBuilder result = new StringBuilder();
        for (String string : strings) {
            result.append(string + ",");
        }
        return result.substring(0, result.length() - 1);
    }

    List<String> flat() {
        List<List<String>> listOfList = Arrays.asList(Arrays.asList("first", "second"), Arrays.asList("third", "fourth"));

        List<String> result = new ArrayList<>();

        for (List<String> list : listOfList) {
            for (String string : list) {
                result.add(string);
            }
        }
        return result;
    }

    Integer sum() {
        int result = 0;
        for (String string : strings) {
            result += string.length();
        }
        return result;
    }
}
