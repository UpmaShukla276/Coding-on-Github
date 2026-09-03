class Solution {
    public int countPrimes(int n) {
        if(n<=2){
            return 0;
        }

        boolean[] IsPrime = new boolean[n];
        for(int i=2;i<n;i++){
            IsPrime[i] = true;
        }
        for(int i=2; i*i<n; i++){
            if(IsPrime[i]){
                for(int j=i*i; j<n;j+=i){
                    IsPrime[j]=false;
                }
            }
        }
        int count = 0;

        for(int i=2;i<n;i++){
            if (IsPrime[i]){
                count++;
            }
        }
        return count;   
    }
}