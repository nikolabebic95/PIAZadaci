/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import entities.Exam;
import java.util.Date;

/**
 *
 * @author Nikola
 */
public class PassedExamBean {
    private String name;
    private int grade;
    private Date date;

    public PassedExamBean() {
    }
    
    public PassedExamBean(Exam exam) {
        name = exam.getName();
        grade = exam.getGrade();
        date = exam.getDate();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
