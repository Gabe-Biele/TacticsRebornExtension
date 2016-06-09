package com.bielestudios.smartfox.tacticsreborn.util;

import java.util.ArrayList;
import java.util.List;

import com.smartfoxserver.v2.components.signup.PasswordMode;
import com.smartfoxserver.v2.components.signup.SignUpAssistantComponent;


public class RegistrationHandler 
{
	private SignUpAssistantComponent ourSUAC;
	private List<String> ourExtraFields;
	
	public RegistrationHandler()
	{
		ourExtraFields = new ArrayList<String>();
		ourExtraFields.add("DateCreated");

		
		ourSUAC = new SignUpAssistantComponent();
		ourSUAC.getConfig().signUpTable = "UserAccounts";
		ourSUAC.getConfig().idField = "UserID";
		ourSUAC.getConfig().usernameField = "Username";
		ourSUAC.getConfig().passwordField = "PasswordHash";
		ourSUAC.getConfig().emailField = "Email";
		ourSUAC.getConfig().extraFields = ourExtraFields;
		ourSUAC.getConfig().checkForDuplicateUserNames = true;
		ourSUAC.getConfig().checkForDuplicateUserNames = true;
		ourSUAC.getConfig().passwordMode = PasswordMode.MD5;
	}
	public SignUpAssistantComponent getSUAC()
	{
		return ourSUAC;
	}
}
