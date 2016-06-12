package com.bielestudios.smartfox.tacticsreborn.handlers;

import com.bielestudios.smartfox.tacticsreborn.TacticsRebornExtension;
import com.bielestudios.smartfox.tacticsreborn.data.Player;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler;

public class JoinGameLobbyHandler extends BaseClientRequestHandler
{		
	@Override
	public void handleClientRequest(User SFUser, ISFSObject objectIn) 
	{
		TacticsRebornExtension ourParentExt = (TacticsRebornExtension)getParentExtension();

		//Send the new player out to all players
		ISFSObject objectOut = new SFSObject();
		objectOut.putUtfString("PlayerName", SFUser.getName());
		ourParentExt.send("PlayerConnected", objectOut, ourParentExt.getGameManager().getPlayerList());
		
		//Add the new player to game server
		ourParentExt.getGameManager().getPlayerDictionary().put(SFUser, new Player());
		ourParentExt.getGameManager().getPlayerList().add(SFUser);
		
		trace(SFUser.getName() + " has logged into the game. Entering Lobby....");
		trace("Total Users:" + ourParentExt.getGameManager().getPlayerDictionary().size());
		
		ourParentExt.send("JoinGameLobby", objectOut, SFUser);	
	}

}
