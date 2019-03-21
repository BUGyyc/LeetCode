# 两数之和
```class Solution {
    /**
     * target - x 目标差值
     * 若存在，说明有解
     * 关键在map.get(x)、map.put((target-x), i)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        int[] arr=new int[2];
        for(int i=0;i<nums.length;i++){
            int x=nums[i];
            if(map.get(x)!=null){//直接找 目标差值 （target-x）
                arr[1]=i;
                arr[0]=map.get(nums[i]);
                return arr;
            }else{
                map.put((target-x), i);//存索引
            }
        }
        return null;
    }
}```
