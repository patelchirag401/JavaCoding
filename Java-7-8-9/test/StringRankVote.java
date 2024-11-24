package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StringRankVote {
	
	public static void main(String a[]) {
		StringRankVote stringRankVote = new StringRankVote();
		
		String[] votes= new String[5];
		votes[0]="ABC";
    	votes[1]="ACB";
    	votes[2]="ABC";
    	votes[3]="ACB";
    	votes[4]="ACB";
    	
    	
		System.out.println(stringRankVote.rankTeams(votes));
		
	}
	
	
    public String rankTeams(String[] votes) {
    	
    	
    	

        int[] result = new int[256];

        for(int i=0;i<votes.length;i++){

           String voteString = votes[i];
           int score=voteString.length();	

           for(int j=0;j<voteString.length();j++){
             char ch = voteString.charAt(j);
             int arrLoc = ch;
             result[arrLoc]+= score;
             score--;
           }  
        }

        List<Element> elements = new ArrayList<Element>();
        for (int i = 0; i < result.length; i++) {
        	if(result[i]!=0)
        		elements.add(new Element(i, result[i]));
        }

        Collections.sort(elements);

        String finalString="";

        for(int i=0;i<elements.size();i++){
            Element elm = elements.get(i);
            char ch = (char)elm.getIndex();
            finalString = finalString +  ch;
        }

    return finalString;

        
}

class Element implements Comparable<Element> {

        int index, value;

        Element(int index, int value){
            this.index = index;
            this.value = value;
        }

        public int compareTo(Element e) {
            return  e.value - this.value;
        }

        int getIndex() {
            return index;
        }
        
    }
}