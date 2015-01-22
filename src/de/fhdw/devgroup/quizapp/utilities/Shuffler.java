package de.fhdw.devgroup.quizapp.utilities;

import java.util.Random;

import android.util.Log;

public class Shuffler {
	
	public static String[][] shuffleStringArray(String[] stringArray){
		String shuffeldArray[][] =  new String[stringArray.length][2];
		int indexTracking[] = new int[stringArray.length];
		
		for (int i = 0; i < stringArray.length; i++)
	    {
			indexTracking[i] = i;
	    }
		
		 Random rnd = new Random();
		    for (int i = stringArray.length - 1; i >= 0; i--)
		    {
		      int index = rnd.nextInt(i+1);
		      
		      String tempStrArray = stringArray[index];
		      int tempIndexTracker = indexTracking[index];
		      
		      stringArray[index] = stringArray[i];
		      stringArray[i] = tempStrArray;
		      
		      indexTracking[index] = indexTracking[i];
		      indexTracking[i] = tempIndexTracker;
		      
		      
		    }
		
		for (int n = 0; n < indexTracking.length; n++){
			shuffeldArray[n][0] = String.valueOf(indexTracking[n]);
			shuffeldArray[n][1] = stringArray[n];
			Log.d("Shuffle", "ShuffeldArray:" + stringArray[n]);
			Log.d("Shuffle", "index:" + indexTracking[n]);
			
		}    
		    
		return shuffeldArray;
	}

}
