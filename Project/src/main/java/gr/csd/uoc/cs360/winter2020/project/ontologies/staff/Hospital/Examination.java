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

    private String Exam_ID = null;
    private String Exam_Room = null;

    public Examination() {

        generateId();
    }

    public Examination(String Exam_room) {
        this.Exam_Room = Exam_room;

        generateId();
    }

    public boolean checkFields() {
        if (Exam_ID == null || Exam_ID.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    private void generateId() {
        this.Exam_ID = UUID.randomUUID().toString();

    }

    public void setExam_ID(String param) {
        this.Exam_ID = param;
    }

    public String getExam_ID() {
        return this.Exam_ID;
    }

    public void setExam_Room(String param) {
        this.Exam_Room = param;
    }

    public String getExam_Room() {
        return this.Exam_Room;
    }
}
