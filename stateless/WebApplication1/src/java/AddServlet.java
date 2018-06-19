
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myBeans.addBean;
import myBeans.AddEjb;

/*saying application server that this class is a servlet*/
/*sholud use this pattern when doing requests. if you want change pattern in index.html and here as well\
(inside form "action" tag)*/
@WebServlet(urlPatterns = {"/AddServlet"})
public class AddServlet extends HttpServlet {
//*********
    @EJB //that someone is "EJB"
    AddEjb obj;// i only have the reference here not the object. I need someone to create the object
    
 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    /*override according to the reauest method you use*/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*to send to client machine*/
       PrintWriter out = response.getWriter();
       /*get values inside text feilds and conver them ito integer since they are passing as String*/
       int i = Integer.parseInt(request.getParameter("t1"));
       int j = Integer.parseInt(request.getParameter("t2"));
       
       /*do addition in same class*/
//       int k = i+j;
//       out.println("Addition is: "+k);
       
        /*do addition in addBean regular java class*/
//       addBean obj = new addBean();
//       obj.setI(i);
//       obj.setJ(j);
//       obj.add();
//       int k = obj.getK();
//       
//       out.println("addition using beans: "+k);
       
              /*there is a dependency here. You have to worry about the object creation as well as the reference
creation here. 

Think about a distributed system. You have server in different machine and beans in 
different machine. That means server doent know the implementation of beans. But in this manner 
you have to create the object without knowing what is the object will be. so you need help from 
someone to remove this dependency(With the help of EJB - only worry about reference creation
i will worry about object creation). now lets focus on ejb beans*/
              //look at the begining of the code***********
              obj.setI(i);
       obj.setJ(j);
       obj.add();
       int k = obj.getK();
       
       out.println("addition using EJB is: "+k);
       
       /*this is the usage of EJB. No need to create object. Knowing class name is enough.
       just create the reference. EJB will create the object for you*/
              
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
