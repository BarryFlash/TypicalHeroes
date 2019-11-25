package barryflash.superheroes.worldgen;

import java.util.Random;

import barryflash.superheroes.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraftforge.fml.common.IWorldGenerator;

public class AtlantisGen implements IWorldGenerator {
	private static final ResourceLocation atlantis1 = new ResourceLocation(Reference.MODID, "atlantis1");
	private static final ResourceLocation atlantis2 = new ResourceLocation(Reference.MODID, "atlantis2");
	private static final ResourceLocation atlantis3 = new ResourceLocation(Reference.MODID, "atlantis3");
	private static final ResourceLocation atlantis4 = new ResourceLocation(Reference.MODID, "atlantis4");
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, net.minecraft.world.gen.IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		int blockX = chunkX * 16;
		int blockZ = chunkZ * 16;
		int randomX = blockX + random.nextInt(16) + 8;
		int randomZ = blockZ + random.nextInt(16) + 8; 
        final BlockPos basePos = new BlockPos(randomX, world.getSeaLevel() - random.nextInt(world.getHeight(randomX, randomZ)), randomZ);
        Biome biome = world.getBiome(basePos);
        final PlacementSettings settings = new PlacementSettings().setRotation(Rotation.NONE);
        final Template atlantis1 = world.getSaveHandler().getStructureTemplateManager().getTemplate(world.getMinecraftServer(), this.atlantis1);  
        final Template atlantis2 = world.getSaveHandler().getStructureTemplateManager().getTemplate(world.getMinecraftServer(), this.atlantis2);  
        final Template atlantis3 = world.getSaveHandler().getStructureTemplateManager().getTemplate(world.getMinecraftServer(), this.atlantis3);  
        final Template atlantis4 = world.getSaveHandler().getStructureTemplateManager().getTemplate(world.getMinecraftServer(), this.atlantis4);  
       
 		if (isBiome(biome, 24)) {
 			if(random.nextInt(300) < 1) {
 			
 				System.out.println(basePos.toString());
 		atlantis1.addBlocksToWorld(world, basePos, settings);	
 		atlantis2.addBlocksToWorld(world, basePos.add(0, 0, -31), settings);	
 		atlantis3.addBlocksToWorld(world, basePos.add(-28, 0, -31), settings);	
 		atlantis4.addBlocksToWorld(world, basePos.add(-28, 0, 0), settings);	
 		}
		}
	}
	private boolean isBiome(Biome input, int... allowedBiomeIds) {
		   int targetId = Biome.getIdForBiome(input);
		   for (int biomeId : allowedBiomeIds)
		   if (targetId == biomeId)
			   return true;
		   return false;
		   }
}
