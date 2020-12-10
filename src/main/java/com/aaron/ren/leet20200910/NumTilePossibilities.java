package com.aaron.ren.leet20200910;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumTilePossibilities {

    //存储字符串的集合
    public Set<String> strings = new HashSet<>();
    //标识不同阶段下的排版内容
    public StringBuffer stringBuffer = new StringBuffer();

    //AAB  A  AA
    public int numTilePossibilities(String tiles) {
        //统计所有char的次数
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tiles.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        handle(map);
        return strings.size();
    }

    private void handle(Map<Character, Integer> map) {
        if (map.size() == 0) {
            return;
        } else {
            //依次选择所有不同的字符作为起始
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                //如果当前字符剩余0，跳过
                if (entry.getValue() == 0) {
                    continue;
                }
                //选择当前字符
                stringBuffer.append(entry.getKey());
                //将当前状态的排版加入结果集
                strings.add(stringBuffer.toString());
                //修改当前字符剩余个数
                map.put(entry.getKey(), entry.getValue() - 1);
                //递归调用
                handle(map);
                //恢复当前字符个数
                map.put(entry.getKey(), entry.getValue() + 1);
                //恢复排版
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
        }
    }

}
