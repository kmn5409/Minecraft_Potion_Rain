package com.keanunichols.potionrain;


import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
//import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
//import org.bukkit.potion.PotionEffect;
//import org.bukkit.potion.PotionEffectType;


public class Main extends JavaPlugin {
	
	/*	
	protected void delaySplash(JavaPlugin plugin, final Player plr){
		Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
			
			
			public void run() {
				LivingEntity le = (LivingEntity) plr;
        		le.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 20 * 5, 0));
            }
        }, 20L);
		
	}
	*/
	private Random random;
	
	public long randomNumberTime(){
		long leftLimit = 1200L;
	    long rightLimit = 1800L;
		//long leftLimit = 410L;
	    //long rightLimit = 420L;
	    long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
		return generatedLong;
	}
	
	private Random getRandom() {
        return this.random;
    }
	
	@Override
	/*
	 Do the plugin for like one minute and a half to 2 minutes
	 */
	public void onEnable() {
		this.random = new Random();
		final JavaPlugin plugin = this;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable()
        {
            public void run()
            {		
            	if(Bukkit.getOnlinePlayers().size() == 0)
            		return;
            	//for(Player plr: Bukkit.getOnlinePlayers())
            	//	plr.sendMessage(Bukkit.getOnlinePlayers().size() + "");
            	int randomSize = getRandom().nextInt(Bukkit.getOnlinePlayers().size());
                final Player plr = new ArrayList<Player>(Bukkit.getOnlinePlayers()).get(randomSize);
                PotionRain pRain = new PotionRain();
        		pRain.makeRain(plr);
            }
        }, 1200L, randomNumberTime());
	}

}
