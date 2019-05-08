/*
 * @lc app=leetcode.cn id=953 lang=java
 *
 * [953] 验证外星语词典
 */
class Solution {

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }
        for(int i=0;i<words.length-1;i++){
            for(int j=0;j<Math.min(words[i].length(),words[i+1].length());j++){
                if(words[i].charAt(j)!=words[i+1].charAt(j)){
                    if(map.get(words[i].charAt(j))>map.get(words[i+1].charAt(j))){
                        return false;
                    }else{
                        break;
                    }
                }
                
            }
            if(words[i].contains(words[i+1])&&words[i].length()>words[i+1].length()){
                return false;
            }
        }
        return true;
    }

    //FIXME:
    /**
     * 遍历每个值
     * @param words
     * @param order
     * @return
     */
    private boolean extracted(String[] words, String order) {
        int i = 0;
        char last = '\0';
        int max = 0;
        int num = 0;
        for (String s : words) {
            max = Math.max(max, s.length());
            num++;
        }
        int x = 1;
        for (String s : words) {
            char c = (i > s.length() - 1) ? '\0' : s.charAt(i);
            if (checkIndexByString(order, c) < checkIndexByString(order, last)) {
                return false;
            }
            x++;
            last = c;

            if (x > num) {
                last = '\0';
                x = 1;
                i++;// 下一位
            }
            if (i >= max - 1) {
                break;
            }
        }
        return true;
    }

    public int checkIndexByString(String order, char c) {
        if (c == '\0') {
            return -1;
        }
        return order.indexOf(c);
    }
}
