class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }

        int m=nums1.length;
        int n=nums2.length;

        int low=0;
        int high=m;

        while(low<=high){
            int partm=(low+high)/2;
            int partn=(m+n+1)/2-partm;

            float max_left_m = (partm == 0) ? Integer.MIN_VALUE : nums1[partm - 1];

            float min_right_m= (partm == m) ? Integer.MAX_VALUE : nums1[partm];

            float max_left_n= (partn == 0) ? Integer.MIN_VALUE : nums2[partn - 1];
            float min_right_n= (partn == n) ? Integer.MAX_VALUE : nums2[partn];


            if(max_left_m<= min_right_n && max_left_n<= min_right_m){
                if((m+n)%2==0){
                    return(Math.max(max_left_m,max_left_n)+Math.min(min_right_m,min_right_n))/2;
                }
                else{
                    return(Math.max(max_left_m,max_left_n));
                }

            }
            else if(max_left_m>min_right_n){
                high=partm-1;
            }
            else{
                low=partm+1;
            }
        }
        throw new IllegalArgumentException("Input arrays are not sorted.");


        
    }
}