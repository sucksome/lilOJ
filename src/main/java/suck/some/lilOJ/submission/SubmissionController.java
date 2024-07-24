package suck.some.lilOJ.submission;

import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class SubmissionController {

    private final SubmissionRepository submissionRepository;

    public SubmissionController(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    @GetMapping("/problems/{id}/submissions/")
    public List<Submission> getSubmissionsByProblem(@PathVariable Integer id) {
        return submissionRepository.findAllByProblemId(id);
    }

    @PostConstruct
    public void init() {
        if (submissionRepository.count() == 0) {
            submissionRepository.save(new Submission(null, 1, "print('Hello, World!')", "Python", "admin", "Accepted",
                    LocalDateTime.now(), 100, 0.5));
        }
    }

}
