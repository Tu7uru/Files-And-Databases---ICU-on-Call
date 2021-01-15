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
    private String nurse_id = null;
    private String exam_room = null;
    private String doctor_id = null;
    private String name;

    public Examination() {

        //generateId();
    }

    public Examination(String nurse_id,
                       String doctor_id,
                       String Exam_room,
                       String name) {
        this.exam_room = Exam_room;
        this.nurse_id = nurse_id;
        this.doctor_id = doctor_id;
        this.name = name;

        generateId();
    }

    public boolean checkFields() {
        if (exam_id == null || exam_id.trim().isEmpty() || doctor_id == null || doctor_id.trim().isEmpty()) {
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

    public void setNurse_ID(String param) {
        this.nurse_id = param;
    }

    public String getNurse_ID() {
        return this.nurse_id;
    }

    public void setDoctorID(String param) {
        this.doctor_id = param;
    }

    public String getDoctorID() {
        return this.doctor_id;
    }

    public void setExam_Room(String param) {
        this.exam_room = param;
    }

    public String getExam_Room() {
        return this.exam_room;
    }

    public void setName(String param) {
        this.name = param;
    }

    public String getName() {
        return this.name;
    }
}
