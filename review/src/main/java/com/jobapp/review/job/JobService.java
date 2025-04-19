package com.jobapp.review.job;

import java.util.List;
import java.util.Optional;

public interface JobService {

    List<Job> get_data();
    boolean add_data(Job job);

    boolean deletejobbyId(Long id);

    Job getjobbyId(Long id);

    boolean updatebyId(Job job, Long id);
}
