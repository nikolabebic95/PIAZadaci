/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.util.ArrayList;

/**
 *
 * @author Nikola
 */
public class ExamsListBean {
    private ArrayList<ExamBean> list = new ArrayList<>();

    public ArrayList<ExamBean> getList() {
        return list;
    }

    public void setList(ArrayList<ExamBean> list) {
        this.list = list;
    }
    
    public void add(ExamBean examBean) {
        list.add(examBean);
    }
}
