package com.itspayne.randommob.events;

import com.itspayne.randommob.RandomMob;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

import java.util.List;

@EventBusSubscriber(modid = RandomMob.MOD_ID, bus = Bus.FORGE)
public class ModEvents {
	@SubscribeEvent
	public static void onPlayerInteract(PlayerTickEvent e) {
		Player p = e.player;
		Level world = e.player.level;
		List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, p.getBoundingBox().expandTowards(200, 200, 200));

		if (e.phase == Phase.END) {
			if (p.tickCount % 20 == 0 && e.side.isClient()) {
					for (LivingEntity livingEntity : entities){
						if (!(livingEntity instanceof Player)){
							double eX = livingEntity.getX();
							double eY = livingEntity.getY();
							double eZ = livingEntity.getZ();

							livingEntity.remove(Entity.RemovalReason.KILLED);

							Entity newEntity;
							// spawning a random one here

						}
				}
			}
		}
	}
}
