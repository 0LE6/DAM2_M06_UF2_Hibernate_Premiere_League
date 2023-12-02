package DAO;

public class DAOManagerFactory {

	public static DAOManager createDAOManager() {
		return new DAOManagerHibernateImpl();
	}
}