# 1-20

1
```
class Solution {
    /**
     * target - x ????
     * ????????
     * ???map.get(x)?map.put((target-x), i)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        int[] arr=new int[2];
        for(int i=0;i<nums.length;i++){
            int x=nums[i];
            if(map.get(x)!=null){//??? ???? ?target-x?
                arr[1]=i;
                arr[0]=map.get(nums[i]);
                return arr;
            }else{
                map.put((target-x), i);//???
            }
        }
        return null;
    }
}


```
2
```
class Solution {
    //TODO:
    //carry?????????????????
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        int carry = 0;
        ListNode listNode = new ListNode(-1);//???????
        ListNode head = listNode;//??????????
        while (l1 != null || l2 != null) {
            int sum = carry;
            carry = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            int newVal = sum;//???? l1?l2????
            if (sum >= 10) {
                carry = 1;// ??
                newVal = sum % 10;// ???
            }
            listNode.next = new ListNode(newVal);//?????????????????????
            listNode = listNode.next;
        }
        if (carry > 0) {
            listNode.next = new ListNode(1);// carry?????1??????1?
        }
        return head.next;
    }
}
```
3
```
class Solution {
    //TODO:
    public int lengthOfLongestSubstring(String s) {
        String temp = "";// ????????
        String list = "";// ???????????
        for (int i = 0; i < s.length(); i++) {
            /*
             * ????????????????????????????
             */
            if (temp.contains(s.charAt(i) + "")) {
                int t = temp.indexOf(s.charAt(i));
                if ((t + 1) == temp.length())//????????????
                    temp = "";
                else
                    temp = temp.substring(t + 1, temp.length());//?????????????????
                temp = temp.concat(s.charAt(i) + "");
            } else {
                temp = temp.concat(s.charAt(i) + "");//???????
            }
            if (list.length() <= temp.length()) {// ?????????????????
                list = temp;
            }
        }
        return list.length();
    }
}
```
4
```
class Solution {
    //TODO:
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, merge, 0, nums1.length);
        System.arraycopy(nums2,0,merge, nums1.length, nums2.length);
        Arrays.sort(merge);

        System.out.println(Arrays.toString(merge));
        if (merge.length % 2 == 1) {
            return merge[merge.length/2];
        } else {
            double p = merge[merge.length/2];
            return (p + merge[merge.length/2 - 1])/2;
        }
    }
}
```
5
```
class Solution {
    //TODO:
    public String longestPalindrome(String s) {
        String longestPalindrome = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - longestPalindrome.length(); i++) {
            for (int j = chars.length - 1; j >= i; j--) {
                // ?????
                if (chars[j] == chars[i]) {
                    // ???????
                    for (int k = i; k <= j; k++) {
                        if (chars[k] != chars[j + i - k]) {
                            break;
                        }
                        // ?????????
                        if (k >= j + i - k) {
                            if (longestPalindrome.length() < (k - i + 1)) {// ??????????
                                char[] bs = new char[k - i + 1];
                                System.arraycopy(chars, i, bs, 0, k - i + 1);
                                // ????
                                longestPalindrome = String.valueOf(bs);
                            }

                        }
                    }
                }
            }
        }
        return longestPalindrome;
    }
}
```
6
```
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        StringBuilder stringBuilder = new StringBuilder();
        for (int q = 1; q <= numRows; q++) {
            int n = 0;
            int next = q;
            int pre = 0;
            while (next <= s.length()) {
                if (pre != next) {
                    stringBuilder.append(s.charAt(next - 1));
                }
                pre = next;
                if (n % 2 == 0) {
                    next = (numRows - q) * 2 + next;
                } else {
                    next = (q - 1) * 2 + next;
                }
                n++;
            }
        }
        return stringBuilder.toString();
    }
}
```
7
```
class Solution {
    //2^31-1=2147483647,-2^31=-2147483648
    public int reverse(int x) {
        String s = String.valueOf(x);
		char[] chars = s.toCharArray();
		// ?????????????????flag=false?
		boolean flag = chars[0] == '-' ? true : false;
		// ???????????????????
		int end = flag ? 1 : 0;
		StringBuffer sb = new StringBuffer();// ?????????
		for (int i = chars.length - 1; i >= end; i--) {
			sb.append(chars[i]);
		}

		int result = 0;// ????
		try {
			result = Integer.parseInt(sb.toString());
		} catch (NumberFormatException e) { // ?????????????? 0
			return 0;
		}
		result = flag ? (-result) : result;
		return result;
    }
}
```







