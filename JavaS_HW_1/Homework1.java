package app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// http://localhost:8080/hmwrk1/hw1
@WebServlet(name="Homework1", urlPatterns = "/hw1")
public class Homework1 extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(Homework1.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Page homework 1 started!!!");

        Product[] prodList = {  new Product(1, "Торт",      819.99f),
                                new Product(2, "Шоколад",  59.99f),
                                new Product(3, "Конфеты",  249.95f),
                                new Product(4, "Зефир",    159.49f),
                                new Product(5, "Безе",     183.39f),
                                new Product(6, "Пастила",  199.99f),
                                new Product(7, "Халва",    129.90f),
                                new Product(8, "Пирожное", 79.99f),
                                new Product(9, "Мороженное",69.99f),
                                new Product(10,"Вафли",    39.89f)
        };

        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");

        for (int i = 0; i < prodList.length; i++)
            resp.getWriter().printf("<h3>" + String.format("\n%d. %s %.2f руб.", prodList[i].id, prodList[i].title, prodList[i].cost));

        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();
    }


}