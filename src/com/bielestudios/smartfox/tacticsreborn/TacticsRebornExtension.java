package com.bielestudios.smartfox.tacticsreborn;


import com.bielestudios.smartfox.tacticsreborn.handlers.JoinGameLobbyHandler;
import com.bielestudios.smartfox.tacticsreborn.handlers.UserDisconnectHandler;
import com.bielestudios.smartfox.tacticsreborn.util.LoginHandler;
import com.bielestudios.smartfox.tacticsreborn.util.RegistrationHandler;
import com.smartfoxserver.v2.components.signup.SignUpAssistantComponent;
import com.smartfoxserver.v2.core.SFSEventType;
import com.smartfoxserver.v2.extensions.SFSExtension;

public class TacticsRebornExtension extends SFSExtension 
{
	private RegistrationHandler ourRegistrationHandler;
	private LoginHandler ourLoginHandler;
	
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
		addRequestHandler("CharacterList", JoinGameLobbyHandler.class);
	}

}
