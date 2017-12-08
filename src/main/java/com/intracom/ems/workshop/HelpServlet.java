package com.intracom.ems.workshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

@SuppressWarnings("serial")
public class HelpServlet extends HttpServlet {
    private static final String PARTICIPANT_FIELD = "Participant";
    private static final String WORKSHOP_FIELD = "Workshop";
    private static final String YEAR_FIELD = "Year";
    private static final String WORKSHOP_VALUE = "Java SE/EE Workshop";
    private static final int YEAR_VALUE = 2017;

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        String acceptHeader = req.getHeader("Accept").toLowerCase();
        BufferedReader br = null;
        String participantName = null;
        try {
            br = req.getReader();
            participantName = IOUtils.toString(br);
        } catch (IOException exc) {
            resp.setStatus(500);
            return;
        }
        if(participantName.split(" ").length < 2) {
            try {
                resp.setContentType("text/plain; charset=UTF-8");
                resp.setStatus(WorkshopToolkit.ERROR_CODE);
                resp.getWriter().print("Please provide your Full Name");
            } catch (IOException e) {
                resp.setStatus(500);
            }
            return;
        }
        switch (acceptHeader) {
        case "application/json":
            createResponseAsJson(participantName, resp);
            break;
        default:
          resp.setCharacterEncoding("UTF-8");
          resp.setContentType("text/plain");
          PrintWriter pw;
          try {
            pw = resp.getWriter();
          } catch (IOException exc) {
              resp.setStatus(500);
              return;
          }
          pw.println(PARTICIPANT_FIELD + ": " + participantName);
          pw.println(WORKSHOP_FIELD + ": " + WORKSHOP_VALUE);
          pw.println(YEAR_FIELD + ": " + YEAR_VALUE);
        }
    }

    private void createResponseAsJson(
            String participantName, HttpServletResponse resp) {
        /*
         * 5th Exercise: Send response in JSON format
         * Write code that will  the JSON string containing all
         * properties: "participant", "workshop", and "year".
         *
         */
        throw new RuntimeException("Not Implemented");
    }
}
