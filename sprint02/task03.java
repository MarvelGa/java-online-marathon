//часу не хватило допрацювати

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Student extends Person {
    private String studyPlace;
    private int studyYears;

    public Student(String name, String studyPlace, int studyYears) {
        super(name);

        this.studyPlace = studyPlace;
        this.studyYears = studyYears;
    }

    public String getStudyPlace() {
        return studyPlace;
    }

    public int getStudyYears() {
        return studyYears;
    }

    @Override
    public String toString() {
        return "Student[" + "name=" + getName() +
                ", studyPlace=" + studyPlace +
                ", studyYears=" + studyYears +
                ']';
    }

}

class Worker extends Person {
    private String workPosition;
    private int experienceYears;

    public Worker(String name, String workPosition, int experienceYears) {
        super(name);
        this.workPosition = workPosition;
        this.experienceYears = experienceYears;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    @Override
    public String toString() {
        return "Worker[" +
                "name=" + getName() +
                ", workPosition=" + workPosition +
                ", experienceYears=" + experienceYears +
                ']';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + experienceYears;
        result = prime * result + ((workPosition == null) ? 0 : workPosition.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)
                || (getClass() != obj.getClass())) {
            return false;
        }
        Worker other = (Worker) obj;
        if ((workPosition == null) && (other.workPosition != null)
                || (workPosition != null) && (other.workPosition == null)) {
            return false;
        } else if ((workPosition == null) && (other.workPosition == null)) {
            return experienceYears == other.experienceYears;
        }
        return (workPosition.equals(other.workPosition))
                && (experienceYears == other.experienceYears);
    }

}

class MyUtils {
    public List<Person> maxDuration(final List<Person> persons) {
        List<Person> result = new ArrayList<Person>();
        Integer studentDuraction = -1;
        Integer workerDuraction = -1;
        if (persons !=null ) {
            for (Person elem : persons) {
                if (elem.getClass() == Student.class) {
                    if (((Student) elem).getStudyYears() >= studentDuraction)
                        studentDuraction = ((Student) elem).getStudyYears();
                }
                if (elem.getClass() == Worker.class) {
                    if (((Worker) elem).getExperienceYears() >= workerDuraction)
                        workerDuraction = ((Worker) elem).getExperienceYears();
                }
            }
            for (Person elem : persons) {
                if (studentDuraction >= 0 && elem.getClass() == Student.class) {
                    if (((Student) elem).getStudyYears() == studentDuraction) {
                        result.add(elem);
                    }
                }
                if (workerDuraction >= 0 && elem.getClass() == Worker.class) {
                    if (((Worker) elem).getExperienceYears() == workerDuraction) {
                        result.add(elem);
                    }
                }
            }
            return result;
        }
        result.add(null);
        return result;
    }
}
