//1、映射法  建立映射表，如果字符映射的与另一个不一样就false  
//          时间： O（n）  空间：O（n）
//2、统计法  
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] charMap = new int[270];
        int[] charMap1 = new int[270];
        if(s.length() != t.length()) {
            return false;
        }

        char[] schar =  s.toCharArray();
        char[] tchar =  t.toCharArray();

        for(int i = 0; i < schar.length; i++){
            int sval = schar[i] - ' ' + 1 ;
            int tval = tchar[i] - ' ' + 1 ;
            if( charMap[tval] == 0){
                charMap[tval] =  sval;
            } else {
                if( sval != charMap[tval] ){
                    return false;
                }
            }
        }

        for(int i = 0; i < schar.length; i++){
            int sval = tchar[i] - ' ' + 1 ;
            int tval = schar[i] - ' ' + 1 ;
            if( charMap1[tval] == 0){
                charMap1[tval] =  sval;
            } else {
                if( sval != charMap1[tval] ){
                    return false;
                }
            }
        }
        return true;
    }
}
