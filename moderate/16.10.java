public class Solution{
	//solution1, this method takes O(nlogn) time, which n is the length of input array(list).
	public static int whichYear1(Person[] people,int min,int max){
		int[] birth = sortYear(people,true);
		int[] death = sortYear(people,false);

		int birthIndex = 0;
		int deathIndex = 0;
		int maxYear = min;
		int currAlive = 0;
		int maxAlive = 0;

		while(birthIndex<birth.length){
			if(birth[birthIndex]<=death[deathIndex]){
				currAlive++;
				if(currAlive>maxAlive){
					maxAlive = currAlive;
					maxYear = birth[birthIndex];
				}
				birthIndex++;
			}else{
				currAlive--;
				deathIndex++;
			}
		}

		return maxYear;
	}

	private static int[] sortYear(Person[] people,boolean isBirth){
		int[] result = new int[people.length];
		int index = 0;
		for(Person each : people){
			result[index] = isBirth?each.birth:each.death;
		}
		Arrays.sort(result);
		return result;
	}


	//solution2, this method takes O(m+n),n is the length of input array, m is the years' span between min and max;
	public static int whichYear2(Person[] people,int min,int max){
		int[] populationRate = getRate(people,min,max);
		int maxYear = getMaxYear(populationRate);
		return min + maxYear; 
	}

	private static int getMaxYear(int[] populationRate){
		int currAlive = 0;
		int maxAlive = 0;
		int maxYear = 0;
		for(int i=0;i<populationRate.length;i++){
			currAlive += populationRate[i];
			if(currAlive>maxAlive){
				maxAlive = currAlive;
				maxYear = i;
			}
		}
		return maxYear;
	}

	private static int[] getRate(Person[] people,int min,int max){
		int[] result = new int[max-min+2];
		for(Person each : people){
			int birth = each.birth - min;
			result[birth]++;
			int death = each.death - min;
			result[death+1]--;
		}
		return result;
	}

	public class Person{
		public int birth;
		public int death;
		public Person(int birthYear,int deathYear){
			birth = birthYear;
			death = deathYear;
		}
	}
}