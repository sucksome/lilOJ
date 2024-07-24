package suck.some.lilOJ.problem;

// import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotEmpty;

@Table("problems")
public record Problem(
                @Id Integer id,
                @NotEmpty String title,
                String description,
                String sampleInput,
                String sampleOutput,
                @NotEmpty String author,
                @Version Integer version

) {
}
