package lessons.servlets.withDb;

import com.sun.corba.se.spi.protocol.RequestDispatcherDefault;
import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Univer_29 on 05.04.2015.
 */
public class MyServlet {
    public void doGet (HttpRequest request, HttpResponse response) {
        String url = "jdbc:mysql://localhost:3306/infopulse";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, "root", "root");
            Statement st = con.createStatement();
            String sql = "SELECT * from clients";
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData metaData = rs.getMetaData();
            int columns = metaData.getColumnCount();
            List<Client> clients = new ArrayList<>();
            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt(1));
                client.setName(rs.getString(2));
                client.setSurname(rs.getString(3));
                clients.add(client);
            }
            HttpSession session = request.getSession(true);
            session.setAttribute("clients", clients);
            RequestDispatcher dispatcher = request.setRequestDispatcher("/clients.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException e) {

        }

    }
}
