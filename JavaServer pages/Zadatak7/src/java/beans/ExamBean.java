/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import entities.Exam;

/**
 *
 * @author Nikola
 */
public class ExamBean {
    private int studentId;
    private String firstName;
    private String lastName;
    private int year;
    private String examName;
    private int grade;

    public ExamBean() {
    }

    public ExamBean(int studentId, String firstName, String lastName, int year, String examName, int grade) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.examName = examName;
        this.grade = grade;
    }

    public ExamBean(Exam exam) {
        studentId = exam.getStudentId().getId();
        firstName = exam.getStudentId().getFirstName();
        lastName = exam.getStudentId().getLastName();
        year = exam.getStudentId().getYear();
        examName = exam.getName();
        grade = exam.getGrade();
    }
    
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
