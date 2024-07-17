package suck.some.lilOJ.problem;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
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

    @GetMapping("/problems")
    public List<Problem> getAllProblems() {
        return problemRepository.findAll();
    }

    @GetMapping("/problems/{id}")
    public Problem findProblemById(@PathVariable Integer id) {
        Optional<Problem> problem = problemRepository.findById(id);
        if (problem.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Problem not found");
        }
        return problem.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/problems/create")
    void createProblem(@Valid @RequestBody Problem problem) {
        problemRepository.create(problem);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("problems/{id}/edit")
    void updateProblem(@PathVariable String id, @Valid @RequestBody Problem problem) {
        problemRepository.update(problem);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("problems/{id}/delete")
    void deleteProblem(@PathVariable Integer id) {
        problemRepository.delete(id);
    }
}
