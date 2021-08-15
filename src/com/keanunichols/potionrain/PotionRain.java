package com.keanunichols.potionrain;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class PotionRain{
	
	float locX;
	float locZ;
	Player plr_;
	PotionEffectType types[];
	int arr[];
	
	public PotionRain(){
		/*
		this.types = new PotionEffectType[] {PotionEffectType.WEAKNESS,PotionEffectType.JUMP,PotionEffectType.HARM,
				PotionEffectType.INVISIBILITY,PotionEffectType.FIRE_RESISTANCE};
		*/
		this.types = new PotionEffectType[] {PotionEffectType.HARM,PotionEffectType.INVISIBILITY,PotionEffectType.POISON,PotionEffectType.WEAKNESS};
		this.arr = new int[]{1, 600};
	}
	
	protected void rainPotion(World wld, Location loc, ItemStack itemStack) {
		locX = loc.getBlockX();
		locZ = loc.getBlockZ();
		Location loc_ = loc.add(0,1,0);
		//Location
		//plr_.sendMessage("Here");
		//plr_.sendMessage(loc.toString());
		//plr_.sendMessage("\n\n");
		for(float x=-2; x<=2; x+=1) {
			//plr_.sendMessage("Inside X");
			//plr_.sendMessage(loc_.toString());
			for(float z=-2; z<=2; z+=1) {
				loc_ = loc.clone().add(x,1,z);
				/*
				ItemStack itemStack = new ItemStack(Material.SPLASH_POTION);
				PotionMeta potionMeta = (PotionMeta) itemStack.getItemMeta();

				potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 1, 0), true);

				itemStack.setItemMeta(potionMeta);
				*/
				ThrownPotion thrownPotion = (ThrownPotion) wld.spawnEntity(loc_, EntityType.SPLASH_POTION);
				thrownPotion.setItem(itemStack);
				//plr_.sendMessage(loc_.toString());
				//plr_.sendMessage("Inside Z");
				
			}	
		}
		
	}
	
	protected void makeRain(Player plr){
		plr_ = plr;
		final Location floc = plr.getLocation();
		//Location loc = plr.getLocation();
		//loc.add(0,2,0);
		
		//World wld = plr.getWorld();
		ItemStack itemStack = new ItemStack(Material.SPLASH_POTION);
		PotionMeta potionMeta = (PotionMeta) itemStack.getItemMeta();

		//potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.GLOWING, 1, 0), true);
		int rnd = new Random().nextInt(types.length);
		if(rnd == 0)
			potionMeta.addCustomEffect(new PotionEffect(types[rnd], arr[0], 0), true);
		else
			potionMeta.addCustomEffect(new PotionEffect(types[rnd], arr[1], 0), true);

		itemStack.setItemMeta(potionMeta);

		rainPotion(plr.getWorld(),floc,itemStack);
		//ThrownPotion thrownPotion = (ThrownPotion) wld.spawnEntity(loc, EntityType.SPLASH_POTION);
		

		
		
	}

}
