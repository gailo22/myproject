package myproject.interview;

import java.util.HashMap;

class TrieNode {
	HashMap<Character, TrieNode> map;
	char character;
	boolean  last;
	
	public TrieNode(char character) {
		this.map = new HashMap<>();
		this.character = character;
		this.last = false;
	}
}

class Trie {
	private TrieNode root;
	public Trie() {
		root = new TrieNode(' ');
	}
	
	public void insert(String word) {
		TrieNode current = root;
		for (char c : word.toCharArray()) {
			if (!current.map.containsKey(c)) {
				current.map.put(c, new TrieNode(c));
			}
			current = current.map.get(c);
		}
		current.last = true;
	}
	
	public boolean search(String word) {
		TrieNode current = root;
		for (char c : word.toCharArray()) {
			if (!current.map.containsKey(c)) return false;
			current = current.map.get(c);
		}
		if (current.last == true) return true;
		else return false;
	}
	
	public boolean startsWith(String prefix) {
		TrieNode current = root;
		for (char c : prefix.toCharArray()) {
			if (!current.map.containsKey(c)) return false;
			current = current.map.get(c);
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		Trie trie = new Trie();
		trie.insert("somestring");
		trie.search("key");
		
		System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
		
	}
}

