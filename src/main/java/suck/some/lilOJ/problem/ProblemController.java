package suck.some.lilOJ.problem;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class ProblemController {

    private final ProblemRepository problemRepository;

    public ProblemController(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    @GetMapping("/problems/")
    public List<Problem> getAllProblems() {
        return problemRepository.findAll();
    }

    @GetMapping("/problems/{id}/")
    public Problem findProblemById(@PathVariable Integer id) {
        Optional<Problem> problem = problemRepository.findById(id);
        if (problem.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Problem not found");
        }
        return problem.get();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/problems/create")
    void createProblem(@Valid @RequestBody Problem problem) {
        problemRepository.save(problem);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("problems/{id}/edit")
    void updateProblem(@PathVariable String id, @Valid @RequestBody Problem problem) {
        problemRepository.save(problem);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("problems/{id}/delete")
    void deleteProblem(@PathVariable Integer id) {
        problemRepository.deleteById(id);
    }

    @PostConstruct
    private void init() {
        System.out.println("Number of problems: " + problemRepository.count());
        if (problemRepository.count() == 0) {
            problemRepository
                    .save(new Problem(1, "A+B Problem", "Calculate the sum of two integers", "1 2", "3", "admin",
                            null));
            problemRepository.save(
                    new Problem(2, "A-B Problem", "Calculate the difference of two integers", "1 2", "-1", "admin",
                            null));
            problemRepository.save(
                    new Problem(3, "A*B Problem", "Calculate the product of two integers", "2 3",
                            "6", "admin", null));
            problemRepository.save(
                    new Problem(4, "A/B Problem", "Calculate the quotient of two integers", "6 3", "2", "admin", null));
        }
    }
}
