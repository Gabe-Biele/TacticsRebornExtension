package com.bielestudios.smartfox.tacticsreborn.handlers;

import java.util.ArrayList;
import java.util.List;

import com.bielestudios.smartfox.tacticsreborn.TacticsRebornExtension;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler;

public class OnlinePlayersHandler extends BaseClientRequestHandler
{		
	@Override
	public void handleClientRequest(User SFUser, ISFSObject objectIn) 
	{
		TacticsRebornExtension ourParentExt = (TacticsRebornExtension)getParentExtension();
		
		//Send all the currently online players to the new player
		ISFSObject objectOut = new SFSObject();
		List<String> userNames = new ArrayList<String>();
		
		for(int i = 0; i < ourParentExt.getGameManager().getPlayerList().size(); i++)
		{
			userNames.add(ourParentExt.getGameManager().getPlayerList().get(i).getName());
		}
		
		objectOut.putUtfStringArray("PlayerNameArray", userNames);
		ourParentExt.send("OnlinePlayers", objectOut, SFUser);
		
		trace("Sent player list to " + SFUser.getName());
	}

}
