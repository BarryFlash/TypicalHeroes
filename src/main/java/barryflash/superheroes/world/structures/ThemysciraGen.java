package barryflash.superheroes.world.structures;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import barryflash.superheroes.Reference;
import barryflash.superheroes.init.ModBlocks;
import barryflash.superheroes.util.LootTableHandler;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.world.storage.loot.LootTableList;

public class ThemysciraGen extends WorldGenerator {
	Random r2 =new Random();
	
	  
    int r;
	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		WorldServer worldserver = (WorldServer) world;
		MinecraftServer minecraftserver = world.getMinecraftServer();
		TemplateManager templatemanager = worldserver.getStructureTemplateManager();
		Template template = templatemanager.getTemplate(minecraftserver, new ResourceLocation(Reference.MODID, "themyscira"));
		
		if(template == null)
		{
			System.out.println("NO STRUCTURE");
			return false;
		}
		
		if(THWorldGenerator.canSpawnHere(template, worldserver, position)) {
			IBlockState iblockstate = world.getBlockState(position);
			world.notifyBlockUpdate(position, iblockstate, iblockstate, 3);
			
			PlacementSettings placementsettings = (new PlacementSettings()).setMirror(Mirror.NONE)
					.setRotation(Rotation.NONE).setIgnoreEntities(false).setChunk((ChunkPos) null)
					.setReplacedBlock((Block) null).setIgnoreStructureBlock(false);
			
			template.getDataBlocks(position, placementsettings);
			template.addBlocksToWorld(world, position, placementsettings);
			
			 Map<BlockPos, String> map = template.getDataBlocks(position, placementsettings);

	         for (Entry<BlockPos, String> entry : map.entrySet())
	         {
	             if ("chest".equals(entry.getValue()))
	             {
	                 BlockPos blockpos = entry.getKey();
	                 world.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 3);
	                 TileEntity tileentity = world.getTileEntity(blockpos.down());

	                 if (tileentity instanceof TileEntityChest)
	                 {
	                     ((TileEntityChest)tileentity).setLootTable(LootTableHandler.THEMYSCIRA_VILLAGE, rand.nextLong());
	                 }
	             }
	            
	        }
	        
	        
	     
			return true;
		}
		return false;
	}

	public void addLoot(World world) {
		
	}
}
