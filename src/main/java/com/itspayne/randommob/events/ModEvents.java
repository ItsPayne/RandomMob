package com.itspayne.randommob.events;

import com.itspayne.randommob.RandomMob;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = RandomMob.MOD_ID, bus = Bus.FORGE)
public class ModEvents {
	public static int ticks = 0;
	
	@SubscribeEvent
	public static void onPlayerInteract(PlayerTickEvent e) {
		Player p = e.player;
		
		if (e.phase == Phase.END) {
			if (p.tickCount % 20 == 0) {
				
			}
		}
	}
}
