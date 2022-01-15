package com.itspayne.randommob.events;

import com.itspayne.randommob.RandomMob;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

import java.util.Collection;
import java.util.List;
import java.util.Locale;

@EventBusSubscriber(modid = RandomMob.MOD_ID, bus = Bus.FORGE)
public class ModEvents {
	public static int ticks = 0;
	
	@SubscribeEvent
	public static void onPlayerInteract(PlayerTickEvent e) {
		Player p = e.player;
		Level world = e.player.level;
		List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, p.getBoundingBox().expandTowards(200, 200, 200));

		if (e.phase == Phase.END) {
			if (p.tickCount % 20 == 0 && e.side.isClient()) {
				for (LivingEntity livingEntity : entities){
					if (!(livingEntity instanceof Player)) {
						double entityX = livingEntity.getX();
						double entityY = livingEntity.getY();
						double entityZ = livingEntity.getZ();

						CompoundTag compoundtag = new CompoundTag();
						compoundtag.putString("id", "minecraft:chicken");

						livingEntity.kill();

						Entity newEntity = EntityType.loadEntityRecursive(new CompoundTag(), world, (ent) -> {
							ent.moveTo(entityX, entityY, entityZ);
							return ent;
						});
						world.addFreshEntity(newEntity);
					}
				}
			}
		}
	}
}
