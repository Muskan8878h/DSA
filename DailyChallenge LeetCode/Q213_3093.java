class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int index = -1;
        int len = Integer.MAX_VALUE;
    }

    TrieNode root = new TrieNode();

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }

    private void insert(String word, int idx) {

        TrieNode node = root;
        update(node, word.length(), idx);
        for (int i = word.length() - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            int pos = ch - 'a';
            if (node.children[pos] == null) {
                node.children[pos] = new TrieNode();
            }
            node = node.children[pos];
            update(node, word.length(), idx);
        }
    }

    private void update(TrieNode node, int len, int idx) {
        if (len < node.len) {
            node.len = len;
            node.index = idx;
        }
    }

    private int search(String word) {
        TrieNode node = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            int pos = ch - 'a';
            if (node.children[pos] == null) {
                break;
            }
            node = node.children[pos];
        }
        return node.index;
    }
}
