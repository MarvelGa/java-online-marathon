package com.softserve.edu.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.softserve.edu.dto.SprintScore;
import com.softserve.edu.entity.Entity;
import com.softserve.edu.entity.Solution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserve.edu.dto.AverageScore;
import com.softserve.edu.dto.MentorStudent;
import com.softserve.edu.dto.StudentScore;
import com.softserve.edu.service.DataService;
import com.softserve.edu.service.MarathonService;

@Service
public class MarathonServiceImpl implements MarathonService {
    private DataService dataService;

    @Autowired
    public MarathonServiceImpl(DataService dataService) {
        this.dataService = dataService;
    }

    public List<String> getStudents() {
        return dataService.getStudents().stream().map(Entity::getName).collect(Collectors.toList());
    }

    public List<String> getMentors() {
        return dataService.getMentors().stream().map(Entity::getName).collect(Collectors.toList());

    }

    public StudentScore studentResult(String studentName) {
        List<SprintScore> sprintScores = new ArrayList<>();
        List<Solution> solutions = dataService
                .getSolution()
                .stream()
                .filter(x -> x.getIdStudent() == dataService.getStudentId(studentName))
                .collect(Collectors.toList());
        for (Solution x : solutions) {
            sprintScores.add(new SprintScore(dataService.getSprintName(x.getIdSprint()), x.getScore()));
        }
        return new StudentScore(studentName, sprintScores);
    }

    public List<StudentScore> allStudentsResult() {
        List<StudentScore> studentResults = new ArrayList<>();
        for (Entity x : dataService.getStudents()) {
            studentResults.add(studentResult(x.getName()));
        }
        return studentResults;
    }

    public AverageScore studentAverage(String studentName) {
        StudentScore score = studentResult(studentName);
        int sum = score.getSprintScore().stream().map(SprintScore::getScore).reduce(0, Integer::sum);
        return new AverageScore(studentName, (double)sum / score.getSprintScore().size());
    }

    public List<AverageScore> allStudentsAverage() {
        List<AverageScore> averageScores = new ArrayList<>();
        for (Entity x : dataService.getStudents()) {
            averageScores.add(studentAverage(x.getName()));
        }
        return averageScores;
    }

    public MentorStudent mentorStudents(String mentorName) {
        int id = dataService.getMentorId(mentorName);
        if (id!= -1) {
            List<String>students = dataService
                    .getCommunication()
                    .stream()
                    .filter(x->x.getIdMentor()==id)
                    .map(x->dataService.getStudentName(x.getIdStudent()))
                    .collect(Collectors.toList());
            return new MentorStudent(mentorName,students);
        } else {
            return null;
        }
    }
}
