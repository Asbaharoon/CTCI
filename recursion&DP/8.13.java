public class Solution{
	public static int tallestHeight(ArrayList<Box> boxes){
		//sort in decending order by height
		Collections.sort(boxes,new BoxComparator());
		int[] cache = new int[boxes.size()];
		int maxHeight = 0;
		for(int i=0;i<boxes.size();i++){
			int height = createStack(boxes,i,cache);
			maxHeight = Math.max(maxHeight,height);
		}
		return maxHeight;
	}

	private static int createStack(ArrayList<Box> boxes,int index,int[] cache){
		if(index<boxes.size()&&cache[index]>0){
			return cache[index];
		}

		Box bottom = boxes.get(index);
		int maxHeight = 0;
		for(int i=index+1;i<boxes.size();i++){
			if(validBox(bottom,boxes.get(i))){
				int height = createStack(boxes,i,cache);
				maxHeight = Math.max(maxHeight,height);
			}
		}
		maxHeight += bottom.getHeight();
		cache[index] = maxHeight;
		return maxHeight;
	}

	private static boolean validBox(Box bottom,Box curr){
		if(bottom.getWidth()>curr.getWidth()&&bottom.getDepth()>curr.getDepth()){
			return true;
		}
		return false;
	}

	class BoxComparator implements Comparator<Box>{
		@override
		public int compare(Box x,Box y){
			return y.getHeight()-x.getHeight();
		}
	}
}