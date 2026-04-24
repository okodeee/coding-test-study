class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        int answer = 0;
        
        for (int i = 0; i < skill_trees.length; i++) {
            String skill_tree = skill_trees[i];
            int index = 0;
            boolean pos = true;
            
            for (int j = 0; j < skill_tree.length(); j++) {
                // 문자열에서 특정 문자 있는지 찾으려면 indexOf 사용
                if (skill.indexOf(skill_tree.charAt(j)) < 0) continue;
                
                if (skill.charAt(index) != skill_tree.charAt(j)) {
                    pos = false;
                    break;
                }
                
                index++;
                
            }
            
            if (pos) {
                answer++;
            }
        }
        
        return answer;
    }
}