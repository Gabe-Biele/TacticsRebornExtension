package com.bielestudios.smartfox.tacticsreborn.util;

import com.smartfoxserver.v2.components.login.LoginAssistantComponent;
import com.smartfoxserver.v2.extensions.SFSExtension;

public class LoginHandler 
{
	private LoginAssistantComponent OurLAC;
	private SFSExtension ParentExt;
	
	public LoginHandler(SFSExtension PE)
	{
		this.ParentExt = PE;
		OurLAC = new LoginAssistantComponent(this.ParentExt);
        
        // Configure the component
		OurLAC.getConfig().loginTable = "UserAccounts";
		OurLAC.getConfig().userNameField = "Username";
		OurLAC.getConfig().passwordField = "PasswordHash";
	}
}
