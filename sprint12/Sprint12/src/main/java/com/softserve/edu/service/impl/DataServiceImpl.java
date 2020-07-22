package com.softserve.edu.service.impl;

import com.softserve.edu.entity.Communication;
import com.softserve.edu.entity.Entity;
import com.softserve.edu.entity.Solution;
import com.softserve.edu.service.DataService;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataServiceImpl implements DataService {
    private List<Entity> students;
    private List<Entity> mentors;
    private List<Entity> sprints;
    private List<Communication> communication;
    private List<Solution> solution;

    public void addStudent(String studentName) {
        if(students==null){
            students = new ArrayList<>();
        }
        for(Entity x:students){
            if(x.equals(new Entity(studentName)))
                return;
        }
        students.add(new Entity(studentName));
    }

    public void addMentor(String mentorName) {
        if(mentors==null){
            mentors = new ArrayList<>();
        }
        for(Entity x:mentors){
            if(x.equals(new Entity(mentorName)))
                return;
        }
        mentors.add(new Entity(mentorName));
    }

    public void addSprint(String sprintName) {
        if(sprints==null){
            sprints = new ArrayList<>();
        }
        for(Entity x:sprints){
            if(x.equals(new Entity(sprintName)))
                return;
        }
        sprints.add(new Entity(sprintName));
    }

    public void addCommunication(String studentName, String mentorName) {
        int studentId = getStudentId(studentName);
        int mentorId = getMentorId(mentorName);

        if (studentId != -1 && mentorId != -1) {
            if(communication==null){
                communication = new ArrayList<>();
            }
            for(Communication x:communication){
                if(x.equals(new Communication(studentId,mentorId)))
                    return;
            }
            communication.add(new Communication(studentId, mentorId));
        }
    }

    public void addSolution(String studentName, String sprintName, int score) {
        int studentId = getStudentId(studentName);
        int sprintId = getSprintId(sprintName);

        if (studentId != -1 && sprintId != -1) {
            if(solution==null){
                solution = new ArrayList<>();
            }
            for(Solution x:solution){
                if(x.equals(new Solution(studentId,sprintId,score)))
                    return;
            }
            solution.add(new Solution(studentId, sprintId, score));
        }
    }

    public int getStudentId(String studentName) {
        Entity student = students.stream().filter(x -> x.getName().equals(studentName)).findFirst().orElse(null);
        return student != null ? student.getId() : -1;
    }

    public int getMentorId(String mentorName) {
        Entity mentor = mentors.stream().filter(x -> x.getName().equals(mentorName)).findFirst().orElse(null);
        return mentor != null ? mentor.getId() : -1;

    }

    public int getSprintId(String sprintName) {
        Entity sprint = sprints.stream().filter(x -> x.getName().equals(sprintName)).findFirst().orElse(null);
        return sprint != null ? sprint.getId() : -1;
    }

    @Override
    public String getStudentName(int studentId) {
        return students.stream().filter(x -> x.getId() == studentId).findFirst().orElse(null).getName();
    }

    @Override
    public String getMentorName(int mentorId) {
        return mentors.stream().filter(x -> x.getId() == mentorId).findFirst().orElse(null).getName();

    }

    @Override
    public String getSprintName(int sprintId) {
        return sprints.stream().filter(x -> x.getId() == sprintId).findFirst().orElse(null).getName();
    }

    public List<Entity> getStudents() {
        return students;
    }

    public List<Entity> getMentors() {
        return mentors;
    }

    public List<Entity> getSprints() {
        return sprints;
    }

    public List<Communication> getCommunication() {
        return communication;
    }

    public List<Solution> getSolution() {
        return solution;
    }
}
