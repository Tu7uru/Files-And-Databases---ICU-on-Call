/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.Servlet;

import com.google.gson.Gson;
import gr.csd.uoc.cs360.winter2020.project.CS360DB.DoctorDB;
import gr.csd.uoc.cs360.winter2020.project.CS360DB.PatientDB;
import gr.csd.uoc.cs360.winter2020.project.CS360DB.RandomDB;
import gr.csd.uoc.cs360.winter2020.project.CS360DB.VisitDB;
import gr.csd.uoc.cs360.winter2020.project.CS360DB.DiagnoseDB;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Doctor.Doctor;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Hospital.Examination;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Patient.Visit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tolis
 */
@WebServlet(name = "ExamServlet", urlPatterns = {"/ExamServlet"})
public class ExamServlet extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("#EXAMSERVLET: IN DO POST");
        BufferedReader body = request.getReader();
        String line;
        HashMap<String, String> params = new HashMap<>();
        List<String> symptoms = new ArrayList<>();

        try {
            while ((line = body.readLine()) != null) {
                StringTokenizer tk = new StringTokenizer(line, "=");
                String field = tk.nextToken();
                String value = tk.nextToken();

                params.put(field, value);
            }
            System.out.println("#EXAMSERVLET: " + params);


            if (params.get("type").equals("make")) {
                Visit v = VisitDB.getVisit(params.get("patient_id"), params.get("date"));
                symptoms = VisitDB.getVisitSymptoms(v);

                makeExam(response, params, symptoms);
            } else if (params.get("type").equals("assign")) {
                assignExam(response, params);
            } else if (params.get("type").equals("")) {

            } else {
                prescribe(response, params);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PatientDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void prescribe(HttpServletResponse response, HashMap<String, String> params) throws IOException, ClassNotFoundException {
        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();


        String dis_name = DiagnoseDB.getDiagnoseByExID(params.get("exam_id")).getDisease_Name();

        String med_id = new RandomDB().getMedication(dis_name);


        /*DoctorDB.Prescribe(
                params.get("exam_id"),
                med_id,
                params.get("date"),
                params.get("doctor_id")
        );
*/
        System.out.println("#EXAMSERVLET: PRESCRIBE DONE");

        out.println("Prescribe done");
        out.flush();
        out.close();
    }

    private void assignExam(HttpServletResponse response, HashMap<String, String> params) throws IOException, ClassNotFoundException, SQLException {
            response.setStatus(200);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();

        List<String> exams = new ArrayList<>();
        exams.add("blood_exam");
        exams.add("urine_exam");
        exams.add("ultrasound_exam");
        exams.add("checking_vital_sings");

        Random rand = new Random();

            DoctorDB.DoctorOrdersExamFromNurse(
                    params.get("patient_id"),
                    params.get("date"),
                    params.get("doctor_id"),
                    RandomDB.getExamRoom(DoctorDB.getDoctor(params.get("doctor_id"))),
                    exams.get(rand.nextInt(exams.size()))
            );

        System.out.println("EXAMSERVLET: ASSIGN WAS SUCCESSFULLY DONE.");

        String json = new Gson().toJson("Assign was successfully done.");
            out.println(json);
            out.flush();
            out.close();

    }

    private void makeExam(HttpServletResponse response, HashMap<String, String> params, List<String> symptoms) throws IOException, ClassNotFoundException, SQLException {
        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        PrintWriter out = response.getWriter();
        Doctor d = DoctorDB.getDoctor(params.get("doctor_id"));

        System.out.println(d);
        String examRoom = new RandomDB().getExamRoom(d);
        String examName = new RandomDB().getExamName(d);
        Examination e = new Examination(
            "",
                params.get("doctor_id"),
                examRoom,
                examName
        );


        //System.out.println(params.get("patient_id") + " " + params.get("doctor_id") + " " + params.get("date"));
        PatientDB.PatientReceivesExaminationByDoctor(e, params.get("patient_id"),
                params.get("doctor_id"), params.get("date"),
                symptoms
        );

        System.out.println("#EXAMSERVLET: EXAMINATION DONE SUCCESSFULLY ");
        HashMap<String, String> h = new HashMap<>();
        h.put("exam_room", examRoom);
        h.put("exam_name", examName);
        h.put("exam_id", e.getExam_ID());

        String json = new Gson().toJson(h);
        out.println(json);
        out.flush();
        out.close();

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
