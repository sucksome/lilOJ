package suck.some.lilOJ.submission;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

public interface SubmissionRepository extends ListCrudRepository<Submission, Integer> {
    List<Submission> findAllByProblemId(Integer problemId);
}
