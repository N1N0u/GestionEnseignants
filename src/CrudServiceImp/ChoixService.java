package CrudServiceImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import Crud_Service.ServiceChoix;
import DemandeFormation.Choix;
import DemandeFormation.Enseignant;
import Formation.Formation;
import Formation.Session;

public class ChoixService implements ServiceChoix {

	public Vector getAllChoix() throws SQLException {
		Vector v=new Vector();
		String sql=" select * from Choix, Enseignant, Formation, Session where Choix.idFormation = Formation.id and Enseignant.email=Choix.emailEns and Session.idS=Choix.idSession";
		Connection c=sqlConnection.conector();
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			v.addElement(new Choix(new Enseignant(rs.getString("nom"), rs.getString("prenom"), rs.getString("adress"), rs.getString("email"), rs.getString("password")), new Formation(rs.getInt("id"), rs.getString("titre"),rs.getString("duree"), rs.getDouble("prix")), new Session(rs.getInt("idS"), rs.getInt("idFormation"), rs.getString("lieu"), rs.getString("dateDebut"), rs.getString("dateFin")),rs.getInt("etatC")));
	/*System.out.println(rs.getString("nom"));
		System.out.println(rs.getString("prenom"));
		System.out.println(rs.getString("adress"));
		System.out.println(rs.getString("email"));
		System.out.println(rs.getString("password"));
		System.out.println(rs.getInt("id"));
		System.out.println(rs.getString("titre"));
		System.out.println(rs.getString("duree"));
		System.out.println(rs.getDouble("prix"));
		System.out.println(rs.getInt("idS"));
		System.out.println(rs.getString("idFormation"));
		System.out.println(rs.getString("lieu"));
		System.out.println(rs.getString("dateDebut"));
		System.out.println(rs.getString("dateFin"));
		System.out.println(rs.getInt("etatC"));
		*/
		}
		c.close();
		return v;
	}

}
