class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> setA=new HashSet<>();
        HashSet<Integer> setB=new HashSet<>();

        int n=A.length;

        int[] ans=new int[n];
        if(A[0]==B[0])ans[0]=1;
        setA.add(A[0]);
        setB.add(B[0]);
        for(int i=1;i<n;i++){
            if(A[i]==B[i]){
                ans[i]=ans[i-1]+1;
            }
            else{
                ans[i]=ans[i-1];
                if(setB.contains(A[i])){
                    ans[i]+=1;
                }
                if(setA.contains(B[i])){
                    ans[i]+=1;
                }
                setA.add(A[i]);
                setB.add(B[i]);
            }
        }
        return ans;
    }
}