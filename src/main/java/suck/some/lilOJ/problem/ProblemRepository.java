package suck.some.lilOJ.problem;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;
// import org.springframework.stereotype.Repository;

// import jakarta.annotation.PostConstruct;

public interface ProblemRepository extends ListCrudRepository<Problem, Integer> {

    // private final List<Problem> problems = new ArrayList<>();

    // List<Problem> findAll() {
    // return problems;
    // }

    // Optional<Problem> findById(Integer id) {
    // return problems.stream().filter(problem ->
    // problem.id().equals(id)).findFirst();
    // }

    // void create(Problem problem) {
    // problems.add(problem);
    // }

    // void delete(Integer id) {
    // Optional<Problem> problem = findById(id);
    // if (problem.isEmpty()) {
    // throw new IllegalArgumentException("Problem not found");
    // }
    // problems.remove(problem.get());
    // }

    // void update(Problem problem) {
    // Optional<Problem> existingProblem = findById(problem.id());
    // if (existingProblem.isEmpty()) {
    // throw new IllegalArgumentException("Problem not found");
    // }
    // problems.set(problems.indexOf(existingProblem.get()), problem);
    // }

}
