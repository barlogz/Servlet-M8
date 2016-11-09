package ua.goit.java.module_8.controller;

import ua.goit.java.module_8.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "DeleteTask", urlPatterns = {"/delete"})
public class DeleteTask extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        List<Task> tasks = (List<Task>) session.getAttribute("tasks");

        int id = Integer.parseInt(req.getParameter("id"));

        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
            }
        }
        session.setAttribute("tasks", tasks);
        resp.sendRedirect("/jsp/tasks.jsp");
    }
}
