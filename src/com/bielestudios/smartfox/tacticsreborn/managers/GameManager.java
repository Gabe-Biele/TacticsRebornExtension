package com.bielestudios.smartfox.tacticsreborn.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bielestudios.smartfox.tacticsreborn.data.Player;
import com.smartfoxserver.v2.entities.User;

public class GameManager 
{
	private Map<User, Player> ourPlayerDictionary = new HashMap<User, Player>();
	private List<User> currentPlayerList = new ArrayList<User>();
	
	public GameManager()
	{
		
	}

	public Map<User, Player> getPlayerDictionary() 
	{
		return ourPlayerDictionary;
	}

	public void setPlayerDictionary(Map<User, Player> ourPlayerDictionary) 
	{
		this.ourPlayerDictionary = ourPlayerDictionary;
	}

	public List<User> getPlayerList() 
	{
		return currentPlayerList;
	}
	
	
}
