package suck.some.lilOJ.problem;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;

public record Problem(
        Integer id,
        @NotEmpty String title,
        String descripion,
        List<String> sampleInput,
        List<String> sampleOutput,
        @NotEmpty String author

) {
}
