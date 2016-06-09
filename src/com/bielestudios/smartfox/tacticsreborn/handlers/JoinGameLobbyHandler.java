package com.bielestudios.smartfox.tacticsreborn.handlers;

import com.bielestudios.smartfox.tacticsreborn.TacticsRebornExtension;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler;

public class JoinGameLobbyHandler extends BaseClientRequestHandler
{		
	@Override
	public void handleClientRequest(User SFUser, ISFSObject ObjectIn) 
	{
		TacticsRebornExtension ourParentExt = (TacticsRebornExtension)getParentExtension();
		ISFSObject ObjectOut = new SFSObject();
		
		trace(SFUser.getName() + " has logged into the game. Entering Lobby....");
	}

}
