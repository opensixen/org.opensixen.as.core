package org.opensixen.connection;


import org.compiere.db.CConnection;
import org.compiere.interfaces.Server;
import org.opensixen.osgi.Service;
import org.opensixen.osgi.interfaces.IApplicationServer;

public class DummyConnection extends CConnection{

	private static final long serialVersionUID = 1L;
	
	private IApplicationServer m_server;
	
	public DummyConnection() {
		super(null);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.compiere.db.CConnection#isAppsServerOK(boolean)
	 */
	@Override
	public boolean isAppsServerOK(boolean tryContactAgain) {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.compiere.db.CConnection#getServer()
	 */
	@Override
	public Server getServer() {
		if (m_server != null)	{
			return m_server;
		}
		
		// Lookup OSGi server
		IApplicationServer OSGi = Service.locate(IApplicationServer.class);
		if (OSGi != null)	{
			m_server = OSGi;
			return m_server;
		}
		return super.getServer();
	}
	
	
		
	
}
