package controle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/Serv2",
        initParams = {@WebInitParam(name = "MaximaInteracao", value = "5")})

public class Serv2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Integer interacoes = (Integer) req.getServletContext().getAttribute("Interações");
        String max = req.getServletContext().getInitParameter("total");

        if(interacoes < Integer.parseInt(max)){
            interacoes = new Integer(interacoes + 1);
            req.getServletContext().setAttribute("Interações", interacoes);

            System.out.println("Quantidade de  " + interacoes);
                req.getRequestDispatcher("serv1.java").forward(req, res);

        }else{
        System.out.println("Atingiu o limite de interações");
                req.getRequestDispatcher("serv1.java").forward(req, res);
        }
    }
}
