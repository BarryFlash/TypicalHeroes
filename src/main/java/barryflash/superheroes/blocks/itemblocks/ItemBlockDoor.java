package barryflash.superheroes.blocks.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemBlockDoor extends ItemBlock {

	public ItemBlockDoor(Block block) {
		super(block);
		// TODO Auto-generated constructor stub
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (facing != EnumFacing.UP) return EnumActionResult.FAIL;
		else {
			IBlockState bottomDoorState = worldIn.getBlockState(pos);
			Block bottomDoorBlock = bottomDoorState.getBlock();
			
			if (!block.isReplaceable(worldIn, pos)) pos = pos.offset(facing);
			
			ItemStack stack = player.getHeldItem(hand);
			if (player.canPlayerEdit(pos, facing, stack) && this.block.canPlaceBlockAt(worldIn, pos)) {
				EnumFacing playerfacing = EnumFacing.fromAngle((double) player.rotationYaw);
				int x = playerfacing.getFrontOffsetX();
				int z = playerfacing.getFrontOffsetZ();
				boolean flag = x < 0 && hitZ < 0.5F || x > 0 && hitZ > 0.5F || z < 0 && hitX < 0.5F || z > 0 && hitX > 0.5F;
				placeDoor(worldIn, pos, playerfacing, this.block, flag);
				
				SoundType sound = block.getSoundType(bottomDoorState, worldIn, pos, player);
				worldIn.playSound(player, pos, sound.getPlaceSound(), SoundCategory.BLOCKS, (sound.getVolume() + 1.0F) / 2.0F, sound.getPitch() * 0.8F);
				
				stack.shrink(1);
				return EnumActionResult.SUCCESS;
			} else return EnumActionResult.FAIL;
		}
	}

	private static void placeDoor(World worldIn, BlockPos bottomDoorPos, EnumFacing playerfacing, Block door, boolean isRightHinge) {
		// TODO Auto-generated method stub
		BlockPos posYClockwise = bottomDoorPos.offset(playerfacing.rotateY());
		BlockPos posYAntiClockwise = bottomDoorPos.offset(playerfacing.rotateYCCW());
		
		int i = (worldIn.getBlockState(posYAntiClockwise).isNormalCube() ? 1 : 0) + (worldIn.getBlockState(posYAntiClockwise.up()).isNormalCube() ? 1 : 0);
		int j = (worldIn.getBlockState(posYClockwise).isNormalCube() ? 1 : 0) + (worldIn.getBlockState(posYClockwise.up()).isNormalCube() ? 1 : 0);
		
		boolean flag = worldIn.getBlockState(posYAntiClockwise).getBlock() == door || worldIn.getBlockState(posYAntiClockwise.up()).getBlock() == door;
		boolean flag1 = worldIn.getBlockState(posYClockwise).getBlock() == door || worldIn.getBlockState(posYClockwise.up()).getBlock() == door;
		
		if ((!flag || flag1) && j <= i) {
			if (flag1 && !flag || j < i) isRightHinge = false;
		} else isRightHinge = false;
		
		BlockPos topDoorPos = bottomDoorPos.up();
		boolean powered = worldIn.isBlockPowered(bottomDoorPos) || worldIn.isBlockPowered(topDoorPos);
		IBlockState doorState = door.getDefaultState()
				.withProperty(BlockDoor.FACING, playerfacing)
				.withProperty(BlockDoor.HINGE, isRightHinge ? BlockDoor.EnumHingePosition.RIGHT : BlockDoor.EnumHingePosition.LEFT)
				.withProperty(BlockDoor.POWERED, Boolean.valueOf(powered))
				.withProperty(BlockDoor.OPEN, Boolean.valueOf(powered));
		
		worldIn.setBlockState(bottomDoorPos, doorState.withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.LOWER));
		worldIn.setBlockState(topDoorPos, doorState.withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER));
		worldIn.notifyNeighborsOfStateChange(bottomDoorPos, door, false);
		worldIn.notifyNeighborsOfStateChange(topDoorPos, door, false);
	}
}
