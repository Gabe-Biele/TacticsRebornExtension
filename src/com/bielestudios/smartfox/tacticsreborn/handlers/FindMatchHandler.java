package com.bielestudios.smartfox.tacticsreborn.handlers;

import com.bielestudios.smartfox.tacticsreborn.TacticsRebornExtension;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler;

public class FindMatchHandler extends BaseClientRequestHandler
{		
	@Override
	public void handleClientRequest(User SFUser, ISFSObject objectIn) 
	{
		TacticsRebornExtension ourParentExt = (TacticsRebornExtension)getParentExtension();

		String chatText = objectIn.getUtfString("ChatText");
		
		//TODO Need to add parsers to check for PMs and other commands
		String processedChatText = SFUser.getName() + ": " + chatText;
		
		//Build and send the response back
		ISFSObject objectOut = new SFSObject();
		objectOut.putUtfString("ChatText", processedChatText);
		ourParentExt.send("EnterChat", objectOut, ourParentExt.getGameManager().getPlayerList());	
	}

}
