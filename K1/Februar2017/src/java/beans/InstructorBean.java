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
public class InstructorBean {
    private ArrayList<SkierBean> list = new ArrayList<>();

    public ArrayList<SkierBean> getList() {
        return list;
    }

    public void setList(ArrayList<SkierBean> list) {
        this.list = list;
    }
    
    public void add(SkierBean skierBean) {
        list.add(skierBean);
    }
}
