package com.itspayne.randommob;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("randommob")
public class RandomMob {
	public static final String MOD_ID = "randommob";
	
	public RandomMob() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		MinecraftForge.EVENT_BUS.register(this);
	}
}
