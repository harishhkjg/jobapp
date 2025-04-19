package com.jobapp.review.job;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    private JobServiceImpl jobservice;

    public JobController(JobServiceImpl jobservice) {
        this.jobservice = jobservice;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> getjobs(){
       //return jobservice.get_data();
        return new ResponseEntity<>(jobservice.get_data(),HttpStatus.OK);
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> addjob (@RequestBody Job jobvalue) {

        boolean isJobAdded = jobservice.add_data(jobvalue);

        if(isJobAdded) {
            return new ResponseEntity<>("Job added Successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Job Not added Successfully", HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String>  deletejobbyid(@PathVariable Long id)
    {
        boolean deleted  =   jobservice.deletejobbyId(id);
        if(deleted  == true) {
            return new ResponseEntity<>("Job added Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Job Not added Successfully",HttpStatus.NOT_FOUND);

    }

    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable Long id){
        return jobservice.getjobbyId(id);
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateJobById(@RequestBody Job job,@PathVariable Long id) {
     boolean updated  = jobservice.updatebyId(job,id);
     if(updated  == true) {
         return new ResponseEntity<>("Job Updated Successfully", HttpStatus.OK);
     }
        return new ResponseEntity<>("Job Not Updated Successfully", HttpStatus.NOT_FOUND);


    }
}
