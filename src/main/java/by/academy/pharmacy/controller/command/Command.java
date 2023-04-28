package by.academy.pharmacy.controller.command;

import jakarta.servlet.http.HttpServletRequest;

public interface Command {
    /**
     * @param request http request from client.
     * @return path to jsp page.
     */
    String execute(HttpServletRequest request);
}
