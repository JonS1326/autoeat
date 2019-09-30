/*
 * Copyright (C) 2014 - 2019 | Wurst-Imperium | All rights reserved.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient.hacks;

import net.wurstclient.Category;
import net.wurstclient.SearchTags;
import net.wurstclient.events.DeathListener;
import net.wurstclient.hack.Hack;

@SearchTags({"auto respawn", "AutoRevive", "auto revive"})
public final class AutoRespawnHack extends Hack implements DeathListener
{
	public AutoRespawnHack()
	{
		super("AutoRespawn", "Automatically respawns you whenever you die.");
		setCategory(Category.COMBAT);
	}
	
	@Override
	public void onEnable()
	{
		WURST.getEventManager().add(DeathListener.class, this);
	}
	
	@Override
	public void onDisable()
	{
		WURST.getEventManager().remove(DeathListener.class, this);
	}
	
	@Override
	public void onDeath()
	{
		MC.player.requestRespawn();
		MC.openScreen(null);
	}
}