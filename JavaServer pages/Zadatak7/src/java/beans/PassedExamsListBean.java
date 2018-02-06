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
public class PassedExamsListBean {
    private ArrayList<PassedExamBean> list = new ArrayList<>();
    private int addedIndex = -1;

    public PassedExamsListBean() {
    }

    public PassedExamsListBean(int addedIndex) {
        this.addedIndex = addedIndex;
    }

    public ArrayList<PassedExamBean> getList() {
        return list;
    }

    public void setList(ArrayList<PassedExamBean> list) {
        this.list = list;
    }

    public int getAddedIndex() {
        return addedIndex;
    }

    public void setAddedIndex(int addedIndex) {
        this.addedIndex = addedIndex;
    }
    
    public void add(PassedExamBean passedExamBean) {
        list.add(passedExamBean);
    }
}
