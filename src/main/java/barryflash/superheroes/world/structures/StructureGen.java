package barryflash.superheroes.world.structures;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import barryflash.superheroes.Reference;
import barryflash.superheroes.init.ModBlocks;
import barryflash.superheroes.util.LootTableHandler;
import barryflash.superheroes.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class StructureGen extends WorldGenerator {

	private static final int VARIATION = 2;
	private String structureName;

	public StructureGen(String structureName) {
		this.structureName = structureName;
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		WorldServer worldServer = (WorldServer) world;
		MinecraftServer minecraftServer = world.getMinecraftServer();
		TemplateManager templateManager = worldServer.getStructureTemplateManager();
		Template template = templateManager.get(minecraftServer,
				new ResourceLocation(Reference.MODID, this.structureName));
		if (template == null) {
			// The template does not exist
			Utils.getLogger().error("The structre template: " + this.structureName + " did not exist!");
			return false;
		}
		if (canSpawnHere(template, worldServer, position)) {
			Rotation rotation = Rotation.values()[rand.nextInt(3)];
			PlacementSettings settings = new PlacementSettings().setMirror(Mirror.NONE).setRotation(rotation)
					.setIgnoreStructureBlock(false);

			template.addBlocksToWorld(world, position, settings);
			Map<BlockPos, String> dataBlocks = template.getDataBlocks(position, settings);
			for (Entry<BlockPos, String> entry : dataBlocks.entrySet()) {
				try {
					if ("temple".equals(entry.getValue()))
		             {
		                 BlockPos blockpos2 = entry.getKey();
		                 world.setBlockState(blockpos2.up(), Blocks.AIR.getDefaultState(), 3);
		                 TileEntity tileentity = world.getTileEntity(blockpos2);

		                 if (tileentity instanceof TileEntityChest)
		                 {
		                     ((TileEntityChest)tileentity).setLootTable(LootTableHandler.KRYPTONITE_SHIP, rand.nextLong());
		                 }
		             }
		             if ("shrine".equals(entry.getValue()))
		             {
		                 BlockPos blockpos2 = entry.getKey();
		                 world.setBlockState(blockpos2.up(), ModBlocks.ZEUS_SHRINE_BLOCK.getDefaultState(), 3);
		             }
		        

		             if ("house3".equals(entry.getValue()))
		             {
		                 BlockPos blockpos2 = entry.getKey();
		                 world.setBlockState(blockpos2.up(), Blocks.AIR.getDefaultState(), 3);
		                 TileEntity tileentity = world.getTileEntity(blockpos2);

		                 if (tileentity instanceof TileEntityChest)
		                 {
		                     ((TileEntityChest)tileentity).setLootTable(LootTableHandler.KRYPTONITE_SHIP, rand.nextLong());
		                 }
		             }
		        
		             if ("house1".equals(entry.getValue()))
		             {
		                 BlockPos blockpos2 = entry.getKey();
		                 world.setBlockState(blockpos2.up(), Blocks.AIR.getDefaultState(), 3);
		                 TileEntity tileentity = world.getTileEntity(blockpos2);

		                 if (tileentity instanceof TileEntityChest)
		                 {
		                     ((TileEntityChest)tileentity).setLootTable(LootTableHandler.KRYPTONITE_SHIP, rand.nextLong());
		                 }
		             }
		             if ("house2".equals(entry.getValue()))
		             {
		                 BlockPos blockpos2 = entry.getKey();
		                 world.setBlockState(blockpos2.up(), Blocks.AIR.getDefaultState(), 3);
		                 TileEntity tileentity = world.getTileEntity(blockpos2);

		                 if (tileentity instanceof TileEntityChest)
		                 {
		                     ((TileEntityChest)tileentity).setLootTable(LootTableHandler.KRYPTONITE_SHIP, rand.nextLong());
		                 }
		             }
				} catch (Exception e) {
					Utils.getLogger().catching(e);
					continue;
				}
			}
			return true;
		}

		return false;
	}

	public static boolean canSpawnHere(Template template, World world, BlockPos pos) {
		return isCornerValid(world, pos) && isCornerValid(world, pos.add(template.getSize().getX(), 0, 0))
				&& isCornerValid(world, pos.add(template.getSize().getX(), 0, template.getSize().getZ()))
				&& isCornerValid(world, pos.add(0, 0, template.getSize().getZ()));
	}
	public static boolean isCornerValid(World world, BlockPos pos) {
		int groundY = getGroundFromAbove(world, pos.getX(), pos.getZ());
		return groundY > pos.getY() - VARIATION && groundY < pos.getY() + VARIATION;
	}

	public static int getGroundFromAbove(World world, int x, int z) {
		int y = 255;
		boolean foundGround = false;
		while (!foundGround && y-- > 0) {
			Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
			if (block == Blocks.WATER || block == Blocks.FLOWING_WATER) {
				y = -1;
				break;
			}
			foundGround = block == Blocks.GRASS || block == Blocks.SAND || block == Blocks.SNOW
					|| block == Blocks.SNOW_LAYER || block == Blocks.MYCELIUM || block == Blocks.STONE;
		}
		return y;
	}
}
