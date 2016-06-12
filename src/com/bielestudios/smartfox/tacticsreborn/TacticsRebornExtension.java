package com.bielestudios.smartfox.tacticsreborn;


import com.bielestudios.smartfox.tacticsreborn.handlers.*;
import com.bielestudios.smartfox.tacticsreborn.managers.GameManager;
import com.bielestudios.smartfox.tacticsreborn.util.LoginHandler;
import com.bielestudios.smartfox.tacticsreborn.util.RegistrationHandler;
import com.smartfoxserver.v2.components.signup.SignUpAssistantComponent;
import com.smartfoxserver.v2.core.SFSEventType;
import com.smartfoxserver.v2.extensions.SFSExtension;

public class TacticsRebornExtension extends SFSExtension 
{
	private RegistrationHandler ourRegistrationHandler;
	private LoginHandler ourLoginHandler;
	
	private GameManager ourGameManager;
	
	@Override
	public void init() 
	{
		//Start Registration Handler
		ourRegistrationHandler = new RegistrationHandler();
		addRequestHandler(SignUpAssistantComponent.COMMAND_PREFIX, ourRegistrationHandler.getSUAC());
		
		//Start Login Handler
		ourLoginHandler = new LoginHandler(this);
		
		//Setup EventHandlers
		addEventHandler(SFSEventType.USER_DISCONNECT, UserDisconnectHandler.class);
		
		//Setup RequestHandlers
		addRequestHandler("JoinGameLobby", JoinGameLobbyHandler.class);
		addRequestHandler("FindMatch", FindMatchHandler.class);
		addRequestHandler("OnlinePlayers", OnlinePlayersHandler.class);
		addRequestHandler("EnterChat", EnterChatHandler.class);
		
		//Start Game Server
		ourGameManager = new GameManager();
	}

	public GameManager getGameManager() 
	{
		return ourGameManager;
	}

	public void setGameManager(GameManager aGameManager) 
	{
		this.ourGameManager = aGameManager;
	}

}
