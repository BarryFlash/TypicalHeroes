package barryflash.superheroes.worldgen;

import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import barryflash.superheroes.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class Gen implements IWorldGenerator {

	 public void generate(Random random, int chunkX, int chunkZ, World world, net.minecraft.world.gen.IChunkGenerator chunkGenerator, IChunkProvider chunkProvider){
		  switch (world.provider.getDimension()) {

		  case 0:
		  Biome biome = world.getBiome(new BlockPos(chunkX * 16, 0, chunkZ * 16));
		  generateOverworld(random, chunkX * 16, chunkZ * 16, world, biome);
		 break;
		 }
		  }
		  
		 
		 
		  private void addOre(IBlockState block, final Block blockspawn, Random random, World world, int posX, int posZ, int minY, int maxY, int minVein, int maxVein, int spawnChance) {
		  for (int i = 0; i < spawnChance; i++) {
		  int defaultChunkSize = 16;
		 
		  int xPos = posX + random.nextInt(defaultChunkSize);
		 
		  int yPos = minY + random.nextInt(maxY - minY);
		 
		  int zPos = posZ + random.nextInt(defaultChunkSize);
		  
		  new WorldGenMinable(block, (minVein + random.nextInt(maxVein - minVein)), new Predicate<IBlockState>()  {
			@Override
			public boolean apply(@Nullable IBlockState input) {
			  return input.getBlock() == blockspawn;
			}
		  }).generate(world, random, new BlockPos(xPos, yPos, zPos));
		  
		
		  
		  }
		 
	}

		  private void generateOverworld(Random random, int worldX, int worldZ, World world, Biome biome) {
		   if (isBiome(biome, 0))
		  {
		  // addOre(ModBlocks.greencoral_block.getDefaultState(), Blocks.WATER, random, world, worldX, worldZ, 30, 40, 2, 4, 8);
		  
	
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