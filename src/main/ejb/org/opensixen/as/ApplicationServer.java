package org.opensixen.as;

import org.compiere.session.ServerBean;
import org.opensixen.osgi.interfaces.IApplicationServer;

public class ApplicationServer extends ServerBean implements IApplicationServer {

	@Override
	public boolean testConnection() {
		return true;
	}

	
}
