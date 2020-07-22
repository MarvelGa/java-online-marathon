package com.softserve.edu.dto;

import java.util.List;
import java.util.Objects;

public class MentorStudent {
    private String mentorName;
    private List<String> studentNames;

    public MentorStudent(String mentorName, List<String> studentNames) {
        this.mentorName = mentorName;
        this.studentNames = studentNames;
    }

    public String getMentorName() {
        return mentorName;
    }

    public List<String> getStudentNames() {
        return studentNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MentorStudent that = (MentorStudent) o;
        return Objects.equals(mentorName, that.mentorName) &&
                Objects.equals(studentNames, that.studentNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mentorName, studentNames);
    }
}
