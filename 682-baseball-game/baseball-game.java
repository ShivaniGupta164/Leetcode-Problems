class Solution {
    public static int calPoints(String arr[]) {
		Stack<Integer>st=new Stack<>();
		int sumofall=0;
		int n=arr.length;
		for(int i=0; i<n; i++) {
			String s=arr[i];
			if(s.equals("C"))st.pop();
			else if(s.equals("D"))st.push(2*st.peek());
			else if(s.equals("+")) {
				int top=st.pop();
				int secondtop=st.peek();
				int sum=top + secondtop;
				st.push(top);
				
				st.push(sum);
			}
			else {
				st.push(Integer.parseInt(s));
			}	
		}
		while(st.size()>0) {
			sumofall=sumofall+st.pop();
		}
		return sumofall;
	}	
}