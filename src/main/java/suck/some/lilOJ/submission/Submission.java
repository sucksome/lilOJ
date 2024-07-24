package suck.some.lilOJ.submission;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("submissions")
public record Submission(
        @Id Integer id,
        Integer problemId,
        String code,
        String language,
        String username,
        String verdict,
        LocalDateTime submissionTime,
        Integer runtime, // in milliseconds
        Double memory // in MB
) {
}
