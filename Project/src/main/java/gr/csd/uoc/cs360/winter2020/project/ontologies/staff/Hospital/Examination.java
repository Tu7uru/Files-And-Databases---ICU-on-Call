/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Hospital;

import java.util.UUID;

/**
 *
 * @author Tolis
 */
public class Examination {

    private String exam_id = null;
    private String exam_room = null;
    private String name;

    public Examination() {

        //generateId();
    }

    public Examination(String Exam_room, String name) {
        this.exam_room = Exam_room;
        this.name = name;
        generateId();
    }

    public boolean checkFields() {
        if (exam_id == null || exam_id.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    private void generateId() {
        this.exam_id = UUID.randomUUID().toString();

    }

    public void setExam_ID(String param) {
        this.exam_id = param;
    }

    public String getExam_ID() {
        return this.exam_id;
    }

    public void setExam_Room(String param) {
        this.exam_room = param;
    }

    public String getExam_Room() {
        return this.exam_room;
    }

    public void setName(String param) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
