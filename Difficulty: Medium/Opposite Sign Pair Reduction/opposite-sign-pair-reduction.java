class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        // code here
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            //we need to check every single element
            int a=arr[i];
            boolean b=true;//alive
            while(b&&!st.isEmpty()&&st.peek()*a<0){
                //if the element is alive and negatie and st is not empty and the peek is of opposite sign that is +ve;
                if(Math.abs(a)==Math.abs(st.peek())){//both elements are abs same so remove them from stack and make the asteroid dead;
                    st.pop();
                    b=false;
                }
                else if(Math.abs(a)>Math.abs(st.peek())){
                    st.pop();//the stack will have its positive one removed 
                    //thus at last stack will have the negative of he value;
                }
                else{
                    //-a<st.peek(),hence a wiil be removed and dead;
                    b=false;
                }
            }
            if(b)st.push(a);//if a is still alive then push it into stack;
        }
        ArrayList<Integer> a=new ArrayList<>();
        while(!st.isEmpty()){
            int num=st.pop();
            a.add(num);
        }
        Collections.reverse(a);
        return a;
    }
}