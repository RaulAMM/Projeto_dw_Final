package Bus.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import Bus.utils.SearcherDataSource;

public class SearcherDataSource {
	private static SearcherDataSource instance = 
			new SearcherDataSource();
	private DataSource dataSource;
	
	private SearcherDataSource() {
		try {
			Context context = new InitialContext();
			context = (Context)context.lookup("java:comp/env");
			dataSource = (DataSource)context.lookup("jdbc/StackOverBus");
		}catch (NamingException e) {
			throw new RuntimeException("Erro durante o lookup", e);
		}
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public static SearcherDataSource getInstance() {
		return instance;
	}
}
