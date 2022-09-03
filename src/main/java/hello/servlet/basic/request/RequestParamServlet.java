package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 1.파라미터 전송기능
 * http://localhost:8080/request-param?username=hello&age=20
 */
@WebServlet(name="requestParamServlet",urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest requset, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("[전체 파라미터 조회] - start");

        requset.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + "=" + requset.getParameter(paramName)));

        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String username = requset.getParameter("username");
        String age = requset.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String[] usernames = requset.getParameterValues("username");
        for(String name :usernames ){
            System.out.println("username = "+name);
        }

        response.getWriter().write("ok");

    }
}
