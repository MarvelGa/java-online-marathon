package com.softserve.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.softserve.edu.dto.AverageScore;
import com.softserve.edu.dto.MentorStudent;
import com.softserve.edu.dto.SprintScore;
import com.softserve.edu.dto.StudentScore;
import com.softserve.edu.entity.Communication;
import com.softserve.edu.entity.Entity;
import com.softserve.edu.entity.Solution;
import com.softserve.edu.service.impl.DataServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.softserve.edu.service.DataService;
import com.softserve.edu.service.MarathonService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private MarathonService marathonService;

    @Autowired
    private DataService dataService;

    @Autowired
    public ApplicationTest(MarathonService marathonService) {
        this.marathonService = marathonService;
        this.dataService = new DataServiceImpl();
        fillDataService();
    }

    @Autowired
    private void fillDataService() {

        dataService.addMentor("Mentor #1");
        dataService.addMentor("Mentor #2");
        dataService.addMentor("Mentor #3");
        dataService.addMentor("Mentor #3");


        dataService.addSprint("sprint01");
        dataService.addSprint("sprint02");
        dataService.addSprint("sprint02");

        dataService.addStudent("Student #1");
        dataService.addStudent("Student #2");
        dataService.addStudent("Student #2");
        dataService.addStudent("Student #3");
        dataService.addStudent("Student #4");
        dataService.addStudent("Student #5");

        dataService.addCommunication("Student #1", "Mentor #2");
        dataService.addCommunication("Student #1", "Mentor #2");
        dataService.addCommunication("Student #2", "Mentor #1");
        dataService.addCommunication("Student #3", "Mentor #1");
        dataService.addCommunication("Student #4", "Mentor #1");
        dataService.addCommunication("Student #5", "Mentor #2");
        dataService.addCommunication("Student #6", "Mentor #2");
        dataService.addCommunication("Student #7", "Mentor #2");
        dataService.addCommunication("Student #8", "Mentor #1");
        dataService.addCommunication("Student #9", "Mentor #1");
        dataService.addCommunication("Student #10", "Mentor #2");

        dataService.addSolution("Student #1", "sprint01", 5);
        dataService.addSolution("Student #2", "sprint01", 4);
        dataService.addSolution("Student #3", "sprint01", 2);
        dataService.addSolution("Student #3", "sprint01", 2);
        dataService.addSolution("Student #4", "sprint01", 5);
        dataService.addSolution("Student #5", "sprint01", 5);
        dataService.addSolution("Student #6", "sprint01", 5);
        dataService.addSolution("Student #7", "sprint01", 4);
        dataService.addSolution("Student #8", "sprint01", 4);
        dataService.addSolution("Student #10", "sprint01", 3);

        dataService.addSolution("Student #1", "sprint02", 4);
        dataService.addSolution("Student #2", "sprint02", 3);
        dataService.addSolution("Student #3", "sprint02", 3);
        dataService.addSolution("Student #3", "sprint02", 3);
        dataService.addSolution("Student #4", "sprint02", 2);
        dataService.addSolution("Student #5", "sprint02", 2);
        dataService.addSolution("Student #6", "sprint02", 1);
        dataService.addSolution("Student #7", "sprint02", 4);
        dataService.addSolution("Student #8", "sprint02", 4);
        dataService.addSolution("Student #9", "sprint02", 5);

    }

    @Test
    public void checkGetStudents() {
        List<String> expected = new ArrayList<>();
        expected.add("Student #1");
        expected.add("Student #2");
        expected.add("Student #3");
        expected.add("Student #4");
        expected.add("Student #5");
        List<String> actual = marathonService.getStudents();
        Assertions.assertEquals(expected, actual, "checkGetStudents()");
    }

    @Test
    public void checkGetMentors() {
        List<String> expected = new ArrayList<>();
        expected.add("Mentor #1");
        expected.add("Mentor #2");
        expected.add("Mentor #3");
        List<String> actual = marathonService.getMentors();
        Assertions.assertEquals(expected, actual, "checkGetMentors()");
    }

    @Test
    public void checkGetSprints() {
        List<String> expected = new ArrayList<>();
        expected.add("sprint01");
        expected.add("sprint02");
        List<String> actual = dataService.getSprints().stream().map(x -> x.getName()).collect(Collectors.toList());
        Assertions.assertEquals(expected, actual, "checkGetSprints()");
    }

    @Test
    public void checkGetCommunications() {
        List<Communication> expected = new ArrayList<>();
        expected.add(new Communication(dataService.getStudentId("Student #1"), dataService.getMentorId("Mentor #2")));
        expected.add(new Communication(dataService.getStudentId("Student #2"), dataService.getMentorId("Mentor #1")));
        expected.add(new Communication(dataService.getStudentId("Student #3"), dataService.getMentorId("Mentor #1")));
        expected.add(new Communication(dataService.getStudentId("Student #4"), dataService.getMentorId("Mentor #1")));
        expected.add(new Communication(dataService.getStudentId("Student #5"), dataService.getMentorId("Mentor #2")));
        List<Communication> actual = dataService.getCommunication();
        Assertions.assertEquals(expected, actual, "checkGetCommunications()");
    }

    @Test
    public void checkGetSolutions() {
        List<Solution> expected = new ArrayList<>();
        expected.add(new Solution(dataService.getStudentId("Student #1"), dataService.getSprintId("sprint01"), 5));
        expected.add(new Solution(dataService.getStudentId("Student #2"), dataService.getSprintId("sprint01"), 4));
        expected.add(new Solution(dataService.getStudentId("Student #3"), dataService.getSprintId("sprint01"), 2));
        expected.add(new Solution(dataService.getStudentId("Student #4"), dataService.getSprintId("sprint01"), 5));
        expected.add(new Solution(dataService.getStudentId("Student #5"), dataService.getSprintId("sprint01"), 5));

        expected.add(new Solution(dataService.getStudentId("Student #1"), dataService.getSprintId("sprint02"), 4));
        expected.add(new Solution(dataService.getStudentId("Student #2"), dataService.getSprintId("sprint02"), 3));
        expected.add(new Solution(dataService.getStudentId("Student #3"), dataService.getSprintId("sprint02"), 3));
        expected.add(new Solution(dataService.getStudentId("Student #4"), dataService.getSprintId("sprint02"), 2));
        expected.add(new Solution(dataService.getStudentId("Student #5"), dataService.getSprintId("sprint02"), 2));

        List<Solution> actual = dataService.getSolution();
        Assertions.assertEquals(expected, actual, "checkGetSolutions()");
    }


    @Test
    public void checkStudentResult() {
        List<SprintScore> sprintScores = new ArrayList<>();
        StudentScore expected = new StudentScore("Student #1", sprintScores);
        sprintScores.add(new SprintScore("sprint01", 5));
        sprintScores.add(new SprintScore("sprint02", 4));

        StudentScore actual = marathonService.studentResult("Student #1");

        Assertions.assertEquals(expected, actual, "checkStudentResult");
    }

    @Test
    public void checkAllStudentScores() {
        List<StudentScore> expected = new ArrayList<>();
        expected.add(new StudentScore("Student #1", new ArrayList<SprintScore>() {{
            add(new SprintScore("sprint01", 5));
            add(new SprintScore("sprint02", 4));
        }}));
        expected.add(new StudentScore("Student #2", new ArrayList<SprintScore>() {{
            add(new SprintScore("sprint01", 4));
            add(new SprintScore("sprint02", 3));
        }}));
        expected.add(new StudentScore("Student #3", new ArrayList<SprintScore>() {{
            add(new SprintScore("sprint01", 2));
            add(new SprintScore("sprint02", 3));
        }}));
        expected.add(new StudentScore("Student #4", new ArrayList<SprintScore>() {{
            add(new SprintScore("sprint01", 5));
            add(new SprintScore("sprint02", 2));
        }}));
        expected.add(new StudentScore("Student #5", new ArrayList<SprintScore>() {{
            add(new SprintScore("sprint01", 5));
            add(new SprintScore("sprint02", 2));
        }}));
        List<StudentScore> actual = marathonService.allStudentsResult();
        Assertions.assertEquals(expected, actual, "checkAllStudentScores()");
    }

    @Test
    public void checkStudentAverageScore() {
        AverageScore expected = new AverageScore("Student #1", 4.5);
        AverageScore actual = marathonService.studentAverage("Student #1");
        Assertions.assertEquals(expected, actual, "checkStudentAverageScore");
    }

    @Test
    public void checkAllStudentAverage() {
        List<AverageScore> expected = new ArrayList<>();
        expected.add(new AverageScore("Student #1", 4.5));
        expected.add(new AverageScore("Student #2", 3.5));
        expected.add(new AverageScore("Student #3", 2.5));
        expected.add(new AverageScore("Student #4", 3.5));
        expected.add(new AverageScore("Student #5", 3.5));
        List<AverageScore> actual = marathonService.allStudentsAverage();
        Assertions.assertEquals(expected, actual, "checkAllStudentAverage()");
    }

    @Test
    public void checkMentorStudents() {
        List<MentorStudent> expected = new ArrayList<>();
        expected.add(new MentorStudent("Mentor #1", new ArrayList<String>() {{
            add("Student #2");
            add("Student #3");
            add("Student #4");
        }}));
        expected.add(new MentorStudent("Mentor #2", new ArrayList<String>() {{
            add("Student #1");
            add("Student #5");
        }}));
        expected.add(new MentorStudent("Mentor #3",new ArrayList<String>()));

        List<MentorStudent> actual = new ArrayList<>();
        List<String> mentors = marathonService.getMentors();
        for (String x : mentors) {
            actual.add(marathonService.mentorStudents(x));
        }
        Assertions.assertEquals(expected, actual, "checkMentorStudents()");
    }

}
