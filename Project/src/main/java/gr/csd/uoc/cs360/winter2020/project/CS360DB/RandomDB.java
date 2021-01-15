/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.CS360DB;

import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Doctor.Doctor;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Hospital.Medication;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Tolis
 */
public class RandomDB {

    private static HashMap<String, String> commonExams = new HashMap<>();

    public RandomDB() {
        __init__();
    }

    private void __init__() {
        commonExams.put("c1", "CCTA");
        commonExams.put("c2", "nuclear_cardiac_stress");
        commonExams.put("c3", "magnetic_resonance_imaging");
        commonExams.put("s1", "breast_biopsy_test");
        commonExams.put("s2", "cholecystectomy_test");
        commonExams.put("s3", "carotid_endarterectomy_test");
        commonExams.put("h1", "complete_blood_count");
        commonExams.put("h2", "lipid_panel");
        commonExams.put("h3", "liver_panel");
        commonExams.put("gp1", "back_complaint");
        commonExams.put("gp2", "osteoarthritis_test");
        commonExams.put("gp3", "glaucoma_test");
        commonExams.put("n1", "complete_neurological_examination");
        commonExams.put("n2", "CT_scans");
        commonExams.put("n3", "CT_myelogram");
    }

    public static String getExamRoom(Doctor d) throws SQLException, ClassNotFoundException {
        String examRoom = new String();
        int x = new Random().nextInt( 100 - 1 + 1 ) + 1;


        if(d.getSpec() == Doctor.Spec.CARDIOLOGIST) {
            examRoom = "C";
        } else if (d.getSpec() == Doctor.Spec.HAEMATOLOGIST) {
            examRoom = "H";
        } else if (d.getSpec() == Doctor.Spec.SURGEON) {
            examRoom = "S";
        } else if (d.getSpec() == Doctor.Spec.GP) {
            examRoom = "GP";
        } else  {
            examRoom = "N";
        }


        return examRoom + x;
    }

    public static String getExamName(Doctor d) {
        String examName = null, temp = null;
        int x = new Random().nextInt(3 - 1 + 1) + 1;

        if(d.getSpec() == Doctor.Spec.CARDIOLOGIST) {
            temp = "c" + x;
        } else if (d.getSpec() == Doctor.Spec.HAEMATOLOGIST) {
            temp = "h" + x;
        } else if (d.getSpec() == Doctor.Spec.SURGEON) {
            temp = "s" + x;
        } else if (d.getSpec() == Doctor.Spec.GP) {
            temp = "gp" + x;
        } else  {
            temp = "n"+ x;
        }

        examName = commonExams.get(temp);

        return examName;
    }

    public static String getMedication(Doctor d) {
        String type;
        String id;

        if(d.getSpec() == Doctor.Spec.GP) {
            type = "general";
        } else if (d.getSpec() == Doctor.Spec.NEUROLOGIST) {
            type = "neurological";
        } else if (d.getSpec() == Doctor.Spec.HAEMATOLOGIST) {
            type = "blood";
        } else if (d.getSpec() == Doctor.Spec.SURGEON) {
            type = "neurological";
        } else {
            type = "heart";
        }


        System.out.println("#RANDOMDB: " + type);
        id = MedicationDB.getMedicationId(type);

        System.out.println("#RANDOMDB: " + id);

        return id;
    }
}
