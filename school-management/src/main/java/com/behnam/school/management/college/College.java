package com.behnam.school.management.college;

import com.behnam.school.management.course.Course;
import com.behnam.school.management.professor.Professor;
import com.behnam.school.management.student.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class College {

    @Id

    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(updatable = false)
    private Long collegeId;
    @Column(nullable = false, length = 20, unique = true)
    private String collegeName;
    @OneToMany(mappedBy = "studentCollege", cascade = CascadeType.MERGE, fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<Student> studentsInCollege;
    @OneToMany(mappedBy = "professorCollege", cascade = CascadeType.MERGE, fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<Professor> professorsInCollege;
    @OneToMany(mappedBy = "courseCollege", cascade = CascadeType.MERGE, fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<Course> coursesInCollege;

    public College() {
    }

    public College(String collegeName) {
        this.collegeName = collegeName;
    }

    public Long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    public List<Student> getStudentsInCollege() {
        return studentsInCollege;
    }

    public void setStudentsInCollege(List<Student> studentsInCollege) {
        this.studentsInCollege = studentsInCollege;
    }

    public List<Professor> getProfessorsInCollege() {
        return professorsInCollege;
    }

    public void setProfessorsInCollege(List<Professor> professorsInCollege) {
        this.professorsInCollege = professorsInCollege;
    }

    public List<Course> getCoursesInCollege() {
        return coursesInCollege;
    }

    public void setCoursesInCollege(List<Course> coursesInCollege) {
        this.coursesInCollege = coursesInCollege;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    @Override
    public String toString() {
        return "College{" +
                "collegeId=" + collegeId +
                ", collegeName='" + collegeName + '\'' +
                '}';
    }
}
