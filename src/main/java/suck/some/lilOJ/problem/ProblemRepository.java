package suck.some.lilOJ.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class ProblemRepository {

    private final List<Problem> problems = new ArrayList<>();

    List<Problem> findAll() {
        return problems;
    }

    Optional<Problem> findById(Integer id) {
        return problems.stream().filter(problem -> problem.id().equals(id)).findFirst();
    }

    void create(Problem problem) {
        problems.add(problem);
    }

    void delete(Integer id) {
        Optional<Problem> problem = findById(id);
        if (problem.isEmpty()) {
            throw new IllegalArgumentException("Problem not found");
        }
        problems.remove(problem.get());
    }

    void update(Problem problem) {
        Optional<Problem> existingProblem = findById(problem.id());
        if (existingProblem.isEmpty()) {
            throw new IllegalArgumentException("Problem not found");
        }
        problems.set(problems.indexOf(existingProblem.get()), problem);
    }

    @PostConstruct
    private void init() {
        problems.add(new Problem(1, "A+B Problem", "Calculate the sum of two integers", List.of("1 2", "3 4"),
                List.of("3", "7"), "admin"));
        problems.add(new Problem(2, "A-B Problem", "Calculate the difference of two integers", List.of("1 2", "3 4"),
                List.of("-1", "-1"), "admin"));
        problems.add(new Problem(3, "A*B Problem", "Calculate the product of two integers", List.of("1 2", "3 4"),
                List.of("2", "12"), "admin"));
        problems.add(new Problem(4, "A/B Problem", "Calculate the quotient of two integers", List.of("1 2", "3 4"),
                List.of("0", "0"), "admin"));
    }
}
