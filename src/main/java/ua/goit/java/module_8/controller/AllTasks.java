package ua.goit.java.module_8.controller;

import ua.goit.java.module_8.Task;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AllTasks", urlPatterns = {"/list"})
public class AllTasks extends HttpServlet {
    private List<Task> tasks = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Task task1 = new Task(1, "Read book", "Reading", true);
        Task task2 = new Task(2, "Go fishing", "Fishing", true);
        Task task3 = new Task(3, "Go to the shop", "Shopping", false);

        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);

        req.setAttribute("tasks", tasks);
        HttpSession session = req.getSession();
        session.setAttribute("tasks", tasks);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/tasks.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Task task = new Task();
        task.setId(Integer.parseInt(req.getParameter("id")));
        task.setName(req.getParameter("name"));
        task.setCategory(req.getParameter("category"));
        task.setCompleted(Boolean.parseBoolean(req.getParameter("completed")));
        tasks.add(task);

        HttpSession session = req.getSession();
        session.setAttribute("tasks", tasks);

        resp.sendRedirect("/jsp/tasks.jsp");
    }

    @Override
    public void init() throws ServletException {

    }
}
