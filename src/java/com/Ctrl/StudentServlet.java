package com.Ctrl;
import com.ModelPackage.BussinessRules.StudentDAOLocal;
import com.ModelPackage.model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class StudentServlet extends HttpServlet {
    @EJB
    private StudentDAOLocal studentDAO;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int yearLvl = 0;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            String studentIDsrt = request.getParameter("student");
            int studentId = 0;
            if (studentIDsrt != null && !studentIDsrt.equals("")) {
                studentId = Integer.parseInt(studentIDsrt);
                String firstName = request.getParameter("fisrtName");
                String lastName = request.getParameter("lastName");
                String yearLevelstr = request.getParameter("yearLevel");
                if (yearLevelstr != null && !yearLevelstr.equals("")) {
                    yearLvl = Integer.parseInt(yearLevelstr);
                }
            }
            Student student = new Student(studentId, action, action, yearLvl);
            List<Student> lista;
            if ("Add".equalsIgnoreCase(action)) {
                studentDAO.addStudent(student);
            } else if ("Edit".equalsIgnoreCase(action)) {
                studentDAO.editStudent(student);
            }else if ("Delete".equalsIgnoreCase(action)) {
                studentDAO.deleteStudent(student);
            }else if ("Search".equalsIgnoreCase(action)) {
                student= studentDAO.getStudent(studentId);
                request.setAttribute("message", student.getStudentId());
                request.setAttribute("message", student.getFirstName());
                request.setAttribute("message", student.getLastName());
                request.setAttribute("message", student.getYearLevel());
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }else if ("Search All".equalsIgnoreCase(action)) {
                lista = studentDAO.getStudents();
            }
            request.setAttribute("student", student);
            request.setAttribute("AllStudents", studentDAO.getStudents());
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
