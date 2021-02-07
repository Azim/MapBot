package icu.azim.mapbot.logic;

import org.bukkit.Chunk;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.block.SpongeAbsorbEvent;
import org.bukkit.event.world.ChunkPopulateEvent;

import icu.azim.mapbot.MapBotPlugin;
import icu.azim.mapbot.util.Vector2i;

public class DirtyListener implements Listener{
	private MapBotPlugin plugin;
	public DirtyListener(MapBotPlugin plugin) {
		this.plugin = plugin;
	}
	
	public void dirtyEvent(BlockEvent e) {
		Chunk c = e.getBlock().getChunk();
		Vector2i v = new Vector2i(c.getX(), c.getZ());
		plugin.cache.remove(v);
	}
	
	@EventHandler
	public void onBurn(BlockBurnEvent e) {
		dirtyEvent(e);
	}
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		dirtyEvent(e);
	}
	@EventHandler
	public void onBlockFade(BlockFadeEvent e) {
		dirtyEvent(e);
	}
	@EventHandler
	public void onBlockGrow(BlockGrowEvent e) {
		dirtyEvent(e);
	}
	@EventHandler
	public void onBlockPhysics(BlockPhysicsEvent e) {
		dirtyEvent(e);
	}
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		dirtyEvent(e);
	}
	@EventHandler
	public void onLeafDecay(LeavesDecayEvent e) {
		dirtyEvent(e);
	}
	@EventHandler
	public void onSpongeAbsorb(SpongeAbsorbEvent e) {
		dirtyEvent(e);
	}
	@EventHandler
	public void onChunkDone(ChunkPopulateEvent e) {
		Chunk c = e.getChunk();
		Vector2i v = new Vector2i(c.getX(), c.getZ());
		System.out.println("populated chunk "+v);
		//plugin.cache.remove(v);
		MapBotPlugin.printcount=100;
	}
}
