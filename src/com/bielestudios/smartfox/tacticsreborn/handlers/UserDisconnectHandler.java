package com.bielestudios.smartfox.tacticsreborn.handlers;

import com.bielestudios.smartfox.tacticsreborn.TacticsRebornExtension;
import com.smartfoxserver.v2.core.ISFSEvent;
import com.smartfoxserver.v2.core.SFSEventParam;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.exceptions.SFSException;
import com.smartfoxserver.v2.extensions.BaseServerEventHandler;

public class UserDisconnectHandler extends BaseServerEventHandler
{
	@Override
	public void handleServerEvent(ISFSEvent Evt) throws SFSException 
	{
		TacticsRebornExtension ourParentExt = (TacticsRebornExtension)getParentExtension();
		User SFUser = (User)Evt.getParameter(SFSEventParam.USER);
		trace("User: " + SFUser.getName() + " has disconnected");
		
		ISFSObject objectOut = new SFSObject();
		objectOut.putUtfString("PlayerName", SFUser.getName());
		
		ourParentExt.send("PlayerDisconnected", objectOut, ourParentExt.getGameManager().getPlayerList());
		
		ourParentExt.getGameManager().getPlayerDictionary().remove(SFUser);
		ourParentExt.getGameManager().getPlayerList().remove(SFUser);
	}
}

