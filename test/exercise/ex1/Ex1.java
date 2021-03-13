package exercise.ex1;

import exercise.ex1.MidFinder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class Ex1 {
    private MidFinder finder = new MidFinder();

    class Spec {
        int[] input;
        int expected;

        public Spec(int[] input, int expected) {
            this.input = input;
            this.expected = expected;
        }
    }

    private List<Spec> inputs = Arrays.asList(
            new Spec(new int[]{1, 2, 5, 7, 10}, 5),
            new Spec(new int[]{2, 3, 2, 7, 11, 23}, 7),
            new Spec(new int[]{}, -1),
            new Spec(new int[]{2, 3, 2, 7, 99, 23}, 23),
            new Spec(new int[]{1, 2, 3, 4}, 2),
            new Spec(new int[]{1, 2, 3, 4, 5, 4}, 3)
    );

    @Test
    public void test() {
        inputs.forEach(spec -> {
            int output = finder.find(spec.input);
            System.out.printf("input: %s, output: %d, result: %b\n", printInput(spec.input), output, (output == spec.expected));
        });
    }

    private String printInput(int[] input) {
        return Arrays.stream(input)
                .mapToObj(String::valueOf)
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
    }

}