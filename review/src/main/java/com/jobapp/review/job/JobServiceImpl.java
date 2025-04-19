package com.jobapp.review.job;

import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;


@Service
public class JobServiceImpl implements JobService{

    private JobRepository jobrepo;

    public JobServiceImpl(JobRepository jobrepo) {
        this.jobrepo = jobrepo;
    }

    @Override
    public List<Job> get_data() {
        return jobrepo.findAll();
    }

    public boolean add_data(Job job) {
        if (job != null) {
            Job savedJob = jobrepo.save(job); // Save the job and capture the returned entity
            return savedJob != null;  // Check if the saved entity is not null
        }
        return false;  // Return false if the job is null
    }

    public boolean deletejobbyId(Long id) {
        Optional<Job> isfind  = jobrepo.findById(id);
        if(isfind.isPresent()){
            jobrepo.deleteById(id);
            return true;
        }
        return false;
    }

    public Job getjobbyId(Long id) {
         return jobrepo.findById(id).orElse(null);
    }

    public boolean updatebyId(Job job, Long id) {
        Optional<Job> findjob = jobrepo.findById(id);
        if(findjob.isPresent()) {
            Job job_ref = findjob.get();
            job_ref.setTitle(job.getTitle());
            job_ref.setDescription(job.getDescription());
            job_ref.setMaxsalary(job.getMaxsalary());
            job_ref.setMinsalary(job.getMinsalary());
            jobrepo.save(job_ref);
            return  true;
        }
        return false;
    }


}
