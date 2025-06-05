class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
    int track[] = new int[26];

    for(int i=0; i<26; i++)
    track[i]=i;

    for(int i=0; i<s1.length(); i++)
    {
       int a = s1.charAt(i)-'a';
       int b = s2.charAt(i)-'a';      
       int l1 = find(track, a);
       int l2 = find(track, b);
       if(l1!=l2)
       {
       int max = Math.max(l1, l2);
       int min = Math.min(l1, l2);
       track[max] = min;
       }
       
    }
    
    for(int i=0; i<26; i++)
    track[i] = find(track, i);
     
    StringBuilder sb = new StringBuilder();

    for(int i=0; i<baseStr.length(); i++)
    {
       int x = baseStr.charAt(i)-'a';
       char ch = (char)(track[x]+'a');
       sb.append(ch);  
    }

    return sb.toString();

    }

    public int find(int track[], int x)
    {
       if(track[x]!=x)
       track[x] = find(track, track[x]);
       return track[x];     
    }
}